package com.hxg.settlement.web.common.resolver;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.hxg.settlement.util.AuthorizationUtils;
import com.hxg.settlement.web.common.exception.ParameterIllegalException;



public class AppTokenArgumentResolver implements HandlerMethodArgumentResolver {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Value("${standaloneMode}")
	public boolean STANDALONE_MODE; 

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return (parameter.getParameterType().equals(AppToken.class));
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		AppToken token = null;
		if (STANDALONE_MODE) {
			// 独立模式
			Object oSub = webRequest.getAttribute(AuthorizationUtils.TOKEN_KEY, NativeWebRequest.SCOPE_REQUEST);
			if (oSub == null) {
				log.error("非法APP请求,认证参数不合法");
				throw new ParameterIllegalException("登录已过期");
			}
			token = new AppToken(Integer.valueOf(oSub.toString()));
			webRequest.removeAttribute("appauth_sub", NativeWebRequest.SCOPE_REQUEST);
		} else {
			// 服务模式
			String strSub = webRequest.getHeader(AuthorizationUtils.TOKEN_KEY);
			if (StringUtils.isBlank(strSub)) {
				log.error("非法APP请求,认证参数不合法");
				throw new ParameterIllegalException("登录已过期");
			}
			token = new AppToken(Integer.valueOf(strSub));
		}
		return token;
	}

}

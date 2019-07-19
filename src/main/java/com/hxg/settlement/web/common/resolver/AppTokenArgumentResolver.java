package com.hxg.settlement.web.common.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSONObject;
import com.hxg.settlement.util.AuthorizationUtils;
import com.hxg.settlement.web.common.exception.ParameterIllegalException;


public class AppTokenArgumentResolver implements HandlerMethodArgumentResolver {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return (parameter.getParameterType().equals(AppToken.class));
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		AppToken token = null;
		// 独立模式
		Object oSub = webRequest.getAttribute(AuthorizationUtils.TOKEN_KEY, NativeWebRequest.SCOPE_REQUEST);
		if (oSub == null) {
			log.error("非法APP请求,认证参数不合法");
			throw new ParameterIllegalException("登录已过期");
		}
		token =JSONObject.parseObject(oSub.toString(), AppToken.class);
		webRequest.removeAttribute(AuthorizationUtils.TOKEN_KEY, NativeWebRequest.SCOPE_REQUEST);
		return token;
	}

}

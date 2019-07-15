package com.hxg.settlement.web.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hxg.settlement.util.AuthorizationUtils;
import com.hxg.settlement.web.common.exception.AppTokenIllegalException;

/**
 * 拦截处理用户Apptoken
 * @author wangfei
 *
 */
public class AppTokenInterceptor extends HandlerInterceptorAdapter {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		int verifyResult = AuthorizationUtils.verifyAppToken(request);
		if (verifyResult == 0) {
			log.warn("签名未通过验证!");
			throw new AppTokenIllegalException("认证参数不正确");
		}
		if (verifyResult == -1) {
			log.warn("认证参数已过期!");
			throw new AppTokenIllegalException("认证参数已过期");
		}
		return super.preHandle(request, response, handler);
		
	}
	
}

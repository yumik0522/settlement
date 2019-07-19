package com.hxg.settlement.web.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hxg.settlement.util.AuthorizationUtils;

/**
 * 拦截处理用户Apptoken
 * @author wangfei
 *
 */
public class AppTokenInterceptor extends HandlerInterceptorAdapter {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		AuthorizationUtils.verifyAppToken(request);
		
		return super.preHandle(request, response, handler);
		
	}
	
}

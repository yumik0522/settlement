package com.hxg.settlement.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hxg.settlement.constant.CommonConstants;
import com.hxg.settlement.web.common.exception.AppTokenIllegalException;
import com.hxg.settlement.web.common.exception.ParameterIllegalException;

@RestControllerAdvice
public class YjkExceptionHandler {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(ParameterIllegalException.class)
	public ApiResponse parameterIllegalExceptionHandler(ParameterIllegalException e) {
		ApiResponse apiResponse = new ApiResponse(CommonConstants.CODE_ILLEGAL_ARGUMENT, e.getMessage());
		if (e.getData() != null) {
			apiResponse.setData(e.getData());
		}
		return apiResponse;
	}
	
	@ExceptionHandler(AppTokenIllegalException.class)
	public ApiResponse appTokenIllegalException(AppTokenIllegalException e) {
		log.info("进入YjkExceptionHandler *****************");
		return new ApiResponse(CommonConstants.CODE_ILLEGAL_APPTOKEN, e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ApiResponse exceptionHandler(Exception e) {
		log.error("发生服务器级异常", e);
		return new ApiResponse(CommonConstants.CODE_SERVER_ERROR, e.getMessage());
	}
	
}

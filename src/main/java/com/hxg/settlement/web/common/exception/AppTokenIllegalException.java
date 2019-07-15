package com.hxg.settlement.web.common.exception;

/**
 * @author wangfei
 * APPToken非法
 */
public class AppTokenIllegalException extends RuntimeException {
	private static final long serialVersionUID = 1140292201333010148L;
	
	public AppTokenIllegalException(String msg) {
		super(msg);
	}

}

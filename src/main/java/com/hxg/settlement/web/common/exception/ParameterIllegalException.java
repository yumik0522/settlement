package com.hxg.settlement.web.common.exception;

/**
 * 非法参数异常
 * @author wangfei
 *
 */
public class ParameterIllegalException extends RuntimeException {
	private static final long serialVersionUID = -5416232933485291796L;
	
	private Object data = null;

	public ParameterIllegalException(String msg) {
		this(msg, null);
	}
	
	public ParameterIllegalException(String msg, Object data) {
		super(msg);
		this.data = data;
	}

	public Object getData() {
		return data;
	}
}
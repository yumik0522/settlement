package com.hxg.settlement.web.common.exception;

public class SettlementIllegaException extends RuntimeException  {
	
	private static final long serialVersionUID = -4568580465062896438L;
	
	private Object data = null;

	public SettlementIllegaException(String msg) {
		this(msg, null);
	}
	
	public SettlementIllegaException(String msg, Object data) {
		super(msg);
		this.data = data;
	}

	public Object getData() {
		return data;
	}
}

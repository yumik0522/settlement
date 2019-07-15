package com.hxg.settlement.web.common;

import java.util.HashMap;

import com.hxg.settlement.constant.CommonConstants;


public class ApiResponse {
	private int code;
	private String msg = "";
	private Object data;
	

	public ApiResponse() {
		this(CommonConstants.CODE_SUCCESS, CommonConstants.MSG_SUCCESS);
	}
	
	public ApiResponse(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public static ApiResponse buildSuccess() {
		ApiResponse resp = new ApiResponse();
		resp.setData(new HashMap<>());
		return resp;
	}
	
	
	public static ApiResponse buildSuccess(Object data) {
		ApiResponse resp = new ApiResponse();
		resp.setData(data);
		return resp;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ApiResponse [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
}

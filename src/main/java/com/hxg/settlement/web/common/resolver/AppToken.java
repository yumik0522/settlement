package com.hxg.settlement.web.common.resolver;

/**
 * @author wangfei
 * APP接口校验用户对象
 */
public class AppToken {
	
	private Integer userid;
	
	
	public AppToken() {}
	
	public AppToken(Integer userid) {
		this.userid = userid;
	}

	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}

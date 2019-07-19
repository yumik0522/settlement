package com.hxg.settlement.web.common.resolver;

/**
 * @author wangfei
 * APP接口校验用户对象
 */
public class AppToken {
	
	private Integer userid;
	
	private String nickname;
	
	private String username;
	
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
}

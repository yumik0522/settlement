package com.hxg.settlement.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxg.settlement.mysql.mapper.AppUserMapper;
import com.hxg.settlement.mysql.persistence.AppUser;

@Service
public class AppUserBiz  {
	
	@Autowired
	private AppUserMapper appUserMapper;

	public AppUser getAppUserInfo(Integer id) {
		return appUserMapper.selectByPrimaryKey(id);
	}

}

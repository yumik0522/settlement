package com.hxg.settlement.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxg.settlement.mysql.mapper.MenuMapper;
import com.hxg.settlement.mysql.persistence.Menu;
import com.hxg.settlement.mysql.persistence.User;

@Service
public class MenuBiz {
	
	@Autowired
	private MenuMapper menuMapper;
	
	/**
	 * @version: V1.0
	 * @Description:  根据用户名获取用户信息
	 * @author: zwq
	 * @date: 2019年7月15日上午11:24:36  
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username) {
		return null;
	}

	public List<Menu> selectAuthorityMenuByUserId(Integer userId) {
		
		return menuMapper.selectAuthorityMenuByUserId(userId);
	}

}

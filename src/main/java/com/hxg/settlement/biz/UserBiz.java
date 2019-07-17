package com.hxg.settlement.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxg.settlement.mysql.mapper.UserMapper;
import com.hxg.settlement.mysql.persistence.User;

@Service
public class UserBiz {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * @version: V1.0
	 * @Description:  根据用户名获取用户信息
	 * @author: zwq
	 * @date: 2019年7月15日上午11:24:36  
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username) {
		User user = new User();
		user.setUsername(username);
		return userMapper.selectOne(user);
	}

}

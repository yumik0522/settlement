package com.hxg.settlement.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hxg.settlement.mysql.mapper.UserMapper;
import com.hxg.settlement.mysql.persistence.User;
import com.hxg.settlement.web.vo.UserInfo;

@Service
public class AuthService implements UserDetailsService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User record = new User();
		record.setUsername(username);
		User user = userMapper.selectOne(record);
		UserInfo info = new UserInfo();
		BeanUtils.copyProperties(user, info);
		return info;
	}

}

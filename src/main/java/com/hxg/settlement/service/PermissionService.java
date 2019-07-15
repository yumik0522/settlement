package com.hxg.settlement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hxg.settlement.biz.UserBiz;
import com.hxg.settlement.mysql.persistence.User;
import com.hxg.settlement.web.vo.PermissionInfo;
import com.hxg.settlement.web.vo.UserInfo;

public class PermissionService {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	@Autowired
	private UserBiz userBiz;
	
	public List<PermissionInfo> getAllPermission(Integer userid) {
		
//		List<Menu> menus = menuBiz.selectListAll();
//        List<PermissionInfo> result = new ArrayList<PermissionInfo>();
//        PermissionInfo info = null;
//        menu2permission(menus, result);
//        List<Element> elements = elementBiz.getAllElementPermissions();
//        element2permission(result, elements);
		
		return null;
    }
	
	/**
	 * @version: V1.0
	 * @Description: 账号密码校验 
	 * @author: zwq
	 * @date: 2019年7月15日上午11:28:23  
	 * @param username
	 * @param password
	 * @return
	 */
	public UserInfo validate(String username,String password){
        UserInfo info = new UserInfo();
        User user = userBiz.getUserByUsername(username);
        if (encoder.matches(password, user.getPassword())) {
            BeanUtils.copyProperties(user, info);
            info.setId(user.getId());
        }
        return info;
    }
}
 
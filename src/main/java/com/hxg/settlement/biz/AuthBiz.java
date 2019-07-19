package com.hxg.settlement.biz;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hxg.settlement.service.PermissionService;
import com.hxg.settlement.web.common.exception.SettlementIllegaException;
import com.hxg.settlement.web.common.resolver.AppToken;
import com.hxg.settlement.web.vo.UserInfo;

@Service
public class AuthBiz {
	
	@Autowired
	private PermissionService permissionService;
	
	public Map<String,Object> login(String username,String password) {
		
		UserInfo info = permissionService.validate(username, password);
		
        if (StringUtils.isEmpty(info.getId())) {
        	throw new SettlementIllegaException("用户不存在或账户密码错误!");
        }
        
        AppToken appToken = new AppToken();
        
        appToken.setUserid(info.getId());
        appToken.setUsername(info.getUsername());
        appToken.setNickname(info.getName());
        
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("token", appToken);
		
		return resultMap;
	}

}

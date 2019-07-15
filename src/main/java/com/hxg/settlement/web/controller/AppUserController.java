package com.hxg.settlement.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hxg.settlement.biz.AppUserBiz;
import com.hxg.settlement.mysql.persistence.AppUser;
import com.hxg.settlement.web.common.ApiResponse;
import com.hxg.settlement.web.common.exception.ParameterIllegalException;
import com.hxg.settlement.web.common.resolver.AppToken;

@RestController
@RequestMapping("/appUser")
public class AppUserController {
	
	@Autowired
	private AppUserBiz appUserBiz;
	
	@RequestMapping(value = "/getAppUserInfo", method = RequestMethod.GET)
	public ApiResponse getAppUserInfo(AppToken appToken) {
		
		Integer id = appToken.getUserid();
		
		if(StringUtils.isEmpty(id)) {
			throw new ParameterIllegalException("id不能为空！");
		}

		AppUser appUser = appUserBiz.getAppUserInfo(id);
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("appUser", appUser);

		return ApiResponse.buildSuccess(resultMap);
	}

}

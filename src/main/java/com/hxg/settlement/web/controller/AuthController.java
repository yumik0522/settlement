package com.hxg.settlement.web.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hxg.settlement.biz.AuthBiz;
import com.hxg.settlement.web.common.ApiResponse;
import com.hxg.settlement.web.common.exception.AppTokenIllegalException;
import com.hxg.settlement.web.common.exception.ParameterIllegalException;

@RestController
@RequestMapping("/")
public class AuthController {
	
	@Autowired
	private AuthBiz authBiz;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ApiResponse login(String username,String password) {
		
		if(StringUtils.isEmpty(username)) {
			throw new ParameterIllegalException("用户名不能为空！");
		}
		
		if(StringUtils.isEmpty(password)) {
			throw new ParameterIllegalException("密码不能为空！");
		}
		
		Map<String,Object> resultMap = authBiz.login(username, password);

		return ApiResponse.buildSuccess(resultMap);
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ApiResponse loginPage() {
		
		throw new AppTokenIllegalException("权限不足，请联系管理员!");
	}
}

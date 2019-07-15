package com.hxg.settlement.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hxg.settlement.web.common.ApiResponse;

@RestController
@RequestMapping("/")
public class AuthController {
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ApiResponse login(String username,String password) {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();

		return ApiResponse.buildSuccess(resultMap);
	}
}

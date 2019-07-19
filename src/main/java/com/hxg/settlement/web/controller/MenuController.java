package com.hxg.settlement.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hxg.settlement.biz.MenuBiz;
import com.hxg.settlement.mysql.persistence.Menu;
import com.hxg.settlement.web.common.ApiResponse;
import com.hxg.settlement.web.common.resolver.AppToken;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuBiz menuBiz;
	
	
	@RequestMapping(value = "/listUserAuthoritySystem", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse listUserAuthoritySystem(AppToken appToken) {
		Integer userId = appToken.getUserid();
		List<Menu> list = menuBiz.selectUserAuthoritySystemByUserId(userId); 
        return ApiResponse.buildSuccess(list);
    }
}

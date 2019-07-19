package com.hxg.settlement.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hxg.settlement.biz.ElementBiz;
import com.hxg.settlement.biz.MenuBiz;
import com.hxg.settlement.biz.UserBiz;
import com.hxg.settlement.constant.CommonConstants;
import com.hxg.settlement.mysql.persistence.Element;
import com.hxg.settlement.mysql.persistence.Menu;
import com.hxg.settlement.mysql.persistence.User;
import com.hxg.settlement.web.vo.PermissionInfo;
import com.hxg.settlement.web.vo.UserInfo;

@Service
public class PermissionService {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	@Autowired
	private UserBiz userBiz;
	@Autowired
	private MenuBiz menuBiz;
	@Autowired
	private ElementBiz elementBiz;
	
	/**
	 * @version: V1.0
	 * @Description: 获取用户权限 
	 * @author: zwq
	 * @date: 2019年7月16日上午9:47:51  
	 * @param userid
	 * @return
	 */
	public List<PermissionInfo> getAllPermissionByUserid(Integer userId) {
		
		List<Menu> menus = menuBiz.selectAuthorityMenuByUserId(userId);
        List<PermissionInfo> result = new ArrayList<PermissionInfo>();
        menu2permission(menus, result);
        List<Element> elements = elementBiz.selectAuthorityElementByUserId(userId);
        element2permission(result, elements);
		
		return result;
    }
	
	public List<PermissionInfo> getAllPermission() {
		
		List<Menu> menus = menuBiz.selectListAll();
        List<PermissionInfo> result = new ArrayList<PermissionInfo>();
        menu2permission(menus, result);
        List<Element> elements = elementBiz.getAllElementPermissions();
        element2permission(result, elements);
		
		return result;
    }
	
	/**
	 * @version: V1.0
	 * @Description: 菜单权限
	 * @author: zwq
	 * @date: 2019年7月16日上午9:56:35  
	 * @param menus
	 * @param result
	 */
	private void menu2permission(List<Menu> menus, List<PermissionInfo> result) {
        PermissionInfo info;
        for (Menu menu : menus) {
            if (StringUtils.isBlank(menu.getHref())) {
                menu.setHref("/" + menu.getCode());
            }
            info = new PermissionInfo();
            info.setCode(menu.getCode());
            info.setType(CommonConstants.RESOURCE_TYPE_MENU);
            info.setName(CommonConstants.RESOURCE_ACTION_VISIT);
            String uri = menu.getHref();
            if (!uri.startsWith("/")) {
                uri = "/" + uri;
            }
            info.setUri(uri);
            info.setMethod(CommonConstants.RESOURCE_REQUEST_METHOD_GET);
            result.add(info);
            info.setMenu(menu.getTitle());
        }
    }
	
	/**
	 * @version: V1.0
	 * @Description:  按钮权限
	 * @author: zwq
	 * @date: 2019年7月16日上午9:56:57  
	 * @param result
	 * @param elements
	 */
	private void element2permission(List<PermissionInfo> result, List<Element> elements) {
        PermissionInfo info;
        for (Element element : elements) {
            info = new PermissionInfo();
            info.setCode(element.getCode());
            info.setType(element.getType());
            info.setUri(element.getUri());
            info.setMethod(element.getMethod());
            info.setName(element.getName());
            info.setMenu(element.getMenuId());
            result.add(info);
        }
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
        
        if(user==null) {
        	throw new RuntimeException("账号不存在!");
        }
        
        if (encoder.matches(password, user.getPassword())) {
            BeanUtils.copyProperties(user, info);
            info.setId(user.getId());
        }
        return info;
    }

	public List<Menu> getAllMenu() {
		
		return null;
	}
}
 
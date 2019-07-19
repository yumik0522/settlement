package com.hxg.settlement.config;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.alibaba.fastjson.JSON;
import com.hxg.settlement.service.PermissionService;
import com.hxg.settlement.util.AuthorizationUtils;
import com.hxg.settlement.web.common.resolver.AppToken;
import com.hxg.settlement.web.vo.PermissionInfo;

/**
 * Created by sang on 2017/12/28.
 */
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private PermissionService permissionService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) {
    	HttpServletRequest request = ((FilterInvocation) o).getRequest();
    	AppToken appToken  = AuthorizationUtils.verifyAppToken(request);
    	if(appToken==null) {
    		return SecurityConfig.createList("ROLE_LOGIN");
    	}
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<PermissionInfo> allPermission = permissionService.getAllPermissionByUserid(appToken.getUserid());
        System.out.println(JSON.toJSONString(allPermission));
        for (PermissionInfo permissionInfo : allPermission) {
            if (antPathMatcher.match(permissionInfo.getUri(), requestUrl)||antPathMatcher.match(permissionInfo.getUri()+"?*", requestUrl)) {
                return SecurityConfig.createList("ROLE_ANONYMOUS");
            }
        }
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}


package com.hxg.settlement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.hxg.settlement.web.common.interceptor.AppTokenInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
  
  /**
   * 配置静态资源,避免静态资源请求被拦截
   */
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/vue/**").addResourceLocations("classpath:/vue/");
      super.addResourceHandlers(registry);
  }
  
  /**
   * 添加拦截规则
   */
  public void addInterceptors(InterceptorRegistry registry) {
	  AppTokenInterceptor appInterceptor = new AppTokenInterceptor();
      registry.addInterceptor(appInterceptor);
      super.addInterceptors(registry);
  }
}

package com.hxg.settlement.config;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hxg.settlement.web.common.converter.CustomDateConverter;
import com.hxg.settlement.web.common.interceptor.AppTokenInterceptor;
import com.hxg.settlement.web.common.resolver.AppTokenArgumentResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new CustomDateConverter());
	}

	@Bean
	public ExecutorService executorService() {
		return Executors.newCachedThreadPool();
	}
	
	/**
     * 配置静态资源,避免静态资源请求被拦截
     */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	    WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		AppTokenInterceptor appInterceptor = new AppTokenInterceptor();
		registry.addInterceptor(appInterceptor);
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		HandlerMethodArgumentResolver resoover = new AppTokenArgumentResolver();
		resolvers.add(resoover);
		WebMvcConfigurer.super.addArgumentResolvers(resolvers);
	}
	
	
	
	
}

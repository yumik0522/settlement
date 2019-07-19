package com.hxg.settlement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.hxg.settlement.service.AuthService;
import com.hxg.settlement.web.common.exception.SettlementIllegaException;

/**
 * Created by sang on 2017/12/28.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthService authService;
    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    private UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    private AuthenticationAccessDeniedHandler deniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());
    }
    

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**", "/login", "/loginPage", "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) {
        try {
			http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
			    @Override
			    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
			        o.setSecurityMetadataSource(metadataSource);
			        o.setAccessDecisionManager(urlAccessDecisionManager);
			        return o;
			    }
			}).and()
			.formLogin().loginPage("/loginPage")//请求时未登录跳转接口
			.loginProcessingUrl("/login")//post登录接口，登录验证由系统实现
	        .permitAll()
	        .and().csrf().disable()
	        .exceptionHandling().accessDeniedHandler(deniedHandler);
		} catch (Exception e) {
			throw new SettlementIllegaException(e.getMessage());
		}
    }
}
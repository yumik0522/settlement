package com.hxg.settlement.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxg.settlement.constant.CommonConstants;
import com.hxg.settlement.service.AuthService;
import com.hxg.settlement.web.common.ApiResponse;

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
    protected void configure(HttpSecurity http) throws Exception {
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
        .usernameParameter("username")//要认证的用户参数名，默认username
        .passwordParameter("password")//要认证的密码参数名，默认password
        .failureHandler(new AuthenticationFailureHandler() {
					@Override
					public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp,
							AuthenticationException e) throws IOException {
						resp.setContentType("application/json;charset=utf-8");
						if (e instanceof BadCredentialsException || e instanceof UsernameNotFoundException) {
							throw new RuntimeException("账户名或者密码输入错误!");
						} else if (e instanceof LockedException) {
							throw new RuntimeException("账户被锁定，请联系管理员!");
						} else if (e instanceof CredentialsExpiredException) {
							throw new RuntimeException("密码过期，请联系管理员!");
						} else if (e instanceof AccountExpiredException) {
							throw new RuntimeException("账户过期，请联系管理员!");
						} else if (e instanceof DisabledException) {
							throw new RuntimeException("账户被禁用，请联系管理员!");
						} else {
							throw new RuntimeException("登录失败!");
						}
					}
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req,
                                                        HttpServletResponse resp,
                                                        Authentication auth) throws IOException {
                        resp.setContentType("application/json;charset=utf-8");
                        ApiResponse apiResponse = new ApiResponse();
                        apiResponse.setCode(CommonConstants.CODE_SUCCESS);
                        apiResponse.setMsg("登录成功!");
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(apiResponse));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        ApiResponse apiResponse = new ApiResponse();
                        apiResponse.setCode(CommonConstants.CODE_SUCCESS);
                        apiResponse.setMsg("注销成功!");
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(apiResponse));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(deniedHandler);
    }
}
package com.hxg.settlement.util;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.hxg.settlement.web.common.resolver.AppToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class AuthorizationUtils {

	private static final Logger log = LoggerFactory.getLogger(AuthorizationUtils.class);
	
	public static final String TOKEN_KEY = "appauth_sub";
	
	public static String SECRET_KEY = "pYwlpeISBQBxRmHe";
	
	
	/**
	 * 生成统一认证authorization数据
	 * @param appuserId
	 * @param mobile
	 * @return
	 */
	public static String generateAppTokenStr(AppToken appToken) {
		Map<String, Object> claims = new HashMap<>();
//		claims.put("mobile", mobile);
		Date now = new Date();
		Date expireDay = null;
		try {
			expireDay = DateUtils.parseDate(DateFormatUtils.format(now, "yyyyMMdd 00:00:00"),"yyyyMMdd HH:mm:ss");
			expireDay = DateUtils.addDays(expireDay, 30);
		} catch (ParseException e) {}
		String compactJws = Jwts.builder().setSubject(JSON.toJSONString(appToken)).setId(UUID.randomUUID().toString().replaceAll("-", ""))
				.setExpiration(expireDay).setIssuedAt(now).addClaims(claims)
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes(StandardCharsets.UTF_8)).compact();
		return compactJws;
	}
	
	/**
	 * 验证统一认证数据合法性
	 * @param request
	 * @return 0=校验失败,1=校验成功,-1=token已过期
	 */
	public static Integer verifyAppToken(HttpServletRequest request) {
		String headerAuthorization = request.getHeader("Authorization"); // 获取认证数据
		if (StringUtils.isNotBlank(headerAuthorization) && (headerAuthorization.startsWith("Bearer")) && (headerAuthorization.length()>10)) {
			String jws = headerAuthorization.substring(7);
			Claims clms = null;
			try {
                clms = Jwts.parser().setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(jws).getBody();
            } catch (SignatureException se) {
                log.error("Authorization:"+headerAuthorization);
                log.error("verifyAuthorizationTicket Exception:"+se.getMessage(), se);
                return 0;
            } catch (ExpiredJwtException eje) {
            	log.warn("token已过期");
            	return -1;
            }
			request.setAttribute(TOKEN_KEY, clms.getSubject());
		}
		return 1;
	}

	public static void main(String[] args) {
		
	}

}

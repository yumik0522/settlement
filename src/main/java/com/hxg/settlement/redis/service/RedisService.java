package com.hxg.settlement.redis.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 一般使用方法:stringRedisTemplate.opsFor..., 按数据类型选择...
	 */
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 放入字符串
	 * @param key  String的名称
	 * @param value 插入的值
	 * @return 插入成功返回true,插入失败返回false
	 */
	public void put(String key, String value) {
		stringRedisTemplate.opsForValue().set(key,value);
	}

	/**
	 * 放入字符串
	 * 插入元素,并且设置元素的有效时间
	 * @param key String的名称
	 * @param value 插入的值
	 * @param second 有效时间,单位为秒;
	 */

	public void put(String key, String value, int second) {
		stringRedisTemplate.opsForValue().set(key,value,second, TimeUnit.SECONDS);
	}

	/**
	 * 获取值
	 * 获得名称为key的元素的值
	 * @param key String的名称
	 */
	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	/**
	 * 删除名称为key的String元素
	 * @param key String的名称
	 * @return 删除成功返回true,删除失败,返回false
	 */
	public void remove(String key) {
		stringRedisTemplate.delete(key);
	}

	/**
	 * 获取key的过期时间,单位：秒
	 * @param key String的名称
	 */
	public Long getExpire(String key) {
		return stringRedisTemplate.getExpire(key);
	}



	/**
	 * 向Redis存入Hash类型的键值数据
	 * @param key 数据信息的主值
	 * @param hashKey 哈希键
	 * @param value 存储的数据值
	 */
	public void putHashString(String key, String hashKey, String value) {
		stringRedisTemplate.opsForHash().put(key, hashKey, value);
	}
	
	/**
	 * @param key 数据信息的主值
	 * @param hashKey 哈希键
	 * @return 存储的数据值
	 */
	public String getHashString(String key, String hashKey) {
		Object value = stringRedisTemplate.opsForHash().get(key, hashKey);
		if (value == null) {
			log.info("Redis中未获取到key为{}的Hash值", key);
			return "";
		}
		return value.toString();
	}

}

package com.hxg.settlement.mysql.mapper;

import java.util.List;

import com.hxg.settlement.mysql.persistence.Menu;
import tk.mybatis.mapper.common.Mapper;

public interface MenuMapper extends Mapper<Menu> {

	List<Menu> selectAuthorityMenuByUserId(Integer userId);

	List<Menu> selectUserAuthoritySystemByUserId(Integer userId);
}
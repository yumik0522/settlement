package com.hxg.settlement.mysql.mapper;

import java.util.List;

import com.hxg.settlement.mysql.persistence.Element;
import tk.mybatis.mapper.common.Mapper;

public interface ElementMapper extends Mapper<Element> {

	List<Element> selectAuthorityElementByUserId(Integer userid);
}
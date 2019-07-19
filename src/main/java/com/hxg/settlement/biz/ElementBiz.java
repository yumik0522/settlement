package com.hxg.settlement.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxg.settlement.mysql.mapper.ElementMapper;
import com.hxg.settlement.mysql.persistence.Element;

@Service
public class ElementBiz {
	
	@Autowired
	private ElementMapper elementMapper;
	

	public List<Element> selectAuthorityElementByUserId(Integer userid) {
		return elementMapper.selectAuthorityElementByUserId(userid);
	}


	public List<Element> getAllElementPermissions() {
		return elementMapper.selectAllElementPermissions();
	}

}

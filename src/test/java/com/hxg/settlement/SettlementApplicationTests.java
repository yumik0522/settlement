package com.hxg.settlement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hxg.settlement.biz.AuthBiz;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SettlementApplicationTests {
	
	@Autowired
	private AuthBiz authBiz;

	@Test
	public void contextLoads() {
		authBiz.login("admin", "admin");
	}

}

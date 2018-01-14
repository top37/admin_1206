package com.springdemo.model;

import org.junit.Test;

public class UserInfoTest {
	
	@Test
	public void testToJsonString(){
		UserInfo ui = new UserInfo();
		ui.setAge("26");
		ui.setName("aqiang");
		System.out.println(ui.toJsonString());
	}
}

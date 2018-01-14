package com.springdemo.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UsersInfoTest {
	
	@Test
	public void testToJsonString(){
		UsersInfo usi = new UsersInfo();
		usi.setDepartment("dev");
		
		List<UserInfo> lsu = new ArrayList<>();
		UserInfo ui = new UserInfo();
		ui.setAge("26");
		ui.setName("aqiang");
		UserInfo ui1 = new UserInfo();
		ui1.setAge("24");
		ui1.setName("bqiang");
		lsu.add(ui);lsu.add(ui1);
		usi.setListUserInfo(lsu);
		System.out.println(usi.toJsonString());
	}
}

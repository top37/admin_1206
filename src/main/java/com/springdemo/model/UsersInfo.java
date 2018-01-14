package com.springdemo.model;

import java.util.List;

import com.springdemo.model.pojorule.PojoRule;

public class UsersInfo extends PojoRule{
	
	private String department;
	private List<UserInfo> listUserInfo;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<UserInfo> getListUserInfo() {
		return listUserInfo;
	}
	public void setListUserInfo(List<UserInfo> listUserInfo) {
		this.listUserInfo = listUserInfo;
	}
}

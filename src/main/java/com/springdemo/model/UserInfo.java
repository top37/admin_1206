package com.springdemo.model;

import com.springdemo.model.pojorule.PojoRule;

public class UserInfo extends PojoRule{
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}

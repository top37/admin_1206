package com.springdemo.model;

import com.springdemo.model.pojorule.PojoRule;

public class Shop extends PojoRule{
	String name;
	String staffName[];
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getStaffName() {
		return staffName;
	}
	public void setStaffName(String[] staffName) {
		this.staffName = staffName;
	}	
}
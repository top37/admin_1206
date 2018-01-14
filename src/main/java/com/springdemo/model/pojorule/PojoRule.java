package com.springdemo.model.pojorule;

import net.sf.json.JSONObject;

public abstract class PojoRule implements PojoI{
	public String toJsonString(){
		return JSONObject.fromObject(this).toString();
	}
}

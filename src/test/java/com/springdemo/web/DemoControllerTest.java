package com.springdemo.web;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.springdemo.utils.EnvConfig;

public class DemoControllerTest {
	
	@Test
	public void testDemoControllerGet(){
		given().log().all()  
		.body("")
		.contentType("text/plain;charset=UTF-8")
		.get(EnvConfig.getPropVal()+"admin/abce").then()
		.statusCode(200).log().all();
	}
	
	@Test
	public void testDemoControllerPost(){
		String name = "aqiang1";
		given().log().all()  
		.body("")
		.contentType("text/plain;charset=UTF-8")
		.post(EnvConfig.getPropVal()+"admin/abc/"+name).then()
		.statusCode(200).log().all()
		.body("name", equalTo(name))
		;
	}
	
	@Test
	public void testDemoControllerPostWithPara(){
//		UserInfo p = new UserInfo();p.setAge("11");p.setName("aqiang");
		Para p = new Para();p.setAge("11");p.setName("aqiang");
		given().log().all()  
		.body(p)
		.contentType("application/json;charset=UTF-8")
		.post(EnvConfig.getPropVal()+"admin/postpara").then()
		.statusCode(200).log().all()
		;
	}
	
	@Test
	public void testDemoControllerGetReInt(){
		given().log().all()  
		.body("")
		.contentType("application/json;charset=UTF-8")
		.get(EnvConfig.getPropVal()+"admin/abcf").then()
		.statusCode(200).log().all()
		;
	}

}

class Para{
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

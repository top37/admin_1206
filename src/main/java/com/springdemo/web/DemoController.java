package com.springdemo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.model.Shop;
import com.springdemo.model.UserInfo;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class DemoController {
	private static final Logger LOG = Logger.getLogger(DemoController.class);  

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index1";
    }
    
    
    @RequestMapping(value="abc/{name}", method = RequestMethod.POST)
	public @ResponseBody Shop getShopInJSON(@PathVariable String name) {
    	LOG.info("-----json--------");
		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
 
		return shop;
	}
    
    @RequestMapping(value="abcd/{name}", method = RequestMethod.GET)
   	public @ResponseBody String getString(@PathVariable String name) {
    	Map<String,String> m = new HashMap<>();
		m.put("name",name);
		m.put("sex", "nan");
		JSONObject jsonObject = JSONObject.fromObject(m);
   		return jsonObject.toString();
   	}
    
    @RequestMapping(value="abce", method = RequestMethod.GET)
	public @ResponseBody String GetTest() {
    	LOG.info("-----json--------");
		Shop shop = new Shop();
		shop.setName("aqiang");
		shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
		JSONObject jsonObject = JSONObject.fromObject(shop);
		return jsonObject.toString();
	}
    
    @RequestMapping(value="abcf", method = RequestMethod.GET)
	public @ResponseBody List<Integer> GetTestInt() {
    	LOG.info("-----json--------");
    	List<Integer> lstInt = new ArrayList<>();
    	lstInt.add(19);lstInt.add(39);lstInt.add(7);lstInt.add(12);lstInt.add(15);lstInt.add(9);lstInt.add(2);
		return lstInt;
	}
    
    @RequestMapping(value="post", method = RequestMethod.POST)
	public @ResponseBody UserInfo PostT(UserInfo userInfo) {
    	LOG.info("-----json--------");
    	UserInfo rUserInfo = new UserInfo();
    	rUserInfo.setName(userInfo.getName());
    	rUserInfo.setAge(userInfo.getAge());
 
		return rUserInfo;
	}
    
    @RequestMapping(value="postpara", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody UserInfo PostP(@RequestBody UserInfo userInfo) {
    	LOG.info("-----json--------");
    	UserInfo rUserInfo = new UserInfo();
    	rUserInfo.setName(userInfo.getName());
    	rUserInfo.setAge(userInfo.getAge());
 
		return rUserInfo;
	}
    
//    public static void main(String[] args) {
//    	LOG.info("----------------in--------------");
////		Map<String,String> m = new HashMap<>();
////		m.put("name","aqiang");
////		m.put("sex", "nan");
////		JSONObject jsonObject = JSONObject.fromObject(m);
//    	Shop shop = new Shop();
//		shop.setName("haha");
//		shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
//		JSONObject jsonObject = JSONObject.fromObject(shop);
//		System.out.println(jsonObject.toString());
//	}
}

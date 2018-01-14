package com.springdemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvConfig {
	private static Properties env_p = new Properties();
    static {
        try {
            InputStream env_in = EnvConfig.class.getResourceAsStream("/env.properties");
            env_p.load(env_in); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPropVal(Properties prop, String key){
        return prop.getProperty(key);
    }
    
    public static String getPropVal(String key){
        return env_p.getProperty(key);
    }
    
    public static String getPropVal(){
        return env_p.getProperty("localhost");
    }
    
    
	public static void main(String[] args) throws IOException {
		System.out.println(getPropVal("localhost"));
	}
}

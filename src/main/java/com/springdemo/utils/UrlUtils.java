package com.springdemo.utils;

import java.net.URISyntaxException;
/**
 * 
 * @author 单强
 * 说明：对比了getResource在src/main/java与src/test/java返回的路径得知
 * src/main/java - file:/D:/eclipseWorkSpace/workspace_studysvn/admin_1206/target/classes/xxx.properties
 * src/test/java - file:/D:/eclipseWorkSpace/workspace_studysvn/admin_1206/target/test-classes/xxx.properties
 */
public class UrlUtils {
	
	
	/**
	 * Class.getResource(String path)
     * 如果path以"/"开头，例如："/a.txt"，则从classpath的根下获取资源；
     * 如果path不以"/"开头，例如"a.txt"，则从类所在的包路径下取资源。
	 */
	public static void main(String[] args) throws URISyntaxException {
		System.out.println(UrlUtils.class.getResource("").toURI().toString());
		System.out.println(UrlUtils.class.getResource("/").toURI().toString());
		System.out.println(UrlUtils.class.getClassLoader().getResource("").toURI().toString());
		System.out.println(UrlUtils.class.getClassLoader().getResource("/").toURI().toString());
	}
}

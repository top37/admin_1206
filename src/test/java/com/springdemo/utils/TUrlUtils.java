package com.springdemo.utils;

import java.net.URISyntaxException;

public class TUrlUtils {
	public static void main(String[] args) throws URISyntaxException {
		System.out.println(TUrlUtils.class.getResource("/aa.txt").toURI().toString());
	}
	
}

package com.springdemo.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

import com.springdemo.config.Constants;


public class FileUtils {
	
	private static Logger logger = Logger.getLogger("FileUtils"); 
	
	private FileUtils(){}

	public static String readFlie(String path, String encoding) {
		List<String> ls = null;
		StringBuilder sb = new StringBuilder();
		try 
		{
			ls = Files.readAllLines(Paths.get(path),Charset.forName(encoding));
		} 
		catch (Exception e1) 
		{
			logger.info(e1.toString());
			new IOException(e1);
		}
		for(String s : ls)
		{
			sb.append(s+"\r");
		}
		return sb.toString();
	}

	public static String readFlie(String path) {
		return readFlie(path,Constants.encoding_UTF8);
	}
}

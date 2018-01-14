package com.springdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 单强 2017年12月8日10:18:17
 * String 工具类
 * 简化其他方法中对string的一些操作
 */
public class StringHelper {
	
	/**
	 * @author 单强 2017年12月8日10:18:59
	 * 功能：去除getResource返回所带的字符串"file:/"
	 */
	public static String removeFileStri(String uri){
		return uri.replace("file:/", "");
	}
	/**
	 * @author 单强	
	 * 功能：判断参数是否合法
	 */
	public static boolean isValid(Object param){
		if(null == param) return false;
		if("".equals(param.toString())) return false;
		if("0".equals(param.toString())) return false;
		if("null".equals(param.toString())) return false;
		if("undefined".equals(param.toString())) return false;
		return true;
	}

	/**
	 * @author 单强	2014-08-05
	 * 功能：判断字符串是否为空
	 */
	public static boolean isEmpty(String str){
		if(null == str) return true;
		if("".equals(str)) return true;
		return false;
	}
	
	/**
	 * @author 单强	2014-08-05
	 * 功能：判断字符串是否为空
	 */
	public static boolean isNotEmpty(String str){
		if(null == str) return false;
		if("".equals(str)) return false;
		return true;
	}
	
	/**
	 * @author 单强	2015-12-02
	 * 功能：判断一个字符串是不是电话号码
	 */
	public static boolean isMobile(String str){
		Pattern p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$"); // 验证手机号
		Matcher m = p.matcher(str);
		return m.matches();
	}
	
	
	/**
	 * @author 单强  2015年5月12日
	 * @return 获取有效的用户名
	 * @author 单强  2015年6月4日
	 * 根据文件路径或者文件名称获取文件后缀
	 */
	public static String getFileSuffix(String filename){
		return filename.substring( filename.lastIndexOf(".") );
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static String getUUIDoutpath(String source){
		String suffix = "";
		if(StringHelper.isNotEmpty(source)) suffix = StringHelper.getFileSuffix(source);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String str = sdf.format(new Date());
		return str.substring(0,4) + "/" + str.substring(4, 6) + "/" + str.substring(6, 8) + "/" + str + suffix;
	}

	public static String getUUIDoutpath(){
		return StringHelper.getUUIDoutpath("");
	}
	
	public static final String[] chars = new String[] { "a", "b", "c", "d", "e", "f",  
        "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",  
        "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",  
        "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",  
        "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
        "W", "X", "Y", "Z" };
	public static String generateShortUuid() {
	    StringBuffer shortBuffer = new StringBuffer();  
	    String uuid = UUID.randomUUID().toString().replace("-", "");
	    for (int i = 0; i < 8; i++) {
	        String str = uuid.substring(i * 4, i * 4 + 4);
	        int x = Integer.parseInt(str, 16);
	        shortBuffer.append(chars[x % 0x3E]);
	    }
	    return shortBuffer.toString();  
	}
	
	public static String generateShortUuid(int len) {
	    StringBuffer shortBuffer = new StringBuffer();  
	    String uuid = UUID.randomUUID().toString().replace("-", "");
	    int tm = uuid.length()/len;
	    for (int i = 0; i < len; i++) {
	        String str = uuid.substring(i * tm, i * tm + tm);
	        int x = Integer.parseInt(str, 16);
	        shortBuffer.append(chars[x % 0x3E]);
	    }
	    return shortBuffer.toString();  
	}
	
	
	public static String[] useragents = null;
	static{
		useragents = new String[]{
				"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50",
				"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0",
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:2.0.1) Gecko/20100101 Firefox/4.0.1",
				"Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1",		//Firefox 4.0.1 – Windows
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11",	//Chrome 17.0 – MAC
				"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SE 2.X MetaSr 1.0; SE 2.X MetaSr 1.0; .NET CLR 2.0.50727; SE 2.X MetaSr 1.0)",
				"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)",
				"Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5",
				"Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
				"Opera/9.80 (Android 2.3.4; Linux; Opera Mobi/build-1107180945; U; en-GB) Presto/2.8.149 Version/11.10",
				"UCWEB7.0.2.37/28/999"
		};
	}
	public static String getRandUserAgent(){
		int index = (new Random()).nextInt(useragents.length);
		return useragents[index];
	}
	
	
	/**
	 * @param str
	 * @param charset	编码：utf-8， gbk
	 * @return
	 * @throws Exception
	 * URL编码
	 */
	public static String urlencode(String str, String charset) throws Exception{
		 return new String(java.net.URLEncoder.encode(str, charset).getBytes());
	}
	
	/**
	 * @param str
	 * @param charset
	 * @throws Exception
	 * URL解码
	 */
	public static String urldecode(String str, String charset) throws Exception{
		return java.net.URLDecoder.decode(new String(str.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
	}
	
	
	/**
	 * @param coll
	 * @功能：打印列表集合
	 */
	public static void printList(Collection<String> coll){
		if(coll==null || coll.size()==0) {
			System.out.println("集合为空");
			return ;
		}
		for(String obj : coll){
			System.out.println(obj.toString());
		}
	}
	
	/**
	 * https://www.oschina.net/code/snippet_107039_6026
	 * java去除字符串中的空格、回车、换行符、制表符
	 * sb.replaceAll( "\\s*|\t|\r|\n", "" )
	 * str.replaceAll( "\\s", "" )
	 */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static int strToInt(String str){
    	if(str==null||"".equals(str)){
    		return 0;
    	}
    	int value = Integer.parseInt(str);
    	return value;	
    }
	
	
	public static void main(String[] args) throws Exception{
		String str = StringHelper.getRandUserAgent();
		System.out.println(str);
		
		String name="中文";
		  //URL编码
		  String nameStr=new String(java.net.URLEncoder.encode(name,"gbk").getBytes());
		  System.out.println(nameStr);
		  
		  String cnStr = "中文";
		  String cnStr1 = "";
		  
		  cnStr1 = new String(java.net.URLEncoder.encode(cnStr, "UTF-8").getBytes(), "ISO-8859-1");
		  System.out.println(cnStr1);
		  //URL解码
		  System.out.println(java.net.URLDecoder.decode(new String(cnStr1.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
		  
	}

}






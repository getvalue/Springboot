package com.gmbsh.util;
/**
 * 字符串相关方法
 *
 */
public class StringUtil {

	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList(String valStr){
	    int i = 0;
	    String TempStr = valStr;
	    String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
	    valStr = valStr + ",";
	    while (valStr.indexOf(',') > 0)
	    {
	        returnStr[i] = valStr.substring(0, valStr.indexOf(','));
	        valStr = valStr.substring(valStr.indexOf(',')+1 , valStr.length());
	        
	        i++;
	    }
	    return returnStr;
	}

	/**
	 * 不为空
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		return null == str || "".equals(str) || "null".equals(str);
	}

	/**
	 * 为空
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj) {
		return null == obj || "".equals(obj);
	}

}

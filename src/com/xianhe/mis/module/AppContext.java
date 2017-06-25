package com.xianhe.mis.module;

import java.util.HashMap;
import java.util.Map;

public class AppContext {
	public final static String IN_STATUS = "IN_STATUS";
	public final static int IN_STATUS_INITIAL = 0;
	public final static int IN_STATUS_READED = 1;
	public final static int IN_STATUS_COPY = 2;

	private static Map<String,Integer> status = new HashMap<String,Integer>();
	
	public static synchronized void setStatus(String key,Integer value){
		status.put(key, value);
	}
	
	public static synchronized Integer getStatus(String key){
		return status.get(key);
	}
}

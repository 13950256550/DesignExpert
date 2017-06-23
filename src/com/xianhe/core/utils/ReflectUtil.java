package com.xianhe.core.utils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReflectUtil {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static Method getDeclaredMethod(Object object, String methodName,Class<?>... parameterTypes) {
		Method method = null;
		for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				method = clazz.getDeclaredMethod(methodName, parameterTypes);
				return method;
			} catch (Exception e) {
				// 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				// 如果这里的异常打印或者往外抛，则就不会执行clazz =
				// clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}
		return null;
	}
	
	public static void setFieldValue(Object entity,String field,String value){
		try {
			String methodName = getMethodName(field,"get");
			Method method = getDeclaredMethod(entity,methodName, null);
			Class paramType = method.getReturnType();
			methodName = getMethodName(field,"set");
			method = getDeclaredMethod(entity,methodName, paramType);
			Object fieldValue = getCastValue(value,paramType);
			method.invoke(entity,fieldValue);
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	public static String getMethodName(String fieldName,String perfix){
		if(fieldName!=null && fieldName.length()>0){
			fieldName = fieldName.toUpperCase().substring(0,1)+fieldName.substring(1);
		}else{
			fieldName = "";
		}
		String methodName = perfix+fieldName;
		return methodName;
	}
	
	
	public static Object getFieldValue(Object entity,String field){
		if(field!=null && field.length()>0){
			field = field.toUpperCase().substring(0,1)+field.substring(1);
		}else{
			field = "";
		}
		String methodName = "get"+field;
		Object result = null;
		try {
			Method method = entity.getClass().getDeclaredMethod(methodName, null);
			result = method.invoke(entity,null);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return result;
	}
	
	public static Object getCastValue(String value,Class aClass){
		Object resultValue = null;
		if(value!=null && !"".equals(value.trim())){
			String className = aClass.getSimpleName();
			try {
				if("BigDecimal".equals(className)){
					resultValue = new BigDecimal(value);
				}else if("Double".equals(className)){
					resultValue = new Double(value);
				}else if("Long".equals(className)){
					//resultValue = new Long(value);
					resultValue = new Double(value).longValue();
				}else if("Integer".equals(className)){
					//resultValue = new Integer(value);
					resultValue = new Double(value).intValue();
				}else if("String".equals(className)){
					resultValue = value;
				}else if("Date".equals(className)){
					java.util.Date date = dateFormat.parse(value);
					className = aClass.getName();
					if("java.sql.Date".equals(className)){
						resultValue = new java.sql.Date(date.getTime());
					}else if("java.util.Date".equals(className)){
						resultValue = date; 
					}
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return resultValue;
	}
}

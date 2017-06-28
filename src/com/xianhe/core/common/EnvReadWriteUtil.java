package com.xianhe.core.common;

import java.io.File;
import java.io.IOException;

import org.ini4j.Config;
import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;

public class EnvReadWriteUtil {
	private static String EnvFile = "DesignFanEnv.ini";
	
	public static File getEnvFile(){
		String path = EnvReadWriteUtil.class.getResource("/DesignFanEnv.ini").getPath();
		//System.out.println(path);
		File file = new File(path);
		return file;
	}
	
	public static Ini getEvnIni(){
		Config cfg = new Config();
		cfg.setMultiSection(true);  
        Ini ini = new Ini();  
        ini.setConfig(cfg);
        
        try {
			ini.load(getEnvFile());
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return ini;
	}
	
	public static void setDefaultWorkPath(String id){
		File file = getEnvFile();
		Ini ini = getEvnIni();
		Section session = ini.get("ENVNUM");
		session.put("DEFAULT", id);
		
		try {
			ini.store(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getWorkPath(){
		String result = "";
		
		Ini ini = getEvnIni();
		Section session = ini.get("ENVNUM");
		String id = session.get("DEFAULT");
		
		for (Section aSession : ini.getAll("ITEM")) {
			if(aSession.get("ID").equals(id)){
				result = aSession.get("PATH");
				break;
			}
		}
		return result;
	}
	
	public static void addWorkPath(String id,String name,String path){
		Ini ini = getEvnIni();

		Section session = ini.add("ITEM");
		session.add("ID", id);
		session.add("NAME", name);
		session.add("PATH", path);
		
		File file = getEnvFile();
		try {
			ini.store(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static File getFile(String fileName){
		File file = new File(getWorkPath()+"/"+fileName);
		return file;
	}
	
	/*
	public static File get1D_in1File(){
		File file = new File(getWorkPath()+"/1D/1d_in1");
		return file;
	}
	
	public static File get1D_in2File(){
		File file = new File(getWorkPath()+"/1D/1d_in2");
		return file;
	}
	
	public static File get1D_outFile(){
		File file = new File(getWorkPath()+"/1D/1d_out");
		return file;
	}
	*/
	public static void main(String[] args) {
	}

}

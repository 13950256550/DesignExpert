package com.xianhe.mis.module.module1D.readwritefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class PathUtil {
	private static String pathFileName = "path.txt";
	public static File getPathFile(){
		String path = PathUtil.class.getResource("/").getPath();
		File file = new File(path+"/"+pathFileName);
		
		return file;
	}
	public static void setWorkPath(String workPath){
		File file = getPathFile();
		
		OutputStream os = null;
		try {
			byte[] buffer = workPath.getBytes();
			os = new FileOutputStream(file);
			os.write(buffer, 0, buffer.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String getWorkPath(){
		String result = "";
		File file = getPathFile();
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			result = in.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
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
	
	public static void main(String[] args) {
	}

}

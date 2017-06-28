package com.xianhe.mis.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.xianhe.core.common.EnvReadWriteUtil;
import com.xianhe.core.common.MyRunnable;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class Module1DController {
	String lineStr = null;
	public void calculate(String path,TextArea textArea){
		System.out.println("calculate");
		Runtime run = Runtime.getRuntime();
		String cmd = "ping www.baidu.com -t";
		cmd = EnvReadWriteUtil.getWorkPath();
		cmd = cmd.substring(0,cmd.length()-1);
		cmd += path;
		try {
			Process p = run.exec(cmd);// ������һ��������ִ������ 
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
			BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
			//String lineStr;  
			while ((lineStr = inBr.readLine()) != null) { 
			    //�������ִ�к��ڿ���̨�������Ϣ  
			    //System.out.println(lineStr);// ��ӡ�����Ϣ  
				Platform.runLater(new MyRunnable(textArea,lineStr));
			}
			//��������Ƿ�ִ��ʧ�ܡ�  
			if (p.waitFor() != 0) {  
			    if (p.exitValue() == 1){//p.exitValue()==0��ʾ����������1������������  
			        //System.err.println("����ִ��ʧ��!");
			        textArea.appendText("����ִ��ʧ��!\n");
			    }else if (p.exitValue() == 0){
			    	textArea.appendText("����ִ�����!\n");
			    }
			}  
			inBr.close();  
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}

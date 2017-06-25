package com.xianhe.mis.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.scene.control.TextArea;

public class Module1DController {
	public void calculate(TextArea textArea){
		System.out.println("calculate");
		Runtime run = Runtime.getRuntime();
		String cmd = "ping www.baidu.com -t";
		try {
			Process p = run.exec(cmd);// ������һ��������ִ������ 
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
			BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
			String lineStr;  
			while ((lineStr = inBr.readLine()) != null) { 
			    //�������ִ�к��ڿ���̨�������Ϣ  
			    //System.out.println(lineStr);// ��ӡ�����Ϣ  
				textArea.appendText(lineStr);
				textArea.appendText("\n");
			}
			//��������Ƿ�ִ��ʧ�ܡ�  
			if (p.waitFor() != 0) {  
			    if (p.exitValue() == 1){//p.exitValue()==0��ʾ����������1������������  
			        //System.err.println("����ִ��ʧ��!");
			        textArea.appendText("����ִ��ʧ��!\n");
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

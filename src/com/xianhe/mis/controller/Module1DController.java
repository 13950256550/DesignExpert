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
			Process p = run.exec(cmd);// 启动另一个进程来执行命令 
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
			BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
			String lineStr;  
			while ((lineStr = inBr.readLine()) != null) { 
			    //获得命令执行后在控制台的输出信息  
			    //System.out.println(lineStr);// 打印输出信息  
				textArea.appendText(lineStr);
				textArea.appendText("\n");
			}
			//检查命令是否执行失败。  
			if (p.waitFor() != 0) {  
			    if (p.exitValue() == 1){//p.exitValue()==0表示正常结束，1：非正常结束  
			        //System.err.println("命令执行失败!");
			        textArea.appendText("命令执行失败!\n");
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

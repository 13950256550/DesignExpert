package com.xianhe.core.common;

import javafx.scene.control.TextArea;

public class MyRunnable implements Runnable {
	private TextArea textArea = null;
	private String line = null;
	
	public MyRunnable(TextArea textArea,String line){
		this.textArea = textArea;
		this.line = line;
	}
	@Override
	public void run() {
		textArea.appendText(line);
		textArea.appendText("\n");
	}

}

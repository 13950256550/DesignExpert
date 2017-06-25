package com.xianhe.mis.input;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class InputEventHandler implements EventHandler<ActionEvent> {
	private String inputId = null;
	
	public InputEventHandler(String inputId) {
		super();
		this.inputId = inputId;
	}

	@Override
	public void handle(ActionEvent event) {
	}

}

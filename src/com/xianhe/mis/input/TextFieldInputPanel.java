package com.xianhe.mis.input;

import com.xianhe.core.common.InputItemConfig;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

public class TextFieldInputPanel extends InputPanel /*implements EventHandler<ActionEvent>*/{

	public TextFieldInputPanel(InputItemConfig inputItemConfig){
		super(inputItemConfig);
	}
	
	public Control createControl(InputItemConfig inputItemConfig){
		TextField textField = new TextField();
		//textField.setOnAction(this);
		return textField;
	}
	
	//@Override
	public void handle(ActionEvent event) {
		this.dataChanged();
	}

	@Override
	public void setValue(Object value) {
		TextField textField = (TextField)control;
		if(textField!=null){
			textField.setText(String.valueOf(value));
		}
	}

	@Override
	public Object getValue() {
		String result = null;
		TextField textField = (TextField)control;
		if(textField!=null){
			result = textField.getText();
		}
		
		if(result==null || "".equals(result.trim())){
			result = "0";
		}
		return result;
	}
}

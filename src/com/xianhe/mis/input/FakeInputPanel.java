package com.xianhe.mis.input;

import com.xianhe.core.common.InputItemConfig;

import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.text.TextAlignment;

public class FakeInputPanel extends InputPanel{

	public FakeInputPanel(InputItemConfig inputItemConfig){
		super(inputItemConfig);
		
		label.setAlignment(Pos.CENTER_LEFT);
		label.setTextAlignment(TextAlignment.LEFT);
	}
	
	public Control createControl(InputItemConfig inputItemConfig){
		return null;
	}

	@Override
	public void setValue(Object value) {
		
	}

	@Override
	public Object getValue() {
		return null;
	}
	
	
}

package com.xianhe.mis.input;

import com.xianhe.core.common.Code;
import com.xianhe.core.common.InputItemConfig;
import com.xianhe.mis.module.module1D.CodeList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

public class ComoboxInputPanel extends InputPanel implements EventHandler<ActionEvent>{

	public ComoboxInputPanel(InputItemConfig inputItemConfig){
		super(inputItemConfig);
	}
	
	public Control createControl(InputItemConfig inputItemConfig){
		ComboBox comboBox = new ComboBox();
		CodeList list = CodeList.getCodeListByName(inputItemConfig.getId());
		if(list!=null){
			for(Code code:list.getCodeList()){
				comboBox.getItems().add(code);
			}
		}
		
		comboBox.setOnAction(this);
		return comboBox;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.dataChanged();
	}

	@Override
	public void setValue(Object value) {
		ComboBox comboBox = (ComboBox)control;
		if(comboBox!=null){
			for(int i=0;i<comboBox.getItems().size();i++){
				Object object = comboBox.getItems().get(i);
				if(object instanceof Code){
					Code code = (Code)object;
					if(code.getKey().equals(value)){
						comboBox.getSelectionModel().select(i);
						break;
					}
				}
			}
		}
	}

	@Override
	public Object getValue() {
		String result = "0";
		ComboBox comboBox = (ComboBox)control;
		if(comboBox!=null){
			Object object = comboBox.getValue();
			if(object instanceof Code){
				Code code = (Code)object;
				result = code.getKey();
			}
		}
		
		return result;
	}
}

package com.xianhe.mis.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xianhe.core.common.InputItemConfig;

import javafx.scene.layout.HBox;

public class RowPanel extends HBox{
	private List<InputPanel> inputPanels = new ArrayList<InputPanel>();
	
	public RowPanel(List<InputItemConfig> inputItemConfigs) {
		for(InputItemConfig inputItemConfig:inputItemConfigs){
			InputPanel panel = InputPanel.createInputPanel(inputItemConfig);
			inputPanels.add(panel);
			this.getChildren().add(panel);
		}
	}
	
	public void setValue(String id,Object value){
		for(InputPanel inputPanel:inputPanels){
			String panelId = inputPanel.getInputPanelId();
			if(panelId!=null && panelId.equals(id)){
				inputPanel.setValue(value);
			}
		}
	}
	
	public Object getValue(String id){
		Object result = "";
		for(InputPanel inputPanel:inputPanels){
			String panelId = inputPanel.getInputPanelId();
			if(panelId!=null && panelId.equals(id)){
				result = inputPanel.getValue();
				break;
			}
		}
		return result;
	}
	
	public InputPanel getInputPanel(String id){
		InputPanel result = null;
		for(InputPanel inputPanel:inputPanels){
			String panelId = inputPanel.getInputPanelId();
			if(panelId!=null && panelId.equals(id)){
				result = inputPanel;
				break;
			}
		}
		return result;
	}
	
	public void getValueIntoMap(Map<String,Object> map){
		for(InputPanel inputPanel:inputPanels){
			String panelId = inputPanel.getInputPanelId();
			if(panelId!=null){
				map.put(panelId,inputPanel.getValue());
			}
		}
	}
	
	public void setInputChangeListener(String id){
		for(InputPanel inputPanel:inputPanels){
			String panelId = inputPanel.getInputPanelId();
			if(id!=null && id.equals(panelId)){
				inputPanel.setInputChangeListener();
			}
		}
	}
	
	public void setReadonly(boolean flag){
		for(InputPanel inputPanel:inputPanels){
			inputPanel.setReadonly(flag);
		}
	}
	
	public void setReadonly(String id,boolean flag){
		for(InputPanel inputPanel:inputPanels){
			String panelId = inputPanel.getInputPanelId();
			if(id!=null && id.equals(panelId)){
				inputPanel.setReadonly(flag);
			}
		}
	}
}

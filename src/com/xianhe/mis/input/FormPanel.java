package com.xianhe.mis.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xianhe.core.common.RowConfig;

import javafx.scene.layout.VBox;

public class FormPanel extends VBox {
	public List<RowPanel> rowPanels = new ArrayList<RowPanel>();
	
	public FormPanel(List<RowConfig> rowConfigs) {
		for(RowConfig rowConfig:rowConfigs){
			RowPanel panel = new RowPanel(rowConfig.inputItemConfigs);
			getChildren().add(panel);
			rowPanels.add(panel);
		}
	}
	
	public void setValue(String id,Object value){
		for(RowPanel rowPanel:rowPanels){
			rowPanel.setValue(id, value);
		}
	}
	
	public Object getValue(String id){
		Object result = null;
		for(RowPanel rowPanel:rowPanels){
			InputPanel inputPanel = null;
			inputPanel = rowPanel.getInputPanel(id);
			if(inputPanel!=null){
				result = inputPanel.getValue();
			}
		}
		return result;
	}
	
	public void getValueIntoMap(Map<String,Object> map){
		for(RowPanel rowPanel:rowPanels){
			rowPanel.getValueIntoMap(map);
		}
	}
}

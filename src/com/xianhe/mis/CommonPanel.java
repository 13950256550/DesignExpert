package com.xianhe.mis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xianhe.mis.input.FormPanel;
import com.xianhe.mis.input.InputPanel;
import com.xianhe.mis.input.RowPanel;

import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class CommonPanel extends VBox {
	private List<FormPanel> panels = new ArrayList<FormPanel>();
	
	public void addFormPanel(FormPanel panel){
		panels.add(panel);
		panel.setPadding(new Insets(20,0,0,0));
		this.getChildren().add(panel);
	}
	
	public void addFormPanel(FormPanel panel,String title){
		panels.add(panel);
		TitledPane titledPane = new TitledPane();
		titledPane.setText(title);
		titledPane.setCollapsible(false);
		titledPane.setContent(panel);
		titledPane.setPadding(new Insets(20,0,0,0));
		this.getChildren().add(titledPane);
	}

	public void setValue(String id,Object value){
		for(FormPanel formPanel:panels){
			formPanel.setValue(id, value);
		}
	}
	
	public Object getValue(String id){
		Object result = null;
		for(FormPanel formPanel:panels){
			result = formPanel.getValue(id);
			if(result!=null){
				return result;
			}
		}
		return result;
	}
	
	public void getValueIntoMap(Map<String,Object> map){
		for(FormPanel formPanel:panels){
			formPanel.getValueIntoMap(map);
		}
	}
	
	public void setValueFromMap(Map<String,Object> map){
		Set<String> keys = map.keySet();
		for(String key:keys){
			Object value = map.get(key);
			setValue(key,value);
		}
	}
	
	public void setReadonly(boolean flag){
		for(FormPanel formPanel:panels){
			formPanel.setReadonly(flag);
		}
	}
	
	public void setReadonly(String id,boolean flag){
		for(FormPanel formPanel:panels){
			formPanel.setReadonly(id,flag);
		}
	}
	
	public Control getInputControl(String id){
		Control control = null;
		for(FormPanel formPanel:panels){
			control = formPanel.getInputControl(id);
		}
		return control;
	}
	
	public InputPanel getInputPanel(String id){
		InputPanel result = null;
		for(FormPanel formPanel:panels){
			result = formPanel.getInputPanel(id);
			if(result!=null){
				break;
			}
		}
		return result;
	}
}

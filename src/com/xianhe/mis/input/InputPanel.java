package com.xianhe.mis.input;

import java.util.List;

import org.apache.log4j.Logger;

import com.xianhe.core.common.InputItemConfig;
import com.xianhe.core.common.InputItemType;
import com.xianhe.mis.module.module1D.CodeList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;

public abstract class InputPanel extends HBox{
	public static Logger logger = Logger.getLogger(InputPanel.class);
	protected InputItemConfig inputItemConfig = null;
	protected Control control = null;
	protected Label label = null;
	
	public InputPanel(){
	}
	
	public InputPanel(InputItemConfig inputItemConfig){
		this.inputItemConfig = inputItemConfig;
		init();
	}
	
	public void init(){
		this.setSpacing(5);
		label = new Label(inputItemConfig.getLabel());
		label.setPrefHeight(inputItemConfig.getHeight()[0]);
		label.setPrefWidth(inputItemConfig.getWidth()[0]);
		label.setWrapText(inputItemConfig.isWrapText());

		label.setAlignment(Pos.CENTER_RIGHT);
		label.setTextAlignment(TextAlignment.RIGHT);

		getChildren().add(label);
		
		control = createControl(inputItemConfig);
		if(control!=null){
			control.setPrefHeight(inputItemConfig.getHeight()[1]);
			control.setPrefWidth(inputItemConfig.getWidth()[1]);
			getChildren().add(control);
			
			if(inputItemConfig.isReadonly()){
				control.setDisable(true);
			}
		}
		
		setPrefHeight(inputItemConfig.getPanelHeight());
		setPrefWidth(inputItemConfig.getWidth()[2]);
		
		setPadding(new Insets(1,1,1,1));
		setAlignment(Pos.CENTER);
	}
	
	public abstract Control createControl(InputItemConfig inputItemConfig);
	
	/*
	
	public Control createControl(InputItemConfig inputItemConfig){
		Control control = null;
		
		if(isCodeList(inputItemConfig)){
			inputItemConfig.setType(InputItemType.combobox);
		}
		
		switch (inputItemConfig.getType()) {
		case fake:
			control = null;
			break;
		case combobox:
			control = createComboBox(inputItemConfig);
			break;
		case grid:
			control = createGrid(inputItemConfig);
			break;
		default:
			TextField textField = new TextField();
			textField.setOnAction(this);
			control = textField;
		}
		
		if(inputItemConfig.isReadonly()){
			control.setDisable(true);
		}
		
		return control;
	}
	
	public Control createComboBox(InputItemConfig inputItemConfig){
		Control control = null;
		
		ComboBox comboBox = new ComboBox();
		CodeList list = CodeList.getCodeListByName(inputItemConfig.getId());
		for(Code code:list.getCodeList()){
			comboBox.getItems().add(code);
		}
		
		comboBox.setOnAction(this);
		
		control = comboBox;
		
		return control;
	}
	
	public static Control createGrid(InputItemConfig inputItemConfig){
		TableView tableView = new TableView();
		
		TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        
        tableView.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        
        return tableView;
	}
	*/
	
	/*
	public void setValue(Object value){
		if(inputItemConfig.getType()!=InputItemType.fake){
			if(inputItemConfig.getType()==InputItemType.combobox){
				ComboBox comboBox = (ComboBox)control;
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
			}else{
				TextField textField = (TextField)control;
				textField.setText(String.valueOf(value));
			}
		}
	}
	
	public Object getValue(){
		String result = "";
		if(inputItemConfig.getType()!=InputItemType.fake){
			if(inputItemConfig.getType()==InputItemType.combobox){
				ComboBox comboBox = (ComboBox)control;
				Object object = comboBox.getValue();
				if(object instanceof Code){
					Code code = (Code)object;
					result = code.getKey();
				}
			}else{
				TextField textField = (TextField)control;
				result = textField.getText();
			}
		}
		return result;
	}
	*/
	
	public abstract void setValue(Object value);
	public abstract Object getValue();
	
	public String getInputPanelId(){
		return inputItemConfig.getId();
	}
	
	public void setReadonly(boolean flag){
		if(control!=null){
			control.setDisable(flag);
		}
	}
	
	public void setInputChangeListener(){
		if(control!=null){
			InputChangeListener listener = new InputChangeListener(inputItemConfig.getId());
			if(control instanceof ComboBox){
				((ComboBox)control).getSelectionModel().selectedItemProperty().addListener(listener);
			}else if(control instanceof TextField){
				((TextField)control).setOnAction(listener);
			}
		}
	}
	
	public void dataChanged(){
	}
	
	public static boolean isCodeList(InputItemConfig inputItemConfig){
		boolean result = false;
		CodeList codeList = CodeList.getCodeListByName(inputItemConfig.getId());
		if(codeList!=null){
			result = true;
		}
		return result;
	}
	
	public static InputPanel createInputPanel(InputItemConfig inputItem) {
		InputPanel panel = null;
		
		if(isCodeList(inputItem)){
			inputItem.setType(InputItemType.combobox);
		}
		
		switch (inputItem.getType()) {
		case grid:	
			GridPanel gridPanel = new GridPanel(inputItem);
			gridPanel.setColumns(inputItem.getColumnNames());
			gridPanel.setRowHeader(inputItem.getRowNames());
			panel = gridPanel;
			break;
		case combobox:
			panel = new ComoboxInputPanel(inputItem);
			break;
		case fake:
			panel = new FakeInputPanel(inputItem);
			break;	
		default:
			panel = new TextFieldInputPanel(inputItem);
		}
		return panel;
	}
	
	public void setGridRowHeader(List<String> rowNames){
	}
	
	public Control getInputControl(){
		return control;
	}
}

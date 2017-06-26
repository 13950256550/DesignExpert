package com.xianhe.mis.module.module1D.view.input1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xianhe.core.common.InputItemConfig;
import com.xianhe.core.common.InputItemType;
import com.xianhe.core.common.RowConfig;
import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.input.FormPanel;
import com.xianhe.mis.input.GridPanel;
import com.xianhe.mis.module.module1D.constant.ControlVariableConstant;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OneDimensionalDgazdInputPanel extends CommonPanel {
	public OneDimensionalDgazdInputPanel() {
		FormPanel panel = getFormPanel1();
		addFormPanel(panel);
		
		panel = getFormPanel2();
		addFormPanel(panel);
		setColName(panel);
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(ControlVariableConstant.DZV���ڵ�Ҷ������򳤶ȱ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.DXV���򳤶�����ϵ��);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(ControlVariableConstant.NZV��Ҷ�ڼ���վ��);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);

		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig("OneDimensionalDgazdInputPanel.grid1",InputItemType.grid);

        List<String> colNames = new ArrayList<String>();
        colNames.add("ת��Ҷ�ż�����򳤶ȱ�");
        colNames.add("����Ҷ�ż�����򳤶ȱ�");
        colNames.add("ת��Ҷ�����򳤶�����ϵ��");
        colNames.add("����Ҷ�����򳤶�����ϵ��");
        colNames.add("ת��Ҷ���ڼ���ļ���վ��");
        colNames.add("����Ҷ���ڼ���ļ���վ��");
        inputItemConfig.setColumnNames(colNames);
        
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		
		return panel;
	}
	
	public void setColName(FormPanel panel){
		GridPanel gridPanel = (GridPanel)(panel.rowPanels.get(0).getInputPanel("OneDimensionalDgazdInputPanel.grid1"));
		TableView<Map<Integer,String>> tableView = gridPanel.getTableView();

		List<String> colNames = new ArrayList<String>();
		colNames.add("");
		colNames.add("DZR");
        colNames.add("DZS");
        colNames.add("DXR");
        colNames.add("DXS");
        colNames.add("NZR");
        colNames.add("NZS");
        
        for(int i=1;i<7;i++){
        	TableColumn col = tableView.getColumns().get(i);
        	tableView.getColumns().remove(col);
			TableColumn<Map<Integer,String>, String> col2 = new TableColumn<Map<Integer,String>, String>(colNames.get(i));
			col2.getColumns().add(col);
			col.setPrefWidth(150);
			tableView.getColumns().add(i, col2);
		}
        
        tableView.setPrefHeight(9*25);
        tableView.setPrefWidth(930);
	}
}

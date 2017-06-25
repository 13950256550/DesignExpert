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
import com.xianhe.mis.module.module1D.constant.FeaturesCalculateConstant;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FeaturesCalculate3Panel extends CommonPanel {
	public FeaturesCalculate3Panel() {
		FormPanel panel = getFormPanel1();
		addFormPanel(panel);
		
		panel = getFormPanel2();
		addFormPanel(panel);
		
		setColName(panel);
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.IGKA1输入,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig("FeaturesCalculate3Panel.grid1",InputItemType.grid);
		
		List<String> rowNames = new ArrayList<String>();
	    rowNames.add("1");
	    rowNames.add("2");
	    rowNames.add("3");
	    rowNames.add("4");
	    rowNames.add("5");
	    rowNames.add("6");
	    rowNames.add("7");
	    inputItemConfig.setRowNames(rowNames);
	    
	    List<String> colNames = new ArrayList<String>();
	    colNames.add("落后角补偿");
	    colNames.add("流量堵塞系数");
	    colNames.add("功储备系数");
	    colNames.add("功率衰减系数");
	    inputItemConfig.setColumnNames(colNames);
	
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public void setColName(FormPanel panel){
		GridPanel gridPanel = (GridPanel)(panel.rowPanels.get(0).getInputPanel("FeaturesCalculate3Panel.grid1"));
		TableView<Map<Integer,String>> tableView = gridPanel.getTableView();

		List<String> colNames = new ArrayList<String>();
		colNames.add("");
		colNames.add("KG");
	    colNames.add("KDB");
	    colNames.add("KHS");
	    colNames.add("KEF");
        
        for(int i=1;i<5;i++){
        	TableColumn col = tableView.getColumns().get(i);
        	tableView.getColumns().remove(col);
			TableColumn<Map<Integer,String>, String> col2 = new TableColumn<Map<Integer,String>, String>(colNames.get(i));
			col2.getColumns().add(col);
			tableView.getColumns().add(i, col2);
		}
        
        tableView.setPrefHeight(9*25);
        tableView.setPrefWidth(450);
	}
}

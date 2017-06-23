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
import com.xianhe.mis.module.module1D.constant.CheckQuestion1Constant;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CheckQuestion3Panel extends CommonPanel {
	public CheckQuestion3Panel() {
		FormPanel panel = getFormPanel1();
		addFormPanel(panel,CheckQuestion1Constant.K1或K3或K4且K122);

		//Map<String,Object> map = ReadInputFileData.parse1D();
		//this.setValueFromMap(map);
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig("CheckQuestion3Panel.grid1",InputItemType.grid);
		
		List<String> rowNames = new ArrayList<String>();
        rowNames.add("1");
        rowNames.add("2");
        rowNames.add("3");
        rowNames.add("4");
        rowNames.add("5");
        rowNames.add("6");
        rowNames.add("7");
        rowNames.add("8");
        inputItemConfig.setRowNames(rowNames);
        
        List<String> colNames = new ArrayList<String>();
        colNames.add("转子稠度");
        colNames.add("静子稠度");
        colNames.add("转子进口绝对气流角");
        colNames.add("转子叶片数或展弦比");
        colNames.add("静子叶片数或展弦比");
        colNames.add("转子最大厚度相对位置");
        colNames.add("静子最大厚度相对位置");
        colNames.add("级理论功储备系数");
        inputItemConfig.setColumnNames(colNames);
        
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		setColName(panel);
		
		return panel;
	}
	
	public void setColName(FormPanel panel){
		GridPanel gridPanel = (GridPanel)(panel.rowPanels.get(0).getInputPanel("CheckQuestion3Panel.grid1"));
		TableView<Map<Integer,String>> tableView = gridPanel.getTableView();

		List<String> colNames = new ArrayList<String>();
		colNames.add("");
		colNames.add("BTR");
        colNames.add("BTS");
        colNames.add("ALF");
        colNames.add("IZR/ASPR");
        colNames.add("IZS/ASPS");
        colNames.add("ABR");
        colNames.add("ABS");
        colNames.add("KHI");
        
        for(int i=1;i<9;i++){
        	TableColumn col = tableView.getColumns().get(i);
        	tableView.getColumns().remove(col);
			TableColumn col2 = new TableColumn(colNames.get(i));
			col2.getColumns().add(col);
			tableView.getColumns().add(i, col2);
		}
        
        tableView.setPrefHeight(10*25);
        tableView.setPrefWidth(950);
	}
}

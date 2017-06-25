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
import com.xianhe.mis.module.module1D.constant.CheckQuestionConstant;
import com.xianhe.mis.module.module1D.readwritefile.ReadInputFileData;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;

public class CheckQuestion2Panel extends CommonPanel {
	public CheckQuestion2Panel() {
		FormPanel panel = getFormPanel1();
		addFormPanel(panel,CheckQuestionConstant.K1或K3或K4且K122);

		//Map<String,Object> map = ReadInputFileData.parse1D();
		//this.setValueFromMap(map);
		
		setColName(panel);
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig("CheckQuestion2Panel.grid1",InputItemType.grid);
		
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
        colNames.add("转子进口外径");
        colNames.add("转子进口内径");
        colNames.add("转子出口外径");
        colNames.add("转子出口内径");
        colNames.add("级加功因子");
        colNames.add("转子最大相对厚度");
        colNames.add("静子最大相对厚度");
        colNames.add("级流量储备系数");
        inputItemConfig.setColumnNames(colNames);

		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public void setColName(FormPanel panel){
		GridPanel gridPanel = (GridPanel)(panel.rowPanels.get(0).getInputPanel("CheckQuestion2Panel.grid1"));
		TableView<Map<Integer,String>> tableView = gridPanel.getTableView();

		List<String> colNames = new ArrayList<String>();
		colNames.add("");
		colNames.add("DT1");
        colNames.add("DH1");
        colNames.add("DT2");
        colNames.add("DH2");
        colNames.add("HZ");
        colNames.add("CMXR");
        colNames.add("CMXS");
        colNames.add("KGI");
        
        for(int i=1;i<9;i++){
        	TableColumn col = tableView.getColumns().get(i);
        	tableView.getColumns().remove(col);
			TableColumn<Map<Integer,String>, String> col2 = new TableColumn<Map<Integer,String>, String>(colNames.get(i));
			col2.getColumns().add(col);
			tableView.getColumns().add(i, col2);
		}
        
        tableView.setPrefHeight(9*25);
        tableView.setPrefWidth(900);
	}
}

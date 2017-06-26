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

public class FeaturesCalculate2Panel extends CommonPanel {

	public FeaturesCalculate2Panel() {
		FormPanel panel = getFormPanel1();
		addFormPanel(panel);
		
		panel = getFormPanel2();
		addFormPanel(panel);
		
		setColName(panel);
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.KGKA1输入,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig("FeaturesCalculate2Panel.grid1",InputItemType.grid);
		
	    List<String> colNames = new ArrayList<String>();
	    colNames.add("转子攻角修正");
	    colNames.add("转速线斜率");
	    colNames.add("转子失速负荷");
	    colNames.add("静子攻角修正");
	    colNames.add("转子A/A*");
	    colNames.add("静子A/A*");
	    inputItemConfig.setColumnNames(colNames);
	
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public void setColName(FormPanel panel){
		GridPanel gridPanel = (GridPanel)(panel.rowPanels.get(0).getInputPanel("FeaturesCalculate2Panel.grid1"));
		TableView<Map<Integer,String>> tableView = gridPanel.getTableView();

		List<String> colNames = new ArrayList<String>();
		colNames.add("");
		colNames.add("DIR");
	    colNames.add("KPR");
	    colNames.add("FAIR");
	    colNames.add("DIS");
	    colNames.add("AGR");
	    colNames.add("AGS");
        
        for(int i=1;i<7;i++){
        	TableColumn col = tableView.getColumns().get(i);
        	tableView.getColumns().remove(col);
			TableColumn<Map<Integer,String>, String> col2 = new TableColumn<Map<Integer,String>, String>(colNames.get(i));
			col2.getColumns().add(col);
			tableView.getColumns().add(i, col2);
		}
        
        tableView.setPrefHeight(9*25);
        tableView.setPrefWidth(700);
	}
}

package com.xianhe.mis.module.module1D.view.input1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xianhe.core.common.InputItemConfig;
import com.xianhe.core.common.InputItemType;
import com.xianhe.core.common.RowConfig;
import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.input.FormPanel;
import com.xianhe.mis.module.module1D.constant.AspectRatioCalculateConstant;
import com.xianhe.mis.module.module1D.readwritefile.ReadInputFileData;

public class AspectRatioCalculatePanel extends CommonPanel {
	public AspectRatioCalculatePanel() {
		FormPanel panel = getFormPanel1();
		addFormPanel(panel,AspectRatioCalculateConstant.此计算在设计检查特性后进行);
		
		panel = getFormPanel2();
		addFormPanel(panel);
		
		panel = getFormPanel3();
		addFormPanel(panel);

		//Map<String,Object> map = ReadInputFileData.parse1D();
		//this.setValueFromMap(map);
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.IZAP1必须计算共同工作点,InputItemType.fake,new int[]{300});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.LSR1必须计算共同工作线工作点,InputItemType.fake,new int[]{300});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.此计算只用前三个计算结果,InputItemType.fake,new int[]{300});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);

		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.喘振裕度输入NCU);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.输入不输用程序值,InputItemType.fake,new int[]{300});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.喘振裕度SM,InputItemType.fake,new int[]{300});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);

		return panel;
	}
	
	public FormPanel getFormPanel3(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig("AspectRatioCalculatePanel.grid1",InputItemType.grid);
		
		List<String> rowNames = new ArrayList<String>();
        rowNames.add("SM");
        inputItemConfig.setRowNames(rowNames);
        
        List<String> colName = new ArrayList<String>();
        colName.add("1");
        colName.add("2");
        colName.add("3");
        colName.add("4");
        inputItemConfig.setColumnNames(colName);
        
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		//panel.setBorder(new TitledBorder(null, "NR/QL", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		return panel;
	}
}

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
		addFormPanel(panel,AspectRatioCalculateConstant.�˼�������Ƽ�����Ժ����);
		
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
		InputItemConfig inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.IZAP1������㹲ͬ������,InputItemType.fake,new int[]{300});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.LSR1������㹲ͬ�����߹�����,InputItemType.fake,new int[]{300});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.�˼���ֻ��ǰ����������,InputItemType.fake,new int[]{300});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);

		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.����ԣ������NCU);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.���벻���ó���ֵ,InputItemType.fake,new int[]{300});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(AspectRatioCalculateConstant.����ԣ��SM,InputItemType.fake,new int[]{300});
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

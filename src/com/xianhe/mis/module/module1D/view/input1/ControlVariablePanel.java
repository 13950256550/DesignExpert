package com.xianhe.mis.module.module1D.view.input1;

import java.util.ArrayList;
import java.util.List;

import com.xianhe.core.common.InputItemConfig;
import com.xianhe.core.common.InputItemType;
import com.xianhe.core.common.RowConfig;
import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.input.FormPanel;
import com.xianhe.mis.module.module1D.constant.ControlVariableConstant;

public class ControlVariablePanel extends CommonPanel {
	
	public ControlVariablePanel() {
		FormPanel panel = getFormPanel1();
		addFormPanel(panel);
		panel.setInputChangeListener(ControlVariableConstant.检查或设计_K12);
		panel.setInputChangeListener(ControlVariableConstant.解题类型_K);
		panel.setInputChangeListener(ControlVariableConstant.损失修正符_IZI);
		panel.setInputChangeListener(ControlVariableConstant.静叶可调_IREG);
		
		panel = getFormPanel2();
		addFormPanel(panel,ControlVariableConstant.以下5个参数为向二维设计文件提供输入的控制符);
		
		//Map<String,Object> map = ReadInputFileData.parse1D();
		//this.setValueFromMap(map);
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(ControlVariableConstant.作业题目_TITLT,new int[]{100,500});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(ControlVariableConstant.气压机个数_IRE);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.机组个数_NV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.解题类型_K);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(ControlVariableConstant.检查或设计_K12);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.损失修正符_IZI);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.不输K12_IZI,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(ControlVariableConstant.损失校正系数ALN);
		//inputItemConfig.setReadonly(true);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.ALW);
		//inputItemConfig.setReadonly(true);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.PKN);
		//inputItemConfig.setReadonly(true);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.PKW);
		//inputItemConfig.setReadonly(true);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(ControlVariableConstant.静叶可调_IREG);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.两特性同图IHAR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.不输IREG_IHAR,InputItemType.fake,200);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(ControlVariableConstant.流路转换_IZX);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.叶排轴向长度缩放_IDX);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.性能参数分布_IPE);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(ControlVariableConstant.叶型参数分布_IFH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.叶排内设站_INZ);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		//panel.setBorder(new TitledBorder(null, ControlVariableConstant.以下5个参数为向二维设计文件提供输入的控制符, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		return panel;
	}
}

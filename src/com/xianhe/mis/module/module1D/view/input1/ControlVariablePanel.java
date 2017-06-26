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
		panel.setInputChangeListener(ControlVariableConstant.�������_K12);
		panel.setInputChangeListener(ControlVariableConstant.��������_K);
		panel.setInputChangeListener(ControlVariableConstant.��ʧ������_IZI);
		panel.setInputChangeListener(ControlVariableConstant.��Ҷ�ɵ�_IREG);
		
		panel = getFormPanel2();
		addFormPanel(panel,ControlVariableConstant.����5������Ϊ���ά����ļ��ṩ����Ŀ��Ʒ�);
		
		//Map<String,Object> map = ReadInputFileData.parse1D();
		//this.setValueFromMap(map);
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(ControlVariableConstant.��ҵ��Ŀ_TITLT,new int[]{100,500});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(ControlVariableConstant.��ѹ������_IRE);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.�������_NV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.��������_K);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(ControlVariableConstant.�������_K12);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.��ʧ������_IZI);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.����K12_IZI,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(ControlVariableConstant.��ʧУ��ϵ��ALN);
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
		inputItemConfig = new InputItemConfig(ControlVariableConstant.��Ҷ�ɵ�_IREG);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.������ͬͼIHAR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.����IREG_IHAR,InputItemType.fake,200);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(ControlVariableConstant.��·ת��_IZX);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.Ҷ�����򳤶�����_IDX);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.���ܲ����ֲ�_IPE);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(ControlVariableConstant.Ҷ�Ͳ����ֲ�_IFH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(ControlVariableConstant.Ҷ������վ_INZ);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		//panel.setBorder(new TitledBorder(null, ControlVariableConstant.����5������Ϊ���ά����ļ��ṩ����Ŀ��Ʒ�, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		return panel;
	}
}

package com.xianhe.mis.module.module1D.view.input1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xianhe.core.common.InputItemConfig;
import com.xianhe.core.common.InputItemType;
import com.xianhe.core.common.RowConfig;
import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.input.FormPanel;
import com.xianhe.mis.module.module1D.constant.CheckQuestionConstant;
import com.xianhe.mis.module.module1D.constant.DesignProblemConstant;
import com.xianhe.mis.module.module1D.readwritefile.ReadInputFileData;

public class CheckQuestion1Panel extends CommonPanel {
	public CheckQuestion1Panel() {
		FormPanel panel = getFormPanel1();
		addFormPanel(panel);
		panel.setInputChangeListener(CheckQuestionConstant.ISTAGE����);
		
		//postProcess();
		
		//Map<String,Object> map = ReadInputFileData.parse1D();
		//this.setValueFromMap(map);
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(CheckQuestionConstant.RPMת�ٶȻ��һ��ת��Ҷ�������ٶ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.K1234,InputItemType.fake,250);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.PR��ѹ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.G����);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.PO������ѹ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.TO��������);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.EFF����Ч��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.����0,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ISTAGE����);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KH���ʴ洢ϵ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KPATH��·�����ʶ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KFҶ�ͱ�ʶ);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KCѹ��������);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.SIGO���ڶ���ѹ�ظ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.SIGV���ڵ�Ҷ��ѹ�ظ�);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ѹ��������,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DTK�⾶);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DHK�ھ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ALFOһת��������);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.���ʴ���ϵ��,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KH1��һ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DKH�𼶵ݼ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KHMIN��Сֵ);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KG��������ϵ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ASP1һתչ����);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ASPK���չ����);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.����Ŷ����λ��,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ABV���ڵ�Ҷ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ABRת��ҶƬ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ABS����ҶƬ);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.���ڵ�Ҷ,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.BTHV����ҳ���);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ASPVչ�ұ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.BTV���);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ǰѹ����,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DHO������ֱ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DTO������ֱ��);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.BTH1һת����ҳ���);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.��085��10,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.CMV���ڵ�Ҷ�����Ժ��);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.��������϶,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.E1��һ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DE������һ����);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.�����ܶ�,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DENRת��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DENS����);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DENBҶƬ);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DRESת�Ӹ�����Ӧ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ALFK����ӳ���������);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.PRO����ѹ��ǰ����ѹ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.HORDA��С�ұ�);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
}

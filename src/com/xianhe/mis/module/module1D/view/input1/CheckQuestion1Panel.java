package com.xianhe.mis.module.module1D.view.input1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xianhe.core.common.InputItemConfig;
import com.xianhe.core.common.InputItemType;
import com.xianhe.core.common.RowConfig;
import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.input.FormPanel;
import com.xianhe.mis.module.module1D.constant.CheckQuestion1Constant;
import com.xianhe.mis.module.module1D.readwritefile.ReadInputFileData;

public class CheckQuestion1Panel extends CommonPanel {
	public CheckQuestion1Panel() {
		FormPanel panel = getFormPanel1();
		addFormPanel(panel);
		
		//postProcess();
		
		//Map<String,Object> map = ReadInputFileData.parse1D();
		//this.setValueFromMap(map);
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(CheckQuestion1Constant.ת�ٶȻ��һ��ת��Ҷ�������ٶ�_RPM);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.K1234,InputItemType.fake,250);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.��ѹ��_PR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.����_G);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.������ѹ_PO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.��������_TO);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.����Ч��_EFF);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.����0,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.����_ISTAGE);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.���ʴ洢ϵ��KH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.��·�����ʶKPATH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.Ҷ�ͱ�ʶKF);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.ѹ��������KC);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.���ڶ���ѹ�ظ�SIGO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.���ڵ�Ҷ��ѹ�ظ�SIGV);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.ѹ��������,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.�⾶DTK);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.�ھ�DHK);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.һת��������ALFO);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.���ʴ���ϵ��,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.��һ��KH1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.�𼶵ݼ�DKH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.��СֵKHMIN);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.��������ϵ��KG);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.һתչ����ASP1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.���չ����ASPK);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.����Ŷ����λ��,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.���ڵ�ҶABV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.ת��ҶƬABR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.����ҶƬABS);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.���ڵ�Ҷ,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.����ҳ���BTHV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.չ�ұ�ASPV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.���BTV);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.ǰѹ����,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.������ֱ��DHO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.������ֱ��DTO);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.һת����ҳ���BTH1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.��085��10,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.���ڵ�Ҷ�����Ժ��CMV);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.��������϶,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.��һ��E1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.������һ����DE);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.�����ܶ�,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.ת��DENR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.����DENS);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.ҶƬDENB);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.ת�Ӹ�����Ӧ��DRES);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.����ӳ���������ALFK);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.����ѹ��ǰ����ѹ��PRO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.��С�ұ�HORDA);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
}

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
		panel.setInputChangeListener(CheckQuestionConstant.ISTAGE级数);
		
		//postProcess();
		
		//Map<String,Object> map = ReadInputFileData.parse1D();
		//this.setValueFromMap(map);
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(CheckQuestionConstant.RPM转速度或第一级转子叶尖切线速度);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.K1234,InputItemType.fake,250);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.PR总压比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.G流量);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.PO进口总压);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.TO进口总温);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.EFF绝热效率);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.可填0,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ISTAGE级数);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KH功率存储系数);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KPATH流路输入标识);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KF叶型标识);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KC压气机类型);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.SIGO进口段总压回复);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.SIGV进口导叶总压回复);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.压气机出口,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DTK外径);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DHK内径);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ALFO一转进气流角);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.功率储备系数,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KH1第一级);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DKH逐级递减);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KHMIN最小值);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.KG流量缩放系数);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ASP1一转展旋比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ASPK最后级展旋比);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.最大扰度相对位置,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ABV进口导叶);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ABR转子叶片);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ABS静子叶片);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.进口导叶,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.BTHV尖根弦长比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ASPV展弦比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.BTV稠度);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.前压汽机,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DHO出口内直径);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DTO出口外直径);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.BTH1一转尖根弦长比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.λ085填10,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.CMV进口导叶最大相对厚度);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.相对轴向间隙,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.E1第一级);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DE最后级与第一级差);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.材料密度,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DENR转件);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DENS静件);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DENB叶片);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.DRES转子根许用应力);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.ALFK最后静子出口气流角);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.PRO本气压机前已有压比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestionConstant.HORDA最小弦比);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
}

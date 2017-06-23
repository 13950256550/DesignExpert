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
		InputItemConfig inputItemConfig = new InputItemConfig(CheckQuestion1Constant.转速度或第一级转子叶尖切线速度_RPM);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.K1234,InputItemType.fake,250);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.总压比_PR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.流量_G);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.进口总压_PO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.进口总温_TO);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.绝热效率_EFF);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.可填0,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.级数_ISTAGE);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.功率存储系数KH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.流路输入标识KPATH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.叶型标识KF);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.压气机类型KC);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.进口段总压回复SIGO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.进口导叶总压回复SIGV);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.压气机出口,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.外径DTK);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.内径DHK);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.一转进气流角ALFO);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.功率储备系数,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.第一级KH1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.逐级递减DKH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.最小值KHMIN);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.流量缩放系数KG);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.一转展旋比ASP1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.最后级展旋比ASPK);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.最大扰度相对位置,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.进口导叶ABV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.转子叶片ABR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.静子叶片ABS);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.进口导叶,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.尖根弦长比BTHV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.展弦比ASPV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.稠度BTV);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.前压汽机,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.出口内直径DHO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.出口外直径DTO);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.一转尖根弦长比BTH1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.λ085填10,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.进口导叶最大相对厚度CMV);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.相对轴向间隙,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.第一级E1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.最后级与第一级差DE);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.材料密度,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.转件DENR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.静件DENS);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.叶片DENB);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.转子根许用应力DRES);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.最后静子出口气流角ALFK);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.本气压机前已有压比PRO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(CheckQuestion1Constant.最小弦比HORDA);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
}

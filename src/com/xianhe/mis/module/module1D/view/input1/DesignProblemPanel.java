package com.xianhe.mis.module.module1D.view.input1;

import java.util.ArrayList;
import java.util.List;

import com.xianhe.core.common.InputItemConfig;
import com.xianhe.core.common.InputItemType;
import com.xianhe.core.common.RowConfig;
import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.input.FormPanel;
import com.xianhe.mis.module.module1D.constant.DesignProblemConstant;

public class DesignProblemPanel extends CommonPanel {
	
	public DesignProblemPanel() {
		FormPanel panel = getFormPanel1();
		addFormPanel(panel);
		
		panel = getFormPanel2();
		addFormPanel(panel,DesignProblemConstant.KPATH流路输入标识);
		
		panel = getFormPanel3();
		addFormPanel(panel);
		
		panel = getFormPanel4();
		addFormPanel(panel,"材料密度");
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.RPM转速或第一级转子叶尖切线速度);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.PO进口总压);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.TO进口总温);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.PR总压比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.G流量);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.EFF绝热效率);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ISTAGE级数);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KH设计压比提高量);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KF叶型标识);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KC压气机类型);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.SIGO进口段总压恢复);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.SIGV进口导叶总压恢复);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.KPATH流路输入标识,InputItemType.combobox,new int[]{150,200});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig("DesignProblemGrid1",InputItemType.grid);
        
        List<String> colName = new ArrayList<String>();
        colName.add("A");
        colName.add("B");
        colName.add("C");
        colName.add("D");
        colName.add("E");
        colName.add("F");
        colName.add("G");
        colName.add("H");
        inputItemConfig.setColumnNames(colName);
        
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		//panel.setBorder(new TitledBorder(null, DesignProblemConstant.KPATH关联变量, TitledBorder.LEADING, TitledBorder.TOP, null, null));

		return panel;
	}
	
	public FormPanel getFormPanel3(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.PRO本压气机前已有压比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KG流量缩放系数);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.VA1一级进轴速度);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.VAM中段轴速度);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.VAC出口轴速);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ALF1一转进气流角);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.OMGN第中级反力度);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DOMG第中级后反力度增量);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ALFK最后静子出口气流角);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.加功因子,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.HZ1第一级);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.HZM平均级);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.HZK最后级);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.功率储备系数,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KH1第一级);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DKH逐级递减值);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KHMIN最小值);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ASP1一转展弦比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.BTH1一转尖根弦长比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ASPK末转展弦比);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.最大扰度相对位置,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ABV进口导叶);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ABR转子叶片);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ABS静子叶片);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.进口导叶,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.BTHV尖根弦长比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ASPV展弦比);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.BTV稠度);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.CMV进口导叶最大相对厚度);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.前压气机机组转接段,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DHO出口内直径);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DTO出口外直径);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.HORDA最小弦长);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.E1第一级);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DE最后级与第一级差);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel4(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.DENR转件);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DENS静件);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DENB叶片);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DRES转子根许用应力);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		//panel.setBorder(new TitledBorder(null, "材料密度", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		return panel;
	}

}

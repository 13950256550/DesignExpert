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
		addFormPanel(panel,DesignProblemConstant.流路输入标识KPATH);
		
		panel = getFormPanel3();
		addFormPanel(panel);
		
		panel = getFormPanel4();
		addFormPanel(panel,"材料密度");
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.转速或第一级转子叶尖切线速度RPM);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.进口总压PO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.进口总温TO);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.总压比PR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.流量G);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.绝热效率EFF);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.级数ISTAGE);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.设计压比提高量KH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.叶型标识KF);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.压气机类型KC);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.进口段总压恢复SIGO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.进口导叶总压恢复SIGV);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.流路输入标识KPATH,InputItemType.combobox,new int[]{150,200});
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig("grid1",InputItemType.grid);
		List<String> rowName = new ArrayList<String>();
        rowName.add("1");
        rowName.add("2");
        rowName.add("3");
        rowName.add("4");
        rowName.add("5");
        rowName.add("6");
        rowName.add("7");
        inputItemConfig.setRowNames(rowName);
        
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
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.本压气机前已有压比PRO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.流量缩放系数KG);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.一级进轴速度VA1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.中段轴速度VAM);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.出口轴速VAC);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.一转进气流角ALF1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.第中级反力度OMGN);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.第中级后反力度增量DOMG);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.最后静子出口气流角ALFK);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.加功因子,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.第一级HZ1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.平均级HZM);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.最后级HZK);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.功率储备系数,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.第一级KH1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.逐级递减值DKH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.最小值KHMIN);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.一转展弦比ASP1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.一转尖根弦长比BTH1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.末转展弦比ASPK);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.最大扰度相对位置,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.进口导叶ABV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.转子叶片ABR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.静子叶片ABS);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.进口导叶,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.尖根弦长比BTHV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.展弦比ASPV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.稠度BTV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.进口导叶最大相对厚度CMV);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.前压气机机组转接段,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.出口内直径DHO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.出口外直径DTO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.最小弦长HORDA);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.第一级E1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.最后级与第一级差DE);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel4(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.转件DENR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.静件DENS);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.叶片DENB);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.转子根许用应力DRES);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		//panel.setBorder(new TitledBorder(null, "材料密度", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		return panel;
	}

}

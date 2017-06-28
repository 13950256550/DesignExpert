package com.xianhe.mis.module.module1D.view.input1;

import java.util.ArrayList;
import java.util.List;

import com.xianhe.core.common.InputItemConfig;
import com.xianhe.core.common.InputItemType;
import com.xianhe.core.common.RowConfig;
import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.input.FormPanel;
import com.xianhe.mis.module.module1D.constant.FeaturesCalculateConstant;

public class FeaturesCalculate1Panel extends CommonPanel {
	//FormPanel panel = null;
	public FeaturesCalculate1Panel() {
		FormPanel panel = getFormPanel1();
		addFormPanel(panel);
		panel.setInputChangeListener(FeaturesCalculateConstant.控制参数KGKA);
		panel.setInputChangeListener(FeaturesCalculateConstant.控制参数IGKA);
		panel.setInputChangeListener(FeaturesCalculateConstant.等转速条线数N);
		
		panel = getFormPanel2();
		addFormPanel(panel,"NR/QL");
		
		panel = getFormPanel3();
		addFormPanel(panel);
		
		panel = getFormPanel4();
		addFormPanel(panel,FeaturesCalculateConstant.共同工作线LSR0输);
		
		panel = getFormPanel5();
		addFormPanel(panel,FeaturesCalculateConstant.静子包括进口导叶);
		
		//Map<String,Object> map = ReadInputFileData.parse1D();
		//this.setValueFromMap(map);

		/*
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
	           @Override
	           public void handle(MouseEvent event) {
	              //System.out.println("Hello World!");
	              System.out.println(panel.getValue("grid4"));
	           }
	       });
	     */
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.等转速条线数N);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.气体常数R);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.绝热指数K);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.状态点间隔DQ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.垂直段误差精度Q值EQ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.总压系数ESIG);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.控制参数KGKA);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.控制参数IGKA);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.转速和状态点控制IVAR1);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig("FeaturesCalculate1Panel.grid1",InputItemType.grid);
		
		List<String> rowNames = new ArrayList<String>();
        rowNames.add("NR");
        rowNames.add("QL");
        inputItemConfig.setRowNames(rowNames);
        
        List<String> colName = new ArrayList<String>();
        colName.add("1");
        colName.add("2");
        colName.add("3");
        colName.add("4");
        colName.add("5");
        colName.add("6");
        colName.add("7");
        colName.add("8");
        colName.add("9");
        colName.add("10");
        inputItemConfig.setColumnNames(colName);
        
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		//panel.setBorder(new TitledBorder(null, "NR/QL", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		return panel;
	}
	
	public FormPanel getFormPanel3(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.状态点计算控制IQP);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.搜索共同工作点IZAP);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.共同工作线给定LSR);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.堵点失速点输出KPATH1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.计算结果输出KPATH2);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.压比收敛精度EPR);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.流量储备系数KG);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.总压恢复步长DSIG);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.喘振裕度SM);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.垂直段单点压比PR2);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.IQR2,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.上起点压比与最小压比之比PRB);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.转速线起始NNS);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.终止NNF);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.计算级起始IIS);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.终止IIF);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.Qλ限制最小值QQS);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.最大值QQF);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel4(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig("FeaturesCalculate1Panel.grid2",InputItemType.grid);
		
		List<String> rowNames = new ArrayList<String>();
        rowNames.add("GCOP");
        rowNames.add("PRW");
        inputItemConfig.setRowNames(rowNames);
        
        List<String> colName = new ArrayList<String>();
        colName.add("1");
        colName.add("2");
        colName.add("3");
        colName.add("4");
        colName.add("5");
        colName.add("6");
        colName.add("7");
        inputItemConfig.setColumnNames(colName);
        
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		//panel.setBorder(new TitledBorder(null, "NR/QL", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		return panel;
	}
	
	public FormPanel getFormPanel5(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig("FeaturesCalculate1Panel.grid3",InputItemType.grid);
        
        List<String> colNames = new ArrayList<String>();
        /*
        colName.add("1");
        colName.add("2");
        colName.add("3");
        colName.add("4");
        colName.add("5");
        colName.add("6");
        colName.add("7");
        colName.add("8");
        */
        int istage = Module1DInput1View.getISTAGE();
        for(int i=1;i<istage+2;i++){
        	colNames.add(String.valueOf(i));
        }
        inputItemConfig.setColumnNames(colNames);
        
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		//panel.setBorder(new TitledBorder(null, "NR/QL", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		return panel;
	}
}

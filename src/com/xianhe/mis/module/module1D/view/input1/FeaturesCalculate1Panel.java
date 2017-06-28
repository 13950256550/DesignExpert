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
		panel.setInputChangeListener(FeaturesCalculateConstant.���Ʋ���KGKA);
		panel.setInputChangeListener(FeaturesCalculateConstant.���Ʋ���IGKA);
		panel.setInputChangeListener(FeaturesCalculateConstant.��ת��������N);
		
		panel = getFormPanel2();
		addFormPanel(panel,"NR/QL");
		
		panel = getFormPanel3();
		addFormPanel(panel);
		
		panel = getFormPanel4();
		addFormPanel(panel,FeaturesCalculateConstant.��ͬ������LSR0��);
		
		panel = getFormPanel5();
		addFormPanel(panel,FeaturesCalculateConstant.���Ӱ������ڵ�Ҷ);
		
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
		InputItemConfig inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.��ת��������N);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.���峣��R);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.����ָ��K);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.״̬����DQ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.��ֱ������QֵEQ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.��ѹϵ��ESIG);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.���Ʋ���KGKA);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.���Ʋ���IGKA);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.ת�ٺ�״̬�����IVAR1);
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
		InputItemConfig inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.״̬��������IQP);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.������ͬ������IZAP);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.��ͬ�����߸���LSR);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.�µ�ʧ�ٵ����KPATH1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.���������KPATH2);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.ѹ����������EPR);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.��������ϵ��KG);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.��ѹ�ָ�����DSIG);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.����ԣ��SM);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.��ֱ�ε���ѹ��PR2);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.IQR2,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.�����ѹ������Сѹ��֮��PRB);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.ת������ʼNNS);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.��ֹNNF);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.���㼶��ʼIIS);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.��ֹIIF);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.Q��������СֵQQS);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(FeaturesCalculateConstant.���ֵQQF);
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

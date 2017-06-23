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
		addFormPanel(panel,DesignProblemConstant.��·�����ʶKPATH);
		
		panel = getFormPanel3();
		addFormPanel(panel);
		
		panel = getFormPanel4();
		addFormPanel(panel,"�����ܶ�");
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.ת�ٻ��һ��ת��Ҷ�������ٶ�RPM);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.������ѹPO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.��������TO);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.��ѹ��PR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.����G);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.����Ч��EFF);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.����ISTAGE);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���ѹ�������KH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.Ҷ�ͱ�ʶKF);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ѹ��������KC);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���ڶ���ѹ�ָ�SIGO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���ڵ�Ҷ��ѹ�ָ�SIGV);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.��·�����ʶKPATH,InputItemType.combobox,new int[]{150,200});
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
		//panel.setBorder(new TitledBorder(null, DesignProblemConstant.KPATH��������, TitledBorder.LEADING, TitledBorder.TOP, null, null));

		return panel;
	}
	
	public FormPanel getFormPanel3(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.��ѹ����ǰ����ѹ��PRO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.��������ϵ��KG);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.һ�������ٶ�VA1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.�ж����ٶ�VAM);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.��������VAC);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.һת��������ALF1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���м�������OMGN);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���м�����������DOMG);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.����ӳ���������ALFK);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.�ӹ�����,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.��һ��HZ1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ƽ����HZM);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���HZK);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���ʴ���ϵ��,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.��һ��KH1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.�𼶵ݼ�ֵDKH);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.��СֵKHMIN);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.һתչ�ұ�ASP1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.һת����ҳ���BTH1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ĩתչ�ұ�ASPK);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.����Ŷ����λ��,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���ڵ�ҶABV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ת��ҶƬABR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.����ҶƬABS);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���ڵ�Ҷ,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.����ҳ���BTHV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.չ�ұ�ASPV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���BTV);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���ڵ�Ҷ�����Ժ��CMV);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ǰѹ��������ת�Ӷ�,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.������ֱ��DHO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.������ֱ��DTO);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.��С�ҳ�HORDA);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.��һ��E1);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.������һ����DE);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel4(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.ת��DENR);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.����DENS);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ҶƬDENB);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ת�Ӹ�����Ӧ��DRES);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		//panel.setBorder(new TitledBorder(null, "�����ܶ�", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		return panel;
	}

}

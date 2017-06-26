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
		addFormPanel(panel,DesignProblemConstant.KPATH��·�����ʶ);
		
		panel = getFormPanel3();
		addFormPanel(panel);
		
		panel = getFormPanel4();
		addFormPanel(panel,"�����ܶ�");
	}
	
	public FormPanel getFormPanel1(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.RPMת�ٻ��һ��ת��Ҷ�������ٶ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.PO������ѹ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.TO��������);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.PR��ѹ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.G����);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.EFF����Ч��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ISTAGE����);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KH���ѹ�������);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KFҶ�ͱ�ʶ);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KCѹ��������);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.SIGO���ڶ���ѹ�ָ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.SIGV���ڵ�Ҷ��ѹ�ָ�);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel2(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.KPATH��·�����ʶ,InputItemType.combobox,new int[]{150,200});
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
		//panel.setBorder(new TitledBorder(null, DesignProblemConstant.KPATH��������, TitledBorder.LEADING, TitledBorder.TOP, null, null));

		return panel;
	}
	
	public FormPanel getFormPanel3(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.PRO��ѹ����ǰ����ѹ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KG��������ϵ��);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.VA1һ�������ٶ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.VAM�ж����ٶ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.VAC��������);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ALF1һת��������);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.OMGN���м�������);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DOMG���м�����������);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ALFK����ӳ���������);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.�ӹ�����,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.HZ1��һ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.HZMƽ����);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.HZK���);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���ʴ���ϵ��,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KH1��һ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DKH�𼶵ݼ�ֵ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.KHMIN��Сֵ);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ASP1һתչ�ұ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.BTH1һת����ҳ���);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ASPKĩתչ�ұ�);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.����Ŷ����λ��,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ABV���ڵ�Ҷ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ABRת��ҶƬ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ABS����ҶƬ);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.���ڵ�Ҷ,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.BTHV����ҳ���);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ASPVչ�ұ�);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.BTV���);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.CMV���ڵ�Ҷ�����Ժ��);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.ǰѹ��������ת�Ӷ�,InputItemType.fake);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DHO������ֱ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DTO������ֱ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.HORDA��С�ҳ�);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.E1��һ��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DE������һ����);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		return panel;
	}
	
	public FormPanel getFormPanel4(){
		List<RowConfig> rowConfigs = new ArrayList<RowConfig>();
		List<InputItemConfig> inputItemConfigs = new ArrayList<InputItemConfig>();
		InputItemConfig inputItemConfig = new InputItemConfig(DesignProblemConstant.DENRת��);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DENS����);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		inputItemConfigs = new ArrayList<InputItemConfig>();
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DENBҶƬ);
		inputItemConfigs.add(inputItemConfig);
		inputItemConfig = new InputItemConfig(DesignProblemConstant.DRESת�Ӹ�����Ӧ��);
		inputItemConfigs.add(inputItemConfig);
		rowConfigs.add(new RowConfig(inputItemConfigs));
		
		FormPanel panel = new FormPanel(rowConfigs);
		//panel.setBorder(new TitledBorder(null, "�����ܶ�", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		return panel;
	}

}

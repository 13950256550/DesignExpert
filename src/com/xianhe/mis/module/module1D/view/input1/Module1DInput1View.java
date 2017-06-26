package com.xianhe.mis.module.module1D.view.input1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.xianhe.core.common.EnvReadWriteUtil;
import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.module.AppContext;
import com.xianhe.mis.module.module1D.constant.CheckQuestionConstant;
import com.xianhe.mis.module.module1D.constant.ControlVariableConstant;
import com.xianhe.mis.module.module1D.constant.DesignProblemConstant;
import com.xianhe.mis.module.module1D.constant.FeaturesCalculateConstant;
import com.xianhe.mis.module.module1D.readwritefile.ReadInputFileData;
import com.xianhe.mis.module.module1D.readwritefile.WriteDataToFile;
import com.xianhe.mis.module.module1D.view.output.Module1DOutputView;

import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class Module1DInput1View extends BorderPane{
	public static Logger logger = Logger.getLogger(Module1DOutputView.class);
	private static List<CommonPanel> panels = null;
	public static TextArea textArea = null;
	public static TabPane tabPane2 = null;
	private String fileName = null;
	
	public Module1DInput1View(String fileName){
		this.fileName = fileName;
		panels = new ArrayList<CommonPanel>();
		TabPane tabPane = new TabPane();
		setCenter(tabPane);
		tabPane.setSide(Side.BOTTOM);
		
		addTab1(tabPane);
		addTab2(tabPane);
	}
	
	public String getInputFileContent(){
		StringBuilder sb = new StringBuilder();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(EnvReadWriteUtil.getFile(this.fileName)),"gbk"));
			String line=null;
			while ((line=in.readLine())!=null) {
				sb.append(line).append("\n");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return sb.toString();
	}
	
	public void addTab1(TabPane tabPane){
		Tab tab = new Tab();
		tab.setText("�ı��༭");
		tab.setClosable(false);
		tabPane.getTabs().add(tab);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true);
		tab.setContent(scrollPane);
		
		textArea = new TextArea();

		scrollPane.setContent(textArea);
		textArea.setText(getInputFileContent());
		textArea.home();
		AppContext.setStatus(AppContext.IN_STATUS, AppContext.IN_STATUS_READED);
		tab.setOnSelectionChanged(event->{
			if(tab.isSelected()){
				Map<String,Object> map = new HashMap<String,Object>();
				if(Module1DInput1View.panels.size()>0){
					for(CommonPanel panel:Module1DInput1View.panels){
						panel.getValueIntoMap(map);
					}
					
					//File file = PathUtil.get1D_in1File();
					//WriteDataToFile.WriteDataToFile(file, map);
				}
				//textArea.setText(getInputFileContent());
				StringBuffer sb = WriteDataToFile.getBufferFromMap(map);
				textArea.setText(sb.toString());
			}
		});
	}
	
	public void addTab2(TabPane tabPane){
		Tab tab = new Tab();
		tab.setText("�������");
		tab.setClosable(false);
		tabPane.getTabs().add(tab);
		
		tabPane2 = new TabPane();
		tabPane2.setSide(Side.TOP);
		tab.setContent(tabPane2);

		tab.setOnSelectionChanged(event->{
			if(tab.isSelected()){
				//logger.info(textArea.getText());
				String[] rows = textArea.getText().split("\n");
				List<String> list = new ArrayList<String>();
				for(String row:rows){
					list.add(row);
				}
				
				Map<String,Object> map = ReadInputFileData.parse1D_in1(list);
				for(CommonPanel panel:panels){
					panel.setValueFromMap(map);
				}
				
				if(AppContext.getStatus(AppContext.IN_STATUS)==AppContext.IN_STATUS_READED){
					AppContext.setStatus(AppContext.IN_STATUS, AppContext.IN_STATUS_COPY);
					
					Map<String,Object> outputMap = new HashMap<String,Object>();
					
					//izi 0-������ 1-����
					String izi = String.valueOf(map.get(ControlVariableConstant.��ʧ������_IZI));
					if(izi!=null && izi.equals("0")){
						Module1DInput1View.setControlVariableDefaultValue(outputMap);
						CommonPanel controlVariablePanel = getCommonPanel(0);
						controlVariablePanel.setValueFromMap(outputMap);
					}
					
					//k12 1-������� 2-�������
					String k12 = String.valueOf(map.get(ControlVariableConstant.�������_K12));
					if(k12!=null && k12.equals("1")){
						//���ԭ�������������Ҫ�����������������������ҳ
					}else if(k12!=null && k12.equals("2")){
						//���ԭ���Ǽ��������Ҫ�����������������������ҳ
						Module1DInput1View.copyCheckQuestionToDesignProblem(outputMap);
						Module1DInput1View.copyCheckQuestion2ToDesignProblem(outputMap);
						Module1DInput1View.setDesignProblemDefaultValue(outputMap);
						CommonPanel designProblemPanel = getCommonPanel(1);
						designProblemPanel.setValueFromMap(outputMap);
					}
					
					//kgka 0-����2ҳ���������   1-����2ҳ�������
					String kgka = String.valueOf(map.get(FeaturesCalculateConstant.���Ʋ���KGKA));
					if(kgka!=null && kgka.equals("0")){
						//���ԭ����kgka=0 ��ҪΪ����2ҳ�����ó�ʼֵ
						setFeaturesCalculate2DefaultValue(outputMap);
						CommonPanel featuresCalculate2Panel = getCommonPanel(6);
						featuresCalculate2Panel.setValueFromMap(outputMap);
					}
					
					//igka 0-����3ҳ���������   1-����3ҳ�������
					String igka = String.valueOf(map.get(FeaturesCalculateConstant.���Ʋ���KGKA));
					if(kgka!=null && kgka.equals("0")){
						//���ԭ����kgka=0 ��ҪΪ����3ҳ�����ó�ʼֵ
						setFeaturesCalculate3DefaultValue(outputMap);
						CommonPanel featuresCalculate3Panel = getCommonPanel(7);
						featuresCalculate3Panel.setValueFromMap(outputMap);
					}
				}
				
			}
		});
		
		addTab21(tabPane2);
		addTab22(tabPane2);
		addTab23(tabPane2);
		addTab24(tabPane2);
		addTab25(tabPane2);
		addTab26(tabPane2);
		addTab27(tabPane2);
		addTab28(tabPane2);
		addTab29(tabPane2);
	}
	
	public void addTab21(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("���Ʊ���");
		tabPane.getTabs().add(tab);
		
		ControlVariablePanel controlVariablePanel = new ControlVariablePanel();
		tab.setContent(controlVariablePanel);
		panels.add(controlVariablePanel);
	}
	
	public void addTab22(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("�������");
		tabPane.getTabs().add(tab);
		
		ScrollPane scrollPane = new ScrollPane();
		tab.setContent(scrollPane);
		
		DesignProblemPanel designProblemPanel = new DesignProblemPanel();
		scrollPane.setContent(designProblemPanel);
		panels.add(designProblemPanel);
	}
	
	public void addTab23(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("�������(1)");
		tabPane.getTabs().add(tab);
		
		CheckQuestion1Panel checkQuestion1Panel = new CheckQuestion1Panel();
		tab.setContent(checkQuestion1Panel);
		panels.add(checkQuestion1Panel);
	}
	
	public void addTab24(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("�������(2)");
		tabPane.getTabs().add(tab);
		
		CheckQuestion2Panel checkQuestion2Panel = new CheckQuestion2Panel();
		tab.setContent(checkQuestion2Panel);
		panels.add(checkQuestion2Panel);
	}
	
	public void addTab25(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("�������(3)");
		tabPane.getTabs().add(tab);
		
		CheckQuestion3Panel checkQuestion3Panel = new CheckQuestion3Panel();
		tab.setContent(checkQuestion3Panel);
		panels.add(checkQuestion3Panel);
	}
	
	public void addTab26(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("���Լ���(1)");
		tabPane.getTabs().add(tab);
		
		ScrollPane scrollPane = new ScrollPane();
		tab.setContent(scrollPane);
		
		FeaturesCalculate1Panel featuresCalculatePanel = new FeaturesCalculate1Panel();
		scrollPane.setContent(featuresCalculatePanel);
		panels.add(featuresCalculatePanel);
	}
	
	public void addTab27(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("���Լ���(2)");
		tabPane.getTabs().add(tab);
		
		FeaturesCalculate2Panel featuresCalculate2Panel = new FeaturesCalculate2Panel();
		tab.setContent(featuresCalculate2Panel);
		panels.add(featuresCalculate2Panel);
	}
	
	public void addTab28(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("���Լ���(3)");
		tabPane.getTabs().add(tab);
		
		FeaturesCalculate3Panel featuresCalculate3Panel = new FeaturesCalculate3Panel();
		tab.setContent(featuresCalculate3Panel);
		panels.add(featuresCalculate3Panel);
	}
	
	public void addTab29(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("չ�ұȼ���");
		tabPane.getTabs().add(tab);
		
		AspectRatioCalculatePanel aspectRatioCalculatePanel = new AspectRatioCalculatePanel();
		tab.setContent(aspectRatioCalculatePanel);
		panels.add(aspectRatioCalculatePanel);
	}
	
	public static CommonPanel getCommonPanel(int index){
		Node node = tabPane2.getTabs().get(index).getContent();
		if(node instanceof ScrollPane){
			node = ((ScrollPane) node).getContent();
		}
		return (CommonPanel) node;
	}
	
	public static void copyCheckQuestionToDesignProblem(Map<String,Object> outputMap){
		CommonPanel checkQuestionPanel = getCommonPanel(2);
		//CommonPanel designProblemPanel = getCommonPanel(1);
		
		Map<String,Object> map = new HashMap<String,Object>();
		checkQuestionPanel.getValueIntoMap(map);
		
		Set<String> keys = map.keySet();
		for(String key:keys){
			Object value = map.get(key);
			
			//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV��13 ���ܲ���
			//#1:RPM��PR��G��P0��T0��EFF��KH��ISTAGE��KPATH��KF��KC��SIG0��SIGV��13 ���ܲ���
			if(key.equals(CheckQuestionConstant.RPMת�ٶȻ��һ��ת��Ҷ�������ٶ�)){
				outputMap.put(DesignProblemConstant.RPMת�ٻ��һ��ת��Ҷ�������ٶ�, value);
			}
			
			if(key.equals(CheckQuestionConstant.PR��ѹ��)){
				outputMap.put(DesignProblemConstant.PR��ѹ��, value);
			}
			
			if(key.equals(CheckQuestionConstant.G����)){
				outputMap.put(DesignProblemConstant.G����, value);
			}
			
			if(key.equals(CheckQuestionConstant.PO������ѹ)){
				outputMap.put(DesignProblemConstant.PO������ѹ, value);
			}
			
			if(key.equals(CheckQuestionConstant.TO��������)){
				outputMap.put(DesignProblemConstant.TO��������, value);
			}
			
			if(key.equals(CheckQuestionConstant.EFF����Ч��)){
				outputMap.put(DesignProblemConstant.EFF����Ч��, value);
			}
			
			if(key.equals(CheckQuestionConstant.KH���ʴ洢ϵ��)){
				outputMap.put(DesignProblemConstant.KH���ѹ�������, value);
			}
			
			if(key.equals(CheckQuestionConstant.ISTAGE����)){
				outputMap.put(DesignProblemConstant.ISTAGE����, value);
			}
			
			if(key.equals(CheckQuestionConstant.KPATH��·�����ʶ)){
				outputMap.put(DesignProblemConstant.KPATH��·�����ʶ, value);
			}
			
			if(key.equals(CheckQuestionConstant.KFҶ�ͱ�ʶ)){
				outputMap.put(DesignProblemConstant.KFҶ�ͱ�ʶ, value);
			}
			
			if(key.equals(CheckQuestionConstant.KCѹ��������)){
				outputMap.put(DesignProblemConstant.KCѹ��������, value);
			}
			
			if(key.equals(CheckQuestionConstant.SIGO���ڶ���ѹ�ظ�)){
				outputMap.put(DesignProblemConstant.SIGO���ڶ���ѹ�ָ�, value);
			}
			
			if(key.equals(CheckQuestionConstant.SIGV���ڵ�Ҷ��ѹ�ظ�)){
				outputMap.put(DesignProblemConstant.SIGV���ڵ�Ҷ��ѹ�ָ�, value);
			}
			
			//#7:KG��ASP1��ASPK��ABV��ABR��ABS��BTHV��ASPV��BTV��DH0��DT0��BTH1��12 �����β���
			//#20:KG��FF��FF��ABV��ABR��ABS��BTHV��ASPV��BTV��DH0��DT0��BTH1��12 ���ṹ����
			if(key.equals(CheckQuestionConstant.KG��������ϵ��)){
				outputMap.put(DesignProblemConstant.KG��������ϵ��, value);
			}
			
			if(key.equals(CheckQuestionConstant.ASP1һתչ����)){
				outputMap.put(DesignProblemConstant.ASP1һתչ�ұ�, value);
			}
			
			if(key.equals(CheckQuestionConstant.ASPK���չ����)){
				outputMap.put(DesignProblemConstant.ASPKĩתչ�ұ�, value);
			}
			
			if(key.equals(CheckQuestionConstant.ABV���ڵ�Ҷ)){
				outputMap.put(DesignProblemConstant.ABV���ڵ�Ҷ, value);
			}
			
			if(key.equals(CheckQuestionConstant.ABRת��ҶƬ)){
				outputMap.put(DesignProblemConstant.ABRת��ҶƬ, value);
			}
			
			if(key.equals(CheckQuestionConstant.ABS����ҶƬ)){
				outputMap.put(DesignProblemConstant.ABS����ҶƬ, value);
			}
			
			if(key.equals(CheckQuestionConstant.BTHV����ҳ���)){
				outputMap.put(DesignProblemConstant.BTHV����ҳ���, value);
			}
			
			if(key.equals(CheckQuestionConstant.ASPVչ�ұ�)){
				outputMap.put(DesignProblemConstant.ASPVչ�ұ�, value);
			}
			
			if(key.equals(CheckQuestionConstant.BTV���)){
				outputMap.put(DesignProblemConstant.BTV���, value);
			}
			
			if(key.equals(CheckQuestionConstant.DHO������ֱ��)){
				outputMap.put(DesignProblemConstant.DHO������ֱ��, value);
			}
			
			if(key.equals(CheckQuestionConstant.DTO������ֱ��)){
				outputMap.put(DesignProblemConstant.DTO������ֱ��, value);
			}
			
			if(key.equals(CheckQuestionConstant.BTH1һת����ҳ���)){
				outputMap.put(DesignProblemConstant.BTH1һת����ҳ���, value);
			}
			
			//#8:E1��DE��CMV��DENR��DENS��DENB��DRES��ALFK��PR0��9 ������
			//#21:E1��DE��CMV��DENR��DENS,DENB��DRES��ALFK��PR0��9 ������
			if(key.equals(CheckQuestionConstant.E1��һ��)){
				outputMap.put(DesignProblemConstant.E1��һ��, value);
			}
			
			if(key.equals(CheckQuestionConstant.DE������һ����)){
				outputMap.put(DesignProblemConstant.DE������һ����, value);
			}
			
			if(key.equals(CheckQuestionConstant.CMV���ڵ�Ҷ�����Ժ��)){
				outputMap.put(DesignProblemConstant.CMV���ڵ�Ҷ�����Ժ��, value);
			}
			
			if(key.equals(CheckQuestionConstant.DENRת��)){
				outputMap.put(DesignProblemConstant.DENRת��, value);
			}
			
			if(key.equals(CheckQuestionConstant.DENS����)){
				outputMap.put(DesignProblemConstant.DENS����, value);
			}
			
			if(key.equals(CheckQuestionConstant.DENBҶƬ)){
				outputMap.put(DesignProblemConstant.DENBҶƬ, value);
			}
			
			if(key.equals(CheckQuestionConstant.DRESת�Ӹ�����Ӧ��)){
				outputMap.put(DesignProblemConstant.DRESת�Ӹ�����Ӧ��, value);
			}
			
			if(key.equals(CheckQuestionConstant.ALFK����ӳ���������)){
				outputMap.put(DesignProblemConstant.ALFK����ӳ���������, value);
			}
			
			if(key.equals(CheckQuestionConstant.PRO����ѹ��ǰ����ѹ��)){
				outputMap.put(DesignProblemConstant.PRO��ѹ����ǰ����ѹ��, value);
			}
			
			//#6:VA1��VAM��VAC��ALF1��OMGN��DOMG��HZ1��HZM��HZK,KH1,DKH��KHMIN��12 ����������
			//#18:ALF0����һ��ת��ǰ����������
			//#19:KH1��DKH��KHMIN����������KHI ֵ����������д0.0
			
			if(key.equals(CheckQuestionConstant.ALFOһת��������)){
				outputMap.put(DesignProblemConstant.ALF1һת��������, value);
			}
			
			if(key.equals(CheckQuestionConstant.KH1��һ��)){
				outputMap.put(DesignProblemConstant.KH1��һ��, value);
			}
			
			if(key.equals(CheckQuestionConstant.DKH�𼶵ݼ�)){
				outputMap.put(DesignProblemConstant.DKH�𼶵ݼ�ֵ, value);
			}
			
			if(key.equals(CheckQuestionConstant.KHMIN��Сֵ)){
				outputMap.put(DesignProblemConstant.KHMIN��Сֵ, value);
			}
			
			//#9:HORDA����С�ҳ���m
			//#22:HORDA����С�ҳ���m
			if(key.equals(CheckQuestionConstant.HORDA��С�ұ�)){
				outputMap.put(DesignProblemConstant.HORDA��С�ҳ�, value);
			}

		}
		
		//designProblemPanel.setValueFromMap(map2);
	}
	
	public static void copyCheckQuestion2ToDesignProblem(Map<String,Object> outputMap){
		CommonPanel checkQuestionPanel = getCommonPanel(3);
		//CommonPanel designProblemPanel = getCommonPanel(1);
		
		Map<String,Object> map = new HashMap<String,Object>();
		//Map<String,Object> map2 = new HashMap<String,Object>();
		checkQuestionPanel.getValueIntoMap(map);
		
		Set<String> keys = map.keySet();
		for(String key:keys){
			Object value = map.get(key);
			/*#2:DT1��D1��DH1��DTC��DMC��DHC��DTK��DFF��DHK��������·��9 ��ֱ��ֵ
			DT1����һ��ת�ӽ���Ҷ��ֱ��
			D1����һ��ת�ӽ�����챱�
			DH1����һ��ת�ӽ��ڸ���ֱ��
			DTC�����⾶д1.0
			DMC�����о�д1.0
			DHC�����ھ�д1.0
			DTK��ѹ���������⾶
			DFF��0.0
			DHK��ѹ���������ھ�
			*/
			if(key.equals("CheckQuestion2Panel.grid1")){
				List<List<String>> grid1 = (List<List<String>>)value;
				/*
				for(List<String> row:grid1){
					for(String col:row){
						System.out.print(" "+col);
					}
					System.out.println("");
				}
				*/
				List<List<String>> grid = new ArrayList<List<String>>();
				List<String> row = new ArrayList<>();
				row.add(grid1.get(0).get(0));
				row.add("0.0");
				row.add(grid1.get(0).get(1));
				row.add("0.0");
				row.add("0.0");
				row.add("0.0");
				row.add(grid1.get(6).get(2));
				row.add("0.0");
				row.add(grid1.get(6).get(1));
				grid.add(row);
				
				outputMap.put("DesignProblemGrid1",grid);
			}
		}
		
		//designProblemPanel.setValueFromMap(map2);
	}
	public static void setControlVariableDefaultValue(Map<String,Object> outputMap){
		outputMap.put(ControlVariableConstant.��ʧУ��ϵ��ALN, "0.0");
		outputMap.put(ControlVariableConstant.ALW, "0.0");
		outputMap.put(ControlVariableConstant.PKN, "0.0");
		outputMap.put(ControlVariableConstant.PKW, "0.0");
	}
	
	public static void setDesignProblemDefaultValue(Map<String,Object> outputMap){
		outputMap.put(DesignProblemConstant.VA1һ�������ٶ�, "0.0");
		outputMap.put(DesignProblemConstant.VAM�ж����ٶ�, "0.0");
		outputMap.put(DesignProblemConstant.VAC��������, "0.0");
		
		outputMap.put(DesignProblemConstant.OMGN���м�������, "0.0");
		outputMap.put(DesignProblemConstant.DOMG���м�����������, "0.0");
		
		outputMap.put(DesignProblemConstant.HZ1��һ��, "0.0");
		outputMap.put(DesignProblemConstant.HZMƽ����, "0.0");
		outputMap.put(DesignProblemConstant.HZK���, "0.0");
	}
	
	public static void setFeaturesCalculate2DefaultValue(Map<String,Object> outputMap){
		List<List<String>> grid = new ArrayList<List<String>>();
		for(int i=0;i<7;i++){
			List<String> row = new ArrayList<>();
			for(int j=0;j<6;j++){
				row.add("0");
			}
			grid.add(row);
		}
		
		outputMap.put("FeaturesCalculate2Panel.grid1",grid);
	}
	
	public static void setFeaturesCalculate3DefaultValue(Map<String,Object> outputMap){
		List<List<String>> grid = new ArrayList<List<String>>();
		for(int i=0;i<7;i++){
			List<String> row = new ArrayList<>();
			for(int j=0;j<4;j++){
				row.add("0");
			}
			grid.add(row);
		}
		
		outputMap.put("FeaturesCalculate3Panel.grid1",grid);
	}
	
	public static Object getValue(String id){
		Object result = null;
		
		for(CommonPanel panel:Module1DInput1View.panels){
			Object value = panel.getValue(id);
			if(value!=null){
				result = value;
				break;
			}
		}
		return result;
	}
	
	public static int getISTAGE(){
		Object value = Module1DInput1View.getValue(CheckQuestionConstant.ISTAGE����);
		int istage = 0;
		try {
			istage = Integer.parseInt(String.valueOf(value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return istage;
	}
}

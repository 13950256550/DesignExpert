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
import com.xianhe.mis.module.module1D.constant.CheckQuestion1Constant;
import com.xianhe.mis.module.module1D.constant.DesignProblemConstant;
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
				//textArea.setText(sb.toString());
				logger.info("\r\n"+Module1DInput1View.getCommonPanel(0));
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
				
				Module1DInput1View.copyCheckQuestionToDesignProblem();
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
	
	public static synchronized void copyCheckQuestionToDesignProblem(){
		CommonPanel checkQuestionPanel = getCommonPanel(2);
		CommonPanel designProblemPanel = getCommonPanel(1);
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		checkQuestionPanel.getValueIntoMap(map);
		
		Set<String> keys = map.keySet();
		for(String key:keys){
			Object value = map.get(key);
			
			//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV��13 ���ܲ���
			//#1:RPM��PR��G��P0��T0��EFF��KH��ISTAGE��KPATH��KF��KC��SIG0��SIGV��13 ���ܲ���
			if(key.equals(CheckQuestion1Constant.ת�ٶȻ��һ��ת��Ҷ�������ٶ�_RPM)){
				map2.put(DesignProblemConstant.ת�ٻ��һ��ת��Ҷ�������ٶ�RPM, value);
			}
			
			if(key.equals(CheckQuestion1Constant.��ѹ��_PR)){
				map2.put(DesignProblemConstant.��ѹ��PR, value);
			}
			
			if(key.equals(CheckQuestion1Constant.����_G)){
				map2.put(DesignProblemConstant.����G, value);
			}
			
			if(key.equals(CheckQuestion1Constant.������ѹ_PO)){
				map2.put(DesignProblemConstant.������ѹPO, value);
			}
			
			if(key.equals(CheckQuestion1Constant.��������_TO)){
				map2.put(DesignProblemConstant.��������TO, value);
			}
			
			if(key.equals(CheckQuestion1Constant.����Ч��_EFF)){
				map2.put(DesignProblemConstant.����Ч��EFF, value);
			}
			
			if(key.equals(CheckQuestion1Constant.���ʴ洢ϵ��KH)){
				map2.put(DesignProblemConstant.���ѹ�������KH, value);
			}
			
			if(key.equals(CheckQuestion1Constant.����_ISTAGE)){
				map2.put(DesignProblemConstant.����ISTAGE, value);
			}
			
			if(key.equals(CheckQuestion1Constant.��·�����ʶKPATH)){
				map2.put(DesignProblemConstant.��·�����ʶKPATH, value);
			}
			
			if(key.equals(CheckQuestion1Constant.Ҷ�ͱ�ʶKF)){
				map2.put(DesignProblemConstant.Ҷ�ͱ�ʶKF, value);
			}
			
			if(key.equals(CheckQuestion1Constant.ѹ��������KC)){
				map2.put(DesignProblemConstant.ѹ��������KC, value);
			}
			
			if(key.equals(CheckQuestion1Constant.���ڶ���ѹ�ظ�SIGO)){
				map2.put(DesignProblemConstant.���ڶ���ѹ�ָ�SIGO, value);
			}
			
			if(key.equals(CheckQuestion1Constant.���ڵ�Ҷ��ѹ�ظ�SIGV)){
				map2.put(DesignProblemConstant.���ڵ�Ҷ��ѹ�ָ�SIGV, value);
			}
			
			//#7:KG��ASP1��ASPK��ABV��ABR��ABS��BTHV��ASPV��BTV��DH0��DT0��BTH1��12 �����β���
			//#20:KG��FF��FF��ABV��ABR��ABS��BTHV��ASPV��BTV��DH0��DT0��BTH1��12 ���ṹ����
			if(key.equals(CheckQuestion1Constant.��������ϵ��KG)){
				map2.put(DesignProblemConstant.��������ϵ��KG, value);
			}
			
			if(key.equals(CheckQuestion1Constant.һתչ����ASP1)){
				map2.put(DesignProblemConstant.һתչ�ұ�ASP1, value);
			}
			
			if(key.equals(CheckQuestion1Constant.���չ����ASPK)){
				map2.put(DesignProblemConstant.ĩתչ�ұ�ASPK, value);
			}
			
			if(key.equals(CheckQuestion1Constant.���ڵ�ҶABV)){
				map2.put(DesignProblemConstant.���ڵ�ҶABV, value);
			}
			
			if(key.equals(CheckQuestion1Constant.ת��ҶƬABR)){
				map2.put(DesignProblemConstant.ת��ҶƬABR, value);
			}
			
			if(key.equals(CheckQuestion1Constant.����ҶƬABS)){
				map2.put(DesignProblemConstant.����ҶƬABS, value);
			}
			
			if(key.equals(CheckQuestion1Constant.����ҳ���BTHV)){
				map2.put(DesignProblemConstant.����ҳ���BTHV, value);
			}
			
			if(key.equals(CheckQuestion1Constant.չ�ұ�ASPV)){
				map2.put(DesignProblemConstant.չ�ұ�ASPV, value);
			}
			
			if(key.equals(CheckQuestion1Constant.���BTV)){
				map2.put(DesignProblemConstant.���BTV, value);
			}
			
			if(key.equals(CheckQuestion1Constant.������ֱ��DHO)){
				map2.put(DesignProblemConstant.������ֱ��DHO, value);
			}
			
			if(key.equals(CheckQuestion1Constant.������ֱ��DTO)){
				map2.put(DesignProblemConstant.������ֱ��DTO, value);
			}
			
			if(key.equals(CheckQuestion1Constant.һת����ҳ���BTH1)){
				map2.put(DesignProblemConstant.һת����ҳ���BTH1, value);
			}
			
			//#8:E1��DE��CMV��DENR��DENS��DENB��DRES��ALFK��PR0��9 ������
			//#21:E1��DE��CMV��DENR��DENS,DENB��DRES��ALFK��PR0��9 ������
			if(key.equals(CheckQuestion1Constant.��һ��E1)){
				map2.put(DesignProblemConstant.��һ��E1, value);
			}
			
			if(key.equals(CheckQuestion1Constant.������һ����DE)){
				map2.put(DesignProblemConstant.������һ����DE, value);
			}
			
			if(key.equals(CheckQuestion1Constant.���ڵ�Ҷ�����Ժ��CMV)){
				map2.put(DesignProblemConstant.���ڵ�Ҷ�����Ժ��CMV, value);
			}
			
			if(key.equals(CheckQuestion1Constant.ת��DENR)){
				map2.put(DesignProblemConstant.ת��DENR, value);
			}
			
			if(key.equals(CheckQuestion1Constant.����DENS)){
				map2.put(DesignProblemConstant.����DENS, value);
			}
			
			if(key.equals(CheckQuestion1Constant.ҶƬDENB)){
				map2.put(DesignProblemConstant.ҶƬDENB, value);
			}
			
			if(key.equals(CheckQuestion1Constant.ת�Ӹ�����Ӧ��DRES)){
				map2.put(DesignProblemConstant.ת�Ӹ�����Ӧ��DRES, value);
			}
			
			if(key.equals(CheckQuestion1Constant.����ӳ���������ALFK)){
				map2.put(DesignProblemConstant.����ӳ���������ALFK, value);
			}
			
			if(key.equals(CheckQuestion1Constant.����ѹ��ǰ����ѹ��PRO)){
				map2.put(DesignProblemConstant.��ѹ����ǰ����ѹ��PRO, value);
			}
			
			//#6:VA1��VAM��VAC��ALF1��OMGN��DOMG��HZ1��HZM��HZK,KH1,DKH��KHMIN��12 ����������
			//#18:ALF0����һ��ת��ǰ����������
			//#19:KH1��DKH��KHMIN����������KHI ֵ����������д0.0
			
			if(key.equals(CheckQuestion1Constant.һת��������ALFO)){
				map2.put(DesignProblemConstant.һת��������ALF1, value);
			}
			
			if(key.equals(CheckQuestion1Constant.��һ��KH1)){
				map2.put(DesignProblemConstant.��һ��KH1, value);
			}
			
			if(key.equals(CheckQuestion1Constant.�𼶵ݼ�DKH)){
				map2.put(DesignProblemConstant.�𼶵ݼ�ֵDKH, value);
			}
			
			if(key.equals(CheckQuestion1Constant.��СֵKHMIN)){
				map2.put(DesignProblemConstant.��СֵKHMIN, value);
			}
			
			//#9:HORDA����С�ҳ���m
			//#22:HORDA����С�ҳ���m
			if(key.equals(CheckQuestion1Constant.��С�ұ�HORDA)){
				map2.put(DesignProblemConstant.��С�ҳ�HORDA, value);
			}
			
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
				for(List<String> row:grid1){
					for(String col:row){
						System.out.println(" "+col);
					}
				}
			}
			
		}
		
		designProblemPanel.setValueFromMap(map2);
	}
}

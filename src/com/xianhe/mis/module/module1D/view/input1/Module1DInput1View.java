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
		tab.setText("文本编辑");
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
		tab.setText("界面控制");
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
		tab.setText("控制变量");
		tabPane.getTabs().add(tab);
		
		ControlVariablePanel controlVariablePanel = new ControlVariablePanel();
		tab.setContent(controlVariablePanel);
		panels.add(controlVariablePanel);
	}
	
	public void addTab22(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("设计问题");
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
		tab.setText("检查问题(1)");
		tabPane.getTabs().add(tab);
		
		CheckQuestion1Panel checkQuestion1Panel = new CheckQuestion1Panel();
		tab.setContent(checkQuestion1Panel);
		panels.add(checkQuestion1Panel);
	}
	
	public void addTab24(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("检查问题(2)");
		tabPane.getTabs().add(tab);
		
		CheckQuestion2Panel checkQuestion2Panel = new CheckQuestion2Panel();
		tab.setContent(checkQuestion2Panel);
		panels.add(checkQuestion2Panel);
	}
	
	public void addTab25(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("检查问题(3)");
		tabPane.getTabs().add(tab);
		
		CheckQuestion3Panel checkQuestion3Panel = new CheckQuestion3Panel();
		tab.setContent(checkQuestion3Panel);
		panels.add(checkQuestion3Panel);
	}
	
	public void addTab26(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("特性计算(1)");
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
		tab.setText("特性计算(2)");
		tabPane.getTabs().add(tab);
		
		FeaturesCalculate2Panel featuresCalculate2Panel = new FeaturesCalculate2Panel();
		tab.setContent(featuresCalculate2Panel);
		panels.add(featuresCalculate2Panel);
	}
	
	public void addTab28(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("特性计算(3)");
		tabPane.getTabs().add(tab);
		
		FeaturesCalculate3Panel featuresCalculate3Panel = new FeaturesCalculate3Panel();
		tab.setContent(featuresCalculate3Panel);
		panels.add(featuresCalculate3Panel);
	}
	
	public void addTab29(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("展弦比计算");
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
			
			//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV─13 个总参数
			//#1:RPM，PR，G，P0，T0，EFF，KH，ISTAGE，KPATH，KF，KC，SIG0，SIGV─13 个总参数
			if(key.equals(CheckQuestion1Constant.转速度或第一级转子叶尖切线速度_RPM)){
				map2.put(DesignProblemConstant.转速或第一级转子叶尖切线速度RPM, value);
			}
			
			if(key.equals(CheckQuestion1Constant.总压比_PR)){
				map2.put(DesignProblemConstant.总压比PR, value);
			}
			
			if(key.equals(CheckQuestion1Constant.流量_G)){
				map2.put(DesignProblemConstant.流量G, value);
			}
			
			if(key.equals(CheckQuestion1Constant.进口总压_PO)){
				map2.put(DesignProblemConstant.进口总压PO, value);
			}
			
			if(key.equals(CheckQuestion1Constant.进口总温_TO)){
				map2.put(DesignProblemConstant.进口总温TO, value);
			}
			
			if(key.equals(CheckQuestion1Constant.绝热效率_EFF)){
				map2.put(DesignProblemConstant.绝热效率EFF, value);
			}
			
			if(key.equals(CheckQuestion1Constant.功率存储系数KH)){
				map2.put(DesignProblemConstant.设计压比提高量KH, value);
			}
			
			if(key.equals(CheckQuestion1Constant.级数_ISTAGE)){
				map2.put(DesignProblemConstant.级数ISTAGE, value);
			}
			
			if(key.equals(CheckQuestion1Constant.流路输入标识KPATH)){
				map2.put(DesignProblemConstant.流路输入标识KPATH, value);
			}
			
			if(key.equals(CheckQuestion1Constant.叶型标识KF)){
				map2.put(DesignProblemConstant.叶型标识KF, value);
			}
			
			if(key.equals(CheckQuestion1Constant.压气机类型KC)){
				map2.put(DesignProblemConstant.压气机类型KC, value);
			}
			
			if(key.equals(CheckQuestion1Constant.进口段总压回复SIGO)){
				map2.put(DesignProblemConstant.进口段总压恢复SIGO, value);
			}
			
			if(key.equals(CheckQuestion1Constant.进口导叶总压回复SIGV)){
				map2.put(DesignProblemConstant.进口导叶总压恢复SIGV, value);
			}
			
			//#7:KG，ASP1，ASPK，ABV，ABR，ABS，BTHV，ASPV，BTV，DH0，DT0，BTH1─12 个几何参数
			//#20:KG，FF，FF，ABV，ABR，ABS，BTHV，ASPV，BTV，DH0，DT0，BTH1─12 个结构参数
			if(key.equals(CheckQuestion1Constant.流量缩放系数KG)){
				map2.put(DesignProblemConstant.流量缩放系数KG, value);
			}
			
			if(key.equals(CheckQuestion1Constant.一转展旋比ASP1)){
				map2.put(DesignProblemConstant.一转展弦比ASP1, value);
			}
			
			if(key.equals(CheckQuestion1Constant.最后级展旋比ASPK)){
				map2.put(DesignProblemConstant.末转展弦比ASPK, value);
			}
			
			if(key.equals(CheckQuestion1Constant.进口导叶ABV)){
				map2.put(DesignProblemConstant.进口导叶ABV, value);
			}
			
			if(key.equals(CheckQuestion1Constant.转子叶片ABR)){
				map2.put(DesignProblemConstant.转子叶片ABR, value);
			}
			
			if(key.equals(CheckQuestion1Constant.静子叶片ABS)){
				map2.put(DesignProblemConstant.静子叶片ABS, value);
			}
			
			if(key.equals(CheckQuestion1Constant.尖根弦长比BTHV)){
				map2.put(DesignProblemConstant.尖根弦长比BTHV, value);
			}
			
			if(key.equals(CheckQuestion1Constant.展弦比ASPV)){
				map2.put(DesignProblemConstant.展弦比ASPV, value);
			}
			
			if(key.equals(CheckQuestion1Constant.稠度BTV)){
				map2.put(DesignProblemConstant.稠度BTV, value);
			}
			
			if(key.equals(CheckQuestion1Constant.出口内直径DHO)){
				map2.put(DesignProblemConstant.出口内直径DHO, value);
			}
			
			if(key.equals(CheckQuestion1Constant.出口外直径DTO)){
				map2.put(DesignProblemConstant.出口外直径DTO, value);
			}
			
			if(key.equals(CheckQuestion1Constant.一转尖根弦长比BTH1)){
				map2.put(DesignProblemConstant.一转尖根弦长比BTH1, value);
			}
			
			//#8:E1，DE，CMV，DENR，DENS，DENB，DRES，ALFK，PR0─9 个参数
			//#21:E1，DE，CMV，DENR，DENS,DENB，DRES，ALFK，PR0─9 个参数
			if(key.equals(CheckQuestion1Constant.第一级E1)){
				map2.put(DesignProblemConstant.第一级E1, value);
			}
			
			if(key.equals(CheckQuestion1Constant.最后级与第一级差DE)){
				map2.put(DesignProblemConstant.最后级与第一级差DE, value);
			}
			
			if(key.equals(CheckQuestion1Constant.进口导叶最大相对厚度CMV)){
				map2.put(DesignProblemConstant.进口导叶最大相对厚度CMV, value);
			}
			
			if(key.equals(CheckQuestion1Constant.转件DENR)){
				map2.put(DesignProblemConstant.转件DENR, value);
			}
			
			if(key.equals(CheckQuestion1Constant.静件DENS)){
				map2.put(DesignProblemConstant.静件DENS, value);
			}
			
			if(key.equals(CheckQuestion1Constant.叶片DENB)){
				map2.put(DesignProblemConstant.叶片DENB, value);
			}
			
			if(key.equals(CheckQuestion1Constant.转子根许用应力DRES)){
				map2.put(DesignProblemConstant.转子根许用应力DRES, value);
			}
			
			if(key.equals(CheckQuestion1Constant.最后静子出口气流角ALFK)){
				map2.put(DesignProblemConstant.最后静子出口气流角ALFK, value);
			}
			
			if(key.equals(CheckQuestion1Constant.本气压机前已有压比PRO)){
				map2.put(DesignProblemConstant.本压气机前已有压比PRO, value);
			}
			
			//#6:VA1，VAM，VAC，ALF1，OMGN，DOMG，HZ1，HZM，HZK,KH1,DKH，KHMIN─12 个气动参数
			//#18:ALF0─第一级转子前绝对气流角
			//#19:KH1，DKH，KHMIN─如已输入KHI 值，此三量均写0.0
			
			if(key.equals(CheckQuestion1Constant.一转进气流角ALFO)){
				map2.put(DesignProblemConstant.一转进气流角ALF1, value);
			}
			
			if(key.equals(CheckQuestion1Constant.第一级KH1)){
				map2.put(DesignProblemConstant.第一级KH1, value);
			}
			
			if(key.equals(CheckQuestion1Constant.逐级递减DKH)){
				map2.put(DesignProblemConstant.逐级递减值DKH, value);
			}
			
			if(key.equals(CheckQuestion1Constant.最小值KHMIN)){
				map2.put(DesignProblemConstant.最小值KHMIN, value);
			}
			
			//#9:HORDA─最小弦长，m
			//#22:HORDA─最小弦长，m
			if(key.equals(CheckQuestion1Constant.最小弦比HORDA)){
				map2.put(DesignProblemConstant.最小弦长HORDA, value);
			}
			
			/*#2:DT1，D1，DH1，DTC，DMC，DHC，DTK，DFF，DHK─给定流路的9 个直径值
			DT1─第一级转子进口叶尖直径
			D1─第一级转子进口轮毂比
			DH1─第一级转子进口根部直径
			DTC─等外径写1.0
			DMC─等中径写1.0
			DHC─等内径写1.0
			DTK─压气机出口外径
			DFF─0.0
			DHK─压气机出口内径
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

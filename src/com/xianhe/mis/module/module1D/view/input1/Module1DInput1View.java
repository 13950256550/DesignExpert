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
				
				if(AppContext.getStatus(AppContext.IN_STATUS)==AppContext.IN_STATUS_READED){
					AppContext.setStatus(AppContext.IN_STATUS, AppContext.IN_STATUS_COPY);
					
					Map<String,Object> outputMap = new HashMap<String,Object>();
					
					//izi 0-不修正 1-修正
					String izi = String.valueOf(map.get(ControlVariableConstant.损失修正符_IZI));
					if(izi!=null && izi.equals("0")){
						Module1DInput1View.setControlVariableDefaultValue(outputMap);
						CommonPanel controlVariablePanel = getCommonPanel(0);
						controlVariablePanel.setValueFromMap(outputMap);
					}
					
					//k12 1-设计问题 2-检查问题
					String k12 = String.valueOf(map.get(ControlVariableConstant.检查或设计_K12));
					if(k12!=null && k12.equals("1")){
						//如果原来是设计问题需要拷贝相关输入参数到检查问题页
					}else if(k12!=null && k12.equals("2")){
						//如果原来是检查问题需要拷贝相关输入参数到设计问题页
						Module1DInput1View.copyCheckQuestionToDesignProblem(outputMap);
						Module1DInput1View.copyCheckQuestion2ToDesignProblem(outputMap);
						Module1DInput1View.setDesignProblemDefaultValue(outputMap);
						CommonPanel designProblemPanel = getCommonPanel(1);
						designProblemPanel.setValueFromMap(outputMap);
					}
					
					//kgka 0-特性2页面参数不输   1-特性2页面参数输
					String kgka = String.valueOf(map.get(FeaturesCalculateConstant.控制参数KGKA));
					if(kgka!=null && kgka.equals("0")){
						//如果原来是kgka=0 需要为特性2页面设置初始值
						setFeaturesCalculate2DefaultValue(outputMap);
						CommonPanel featuresCalculate2Panel = getCommonPanel(6);
						featuresCalculate2Panel.setValueFromMap(outputMap);
					}
					
					//igka 0-特性3页面参数不输   1-特性3页面参数输
					String igka = String.valueOf(map.get(FeaturesCalculateConstant.控制参数KGKA));
					if(kgka!=null && kgka.equals("0")){
						//如果原来是kgka=0 需要为特性3页面设置初始值
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
	
	public static void copyCheckQuestionToDesignProblem(Map<String,Object> outputMap){
		CommonPanel checkQuestionPanel = getCommonPanel(2);
		//CommonPanel designProblemPanel = getCommonPanel(1);
		
		Map<String,Object> map = new HashMap<String,Object>();
		checkQuestionPanel.getValueIntoMap(map);
		
		Set<String> keys = map.keySet();
		for(String key:keys){
			Object value = map.get(key);
			
			//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV─13 个总参数
			//#1:RPM，PR，G，P0，T0，EFF，KH，ISTAGE，KPATH，KF，KC，SIG0，SIGV─13 个总参数
			if(key.equals(CheckQuestionConstant.RPM转速度或第一级转子叶尖切线速度)){
				outputMap.put(DesignProblemConstant.RPM转速或第一级转子叶尖切线速度, value);
			}
			
			if(key.equals(CheckQuestionConstant.PR总压比)){
				outputMap.put(DesignProblemConstant.PR总压比, value);
			}
			
			if(key.equals(CheckQuestionConstant.G流量)){
				outputMap.put(DesignProblemConstant.G流量, value);
			}
			
			if(key.equals(CheckQuestionConstant.PO进口总压)){
				outputMap.put(DesignProblemConstant.PO进口总压, value);
			}
			
			if(key.equals(CheckQuestionConstant.TO进口总温)){
				outputMap.put(DesignProblemConstant.TO进口总温, value);
			}
			
			if(key.equals(CheckQuestionConstant.EFF绝热效率)){
				outputMap.put(DesignProblemConstant.EFF绝热效率, value);
			}
			
			if(key.equals(CheckQuestionConstant.KH功率存储系数)){
				outputMap.put(DesignProblemConstant.KH设计压比提高量, value);
			}
			
			if(key.equals(CheckQuestionConstant.ISTAGE级数)){
				outputMap.put(DesignProblemConstant.ISTAGE级数, value);
			}
			
			if(key.equals(CheckQuestionConstant.KPATH流路输入标识)){
				outputMap.put(DesignProblemConstant.KPATH流路输入标识, value);
			}
			
			if(key.equals(CheckQuestionConstant.KF叶型标识)){
				outputMap.put(DesignProblemConstant.KF叶型标识, value);
			}
			
			if(key.equals(CheckQuestionConstant.KC压气机类型)){
				outputMap.put(DesignProblemConstant.KC压气机类型, value);
			}
			
			if(key.equals(CheckQuestionConstant.SIGO进口段总压回复)){
				outputMap.put(DesignProblemConstant.SIGO进口段总压恢复, value);
			}
			
			if(key.equals(CheckQuestionConstant.SIGV进口导叶总压回复)){
				outputMap.put(DesignProblemConstant.SIGV进口导叶总压恢复, value);
			}
			
			//#7:KG，ASP1，ASPK，ABV，ABR，ABS，BTHV，ASPV，BTV，DH0，DT0，BTH1─12 个几何参数
			//#20:KG，FF，FF，ABV，ABR，ABS，BTHV，ASPV，BTV，DH0，DT0，BTH1─12 个结构参数
			if(key.equals(CheckQuestionConstant.KG流量缩放系数)){
				outputMap.put(DesignProblemConstant.KG流量缩放系数, value);
			}
			
			if(key.equals(CheckQuestionConstant.ASP1一转展旋比)){
				outputMap.put(DesignProblemConstant.ASP1一转展弦比, value);
			}
			
			if(key.equals(CheckQuestionConstant.ASPK最后级展旋比)){
				outputMap.put(DesignProblemConstant.ASPK末转展弦比, value);
			}
			
			if(key.equals(CheckQuestionConstant.ABV进口导叶)){
				outputMap.put(DesignProblemConstant.ABV进口导叶, value);
			}
			
			if(key.equals(CheckQuestionConstant.ABR转子叶片)){
				outputMap.put(DesignProblemConstant.ABR转子叶片, value);
			}
			
			if(key.equals(CheckQuestionConstant.ABS静子叶片)){
				outputMap.put(DesignProblemConstant.ABS静子叶片, value);
			}
			
			if(key.equals(CheckQuestionConstant.BTHV尖根弦长比)){
				outputMap.put(DesignProblemConstant.BTHV尖根弦长比, value);
			}
			
			if(key.equals(CheckQuestionConstant.ASPV展弦比)){
				outputMap.put(DesignProblemConstant.ASPV展弦比, value);
			}
			
			if(key.equals(CheckQuestionConstant.BTV稠度)){
				outputMap.put(DesignProblemConstant.BTV稠度, value);
			}
			
			if(key.equals(CheckQuestionConstant.DHO出口内直径)){
				outputMap.put(DesignProblemConstant.DHO出口内直径, value);
			}
			
			if(key.equals(CheckQuestionConstant.DTO出口外直径)){
				outputMap.put(DesignProblemConstant.DTO出口外直径, value);
			}
			
			if(key.equals(CheckQuestionConstant.BTH1一转尖根弦长比)){
				outputMap.put(DesignProblemConstant.BTH1一转尖根弦长比, value);
			}
			
			//#8:E1，DE，CMV，DENR，DENS，DENB，DRES，ALFK，PR0─9 个参数
			//#21:E1，DE，CMV，DENR，DENS,DENB，DRES，ALFK，PR0─9 个参数
			if(key.equals(CheckQuestionConstant.E1第一级)){
				outputMap.put(DesignProblemConstant.E1第一级, value);
			}
			
			if(key.equals(CheckQuestionConstant.DE最后级与第一级差)){
				outputMap.put(DesignProblemConstant.DE最后级与第一级差, value);
			}
			
			if(key.equals(CheckQuestionConstant.CMV进口导叶最大相对厚度)){
				outputMap.put(DesignProblemConstant.CMV进口导叶最大相对厚度, value);
			}
			
			if(key.equals(CheckQuestionConstant.DENR转件)){
				outputMap.put(DesignProblemConstant.DENR转件, value);
			}
			
			if(key.equals(CheckQuestionConstant.DENS静件)){
				outputMap.put(DesignProblemConstant.DENS静件, value);
			}
			
			if(key.equals(CheckQuestionConstant.DENB叶片)){
				outputMap.put(DesignProblemConstant.DENB叶片, value);
			}
			
			if(key.equals(CheckQuestionConstant.DRES转子根许用应力)){
				outputMap.put(DesignProblemConstant.DRES转子根许用应力, value);
			}
			
			if(key.equals(CheckQuestionConstant.ALFK最后静子出口气流角)){
				outputMap.put(DesignProblemConstant.ALFK最后静子出口气流角, value);
			}
			
			if(key.equals(CheckQuestionConstant.PRO本气压机前已有压比)){
				outputMap.put(DesignProblemConstant.PRO本压气机前已有压比, value);
			}
			
			//#6:VA1，VAM，VAC，ALF1，OMGN，DOMG，HZ1，HZM，HZK,KH1,DKH，KHMIN─12 个气动参数
			//#18:ALF0─第一级转子前绝对气流角
			//#19:KH1，DKH，KHMIN─如已输入KHI 值，此三量均写0.0
			
			if(key.equals(CheckQuestionConstant.ALFO一转进气流角)){
				outputMap.put(DesignProblemConstant.ALF1一转进气流角, value);
			}
			
			if(key.equals(CheckQuestionConstant.KH1第一级)){
				outputMap.put(DesignProblemConstant.KH1第一级, value);
			}
			
			if(key.equals(CheckQuestionConstant.DKH逐级递减)){
				outputMap.put(DesignProblemConstant.DKH逐级递减值, value);
			}
			
			if(key.equals(CheckQuestionConstant.KHMIN最小值)){
				outputMap.put(DesignProblemConstant.KHMIN最小值, value);
			}
			
			//#9:HORDA─最小弦长，m
			//#22:HORDA─最小弦长，m
			if(key.equals(CheckQuestionConstant.HORDA最小弦比)){
				outputMap.put(DesignProblemConstant.HORDA最小弦长, value);
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
		outputMap.put(ControlVariableConstant.损失校正系数ALN, "0.0");
		outputMap.put(ControlVariableConstant.ALW, "0.0");
		outputMap.put(ControlVariableConstant.PKN, "0.0");
		outputMap.put(ControlVariableConstant.PKW, "0.0");
	}
	
	public static void setDesignProblemDefaultValue(Map<String,Object> outputMap){
		outputMap.put(DesignProblemConstant.VA1一级进轴速度, "0.0");
		outputMap.put(DesignProblemConstant.VAM中段轴速度, "0.0");
		outputMap.put(DesignProblemConstant.VAC出口轴速, "0.0");
		
		outputMap.put(DesignProblemConstant.OMGN第中级反力度, "0.0");
		outputMap.put(DesignProblemConstant.DOMG第中级后反力度增量, "0.0");
		
		outputMap.put(DesignProblemConstant.HZ1第一级, "0.0");
		outputMap.put(DesignProblemConstant.HZM平均级, "0.0");
		outputMap.put(DesignProblemConstant.HZK最后级, "0.0");
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
		Object value = Module1DInput1View.getValue(CheckQuestionConstant.ISTAGE级数);
		int istage = 0;
		try {
			istage = Integer.parseInt(String.valueOf(value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return istage;
	}
}

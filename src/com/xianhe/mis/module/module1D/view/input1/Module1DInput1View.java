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

import org.apache.log4j.Logger;

import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.module.module1D.readwritefile.PathUtil;
import com.xianhe.mis.module.module1D.readwritefile.ReadInputFileData;
import com.xianhe.mis.module.module1D.readwritefile.WriteDataToFile;
import com.xianhe.mis.module.module1D.view.output.Module1DOutputView;

import javafx.geometry.Side;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class Module1DInput1View extends BorderPane{
	public static Logger logger = Logger.getLogger(Module1DOutputView.class);
	private static List<CommonPanel> panels = null;
	private TextArea textArea = null;
	
	public Module1DInput1View(){
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
			in = new BufferedReader(new InputStreamReader(new FileInputStream(PathUtil.get1D_in1File()),"gbk"));
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
				logger.info("\r\n"+sb.toString());
			}
		});
	}
	
	public void addTab2(TabPane tabPane){
		Tab tab = new Tab();
		tab.setText("界面控制");
		tab.setClosable(false);
		tabPane.getTabs().add(tab);
		
		TabPane tabPane2 = new TabPane();
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
}

package com.xianhe.mis.module.module1D.view.output;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.xianhe.mis.module.module1D.readwritefile.PathUtil;

import javafx.geometry.Side;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class Module1DOutputView extends BorderPane{
	public static Logger logger = Logger.getLogger(Module1DOutputView.class);
	
	public Module1DOutputView(){
		TabPane tabPane = new TabPane();
		setCenter(tabPane);
		tabPane.setSide(Side.BOTTOM);
		
		addTab1(tabPane);
		addTab2(tabPane);
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
		
		TextArea textArea = new TextArea();
		scrollPane.setContent(textArea);
		
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(PathUtil.get1D_outFile()),"gbk"));
			StringBuilder sb = new StringBuilder();
			String line=null;
			logger.info(new Date());
			while ((line=reader.readLine())!=null) {
				//textArea.appendText(line);
				//textArea.appendText("\r\n");
				sb.append(line).append("\n");
			}
			logger.info(new Date());
			textArea.setText(sb.toString());
			logger.info(new Date());
			reader.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		textArea.home();
	}
	
	public void addTab2(TabPane tabPane){
		Tab tab = new Tab();
		tab.setText("界面控制");
		tab.setClosable(false);
		tabPane.getTabs().add(tab);
		
		TabPane tabPane2 = new TabPane();
		tabPane2.setSide(Side.TOP);
		tab.setContent(tabPane2);
		
		addTab21(tabPane2);
		addTab22(tabPane2);
		addTab23(tabPane2);
	}
	
	public void addTab21(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("气动参数沿级分布图");
		tabPane.getTabs().add(tab);
		
		AeroParameterDistributionPanel aeroParameterDistributionPanel = new AeroParameterDistributionPanel();
		tab.setContent(aeroParameterDistributionPanel);
	}
	
	public void addTab22(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("叶型参数沿级分布图");
		tabPane.getTabs().add(tab);
		
		BladeParameterDistributionPanel bladeParameterDistributionPanel = new BladeParameterDistributionPanel();
		tab.setContent(bladeParameterDistributionPanel);
	}
	
	public void addTab23(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("流路图");
		tabPane.getTabs().add(tab);
		
		FlowPathPanel flowPathPanel = new FlowPathPanel();
		tab.setContent(flowPathPanel);
	}
}

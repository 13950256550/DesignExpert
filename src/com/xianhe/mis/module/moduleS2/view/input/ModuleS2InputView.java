package com.xianhe.mis.module.moduleS2.view.input;

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

import com.xianhe.core.common.EnvReadWriteUtil;
import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.module.AppContext;
import com.xianhe.mis.module.module1D.constant.ControlVariableConstant;
import com.xianhe.mis.module.module1D.constant.FeaturesCalculateConstant;
import com.xianhe.mis.module.module1D.view.input1.ControlVariablePanel;
import com.xianhe.mis.module.module1D.view.input1.Module1DInput1View;
import com.xianhe.mis.module.module1D.view.input1.OneDimensionalDgazdInputPanel;
import com.xianhe.mis.module.module1D.view.output.Module1DOutputView;
import com.xianhe.mis.module.moduleS2.readwritefile.ReadInputFileData;

import javafx.geometry.Side;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class ModuleS2InputView extends BorderPane{
	public static Logger logger = Logger.getLogger(Module1DOutputView.class);
	private static List<CommonPanel> panels = null;
	public static TextArea textArea = null;
	public static TabPane tabPane2 = null;
	private String fileName = null;
	public ModuleS2InputView(String fileName){
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
				
				Map<String,Object> map = ReadInputFileData.parseS2_in(list);
				for(CommonPanel panel:panels){
					panel.setValueFromMap(map);
				}
			}
		});
		
		addTab21(tabPane2);
	}
	
	public void addTab21(TabPane tabPane){
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText("流路图");
		tabPane.getTabs().add(tab);
		
		FlowPathPanel flowPathPanel = new FlowPathPanel(fileName);
		tab.setContent(flowPathPanel);
	}
}

package com.xianhe.mis.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.xianhe.core.common.Code;
import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.module.module1D.constant.AspectRatioCalculateConstant;
import com.xianhe.mis.module.module1D.constant.CheckQuestionConstant;
import com.xianhe.mis.module.module1D.constant.ControlVariableConstant;
import com.xianhe.mis.module.module1D.constant.DesignProblemConstant;
import com.xianhe.mis.module.module1D.constant.FeaturesCalculateConstant;
import com.xianhe.mis.module.module1D.readwritefile.GridDataUtil;
import com.xianhe.mis.module.module1D.view.input1.Module1DInput1View;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class InputChangeListener implements ChangeListener<Code>,EventHandler<ActionEvent> {
	public static Logger logger = Logger.getLogger(InputChangeListener.class);
	private String inputId = null;
	
	public InputChangeListener(String inputId) {
		super();
		this.inputId = inputId;
	}

	@Override
	public void handle(ActionEvent event) {
		if(inputId!=null && inputId.equals(AspectRatioCalculateConstant.喘振裕度输入NCU)){
			TextField textField = (TextField)event.getSource();
			CommonPanel aspectRatioCalculatePanel = Module1DInput1View.getCommonPanel(8);
			if(!"3".equals(textField.getText())){
				aspectRatioCalculatePanel.setReadonly("AspectRatioCalculatePanel.grid1", true);
			}else{
				aspectRatioCalculatePanel.setReadonly("AspectRatioCalculatePanel.grid1", false);
			}
		}
		
		if(inputId!=null && (inputId.equals(CheckQuestionConstant.ISTAGE级数) ||(inputId.equals(DesignProblemConstant.ISTAGE级数)))){
			TextField textField = (TextField)event.getSource();
			String value = textField.getText();
			CommonPanel designProblemPanel = Module1DInput1View.getCommonPanel(1);
			CommonPanel checkQuestion1Panel = Module1DInput1View.getCommonPanel(2);
			String value1 = String.valueOf(designProblemPanel.getValue(DesignProblemConstant.ISTAGE级数));
			String value2 = String.valueOf(checkQuestion1Panel.getValue(CheckQuestionConstant.ISTAGE级数));
			
			if(!value1.equals(value)){
				designProblemPanel.setValue(DesignProblemConstant.ISTAGE级数, value);
			}
			if(!value2.equals(value)){
				checkQuestion1Panel.setValue(CheckQuestionConstant.ISTAGE级数, value);
			}
			
			int istage = 0;
			try {
				istage = Integer.parseInt(value);		
				setGridDataByIstage(istage);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		if(inputId!=null && (inputId.equals(FeaturesCalculateConstant.等转速条线数N))){
			TextField textField = (TextField)event.getSource();
			int n = 0;
			try {
				n = Integer.parseInt(textField.getText());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			CommonPanel featuresCalculate1Panel = Module1DInput1View.getCommonPanel(5);
			List<List<String>> grid = (List<List<String>>)featuresCalculate1Panel.getValue("FeaturesCalculate1Panel.grid3");
			int istage = Module1DInput1View.getISTAGE();
			if(grid!=null){
				if(grid.size()<n){
					for(int row = grid.size()-1;row<n;row++){
						List<String> rowList = new ArrayList<>();
						for(int col=0;col<istage+1;col++){
							rowList.add("0.0");
						}
						grid.add(rowList);
					}
				}else{
					grid = GridDataUtil.trim(grid, 0, n-1);
				}
			}
			featuresCalculate1Panel.setValue("FeaturesCalculate1Panel.grid3", grid);
		}
	}
	
	public void setGridDataByIstage(int istage){
		CommonPanel checkQuestion2Panel = Module1DInput1View.getCommonPanel(3);
		CommonPanel checkQuestion3Panel = Module1DInput1View.getCommonPanel(4);
		CommonPanel featuresCalculate2Panel = Module1DInput1View.getCommonPanel(6);
		CommonPanel featuresCalculate3Panel = Module1DInput1View.getCommonPanel(7);
		
		List<List<String>> grid = (List<List<String>>)checkQuestion2Panel.getValue("CheckQuestion2Panel.grid1");
		if(grid!=null){
			if(grid.size()<istage){
				for(int row = grid.size()-1;row<istage;row++){
					List<String> rowList = new ArrayList<>();
					for(int col=0;col<8;col++){
						rowList.add("0.0");
					}
					grid.add(rowList);
				}
			}else{
				grid = GridDataUtil.trim(grid, 0, istage-1);
			}
		}
		checkQuestion2Panel.setValue("CheckQuestion2Panel.grid1", grid);
		
		grid = (List<List<String>>)checkQuestion3Panel.getValue("CheckQuestion3Panel.grid1");
		List<String> lastRow = grid.get(grid.size()-1);
		grid.remove(lastRow);
		if(grid!=null){
			if(grid.size()<istage){
				for(int row = grid.size()-1;row<istage;row++){
					List<String> rowList = new ArrayList<>();
					for(int col=0;col<8;col++){
						rowList.add("0.0");
					}
					grid.add(rowList);
				}
			}else{
				grid = GridDataUtil.trim(grid, 0, istage-1);
			}
		}
		grid.add(lastRow);
		checkQuestion3Panel.setValue("CheckQuestion3Panel.grid1", grid);
		
		grid = (List<List<String>>)featuresCalculate2Panel.getValue("FeaturesCalculate2Panel.grid1");
		if(grid!=null){
			if(grid.size()<istage){
				for(int row = grid.size()-1;row<istage;row++){
					List<String> rowList = new ArrayList<>();
					for(int col=0;col<8;col++){
						rowList.add("0");
					}
					grid.add(rowList);
				}
			}else{
				grid = GridDataUtil.trim(grid, 0, istage-1);
			}
		}
		featuresCalculate2Panel.setValue("FeaturesCalculate2Panel.grid1", grid);
		
		grid = (List<List<String>>)featuresCalculate3Panel.getValue("FeaturesCalculate3Panel.grid1");
		if(grid!=null){
			if(grid.size()<istage){
				for(int row = grid.size()-1;row<istage;row++){
					List<String> rowList = new ArrayList<>();
					for(int col=0;col<8;col++){
						rowList.add("0");
					}
					grid.add(rowList);
				}
			}else{
				grid = GridDataUtil.trim(grid, 0, istage-1);
			}
		}
		featuresCalculate3Panel.setValue("FeaturesCalculate3Panel.grid1", grid);
		
		CommonPanel featuresCalculate1Panel = Module1DInput1View.getCommonPanel(5);
		grid = (List<List<String>>)featuresCalculate1Panel.getValue("FeaturesCalculate1Panel.grid3");
		grid = GridDataUtil.transform(grid);
		int n = Module1DInput1View.getN();
		if(grid!=null){
			if(grid.size()<istage+1){
				for(int row = grid.size()-1;row<istage;row++){
					List<String> rowList = new ArrayList<>();
					for(int col=0;col<n;col++){
						rowList.add("0.0");
					}
					grid.add(rowList);
				}
			}else{
				grid = GridDataUtil.trim(grid, 0, istage);
			}
		}
		grid = GridDataUtil.transform(grid);
		
		TableView<Map<Integer,String>> tableView = (TableView<Map<Integer,String>>)featuresCalculate1Panel.getInputControl("FeaturesCalculate1Panel.grid3");
		if(tableView!=null){
			tableView.getColumns().clear();
			
			TableColumn<Map<Integer,String>, String> rowNumCol = new TableColumn<Map<Integer,String>, String>("");
			rowNumCol.setCellValueFactory(new MapValueFactory(100));
			rowNumCol.setCellFactory(new MyCallback());
			rowNumCol.setEditable(false);
			rowNumCol.setPrefWidth(30);
			tableView.getColumns().add(rowNumCol);
			String[] columns = new String[istage+1];
			int[] widths = new int[istage+1];
			for(int i=0;i<istage+1;i++){
				columns[i] = String.valueOf(i+1);
				widths[i] = 100;
			}
			if (columns != null && widths != null && columns.length > 0) {
				for (int i = 0; i < columns.length; i++) {
					final int pos = i;
					TableColumn<Map<Integer,String>, String> col = new TableColumn<Map<Integer,String>, String>(columns[i]);
					col.setPrefWidth(widths[i]);
					col.setCellValueFactory(new MapValueFactory(i));
					col.setCellFactory(TextFieldTableCell.forTableColumn());
					col.setOnEditCommit((CellEditEvent<Map<Integer, String>, String> event)->{
						Map<Integer,String> row = event.getTableView().getItems().get(event.getTablePosition().getRow());
						row.put(pos,event.getNewValue());
					});
					
					tableView.getColumns().add(col);
				}
			}
			tableView.setPrefHeight(100);
		}
		
		featuresCalculate1Panel.setValue("FeaturesCalculate1Panel.grid3", grid);
	}

	@Override
	public void changed(ObservableValue<? extends Code> observable, Code oldValue, Code newValue) {
		/*
		String msg = inputId;
		if(oldValue!=null){
			msg += ":"+oldValue.getKey();
		}
		if(newValue!=null){
			msg += ":"+newValue.getKey();
		}
		logger.info(msg);
		*/
		if(inputId!=null && inputId.equals(ControlVariableConstant.检查或设计_K12)){
			//k12 1-设计问题 2-检查问题
			if(newValue!=null && newValue.getKey().equals("1")){
				//检查-->设计
				CommonPanel designProblemPanel = Module1DInput1View.getCommonPanel(1);
				designProblemPanel.setReadonly(false);
				
				CommonPanel checkQuestion1Panel = Module1DInput1View.getCommonPanel(2);
				checkQuestion1Panel.setReadonly(true);
				CommonPanel checkQuestion2Panel = Module1DInput1View.getCommonPanel(3);
				checkQuestion2Panel.setReadonly(true);
				CommonPanel checkQuestion3Panel = Module1DInput1View.getCommonPanel(4);
				checkQuestion3Panel.setReadonly(true);
				
			}else if(newValue!=null && newValue.getKey().equals("2")){
				//设计-->检查
				CommonPanel designProblemPanel = Module1DInput1View.getCommonPanel(1);
				designProblemPanel.setReadonly(true);
				
				CommonPanel checkQuestion1Panel = Module1DInput1View.getCommonPanel(2);
				checkQuestion1Panel.setReadonly(false);
				CommonPanel checkQuestion2Panel = Module1DInput1View.getCommonPanel(3);
				checkQuestion2Panel.setReadonly(false);
				CommonPanel checkQuestion3Panel = Module1DInput1View.getCommonPanel(4);
				checkQuestion3Panel.setReadonly(false);
			}
		}
		
		if(inputId!=null && inputId.equals(ControlVariableConstant.解题类型_K)){
			//k 1-设计或检查 2-特性 3-设计或检查+特性 4-设计或检查+特性+展弦比
			if(newValue!=null && newValue.getKey().equals("1")){
				CommonPanel FeaturesCalculate1Panel = Module1DInput1View.getCommonPanel(5);
				FeaturesCalculate1Panel.setReadonly(true);
				CommonPanel FeaturesCalculate2Panel = Module1DInput1View.getCommonPanel(6);
				FeaturesCalculate2Panel.setReadonly(true);
				CommonPanel FeaturesCalculate3Panel = Module1DInput1View.getCommonPanel(7);
				FeaturesCalculate3Panel.setReadonly(true);
				
				CommonPanel aspectRatioCalculatePanel = Module1DInput1View.getCommonPanel(8);
				aspectRatioCalculatePanel.setReadonly(true);
			}
			
			if(newValue!=null && newValue.getKey().equals("3")){
				CommonPanel FeaturesCalculate1Panel = Module1DInput1View.getCommonPanel(5);
				FeaturesCalculate1Panel.setReadonly(false);
				CommonPanel FeaturesCalculate2Panel = Module1DInput1View.getCommonPanel(6);
				FeaturesCalculate2Panel.setReadonly(false);
				CommonPanel FeaturesCalculate3Panel = Module1DInput1View.getCommonPanel(7);
				FeaturesCalculate3Panel.setReadonly(false);
				
				CommonPanel aspectRatioCalculatePanel = Module1DInput1View.getCommonPanel(8);
				aspectRatioCalculatePanel.setReadonly(true);
			}
			
			if(newValue!=null && newValue.getKey().equals("4")){
				CommonPanel FeaturesCalculate1Panel = Module1DInput1View.getCommonPanel(5);
				FeaturesCalculate1Panel.setReadonly(false);
				CommonPanel FeaturesCalculate2Panel = Module1DInput1View.getCommonPanel(6);
				FeaturesCalculate2Panel.setReadonly(false);
				CommonPanel FeaturesCalculate3Panel = Module1DInput1View.getCommonPanel(7);
				FeaturesCalculate3Panel.setReadonly(false);
				
				CommonPanel aspectRatioCalculatePanel = Module1DInput1View.getCommonPanel(8);
				aspectRatioCalculatePanel.setReadonly(false);
			}
		}
		
		if(inputId!=null && inputId.equals(FeaturesCalculateConstant.控制参数KGKA)){
			//kgka 0-特性2不输 1-特性2输
			if(newValue!=null && newValue.getKey().equals("0")){
				CommonPanel FeaturesCalculate2Panel = Module1DInput1View.getCommonPanel(6);
				FeaturesCalculate2Panel.setReadonly(true);
			}
			
			if(newValue!=null && newValue.getKey().equals("1")){
				CommonPanel FeaturesCalculate2Panel = Module1DInput1View.getCommonPanel(6);
				FeaturesCalculate2Panel.setReadonly(false);
			}
		}
		
		if(inputId!=null && inputId.equals(FeaturesCalculateConstant.控制参数IGKA)){
			//igka 0-特性3不输 1-特性3输
			if(newValue!=null && newValue.getKey().equals("0")){
				CommonPanel FeaturesCalculate3Panel = Module1DInput1View.getCommonPanel(7);
				FeaturesCalculate3Panel.setReadonly(true);
			}
			
			if(newValue!=null && newValue.getKey().equals("1")){
				CommonPanel FeaturesCalculate3Panel = Module1DInput1View.getCommonPanel(7);
				FeaturesCalculate3Panel.setReadonly(false);
			}
		}
		
		if(inputId!=null && inputId.equals(ControlVariableConstant.损失修正符_IZI)){
			CommonPanel controlVariablePanel = Module1DInput1View.getCommonPanel(0);
			//izi 0-不修正 1-修正
			if(newValue!=null && newValue.getKey().equals("0")){
				controlVariablePanel.setReadonly(ControlVariableConstant.损失校正系数ALN,true);
				controlVariablePanel.setReadonly(ControlVariableConstant.ALW,true);
				controlVariablePanel.setReadonly(ControlVariableConstant.PKN,true);
				controlVariablePanel.setReadonly(ControlVariableConstant.PKW,true);
			}
			
			if(newValue!=null && newValue.getKey().equals("1")){
				controlVariablePanel.setReadonly(ControlVariableConstant.损失校正系数ALN,false);
				controlVariablePanel.setReadonly(ControlVariableConstant.ALW,false);
				controlVariablePanel.setReadonly(ControlVariableConstant.PKN,false);
				controlVariablePanel.setReadonly(ControlVariableConstant.PKW,false);
			}
		}
		
		if(inputId!=null && inputId.equals(ControlVariableConstant.静叶可调_IREG)){
			CommonPanel FeaturesCalculate1Panel = Module1DInput1View.getCommonPanel(5);
			//ireg 0-不调 1-调静叶并输入
			if(newValue!=null && newValue.getKey().equals("0")){
				FeaturesCalculate1Panel.setReadonly("FeaturesCalculate1Panel.grid3",true);
			}
			
			if(newValue!=null && newValue.getKey().equals("1")){
				FeaturesCalculate1Panel.setReadonly("FeaturesCalculate1Panel.grid3",false);
			}
		}
	}

}

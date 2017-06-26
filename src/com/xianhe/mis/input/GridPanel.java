package com.xianhe.mis.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.xianhe.core.common.InputItemConfig;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class GridPanel extends InputPanel{
	public static Logger logger = Logger.getLogger(InputPanel.class);
	//private boolean hasRowHeader = false;
	private int defaultColumnWidth = 100;
	private int defaultTableViewHeight = 100;
	private List<List<String>> data = null;
	private InputItemConfig inputItemConfig = null;
	
	private TableView<Map<Integer,String>> tableView = new TableView<Map<Integer,String>>();
	
	public GridPanel(InputItemConfig inputItemConfig){
		this.inputItemConfig = inputItemConfig;
		tableView.setEditable(true);
        getChildren().addAll(tableView);
	}
	
	public Control createControl(InputItemConfig inputItemConfig){
		return tableView;
	}

	public void setRowHeader(List<String> rowHeaders){
		if(rowHeaders!=null && rowHeaders.size()>0){
			//hasRowHeader = true;
			/*
			TableColumn<Map<Integer,String>, String> col = new TableColumn<Map<Integer,String>, String>("");
			col.setCellValueFactory(new MapValueFactory(100));
			col.setCellFactory(new MyCallback());
			col.setEditable(false);
			tableView.getColumns().add(0,col);
			*/
			int count = 3;
			ObservableList<Map<Integer,String>> list = tableView.getItems();
			if(list!=null && list.size()==rowHeaders.size()){
				for(int i=0;i<rowHeaders.size();i++){
					Map<Integer,String> row = list.get(i);
					row.put(100, rowHeaders.get(i));
					if(rowHeaders.get(i).length()>count){
						count = rowHeaders.get(i).length();
					}
				}
			}else if(list!=null && list.size()==0){
				for(int i=0;i<rowHeaders.size();i++){
					Map<Integer,String> row = new HashMap<Integer,String>();
					row.put(100, rowHeaders.get(i));
					list.add(row);
					if(rowHeaders.get(i).length()>count){
						count = rowHeaders.get(i).length();
					}
				}
				
			}
			tableView.getColumns().get(0).setPrefWidth(count*10);
			tableView.setPrefHeight((rowHeaders.size()+1)*25);
		}

	}
	
	public void setColumns(String[] columns, int[] widths) {
		TableColumn<Map<Integer,String>, String> rowNumCol = new TableColumn<Map<Integer,String>, String>("");
		rowNumCol.setCellValueFactory(new MapValueFactory(100));
		rowNumCol.setCellFactory(new MyCallback());
		rowNumCol.setEditable(false);
		rowNumCol.setPrefWidth(30);
		tableView.getColumns().add(rowNumCol);
		
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
					this.dataChanged();
				});
				
				tableView.getColumns().add(col);
			}
		}
		tableView.setPrefHeight(defaultTableViewHeight);
	}
	
	/*
	public void setColumns(String[] columns, int[] widths) {
		if (columns != null && widths != null && columns.length > 0) {
			for (int i = 0; i < columns.length; i++) {
				TableColumn<Map, String> col = new TableColumn<Map, String>(columns[i]);
				col.setPrefWidth(widths[i]);
				col.setCellValueFactory(
						new GridCallback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(i) {
							@Override
							public ObservableValue<String> call(CellDataFeatures<List<String>, String> param) {
								return new SimpleStringProperty(param.getValue().get(index));
							}
						});

				col.setCellFactory(TextFieldTableCell.forTableColumn());

				col.setOnEditCommit(new EventHandler<CellEditEvent<List<String>, String>>() {
					@Override
					public void handle(CellEditEvent<List<String>, String> t) {
						List<String> row = t.getTableView().getItems().get(t.getTablePosition().getRow());
						int colnum = t.getTablePosition().getColumn();
						row.add(colnum,t.getNewValue());
						row.remove(colnum+1);
						
					}
				});
				
				tableView.getColumns().add(col);
			}
		}
		tableView.setPrefHeight(defaultTableViewHeight);
	}
	*/
	public void setColumns(String[] columns,int width){
		if(columns!=null && columns.length>0){
			int[] widths = new int[columns.length];
			for(int i=0;i<widths.length;i++){
				widths[i] = width;
			}
			setColumns(columns,widths);
		}
	}
	
	public void setColumns(String[] columns){
		if(columns!=null && columns.length>0){
			int[] widths = new int[columns.length];
			for(int i=0;i<widths.length;i++){
				widths[i] = defaultColumnWidth;
			}
			setColumns(columns,widths);
		}
	}
	
	public void setColumns(List<String> list){
		if(list!=null && list.size()>0){
			int[] widths = new int[list.size()];
			String[] columns = new String[list.size()];
			for(int i=0;i<widths.length;i++){
				widths[i] = defaultColumnWidth;
				columns[i] = list.get(i);
			}
			setColumns(columns,widths);
		}
	}
	
	public void setTableHeight(int height){
		tableView.setPrefHeight(height);
	}
	
	/*
	public void setValue(Object value){
		ObservableList<List<String>> list = FXCollections.observableArrayList();

		for(List<String> row:(List<List<String>>)value){
			list.add(row);
		}
		tableView.setItems(list);
	}
	
	public Object getValue(){
		ObservableList<List<String>> list = tableView.getItems();
		data.clear();
		for(List<String> row:list){
			data.add(row);
		}
		return data;
	}
	*/
	
	public void setValue(Object value){
		ObservableList<Map<Integer,String>> list = tableView.getItems();
		
		ObservableList<Map<Integer,String>> otherList = FXCollections.observableArrayList();
		
		int count = 0;
		for(List<String> row:(List<List<String>>)value){
			Map<Integer, String> dataRow = null;
			if(count<list.size()){
				dataRow = list.get(count);
				for(int i=0;i<row.size();i++){
					dataRow.put(i, row.get(i));
				}
				otherList.add(dataRow);
			}else{
				dataRow = new HashMap<Integer, String>();
				dataRow.put(100, String.valueOf(count+1));
				for(int i=0;i<row.size();i++){
					dataRow.put(i, row.get(i));
				}
				otherList.add(dataRow);
			}
			
			count++;
		}
		list.removeAll(list);
		
		tableView.setItems(otherList);
		double height = tableView.getPrefHeight();
		if(height<(count+1)*25+15){
			height = (count+1)*25+15;
		}
		tableView.setPrefHeight(height);
	}
	
	public Object getValue(){
		ObservableList<Map<Integer,String>> list = tableView.getItems();
		data = new ArrayList<List<String>>(); 
		for(Map<Integer,String> row:list){
			List<String> rowList = new ArrayList<String>();
			for(int i=0;i<row.size()-1;i++){
				rowList.add(row.get(i));
			}
			data.add(rowList);
		}
		return data;
	}
	
	public String getInputPanelId(){
		return inputItemConfig.getId();
	}

	public TableView<Map<Integer, String>> getTableView() {
		return tableView;
	}

	public void setTableView(TableView<Map<Integer, String>> tableView) {
		this.tableView = tableView;
	}
	
	public void print(){
		for(Map<Integer,String> map:tableView.getItems()){
			logger.info(map);
		}
	}

	@Override
	public void setReadonly(boolean flag) {
		tableView.setDisable(flag);
	}

	@Override
	public void setGridRowHeader(List<String> rowNames) {
		setRowHeader(rowNames);
	}
}

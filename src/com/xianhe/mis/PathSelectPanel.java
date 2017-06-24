package com.xianhe.mis;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.ini4j.Ini;
import org.ini4j.Profile.Section;

import com.xianhe.core.common.EnvReadWriteUtil;
import com.xianhe.core.common.WorkPath;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class PathSelectPanel extends BorderPane{
	public static Logger logger = Logger.getLogger(PathSelectPanel.class);
	private TableView<WorkPath> tableView = new TableView<WorkPath>();
	private Stage stage = null;
	
	public PathSelectPanel(Stage stage) {
		this.stage = stage;
		tableView.setEditable(true);
		this.setCenter(tableView);
		String[] columns = new String[]{"序号","目录名称","目录路径"};
		String[] propertys = new String[]{"id","name","path"};
		int[] widths = new int[]{50,120,300};
		setColumns(columns,widths);
		setDatas();
		
		HBox buttonPanel = new HBox();
		buttonPanel.setPadding(new Insets(5,5,5,5));
		buttonPanel.setSpacing(20);
		buttonPanel.setAlignment(Pos.CENTER);
		this.setBottom(buttonPanel);
		Button button1 = new Button("添加");
		Button button2 = new Button("删除");
		Button button3 = new Button("确定");
		Button button4 = new Button("取消");
		buttonPanel.getChildren().addAll(button1,button2,button3,button4);
		
		button1.setOnAction((ActionEvent e) -> {
			final DirectoryChooser directoryChooser =new DirectoryChooser();
	        final File selectedDirectory = directoryChooser.showDialog(MainFrame.primaryStage);
	        
	        if(selectedDirectory!=null){
	        	String id = String.valueOf(tableView.getItems().size()+1);
	        	String name = selectedDirectory.getName();
	        	String path = selectedDirectory.getAbsolutePath();
	        	WorkPath workPath = new WorkPath(id,name,path,false);
	        	tableView.getItems().add(workPath);
	        }
		});
		
		button2.setOnAction((ActionEvent e) -> {
			int index = tableView.getSelectionModel().getSelectedIndex();
			tableView.getItems().remove(index);
		});
		
		button3.setOnAction((ActionEvent e) -> {
			Ini ini = EnvReadWriteUtil.getEvnIni();
			File file = EnvReadWriteUtil.getEnvFile();
			
			int id = 1;
			for(WorkPath workPath:tableView.getItems()){
				if(workPath.isDefaultPath()){
					Section session = ini.get("ENVNUM");
					session.put("DEFAULT", String.valueOf(id));
					break;
				}
				id++;
			}
			
			List<Section> sections = ini.getAll("ITEM");
			int count = sections.size();
			for(int i=count-1;i>=0;i--){
				sections.remove(i);
			}
			
			id = 1;
			for(WorkPath workPath:tableView.getItems()){
				Section session = ini.add("ITEM");
				session.add("ID", String.valueOf(id));
				session.add("NAME", workPath.getName());
				session.add("PATH", workPath.getPath());
				id++;
			}
			
			try {
				ini.store(file);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			
			stage.close();
		});
		
		button4.setOnAction((ActionEvent e) -> {
			stage.close();
		});
		
		this.setPrefHeight(200);
		this.setPrefWidth(500);
	}
	
	public void setColumns(String[] columns, int[] widths) {
		if (columns != null && widths != null && columns.length > 0) {
			TableColumn<WorkPath, Boolean> col1 = new TableColumn<WorkPath, Boolean>("选择");
			col1.setCellValueFactory(new PropertyValueFactory<WorkPath,Boolean>("defaultPath"));
			col1.setCellFactory(CheckBoxTableCell.forTableColumn(col1));
			col1.setEditable(true);
			/*
			col1.setOnEditCommit((CellEditEvent<WorkPath, Boolean> event)->{
				logger.info(event.getNewValue()+":"+event.getOldValue());
				ObservableList<WorkPath> list = tableView.getItems();
				if(event.getNewValue()){
					for(WorkPath workPath:list){
						workPath.setDefaultPath(false);
						logger.info(workPath);
					}
				}
				WorkPath row = event.getTableView().getItems().get(event.getTablePosition().getRow());
				row.setDefaultPath(event.getNewValue());
				logger.info(row);
			});
			*/
			tableView.getColumns().add(col1);

			TableColumn<WorkPath, String> col = new TableColumn<WorkPath, String>(columns[0]);
			col.setPrefWidth(widths[0]);
			col.setCellValueFactory(new PropertyValueFactory<WorkPath,String>("id"));
			col.setCellFactory(TextFieldTableCell.forTableColumn());
			col.setOnEditCommit((CellEditEvent<WorkPath, String> event)->{
				WorkPath row = event.getTableView().getItems().get(event.getTablePosition().getRow());
				row.setId(event.getNewValue());
				logger.info(row);
			});
			col.setEditable(true);
			tableView.getColumns().add(col);
			
			col = new TableColumn<WorkPath, String>(columns[1]);
			col.setPrefWidth(widths[1]);
			col.setCellValueFactory(new PropertyValueFactory<WorkPath,String>("name"));
			col.setCellFactory(TextFieldTableCell.forTableColumn());
			col.setOnEditCommit((CellEditEvent<WorkPath, String> event)->{
				WorkPath row = event.getTableView().getItems().get(event.getTablePosition().getRow());
				row.setName(event.getNewValue());
				logger.info(row);
			});
			col.setEditable(true);
			tableView.getColumns().add(col);
			
			col = new TableColumn<WorkPath, String>(columns[2]);
			col.setPrefWidth(widths[2]);
			col.setCellValueFactory(new PropertyValueFactory<WorkPath,String>("path"));
			col.setCellFactory(TextFieldTableCell.forTableColumn());
			col.setOnEditCommit((CellEditEvent<WorkPath, String> event)->{
				WorkPath row = event.getTableView().getItems().get(event.getTablePosition().getRow());
				row.setPath(event.getNewValue());
				logger.info(row);
				
			});
			//col.setEditable(true);
			tableView.getColumns().add(col);
		}
	}
	
	public void setDatas(){
		Ini ini = EnvReadWriteUtil.getEvnIni();
		Section session = ini.get("ENVNUM");
		String defaultId = session.get("DEFAULT");
		ObservableList<WorkPath> list = tableView.getItems();
		for (Section aSession : ini.getAll("ITEM")) {
			boolean defaultPath = false;
			if(aSession.get("ID").equals(defaultId)){
				defaultPath = true;
			}
			WorkPath dataRow = new WorkPath(aSession.get("ID"),aSession.get("NAME"),aSession.get("PATH"),defaultPath);
			list.add(dataRow);
		}
	}
}

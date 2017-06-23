package com.xianhe.mis.input;

import java.util.Map;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class MyCallback implements Callback<TableColumn<Map<Integer, String>, String>, TableCell<Map<Integer, String>, String>>{

	@Override
	public TableCell<Map<Integer, String>, String> call(TableColumn<Map<Integer, String>, String> param) {
		return new TableCell<Map<Integer, String>, String>(){

			@Override
			protected void updateItem(String item, boolean empty) {
	            setText(item);
				setStyle("-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color");
			}
		};
	}

}

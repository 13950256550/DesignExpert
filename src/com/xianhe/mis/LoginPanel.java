package com.xianhe.mis;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginPanel extends GridPane{
	private Stage stage = null;
	private MainFrame frame = null;
	private Stage stage1 = null;
	private boolean show = false;
	public LoginPanel(Stage stage,MainFrame frame){
		this.stage = stage;
		this.frame = frame;
		this.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
		this.getStyleClass().add("root");
		this.setVgap(10);
		this.setHgap(10);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10,25,10,25));
		
		Text text = new Text("欢迎");
		text.setId("welcome-text");
		this.add(text, 0, 0, 2, 1);
		
		Label label = new Label("用户:");
		this.add(label, 0, 1);
		
		TextField textField = new TextField();
		this.add(textField, 1, 1);
		
		label = new Label("密码:");
		this.add(label, 0, 2);
		
		PasswordField passwordField = new PasswordField();
		this.add(passwordField, 1, 2);
		
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.BASELINE_RIGHT);
		this.add(hBox, 1, 4);
		
		Button button = new Button("登陆");
		hBox.getChildren().add(button);
		button.setOnAction(e ->{
				//System.out.println("HelloWorld JavaFX");
				stage1.close();
				frame.showMainFrame(stage);
		});

		this.stage1 = new Stage();
		stage1.setTitle("设计专家");
		stage1.setScene(new Scene(this,300,200));
		stage1.initStyle(StageStyle.UNDECORATED);
		
		stage1.show();
	}

	
	
	
}

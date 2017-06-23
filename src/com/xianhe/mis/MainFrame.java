package com.xianhe.mis;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.xianhe.core.common.Item;
import com.xianhe.core.common.MenuItem;
import com.xianhe.core.common.Module;
import com.xianhe.mis.controller.Module1DController;
import com.xianhe.mis.module.module1D.readwritefile.PathUtil;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class MainFrame extends Application implements ChangeListener<TreeItem <String>>,EventHandler<MouseEvent>{
	private static Document document = null;
	private TabPane tabPane = new TabPane();
	private  ContextMenu cm = null; 
	private TreeView<Module> menuTree = null;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		//LoginPanel loginPanel = new LoginPanel(primaryStage,this);
		
		cm = new ContextMenu();
		javafx.scene.control.MenuItem cmItem1 = new javafx.scene.control.MenuItem("设置工作目录");
		cm.getItems().add(cmItem1);
		cmItem1.setOnAction((ActionEvent e) -> {
			//System.out.println(primaryStage);
			final DirectoryChooser directoryChooser =new DirectoryChooser();
	        final File selectedDirectory = directoryChooser.showDialog(primaryStage);
	        
	        PathUtil.setWorkPath(selectedDirectory.getAbsolutePath());
	        System.out.println(PathUtil.getWorkPath());
		});
		
		showMainFrame(primaryStage);
	}

	public static void main(String[] args) {
		Application.launch(MainFrame.class, args);
	}
	
	public void showMainFrame(Stage primaryStage){
		SplitPane splitPane = new SplitPane();
		final StackPane menuPanel = new StackPane();
		final BorderPane borderPane = new BorderPane();
		borderPane.setCenter(tabPane);
		
		splitPane.getItems().addAll(menuPanel, borderPane);

		menuTree = Module.getMenus();
		menuTree.setOnMouseClicked(this);
		menuPanel.getChildren().add(menuTree);
		 
		primaryStage.setTitle("DesignExpert");
		primaryStage.setScene(new Scene(splitPane,1200,700));
		primaryStage.setMaximized(true);  
		splitPane.setDividerPositions(0.1f);
		primaryStage.show();
	}
	
	public TreeView<MenuItem> getTree(){
		TreeItem<MenuItem> rootItem = new TreeItem<MenuItem> (new MenuItem("工作目录"));
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<MenuItem> item = new TreeItem<MenuItem> (new MenuItem("Message"+i,"command"+i,"","")); 
            rootItem.getChildren().add(item);
        }        
        TreeView<MenuItem> tree = new TreeView<MenuItem> (rootItem);
        tree.setOnMouseClicked(this);
        
        return tree;
	}

	@Override
	public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue,TreeItem<String> newValue) {
		if(newValue.isLeaf()){
			System.out.println(newValue);
		}
	}

	@Override
	public void handle(MouseEvent event) {
		
		if(event.getClickCount()==2){
			TreeView<Module> tree = (TreeView<Module>)event.getSource();
			if(tree.getSelectionModel().getSelectedItem().isLeaf()){
				Item item = (Item)tree.getSelectionModel().getSelectedItem().getValue();

				if(item.getType().equals("IN")){
					handleShowView(item.getCaption(),Module.map.get(item.getCode()));
				}else if(item.getType().equals("EXE")){
					handleCommand(item.getCode());
				}
			}
		}else if(event.getButton()==MouseButton.SECONDARY){
			cm.show(menuTree, event.getScreenX(), event.getScreenY());
		}
	}
	
	public static Document getMenuDocument(){
		if(document==null){
			try {
				SAXReader reader = new SAXReader();
				String path = MainFrame.class.getResource("/").getFile();
				File file = new File(path+"/menu.xml");
				document = reader.read(file);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		
		return document;
	}
	
	public static TreeView<MenuItem> getMenus(){
		Document document = getMenuDocument();
		TreeItem<MenuItem> rootItem = new TreeItem<MenuItem> (new MenuItem("工作目录"));
		rootItem.setExpanded(true);
		List<Element> menus = document.selectNodes("/menus/menu");
		for(Element element:menus){
			addMenu(rootItem,element);
		}
		
		TreeView<MenuItem> menuTree = new TreeView<MenuItem> (rootItem);
		return menuTree;
		/*
		Document document = Module.getMenuDocument();
		String[] array = null;
		if(PathUtil.getWorkPath().contains("/")){
			array = PathUtil.getWorkPath().split("/");
		}
		Module root = new Module("root",array[array.length-1],"","1","");
		
		TreeItem<Module> rootItem = new TreeItem<Module> (root);
		rootItem.setExpanded(true);
		List<Element> menus = document.selectNodes("/FileMapping/module");
		for(Element element:menus){
			Module.addMenu(rootItem,element);
		}
		
		TreeView<Module> menuTree = new TreeView<Module> (rootItem);
		return menuTree;
		*/
	}
	
	public static void addMenu(TreeItem<MenuItem> subMenu,Element element){
		if(element.getName().equals("menu")){
			String title = element.attributeValue("title");
			TreeItem<MenuItem> item = new TreeItem<MenuItem> (new MenuItem(title));
			subMenu.getChildren().add(item);
			List<Element> children = element.elements();
			for(Element child:children){
				addMenu(item,child);
			}
		}else if(element.getName().equals("menuitem")){
			String title = element.attributeValue("title");
			String command = element.attributeValue("command");
			String classname = element.attributeValue("classname");
			String type = element.attributeValue("type");
			TreeItem<MenuItem> item = new TreeItem<MenuItem> (new MenuItem(title,command,classname,type));
			subMenu.getChildren().add(item);
		}
	}
	
	public void handleShowView(String title,String classname){
		Tab tab = null;
		for(Tab aTab :tabPane.getTabs()){
			if(title!=null && title.equals(aTab.getText())){
				tab = aTab;
				break;
			}
		}
		if(tab==null){
			tab = new Tab();
			tab.setText(title);
			tabPane.getTabs().add(tab);
		}
		tabPane.getSelectionModel().select(tab);
		BorderPane panel = null;
		
		try {
			panel = (BorderPane)Class.forName(classname).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		tab.setContent(panel);
	}
	
	public void handleCommand(String code){
		new Module1DController().calculate();
	}
	/*
	public void handleCommand(String title,String classname,String command){
		try {
			Object controller = Class.forName(classname).newInstance();
			Method method = ReflectUtil.getDeclaredMethod(controller, command, null);
			method.invoke(controller, null);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}

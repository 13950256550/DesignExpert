package com.xianhe.core.common;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.xianhe.mis.MainFrame;

import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Module {
	public static Logger logger = Logger.getLogger(Module.class);
	private static Document document = null;
	public static Map<String,String> map= new HashMap<String,String>();
	static{
		map.put("81", "com.xianhe.mis.module.module1D.view.input1.Module1DInput1View");
		map.put("82", "com.xianhe.mis.module.module1D.view.input1.Module1DInput2View");
		map.put("83", "com.xianhe.mis.controller.Module1DController");
		map.put("84", "com.xianhe.mis.module.module1D.view.output.Module1DOutputView");
	}
	
	private String key;
	private String caption;
	private String path;
	private String show;
	private String note;
	private int level;
	private List<Module> subModules;
	private List<Item> items;
	
	public Module() {
		
	}
	
	public Module(String key, String caption, String path, String show, String note) {
		super();
		this.key = key;
		this.caption = caption;
		this.path = path;
		this.show = show;
		this.note = note;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String isShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Module> getSubModules() {
		if(subModules==null){
			subModules = new ArrayList<Module>();
		}
		return subModules;
	}

	public void setSubModules(List<Module> subModules) {
		this.subModules = subModules;
	}

	public List<Item> getItems() {
		if(items==null){
			items = new ArrayList<Item>();
		}
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public String getString(String pre){
		StringBuilder sb = new StringBuilder();
		sb.append(pre+this.getCaption()).append("\r\n");
		for(Item item:this.getItems()){
			sb.append(pre).append("-").append(item.getCaption()).append("\r\n");
		}
		
		for(Module subModule:this.getSubModules()){
			sb.append(pre+"-"+subModule.getCaption()).append("\r\n");
			sb.append(subModule.getString(pre+"--"));
		}
		
		
		return sb.toString();
	}
	
	public String toString(){
		return caption;
	}
	
	public static Document getMenuDocument(){
		if(document==null){
			try {
				SAXReader reader = new SAXReader();
				String path = MainFrame.class.getResource("/").getFile();
				File file = new File(path+"/FileMapping.xml");
				document = reader.read(file);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		
		return document;
	}
	
	public static Module getModule(Element element){
		Module result = null;
		
		if(element!=null){
			String key = element.attributeValue("key");
			String caption = element.attributeValue("caption");
			String path = element.attributeValue("path");
			String show = element.attributeValue("show");
			String note = element.attributeValue("note");
			result = new Module(key,caption,path,show,note);
		}
		
		return result;
	}
	
	public static Item getItem(Element element){
		Item result = null;
		
		if(element!=null){
			String key = element.attributeValue("key");
			String caption = element.attributeValue("caption");
			String path = element.attributeValue("path");
			String show = element.attributeValue("show");
			String note = element.attributeValue("note");
			
			String type = element.attributeValue("type");
			String code = element.attributeValue("code");
			
			result = new Item(key,caption,path,show,note,type,code);
		}
		
		return result;
	}
	
	public static void addSubMenu(Module module,Element element){
		List<Element> subModules = element.selectNodes("submodule");
		for(Element subModule:subModules){
			Module aModule = getModule(subModule);
			module.getSubModules().add(aModule);
			addSubMenu(aModule,subModule);
		}
		addItem(module,element);
	}
	
	public static void addItem(Module module,Element element){
		List<Element> items = element.selectNodes("item");
		for(Element item:items){
			Item aItem = getItem(item);
			module.getItems().add(aItem);
		}
	}
	
	public static Module getRootModule(){
		Document document = getMenuDocument();
		String[] array = null;
		if(EnvReadWriteUtil.getWorkPath().contains("/")){
			array = EnvReadWriteUtil.getWorkPath().split("/");
		}
		Module root = new Module("root",array[array.length-1],"","1","");
		
		List<Element> modules = document.selectNodes("/FileMapping/module");
		for(Element element:modules){
			Module module = getModule(element);
			root.getSubModules().add(module);
			addSubMenu(module,element);
		}
		
		return root;
	}
	
	public static void addMenu(TreeItem<Module> subMenu,Element element){
		if(element.getName().equals("submodule") || element.getName().equals("module")){
			String key = element.attributeValue("key");
			String caption = element.attributeValue("caption");
			String path = element.attributeValue("path");
			String show = element.attributeValue("show");
			String note = element.attributeValue("note");
			if("1".equals(show)){
				TreeItem<Module> aSubMenu = new TreeItem<Module> (new Module(key,caption,path,show,note),getIcon("f1.png"));
				subMenu.getChildren().add(aSubMenu);
				List<Element> children = element.elements();
				for(Element child:children){
					addMenu(aSubMenu,child);
				}
			}
		}else if(element.getName().equals("item")){
			String key = element.attributeValue("key");
			String caption = element.attributeValue("caption");
			String path = element.attributeValue("path");
			String show = element.attributeValue("show");
			String note = element.attributeValue("note");
			String type = element.attributeValue("type");
			String code = element.attributeValue("code");
			if("1".equals(show)){
				TreeItem<Module> item = null;
				if(type.equals("EXE")){
					item = new TreeItem<Module> (new Item(key,caption,path,show,note,type,code),getIcon("doc_app.png"));
				}else{
					item = new TreeItem<Module> (new Item(key,caption,path,show,note,type,code),getIcon("doc_edit.png"));
				}
				subMenu.getChildren().add(item);
			}
		}
	}
	
	public static TreeView<Module> getMenus(){
		Document document = getMenuDocument();
		String[] array = null;
		if(EnvReadWriteUtil.getWorkPath().contains("/")){
			array = EnvReadWriteUtil.getWorkPath().split("/");
		}
		Module root = new Module("root",array[array.length-1],"","1","");
		
		TreeItem<Module> rootItem = new TreeItem<Module> (root,getIcon("f1.png"));
		rootItem.setExpanded(true);
		List<Element> menus = document.selectNodes("/FileMapping/module");
		for(Element element:menus){
			Module.addMenu(rootItem,element);
		}
		
		TreeView<Module> menuTree = new TreeView<Module> (rootItem);
		return menuTree;
	}
	
	public static Node getIcon(String iconFile){
		Image image = new Image(Module.class.getResourceAsStream("/assets/"+iconFile));
		return new ImageView(image);  
	}
	
	public static void main(String[] args) {
		Module root = getRootModule();
		logger.info("\r\n"+root);
	}
}

package com.xianhe.core.common;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class WorkPath {
	private SimpleStringProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty path;
	private SimpleBooleanProperty defaultPath;
	
	public WorkPath(String id, String name, String path,Boolean defaultPath) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.path = new SimpleStringProperty(path);
		this.defaultPath = new SimpleBooleanProperty(defaultPath);
	}
	
	@Override
	public String toString() {
		return "WorkPath [id=" + id + ", name=" + name + ", path=" + path + ", defaultPath=" + defaultPath + "]";
	}

	public SimpleStringProperty nameProperty() {  
	    return name;  
	} 
	
	public SimpleStringProperty pathProperty() {  
	    return path;  
	} 
	
	public SimpleBooleanProperty defaultPathProperty() {  
	    return defaultPath;  
	}
	
	public SimpleStringProperty idProperty() {  
	    return id;  
	}
	
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id);
	}
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public String getPath() {
		return path.get();
	}
	public void setPath(String path) {
		this.path.set(path);
	}
	public boolean isDefaultPath() {
		return defaultPath.get();
	}
	public void setDefaultPath(Boolean defaultPath) {
		this.defaultPath.set(defaultPath);
	}
	
	
}

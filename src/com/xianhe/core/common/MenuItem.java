package com.xianhe.core.common;

public class MenuItem {
	private String title = null;
	private String command = null;
	private String classname = null;
	private String type = null;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MenuItem(String title, String command,String classname,String type ) {
		this.title = title;
		this.command = command;
		this.classname = classname;
		this.type = type;
	}
	
	public MenuItem(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return getTitle();
	}
}

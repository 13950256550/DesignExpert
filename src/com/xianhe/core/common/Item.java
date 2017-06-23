package com.xianhe.core.common;

public class Item extends Module {
	private String type;
	private String code;
	
	public Item(String key, String caption, String path, String show, String note, String type, String code) {
		super(key, caption, path, show, note);
		this.type = type;
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}

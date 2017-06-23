package com.xianhe.core.common;

import java.util.List;

import org.jfree.data.xy.XYDataItem;

public class ChartDataset {
	private String key;
	private String title;
	private List<XYDataItem> data;
	
	public ChartDataset(String key, String title, List<XYDataItem> data) {
		this.key = key;
		this.title = title;
		this.data = data;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<XYDataItem> getData() {
		return data;
	}

	public void setData(List<XYDataItem> data) {
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}

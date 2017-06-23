package com.xianhe.core.common;

import java.util.List;

public class InputItemConfig {
	public final static int panelHeight = 25;
	public final static int fakeLabelLength = 200;
	private String id;
	private String label;
	private int[] width = new int[]{100,140,250};
	private int[] height = new int[]{23,23};
	private boolean wrapText = false;
	private boolean readonly = false;
	private InputItemType type = InputItemType.common;
	private List<String> columnNames = null;
	private List<String> rowNames = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int[] getWidth() {
		return width;
	}
	public void setWidth(int[] width) {
		if(type==InputItemType.fake){
			this.width[0] = fakeLabelLength;
			this.width[1] = 0;
			this.width[2] = width[0]+10;
		}
		if(width!=null && width.length==3){
			this.width[0] = width[0];
			this.width[1] = width[1];
			this.width[2] = width[2];
		}else if (width!=null && width.length==2){
			this.width[0] = width[0];
			this.width[1] = width[1];
			this.width[2] = width[0]+width[1]+10;
		}else if (width!=null && width.length==1){
			this.width[0] = width[0];
			this.width[2] = width[0]+this.width[1]+10;
		}
	}
	public InputItemConfig(String id, String label) {
		this.id = id;
		this.label = label;
	}
	public int[] getHeight() {
		return height;
	}
	public int getPanelHeight() {
		int result = panelHeight;
		if(height!=null && height.length==2){
			result = height[0]>height[1]?height[0]:height[1];
			result += 2;
		}
		return result;
	}
	public void setHeight(int[] height) {
		this.height = height;
	}
	public boolean isWrapText() {
		return wrapText;
	}
	public void setWrapText(boolean wrapText) {
		this.wrapText = wrapText;
		if(wrapText){
			height[0] = 36;
		}
	}
	public InputItemType getType() {
		return type;
	}
	public void setType(InputItemType type) {
		this.type = type;
	}
	
	public boolean isReadonly() {
		return readonly;
	}
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}
	
	public List<String> getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}
	public List<String> getRowNames() {
		return rowNames;
	}
	public void setRowNames(List<String> rowNames) {
		this.rowNames = rowNames;
	}
	public InputItemConfig(String id) {
		this.id = id;
		this.label = id;
	}
	
	public InputItemConfig(String id,int[] width) {
		this.id = id;
		this.label = id;
		this.setWidth(width);
	}
	
	public InputItemConfig(String id,InputItemType type) {
		this.id = id;
		this.label = id;
		this.type = type;
		this.setWidth(this.width);
	}
	
	public InputItemConfig(String id,InputItemType type,int[] width) {
		this.id = id;
		this.label = id;
		this.type = type;
		this.setWidth(width);
	}
	
	public InputItemConfig(String id,InputItemType type,int width) {
		this.id = id;
		this.label = id;
		this.type = type;
		int[] widths= new int[3];
		if(type==InputItemType.fake){
			this.width[0] = width;
			this.width[1] = 0;
			this.width[2] = this.width[0]+10;
		}
	}
	
	public InputItemConfig(String id,boolean wrapText) {
		this.id = id;
		this.label = id;
		this.setWrapText(wrapText);
	}
	
	public InputItemConfig(String id, String label,int[] width,int[] height,boolean wrapText,InputItemType type) {
		this.id = id;
		this.label = label;
		this.setWidth(width);
		this.height = height;
		this.wrapText = wrapText;
		this.setType(type);
	}
}

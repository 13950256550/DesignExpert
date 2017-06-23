package com.xianhe.mis.module.module1D.readwritefile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jfree.data.xy.XYDataItem;

import javafx.scene.chart.XYChart.Data;

public class ReadOutputFileData {
	public static String path = PathUtil.getWorkPath();
	
	public static void main(String[] args) {
		/*
		List<List<String>> gridData = readAeroData();
		GridDataUtil.printList(gridData);
		gridData = GridDataUtil.trim(gridData,0,6);
		gridData = GridDataUtil.transform(gridData);
		gridData = GridDataUtil.trim(gridData,1,16);
		GridDataUtil.printList(gridData);
		*/
		List<List<Data>> gridData = readFlowPathData();
		GridDataUtil.printPointList2(gridData);
	}
	
	
	
	public static List<List<String>> readAeroData(){
		List<List<String>> result = new ArrayList<List<String>>();
		
		String fileName = path+"/1D/aero.dat";
		String path = ReadInputFileData.class.getResource("/").getPath();
		File file = new File(fileName);
		
		List<String> rows = ReadInputFileData.readFile(file);
		for(String row:rows){
			String[] arrayString = row.split(" ");
			List<String> rowList = new ArrayList<String>();
			for(String col:arrayString){
				if(col!=null && !"".equals(col)){
					rowList.add(col);
				}
			}
			result.add(rowList);
		}
		
		return result;
	}
	
	public static List<List<String>> readFoilData(){
		List<List<String>> result = new ArrayList<List<String>>();
		
		String fileName = path+"/1D/foil.dat";
		String path = ReadInputFileData.class.getResource("/").getPath();
		File file = new File(fileName);
		
		List<String> rows = ReadInputFileData.readFile(file);
		for(String row:rows){
			String[] arrayString = row.split(" ");
			List<String> rowList = new ArrayList<String>();
			for(String col:arrayString){
				if(col!=null && !"".equals(col)){
					rowList.add(col);
				}
			}
			result.add(rowList);
		}
		
		return result;
	}
	
	public static List<List<String>> readGrfData(){
		List<List<String>> result = new ArrayList<List<String>>();
		
		String fileName = path+"/1D/grf.dat";
		String path = ReadInputFileData.class.getResource("/").getPath();
		File file = new File(fileName);
		
		List<String> rows = ReadInputFileData.readFile(file);
		for(String row:rows){
			List<String> rowList = new ArrayList<String>();
			String[] arrayString = row.split(" ");
			for(String col:arrayString){
				if(col!=null && !"".equals(col)){
					rowList.add(col);
				}
			}
			result.add(rowList);
		}
		
		return result;
	}
	
	public static List<List<String>> readOperData(){
		List<List<String>> result = new ArrayList<List<String>>();
		
		String fileName = path+"/1D/oper.dat";
		String path = ReadInputFileData.class.getResource("/").getPath();
		File file = new File(fileName);
		
		List<String> rows = ReadInputFileData.readFile(file);
		for(String row:rows){
			List<String> rowList = new ArrayList<String>();
			String[] arrayString = row.split(" ");
			for(String col:arrayString){
				if(col!=null && !"".equals(col)){
					rowList.add(col);
				}
			}
			result.add(rowList);
		}
		
		return result;
	}
	
	public static List<List<String>> readPerf2Data(){
		List<List<String>> result = new ArrayList<List<String>>();
		
		String fileName = path+"/1D/perf2.dat";
		String path = ReadInputFileData.class.getResource("/").getPath();
		File file = new File(fileName);
		
		List<String> rows = ReadInputFileData.readFile(file);
		for(String row:rows){
			List<String> rowList = new ArrayList<String>();
			String[] arrayString = row.split(" ");
			for(String col:arrayString){
				if(col!=null && !"".equals(col)){
					rowList.add(col);
				}
			}
			result.add(rowList);
		}
		
		return result;
	}
	
	public static List<List<String>> readSurgData(){
		List<List<String>> result = new ArrayList<List<String>>();
		
		String fileName = path+"/1D/surg.dat";
		String path = ReadInputFileData.class.getResource("/").getPath();
		File file = new File(fileName);
		
		List<String> rows = ReadInputFileData.readFile(file);
		for(String row:rows){
			List<String> rowList = new ArrayList<String>();
			String[] arrayString = row.split(" ");
			for(String col:arrayString){
				if(col!=null && !"".equals(col)){
					rowList.add(col);
				}
			}
			result.add(rowList);
		}
		
		return result;
	}
	
	public static List<List<XYDataItem>> readPathData(){
		List<List<XYDataItem>> result = new ArrayList<List<XYDataItem>>();
		
		String fileName = path+"/1D/path";
		String path = ReadInputFileData.class.getResource("/").getPath();
		File file = new File(fileName);
		
		List<String> rows = ReadInputFileData.readFile(file);
		
		/*
		for(int i=1;i<rows.size();i++){
			List<String> rowList = new ArrayList<String>();
			String[] arrayString = rows.get(i).split(" ");
			for(String col:arrayString){
				if(col!=null && !"".equals(col)){
					rowList.add(col);
				}
			}
			result.add(rowList);
		}
		*/

		int lineLength = Integer.parseInt(rows.get(0).trim());
		List<String> row = null;
		int rowCount = 0;
		int pos = 0;
		
		List<List<String>> lists = new ArrayList<List<String>>();
		for(int line=0;line<3;line++){
			List<String> list = new ArrayList<String>();
			for(int i=0;i<lineLength;i++){
				if(row==null || pos==row.size()){
					rowCount++;
					row = GridDataUtil.splitByBlank(rows.get(rowCount));
					pos=0;
				}
				list.add(row.get(pos));
				pos++;
			}
			lists.add(list);
		}
		
		List<XYDataItem> line1 = new ArrayList<XYDataItem>();
		List<XYDataItem> line2 = new ArrayList<XYDataItem>();
		for(int i=0;i<lineLength;i++){
			XYDataItem item = null;
			double x = 0d;
			try {
				x = Double.parseDouble(lists.get(0).get(i));
			} catch (NumberFormatException e) {
			}
			double y = 0d;
			try {
				y = Double.parseDouble(lists.get(1).get(i));
			} catch (NumberFormatException e) {
			}
			item = new XYDataItem(x,y);
			line1.add(item);
			
			y = 0d;
			try {
				y = Double.parseDouble(lists.get(2).get(i));
			} catch (NumberFormatException e) {
			}
			
			item = new XYDataItem(x,y);
			line2.add(item);
		}
		result.add(line1);
		result.add(line2);
		
		for(int i=0;i<line1.size();i++){
			XYDataItem item1 = line1.get(i);
			XYDataItem item2 = line2.get(i);
			if(item1!=null && item2!=null){
				List<XYDataItem> line = new ArrayList<XYDataItem>();
				line.add(item1);
				line.add(item2);
				result.add(line);
			}
		}
		
		return result;
	}
	
	public static List<List<Data>> readFlowPathData(){
		List<List<Data>> result = new ArrayList<List<Data>>();
		
		String fileName = path+"/1D/path";
		File file = new File(fileName);
		
		List<String> rows = ReadInputFileData.readFile(file);

		int lineLength = Integer.parseInt(rows.get(0).trim());
		List<String> row = null;
		int rowCount = 0;
		int pos = 0;
		
		List<List<String>> lists = new ArrayList<List<String>>();
		for(int line=0;line<3;line++){
			List<String> list = new ArrayList<String>();
			for(int i=0;i<lineLength;i++){
				if(row==null || pos==row.size()){
					rowCount++;
					row = GridDataUtil.splitByBlank(rows.get(rowCount));
					pos=0;
				}
				list.add(row.get(pos));
				pos++;
			}
			lists.add(list);
		}
		
		List<Data> line1 = new ArrayList<Data>();
		List<Data> line2 = new ArrayList<Data>();
		for(int i=0;i<lineLength;i++){
			Data item = null;
			double x = 0d;
			try {
				x = Double.parseDouble(lists.get(0).get(i));
			} catch (NumberFormatException e) {
			}
			double y = 0d;
			try {
				y = Double.parseDouble(lists.get(1).get(i));
			} catch (NumberFormatException e) {
			}
			item = new Data(x,y);
			line1.add(item);
			
			y = 0d;
			try {
				y = Double.parseDouble(lists.get(2).get(i));
			} catch (NumberFormatException e) {
			}
			
			item = new Data(x,y);
			line2.add(item);
		}
		result.add(line1);
		result.add(line2);
		
		for(int i=0;i<line1.size();i++){
			Data item1 = line1.get(i);
			Data item2 = line2.get(i);
			if(item1!=null && item2!=null){
				List<Data> line = new ArrayList<Data>();
				line.add(item1);
				line.add(item2);
				result.add(line);
			}
		}
		
		return result;
	}

}

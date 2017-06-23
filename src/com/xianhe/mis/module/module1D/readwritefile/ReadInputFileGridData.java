package com.xianhe.mis.module.module1D.readwritefile;

import java.util.ArrayList;
import java.util.List;

public class ReadInputFileGridData {
	public static void main(String[] args) {
		List<String> datas = ReadInputFileData.readFile();
		
		List<List<String>> gridData = readGrid6(datas);
		printList(gridData);
	}
	
	public static List<List<String>> readGrid(List<String> list,int startRow,int endRow){
		List<List<String>> result = new ArrayList<List<String>>();
		
		for(int i=startRow;i<=endRow;i++){
			String[] arrayString = list.get(i).split(" ");
			
			List<String> row = new ArrayList<String>();
			for(String str:arrayString){
				row.add(str);
			}
			result.add(row);
		}
		return result;
	}
	
	public static List<List<String>> readGrid1(List<String> list){
		return readGrid(list,7,13);
	}
	
	public static List<List<String>> readGrid2(List<String> list){
		return readGrid(list,14,22);
	}
	
	public static List<List<String>> readGrid3(List<String> list){
		return readGrid(list,33,42);
	}
	
	public static List<List<String>> readGrid4(List<String> list){
		return readGrid(list,46,47);
	}
	
	public static List<List<String>> readGrid5(List<String> list){
		return readGrid(list,48,57);
	}
	
	public static List<List<String>> readGrid6(List<String> list){
		return readGrid(list,59,59);
	}
	
	public static void printList(List<List<String>> list){
		StringBuilder sb = new StringBuilder();
		for(List<String> row:list){
			for(String str:row){
				sb.append(str).append("\t");
			}
			sb.append("\r\n");
		}
		
		System.out.println(sb.toString());
	}

}

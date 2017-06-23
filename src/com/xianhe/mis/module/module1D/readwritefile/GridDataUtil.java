package com.xianhe.mis.module.module1D.readwritefile;

import java.util.ArrayList;
import java.util.List;

import org.jfree.data.xy.XYDataItem;

import com.xianhe.core.common.ChartDataset;

import javafx.scene.chart.XYChart.Data;

public class GridDataUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> gridData = ReadOutputFileData.readAeroData();
		GridDataUtil.printPointList(GridDataUtil.getMatrix(gridData));
	}

	public static List<List<String>> transform(List<List<String>> grid){
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		//ReadInputFileGridData.printList(grid);
		if(grid!=null){
			int maxSize = grid.get(0).size();
			for(List<String> row:grid){
				if(row.size()>maxSize){
					maxSize = row.size();
				}
			}
			
			for(int i=0;i<maxSize;i++){
				List<String> row = new ArrayList<String>();
				if(row!=null){
					result.add(row);
				}
			}
			
			int count = grid.size();
			for(int i=0;i<count;i++){
				List<String> row = grid.get(i);
				for(int j=0;j<maxSize;j++){
					String value = j<row.size()?row.get(j):"";
					result.get(j).add(value);
				}
			}
		}
		
		//System.out.println("--------------------------------");
		
		//ReadInputFileGridData.printList(result);
		
		return result;
	}
	
	public static List<List<String>> trim(List<List<String>> grid,int left,int right,int top,int bottom){
		List<List<String>> result = new ArrayList<List<String>>();
		
		for(int i=top;i<=bottom;i++){
			List<String> row = new ArrayList<String>();
			List<String> temp = grid.get(i);
			for(int j=left;j<=right;j++){
				row.add(temp.get(j));
			}
			result.add(row);
		}
		
		return result;
	}
	
	public static List<List<String>> trim(List<List<String>> grid,int startRow,int endRow){
		List<List<String>> result = new ArrayList<List<String>>();
		
		for(int i=startRow;i<=endRow;i++){
			result.add(grid.get(i));
		}
		
		return result;
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
	
	public static List<ChartDataset> getChartDatasetList(List<List<XYDataItem>> list){
		List<ChartDataset> result = new ArrayList<ChartDataset>();
		
		for(int i=0;i<list.size();i++){
			List<XYDataItem> row = list.get(i);
			String title = "Êý¾Ý"+(i+1);
			ChartDataset chartDataset = new ChartDataset(title,title,row);
			result.add(chartDataset);
		}
		
		return result;
	}
	
	public static List<ChartDataset> getChartDatasetList(List<List<XYDataItem>> list,List<String> lineTitle){
		List<ChartDataset> result = new ArrayList<ChartDataset>();
		
		for(int i=0;i<list.size();i++){
			List<XYDataItem> row = list.get(i);
			ChartDataset chartDataset = new ChartDataset(lineTitle.get(i),lineTitle.get(i),row);
			result.add(chartDataset);
		}
		
		return result;
	}
	
	public static List<List<XYDataItem>> getMatrix(List<List<String>> list,List<String> xAxisList){
		List<List<XYDataItem>> result = new ArrayList<List<XYDataItem>>();
		
		for(List<String> row:list){
			List<XYDataItem> rowPoints = new ArrayList<XYDataItem>();
			for(int i=0;i<row.size();i++){
				double x = 0d;
				try {
					x = Double.parseDouble(xAxisList.get(i));
				} catch (NumberFormatException e) {
					//e.printStackTrace();
				}
				
				double y = 0d;
				try {
					y = Double.parseDouble(row.get(i));
				} catch (NumberFormatException e) {
					//e.printStackTrace();
				}
				
				XYDataItem point = new XYDataItem(x,y);
				rowPoints.add(point);
			}
			result.add(rowPoints);
		}
		
		return result;
	}
	
	public static List<List<XYDataItem>> getMatrix(List<List<String>> list){
		List<List<XYDataItem>> result = new ArrayList<List<XYDataItem>>();
		
		for(List<String> row:list){
			List<XYDataItem> rowPoints = new ArrayList<XYDataItem>();
			for(int i=0;i<row.size();i++){
				double x = i+1;
				
				double y = 0d;
				try {
					y= Double.parseDouble(row.get(i));
				} catch (NumberFormatException e) {
					//e.printStackTrace();
				}
				
				XYDataItem item = new XYDataItem(x,y);
				rowPoints.add(item);
			}
			result.add(rowPoints);
		}
		
		return result;
	}
	
	public static void printPointList(List<List<XYDataItem>> list){
		StringBuilder sb = new StringBuilder();
		for(List<XYDataItem> row:list){
			for(XYDataItem point:row){
				sb.append("(").append(point.getX()).append(",").append(point.getY()).append(")\t");
			}
			sb.append("\r\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void printPointList2(List<List<Data>> list){
		StringBuilder sb = new StringBuilder();
		for(List<Data> row:list){
			for(Data point:row){
				sb.append("(").append(point.getXValue()).append(",").append(point.getYValue()).append(")  ");
			}
			sb.append("\r\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static List<String> splitByBlank(String line){
		List<String> result = new ArrayList<String>();
		
		String[] datas = line.split(" ");
		for(int i=0;i<datas.length;i++){
			if(datas[i]!=null && !"".equals(datas[i].trim())){
				result.add(datas[i]);
			}
		}
		return result;
	}

}

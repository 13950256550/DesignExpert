package com.xianhe.mis.module.module1D.view.output;

import java.util.List;

import com.xianhe.mis.module.module1D.readwritefile.GridDataUtil;
import com.xianhe.mis.module.module1D.readwritefile.ReadOutputFileData;
import com.xianhe.mis.output.ChartPanel;

import javafx.scene.chart.Axis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.GridPane;

public class BladeParameterDistributionPanel extends GridPane {
	private List<List<String>> gridData = null;
	
	public BladeParameterDistributionPanel() {
		
		gridData = ReadOutputFileData.readFoilData();
		gridData = GridDataUtil.trim(gridData,0,6);
		gridData = GridDataUtil.transform(gridData);
		
		this.setVgap(10);
		this.setHgap(10);
		
		this.add(getChartPanel1(), 0, 0);
		this.add(getChartPanel2(), 1, 0);
		this.add(getChartPanel3(), 2, 0);
		
		this.add(getChartPanel4(), 0, 1);
		this.add(getChartPanel5(), 1, 1);
		this.add(getChartPanel6(), 2, 1);
		
		this.add(getChartPanel7(), 0, 2);
		this.add(getChartPanel8(), 1, 2);
		this.add(getChartPanel9(), 2, 2);
	}
	
	public ChartPanel getChartPanel1(){
		ChartPanel panel = new ChartPanel();
		
		Series series1 = new Series();
        series1.setName("静子CMXR");
        List<String> list = gridData.get(3);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("转子CMXS");
        list = gridData.get(4);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
		
		return panel;
	}
	
	public ChartPanel getChartPanel2(){
		ChartPanel panel = new ChartPanel();
		
		Series series1 = new Series();
        series1.setName("静子出口ALF3");
        List<String> list = gridData.get(7);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("转子进口BEA1");
        list = gridData.get(5);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
        
        Series series3 = new Series();
        series3.setName("转子出口BEA2");
        list = gridData.get(6);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series3.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series3);
        
        Series series4 = new Series();
        series4.setName("静子进口ALF4");
        list = gridData.get(8);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series4.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series4);
		
		return panel;
	}
	
	public ChartPanel getChartPanel3(){
		ChartPanel panel = new ChartPanel();
		
		Series series1 = new Series();
        series1.setName("静子INR");
        List<String> list = gridData.get(11);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("转子INS");
        list = gridData.get(12);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
		
		return panel;
	}
	
	public ChartPanel getChartPanel4(){
		ChartPanel panel = new ChartPanel();
		
		Series series1 = new Series();
        series1.setName("静子DER");
        List<String> list = gridData.get(13);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("转子DES");
        list = gridData.get(14);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
		
		return panel;
	}
	
	public ChartPanel getChartPanel5(){
		Axis xAxis = new NumberAxis();
		Axis yAxis = new NumberAxis(0.8,2,0.25);
		ChartPanel panel = new ChartPanel(xAxis,yAxis);
		
		Series series1 = new Series();
        series1.setName("转子展弦比ASR");
        List<String> list = gridData.get(17);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("静子展弦比ASS");
        list = gridData.get(18);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
        
        Series series3 = new Series();
        series3.setName("转子稠度SOLR");
        list = gridData.get(19);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series3.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series3);
        
        Series series4 = new Series();
        series4.setName("静子稠度SOLS");
        list = gridData.get(20);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series4.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series4);
		
		return panel;
	}
	
	public ChartPanel getChartPanel6(){
		ChartPanel panel = new ChartPanel();
		
		Series series1 = new Series();
        series1.setName("转子CAMR");
        List<String> list = gridData.get(21);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("静子CAMS");
        list = gridData.get(22);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
		
		return panel;
	}
	
	public ChartPanel getChartPanel7(){
		ChartPanel panel = new ChartPanel();
		
		Series series1 = new Series();
        series1.setName("转子BBR");
        List<String> list = gridData.get(9);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("静子BBS");
        list = gridData.get(10);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
		
		return panel;
	}
	
	public ChartPanel getChartPanel8(){
		Axis xAxis = new NumberAxis();
		Axis yAxis = new NumberAxis(0.95,1.15,0.025);
		
		ChartPanel panel = new ChartPanel(xAxis,yAxis);
		
		Series series1 = new Series();
        series1.setName("转子AAR");
        List<String> list = gridData.get(15);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("静子AAS");
        list = gridData.get(16);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
		
		return panel;
	}
	
	public ChartPanel getChartPanel9(){
		ChartPanel panel = new ChartPanel();
		
		Series series1 = new Series();
        series1.setName("转子IZR");
        List<String> list = gridData.get(1);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("静子IZS");
        list = gridData.get(2);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
		
		return panel;
	}
}

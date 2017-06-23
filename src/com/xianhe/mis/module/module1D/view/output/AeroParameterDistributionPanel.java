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

public class AeroParameterDistributionPanel extends GridPane {
	private List<List<String>> gridData = null;
	
	public AeroParameterDistributionPanel() {
		
		gridData = ReadOutputFileData.readAeroData();
		gridData = GridDataUtil.trim(gridData,0,6);
		gridData = GridDataUtil.transform(gridData);
		gridData = GridDataUtil.trim(gridData,1,16);
		
		this.setVgap(10);
		this.setHgap(10);
		
		this.add(getChartPanel1(), 0, 0);
		this.add(getChartPanel2(), 1, 0);
		this.add(getChartPanel3(), 2, 0);
		
		this.add(getChartPanel4(), 0, 1);
		this.add(getChartPanel5(), 1, 1);
		this.add(getChartPanel6(), 2, 1);
	}
	
	public ChartPanel getChartPanel1(){
		ChartPanel panel = new ChartPanel();
		
		Series series1 = new Series();
        series1.setName("转子进口轴向VA1");
        List<String> list = gridData.get(0);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("转子出口轴向VA2");
        list = gridData.get(1);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
        
        Series series3 = new Series();
        series3.setName("转子进口周向VU1");
        list = gridData.get(2);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series3.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series3);
		
		return panel;
	}
	
	public ChartPanel getChartPanel2(){
		ChartPanel panel = new ChartPanel();
		
		Series series1 = new Series();
        series1.setName("静子出口ALF1");
        List<String> list = gridData.get(3);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("转子进口BET1");
        list = gridData.get(4);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
        
        Series series3 = new Series();
        series3.setName("转子出口BET2");
        list = gridData.get(5);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series3.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series3);
        
        Series series4 = new Series();
        series4.setName("静子进口ALF3");
        list = gridData.get(6);
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
        series1.setName("转子进口速度系数LM1");
        List<String> list = gridData.get(7);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("级加系数HSZ");
        list = gridData.get(8);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
        
        Series series3 = new Series();
        series3.setName("级反力度OMG");
        list = gridData.get(9);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series3.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series3);
		
		return panel;
	}
	
	public ChartPanel getChartPanel4(){
		Axis xAxis = new NumberAxis();
		Axis yAxis = new NumberAxis(1.2,1.6,0.05);
		
		ChartPanel panel = new ChartPanel(xAxis,yAxis);
		
		Series series1 = new Series();
        series1.setName("转子PRR");
        List<String> list = gridData.get(10);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("级PRS");
        list = gridData.get(11);
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
		Axis yAxis = new NumberAxis(0.8,1.0,0.025);
		
		ChartPanel panel = new ChartPanel(xAxis,yAxis);
		
		Series series1 = new Series();
        series1.setName("转子EFFR");
        List<String> list = gridData.get(12);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("级EFFS");
        list = gridData.get(13);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
		
		return panel;
	}
	
	public ChartPanel getChartPanel6(){
		Axis xAxis = new NumberAxis();
		Axis yAxis = new NumberAxis(0.4,0.65,0.05);
		
		ChartPanel panel = new ChartPanel(xAxis,yAxis);
		
		Series series1 = new Series();
        series1.setName("转子DLR");
        List<String> list = gridData.get(14);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series1.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series1);
        
        Series series2 = new Series();
        series2.setName("级DLS");
        list = gridData.get(15);
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	series2.getData().add(new XYChart.Data(i+1, Double.parseDouble(list.get(i))));
	        }
        }
        panel.addSeries(series2);
		
		return panel;
	}
}

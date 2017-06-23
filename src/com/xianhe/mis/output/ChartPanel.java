package com.xianhe.mis.output;

import javafx.geometry.Side;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.BorderPane;

public class ChartPanel extends BorderPane{
	private String title = null;
	private Axis xAxis = new NumberAxis();
	private Axis yAxis = new NumberAxis();
	private String xAxisLabel = null;
	private String yAxisLabel = null;
	
	private LineChart lineChart = null;
	
	public ChartPanel() {
		lineChart = new LineChart(xAxis,yAxis);
		lineChart.setLegendSide(Side.TOP);
		setCenter(lineChart);
	}
	
	public ChartPanel(Axis xAxis, Axis yAxis) {
		this("",xAxis,yAxis,"","");
	}
	
	public ChartPanel(Axis xAxis, Axis yAxis, String xAxisLabel, String yAxisLabel) {
		this("",xAxis,yAxis,xAxisLabel,yAxisLabel);
	}

	public ChartPanel(String title, Axis xAxis, Axis yAxis, String xAxisLabel, String yAxisLabel) {
		this.title = title;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.xAxisLabel = xAxisLabel;
		this.yAxisLabel = yAxisLabel;
		
		lineChart = new LineChart(xAxis,yAxis);
		lineChart.setLegendSide(Side.TOP);
		setCenter(lineChart);
	}



	public void addSeries(Series series){
		if(series!=null){
			for(int i=0;i<lineChart.getData().size();i++){
				Series temp = (Series)lineChart.getData().get(i);
				if(temp!=null && temp.getName().equals(series.getName())){
					lineChart.getData().remove(temp);
				}
			}
			lineChart.getData().add(series);
		}
	}
}

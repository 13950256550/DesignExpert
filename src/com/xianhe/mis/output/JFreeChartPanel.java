package com.xianhe.mis.output;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javafx.embed.swing.SwingNode;
import javafx.scene.layout.BorderPane;

public class JFreeChartPanel extends BorderPane{
	private SwingNode node = null;
	private JFreeChart chart = null;
	private ChartPanel chartPanel = null;
	public JFreeChartPanel() {
		node = new SwingNode();
		setCenter(node);
		node.setContent(createChartPane(""));
	}
	
	public  ChartPanel createChartPane(String title) {
		NumberAxis xAxis = new NumberAxis("X");
		NumberAxis yAxis = new NumberAxis("Y");
		//xAxis.setAutoRangeIncludesZero(false);
		//yAxis.setAutoRangeIncludesZero(false);
		XYLineAndShapeRenderer xyLineAndShapeRenderer = new XYLineAndShapeRenderer();
		XYPlot localXYPlot = new XYPlot(createXYDataset(), xAxis, yAxis, xyLineAndShapeRenderer);
		chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, localXYPlot,true);

		chartPanel = new ChartPanel(chart);
		return chartPanel;
	}
	
	private XYDataset createXYDataset() {
		XYSeriesCollection localXYSeriesCollection = new XYSeriesCollection();
		return localXYSeriesCollection;
	}
	
	public void addSeries(XYSeries series){
		XYSeriesCollection localXYSeriesCollection = (XYSeriesCollection)chart.getXYPlot().getDataset(0);
		localXYSeriesCollection.addSeries(series);
		/*
		XYPlot localXYPlot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer localXYSplineRenderer = (XYLineAndShapeRenderer)localXYPlot.getRenderer();
		int count = localXYSeriesCollection.getSeriesCount();
		for(int i=0;i<count;i++){
			localXYSplineRenderer.setSeriesShapesVisible(i, false);
			localXYSplineRenderer.setSeriesPaint(i, Color.RED);
		}
		*/
	}

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart localChart) {
		this.chart = localChart;
	}

	public ChartPanel getChartPanel() {
		return chartPanel;
	}

	public void setChartPanel(ChartPanel chartPanel) {
		this.chartPanel = chartPanel;
	}

}

package com.xianhe.mis.module.module1D.view.output;

import java.awt.Color;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.xianhe.mis.module.module1D.readwritefile.ReadOutputFileData;

import javafx.embed.swing.SwingNode;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.layout.BorderPane;

public class FlowPathPanel extends BorderPane {
	private List<List<Data>> gridData = null;
	
	public FlowPathPanel() {
		gridData = ReadOutputFileData.readFlowPathData();
		SwingNode node = new SwingNode();
		//node.autosize();
		setCenter(node);
		
		node.setContent(createChartPane("Á÷Â·Í¼"));
	}
	
	public  ChartPanel createChartPane(String title) {
		NumberAxis localNumberAxis1 = new NumberAxis("X");
		//localNumberAxis1.setAutoRangeIncludesZero(false);
		NumberAxis localNumberAxis2 = new NumberAxis("Y");
		//localNumberAxis2.setAutoRangeIncludesZero(false);
		localNumberAxis2.setLowerBound(0.21); 
		localNumberAxis2.setUpperBound(0.31); 
		
		XYDataset data1 = createSampleData();
		XYLineAndShapeRenderer localXYSplineRenderer = new XYLineAndShapeRenderer();
		//localXYSplineRenderer.setUseFillPaint(true);
		//localXYSplineRenderer.setBaseFillPaint(Color.red);
		int count = data1.getSeriesCount();
		for(int i=0;i<count;i++){
			localXYSplineRenderer.setSeriesShapesVisible(i, false);
			if(i>2){
				localXYSplineRenderer.setSeriesPaint(i, Color.darkGray);
			}else{
				localXYSplineRenderer.setSeriesPaint(i, Color.RED);
			}
		}
		
		XYPlot localXYPlot = new XYPlot(data1, localNumberAxis1, localNumberAxis2, localXYSplineRenderer);
		JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, localXYPlot,true);
		chart.getLegend().setVisible(false);

		ChartPanel chartPanel = new ChartPanel(chart);
		//chartPanel.setMouseZoomable(false);
		return chartPanel;
	}
	
	private static XYDataset createSampleData() {
		XYSeriesCollection localXYSeriesCollection = new XYSeriesCollection();
		List<List<XYDataItem>> list = ReadOutputFileData.readPathData();
		int count = 0;
		for(List<XYDataItem> aList:list){
			count++;
			XYSeries localXYSeries = new XYSeries("Series"+count);
			for(XYDataItem item:aList){
				localXYSeries.add(item);
			}
			localXYSeriesCollection.addSeries(localXYSeries);
		}
		return localXYSeriesCollection;
	}
}

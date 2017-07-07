package com.xianhe.mis.module.module1D.view.output;

import java.awt.Color;
import java.util.List;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.xianhe.mis.module.module1D.readwritefile.GridDataUtil;
import com.xianhe.mis.module.module1D.readwritefile.ReadOutputFileData;
import com.xianhe.mis.output.JFreeChartPanel;

import javafx.scene.layout.GridPane;

public class FeaturesChartPanel extends GridPane{
	public FeaturesChartPanel() {
		this.setVgap(10);
		this.setHgap(10);
		
		this.add(getChartPanel1(), 0, 0);
		this.add(getChartPanel2(), 1, 0);
		this.add(getChartPanel3(), 0, 1);
		//setCenter(getChartPanel1());
	}
	
	public JFreeChartPanel getChartPanel1(){
		JFreeChartPanel panel = new JFreeChartPanel();

		List<List<String>> perfData = ReadOutputFileData.readPerfData();
		perfData = GridDataUtil.transform(perfData);
		for(int rownum=0;rownum<perfData.size();rownum=rownum+4){
			XYSeries series = new XYSeries("series"+rownum);
			List<String> line1 = perfData.get(rownum+1);
			List<String> line2 = perfData.get(rownum+3);
			for(int colnum=0;colnum<line1.size();colnum++){
				double x = Double.parseDouble(line1.get(colnum));
				double y = Double.parseDouble(line2.get(colnum));
				series.add(new XYDataItem(x,y));
			}
			panel.addSeries(series);
		}
		
		JFreeChart chart = panel.getChart();
		chart.getLegend().setVisible(false);
		
		XYPlot localXYPlot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer localXYSplineRenderer = (XYLineAndShapeRenderer)localXYPlot.getRenderer();
		XYSeriesCollection localXYSeriesCollection = (XYSeriesCollection)chart.getXYPlot().getDataset(0);
		int count = localXYSeriesCollection.getSeriesCount();
		for(int i=0;i<count;i++){
			localXYSplineRenderer.setSeriesShapesVisible(i, false);
			localXYSplineRenderer.setSeriesPaint(i, Color.RED);
		}
		
		return panel;
	}
	
	public JFreeChartPanel getChartPanel2(){
		JFreeChartPanel panel = new JFreeChartPanel();
		
		List<List<String>> surgData = ReadOutputFileData.readSurgData();
		XYSeries aSeries = new XYSeries("series01");
		for(List<String> row:surgData){
			double x = Double.parseDouble(row.get(0));
			double y = Double.parseDouble(row.get(1));
			aSeries.add(new XYDataItem(x,y));
		}
		panel.addSeries(aSeries);
		
		List<List<String>> operData = ReadOutputFileData.readOperData();
		aSeries = new XYSeries("series02");
		for(List<String> row:operData){
			double x = Double.parseDouble(row.get(0));
			double y = Double.parseDouble(row.get(1));
			aSeries.add(new XYDataItem(x,y));
		}
		panel.addSeries(aSeries);
		
		List<List<String>> perfData = ReadOutputFileData.readPerfData();
		perfData = GridDataUtil.transform(perfData);
		for(int rownum=0;rownum<perfData.size();rownum=rownum+4){
			XYSeries series = new XYSeries("series"+rownum);
			List<String> line1 = perfData.get(rownum+1);
			List<String> line2 = perfData.get(rownum+2);
			for(int colnum=0;colnum<line1.size();colnum++){
				double x = Double.parseDouble(line1.get(colnum));
				double y = Double.parseDouble(line2.get(colnum));
				series.add(new XYDataItem(x,y));
			}
			panel.addSeries(series);
		}
		
		JFreeChart chart = panel.getChart();
		chart.getLegend().setVisible(false);
		
		XYPlot localXYPlot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer localXYSplineRenderer = (XYLineAndShapeRenderer)localXYPlot.getRenderer();
		XYSeriesCollection localXYSeriesCollection = (XYSeriesCollection)chart.getXYPlot().getDataset(0);
		int count = localXYSeriesCollection.getSeriesCount();
		for(int i=0;i<count;i++){
			localXYSplineRenderer.setSeriesShapesVisible(i, false);
			if(i>1){
				localXYSplineRenderer.setSeriesPaint(i, Color.RED);
			}else{
				localXYSplineRenderer.setSeriesPaint(i, Color.BLUE);
			}
		}
		
		return panel;
	}
	
	public JFreeChartPanel getChartPanel3(){
		JFreeChartPanel panel = new JFreeChartPanel();

		List<List<String>> perfData = ReadOutputFileData.readPerfData();
		perfData = GridDataUtil.transform(perfData);
		for(int rownum=0;rownum<perfData.size();rownum=rownum+4){
			XYSeries series = new XYSeries("series"+rownum);
			List<String> line1 = perfData.get(rownum+3);
			List<String> line2 = perfData.get(rownum+2);
			for(int colnum=0;colnum<line1.size();colnum++){
				double x = Double.parseDouble(line1.get(colnum));
				double y = Double.parseDouble(line2.get(colnum));
				series.add(new XYDataItem(x,y));
			}
			panel.addSeries(series);
		}
		
		JFreeChart chart = panel.getChart();
		chart.getLegend().setVisible(false);
		
		XYPlot localXYPlot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer localXYSplineRenderer = (XYLineAndShapeRenderer)localXYPlot.getRenderer();
		XYSeriesCollection localXYSeriesCollection = (XYSeriesCollection)chart.getXYPlot().getDataset(0);
		int count = localXYSeriesCollection.getSeriesCount();
		for(int i=0;i<count;i++){
			localXYSplineRenderer.setSeriesShapesVisible(i, false);
			localXYSplineRenderer.setSeriesPaint(i, Color.RED);
		}
		
		return panel;
	}
}

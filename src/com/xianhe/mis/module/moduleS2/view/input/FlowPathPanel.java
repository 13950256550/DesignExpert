package com.xianhe.mis.module.moduleS2.view.input;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleEdge;

import com.xianhe.mis.module.moduleS2.readwritefile.ReadInputFileData;
import com.xianhe.mis.output.JFreeChartPanel;

public class FlowPathPanel extends JFreeChartPanel implements ChartMouseListener, MouseListener,MouseMotionListener{
	public static Logger logger = Logger.getLogger(FlowPathPanel.class);
	private XYItemEntity xyItemEntity;
	private XYSeries tempSeries = null;
	private List<int[]> selectSeries = new ArrayList<int[]>();
	public FlowPathPanel(String path){
		super();

		Map<String,Object> map = ReadInputFileData.parseS2_in(path);
		List<List<String>> gridData = (List<List<String>>)map.get("grid1");

		XYSeries series1 = new XYSeries("series01");
		XYSeries series2 = new XYSeries("series02");
		List<String> line1 = gridData.get(0);
		List<String> line2 = gridData.get(1);
		List<String> line3 = gridData.get(2);
		List<String> line4 = gridData.get(3);
		for(int i=0;i<line1.size();i++){
			double x = Double.parseDouble(line2.get(i));
			double y = Double.parseDouble(line1.get(i));
			XYDataItem item1 = new XYDataItem(x,y);
			series1.add(item1);
			
			x = Double.parseDouble(line4.get(i));
			y = Double.parseDouble(line3.get(i));
			XYDataItem item2 = new XYDataItem(x,y);
			series2.add(item2);
			
			XYSeries series = new XYSeries("series"+i);
			series.add(item1);
			series.add(item2);
			addSeries(series);
		}
		
		addSeries(series1);
		addSeries(series2);

		JFreeChart chart = getChart();
		chart.getLegend().setVisible(false);
		
		XYPlot localXYPlot = (XYPlot) chart.getPlot();
		NumberAxis axis = (NumberAxis)localXYPlot.getDomainAxis();
		//axis.setRange(-200, 500);
		axis = (NumberAxis)localXYPlot.getRangeAxis();
		//axis.setRange(-200, 500);
		XYLineAndShapeRenderer localXYSplineRenderer = (XYLineAndShapeRenderer)localXYPlot.getRenderer();
		XYSeriesCollection localXYSeriesCollection = (XYSeriesCollection)chart.getXYPlot().getDataset(0);
		int count = localXYSeriesCollection.getSeriesCount();
		for(int i=0;i<count;i++){
			localXYSplineRenderer.setSeriesShapesVisible(i, false);
			localXYSplineRenderer.setSeriesPaint(i, Color.RED);
		}
		
		localXYSplineRenderer.setSeriesPaint(count-1, Color.BLUE);
		localXYSplineRenderer.setSeriesPaint(count-2, Color.BLUE);
		
		for(MouseListener listener:this.getChartPanel().getMouseListeners()){
			//this.getChartPanel().removeMouseListener(listener);
		}
		this.getChartPanel().addMouseListener(this);
		this.getChartPanel().addChartMouseListener(this);
		this.getChartPanel().addMouseMotionListener(this);
		
		this.getChartPanel().setMouseZoomable(false);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		/*
		int xPos = e.getX();
	    int yPos = e.getY();
	    Point2D point2D = this.getChartPanel().translateScreenToJava2D(new Point(xPos, yPos));
	    
		Rectangle2D localRectangle2D = this.getChartPanel().getScreenDataArea();
		JFreeChart localJFreeChart = this.getChart();
		XYPlot xyPlot = (XYPlot) localJFreeChart.getPlot();
		
		ChartRenderingInfo chartRenderingInfo = this.getChartPanel().getChartRenderingInfo();
	    Rectangle2D rectangle2D = chartRenderingInfo.getPlotInfo().getPlotArea();
	    ValueAxis valueAxis = xyPlot.getRangeAxis();
	    RectangleEdge rectangleEdge = xyPlot.getRangeAxisEdge();
		double y = valueAxis.java2DToValue(point2D.getY(), rectangle2D, rectangleEdge);
		
		valueAxis = xyPlot.getDomainAxis();
	    rectangleEdge = xyPlot.getDomainAxisEdge();
		double x = valueAxis.java2DToValue(point2D.getY(), rectangle2D, rectangleEdge);
		*/
		
		Rectangle2D localRectangle2D = this.getChartPanel().getScreenDataArea();
		JFreeChart localJFreeChart = this.getChartPanel().getChart();
		XYPlot xyPlot = (XYPlot) localJFreeChart.getPlot();
		
		ValueAxis yAxis = xyPlot.getRangeAxis();
		ValueAxis xAxis = xyPlot.getDomainAxis();
		double x = xAxis.java2DToValue(e.getX(), localRectangle2D,RectangleEdge.BOTTOM);
		double y = yAxis.java2DToValue(e.getY(), localRectangle2D,RectangleEdge.LEFT);

		tempSeries.clear();
		XYDataItem item = new XYDataItem(x,y);
		tempSeries.add(item);
		
		updateSeriesByXYDataItem(item);
		
		XYPlot localXYPlot = (XYPlot) this.getChart().getPlot();
		XYLineAndShapeRenderer localXYLineAndShapeRenderer = (XYLineAndShapeRenderer) localXYPlot.getRenderer();
		//localXYLineAndShapeRenderer.setSeriesShapesVisible(localXYSeriesCollection.getSeriesCount()-1, true);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JFreeChart localJFreeChart = this.getChart();
		XYPlot localXYPlot = (XYPlot) localJFreeChart.getPlot();
		XYLineAndShapeRenderer localXYLineAndShapeRenderer = (XYLineAndShapeRenderer) localXYPlot.getRenderer();
		localXYLineAndShapeRenderer.setSeriesShapesVisible(localXYPlot.getDataset(0).getSeriesCount()-1, false);
		
		if(tempSeries!=null){
			tempSeries.clear();
		}
		
		if(xyItemEntity!=null){
			xyItemEntity = null;
		}
		
		if(selectSeries!=null){
			selectSeries.clear();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void chartMouseClicked(ChartMouseEvent paramChartMouseEvent) {
		try {
			// 放在try块中可避免弹出异常提示，目前还没有找到得到XYItemEntity对象的好办法
			xyItemEntity = (XYItemEntity) paramChartMouseEvent.getEntity();
		} catch (Exception ee) {
		}

		if (xyItemEntity != null){
			findSeriesByXYDataItem(xyItemEntity);
		}else{
			return;
		}
		
		XYPlot xyPlot = (XYPlot) this.getChart().getPlot();
		XYLineAndShapeRenderer localXYLineAndShapeRenderer = (XYLineAndShapeRenderer) xyPlot.getRenderer();

		XYSeriesCollection xySeriesCollection = (XYSeriesCollection)xyPlot.getDataset(0);
		
		XYDataItem item = xySeriesCollection.getSeries(xyItemEntity.getSeriesIndex()).getDataItem(xyItemEntity.getItem());
		if(tempSeries==null){
			tempSeries = new XYSeries("temp");
			xySeriesCollection.addSeries(tempSeries);
		}
		tempSeries.clear();
		tempSeries.add(new XYDataItem(item.getXValue(),item.getYValue()));
		localXYLineAndShapeRenderer.setSeriesShapesVisible(xySeriesCollection.getSeriesCount()-1, true);
		//localXYLineAndShapeRenderer.setSeriesShapesVisible(xyItemEntity.getSeriesIndex(), true);
		
	}

	@Override
	public void chartMouseMoved(ChartMouseEvent paramChartMouseEvent) {
	}
	
	public void findSeriesByXYDataItem(XYItemEntity xyItemEntity){
		XYPlot xyPlot = (XYPlot) this.getChart().getPlot();
		XYLineAndShapeRenderer localXYLineAndShapeRenderer = (XYLineAndShapeRenderer) xyPlot.getRenderer();

		XYSeriesCollection xySeriesCollection = (XYSeriesCollection)xyPlot.getDataset(0);
		
		XYDataItem item = xySeriesCollection.getSeries(xyItemEntity.getSeriesIndex()).getDataItem(xyItemEntity.getItem());
		/*
		for(XYSeries series:(List<XYSeries>)xySeriesCollection.getSeries()){
			for(XYDataItem xyDataItem:(List<XYDataItem>)series.getItems()){
				if(item.getXValue()==xyDataItem.getXValue() && item.getYValue()==xyDataItem.getYValue()){
					logger.info();
				}
			}
		}
		*/
		for(int seriesIndex = 0;seriesIndex<xySeriesCollection.getSeriesCount();seriesIndex++){
			XYSeries series = xySeriesCollection.getSeries(seriesIndex);
			for(int itemIndex = 0;itemIndex<series.getItemCount();itemIndex++){
				XYDataItem xyDataItem = (XYDataItem)series.getItems().get(itemIndex);
				if(item.getXValue()==xyDataItem.getXValue() && item.getYValue()==xyDataItem.getYValue()){
					//logger.info("seriesIndex="+seriesIndex+",itemIndex="+itemIndex);
					int[] data = new int[]{seriesIndex,itemIndex};
					selectSeries.add(data);
				}
			}
		}
	}
	
	public void updateSeriesByXYDataItem(XYDataItem item){
		for(int[] data:selectSeries){
			XYSeries xySeries = getXYSeries(data[0]);
			List<XYDataItem> list = new ArrayList<XYDataItem>();
			for(int i=0;i<xySeries.getItemCount();i++){
				if(i==data[1]){
					list.add(item);
				}else{
					list.add(xySeries.getDataItem(i));
				}
			}
			
			xySeries.clear();
			for(XYDataItem aItem:list){
				xySeries.add(aItem);
			}
		}
	}
	
	public XYSeries getXYSeries(int seriesIndex){
		XYPlot xyPlot = (XYPlot) this.getChart().getPlot();
		XYSeriesCollection xySeriesCollection = (XYSeriesCollection)xyPlot.getDataset(0);
		return xySeriesCollection.getSeries(seriesIndex);
	}

}

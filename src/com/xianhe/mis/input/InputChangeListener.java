package com.xianhe.mis.input;

import org.apache.log4j.Logger;

import com.xianhe.core.common.Code;
import com.xianhe.mis.CommonPanel;
import com.xianhe.mis.module.module1D.constant.AspectRatioCalculateConstant;
import com.xianhe.mis.module.module1D.constant.ControlVariableConstant;
import com.xianhe.mis.module.module1D.constant.FeaturesCalculateConstant;
import com.xianhe.mis.module.module1D.view.input1.Module1DInput1View;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class InputChangeListener implements ChangeListener<Code>,EventHandler<ActionEvent> {
	public static Logger logger = Logger.getLogger(InputChangeListener.class);
	private String inputId = null;
	
	public InputChangeListener(String inputId) {
		super();
		this.inputId = inputId;
	}

	@Override
	public void handle(ActionEvent event) {
		if(inputId!=null && inputId.equals(AspectRatioCalculateConstant.喘振裕度输入NCU)){
			TextField textField = (TextField)event.getSource();
			CommonPanel aspectRatioCalculatePanel = Module1DInput1View.getCommonPanel(8);
			if(!"3".equals(textField.getText())){
				aspectRatioCalculatePanel.setReadonly("AspectRatioCalculatePanel.grid1", true);
			}else{
				aspectRatioCalculatePanel.setReadonly("AspectRatioCalculatePanel.grid1", false);
			}
		}
	}

	@Override
	public void changed(ObservableValue<? extends Code> observable, Code oldValue, Code newValue) {
		/*
		String msg = inputId;
		if(oldValue!=null){
			msg += ":"+oldValue.getKey();
		}
		if(newValue!=null){
			msg += ":"+newValue.getKey();
		}
		logger.info(msg);
		*/
		if(inputId!=null && inputId.equals(ControlVariableConstant.检查或设计_K12)){
			//k12 1-设计问题 2-检查问题
			if(newValue!=null && newValue.getKey().equals("1")){
				//检查-->设计
				CommonPanel designProblemPanel = Module1DInput1View.getCommonPanel(1);
				designProblemPanel.setReadonly(false);
				
				CommonPanel checkQuestion1Panel = Module1DInput1View.getCommonPanel(2);
				checkQuestion1Panel.setReadonly(true);
				CommonPanel checkQuestion2Panel = Module1DInput1View.getCommonPanel(3);
				checkQuestion2Panel.setReadonly(true);
				CommonPanel checkQuestion3Panel = Module1DInput1View.getCommonPanel(4);
				checkQuestion3Panel.setReadonly(true);
				
			}else if(newValue!=null && newValue.getKey().equals("2")){
				//设计-->检查
				CommonPanel designProblemPanel = Module1DInput1View.getCommonPanel(1);
				designProblemPanel.setReadonly(true);
				
				CommonPanel checkQuestion1Panel = Module1DInput1View.getCommonPanel(2);
				checkQuestion1Panel.setReadonly(false);
				CommonPanel checkQuestion2Panel = Module1DInput1View.getCommonPanel(3);
				checkQuestion2Panel.setReadonly(false);
				CommonPanel checkQuestion3Panel = Module1DInput1View.getCommonPanel(4);
				checkQuestion3Panel.setReadonly(false);
			}
		}
		
		if(inputId!=null && inputId.equals(ControlVariableConstant.解题类型_K)){
			//k 1-设计或检查 2-特性 3-设计或检查+特性 4-设计或检查+特性+展弦比
			if(newValue!=null && newValue.getKey().equals("1")){
				CommonPanel FeaturesCalculate1Panel = Module1DInput1View.getCommonPanel(5);
				FeaturesCalculate1Panel.setReadonly(true);
				CommonPanel FeaturesCalculate2Panel = Module1DInput1View.getCommonPanel(6);
				FeaturesCalculate2Panel.setReadonly(true);
				CommonPanel FeaturesCalculate3Panel = Module1DInput1View.getCommonPanel(7);
				FeaturesCalculate3Panel.setReadonly(true);
				
				CommonPanel aspectRatioCalculatePanel = Module1DInput1View.getCommonPanel(8);
				aspectRatioCalculatePanel.setReadonly(true);
			}
			
			if(newValue!=null && newValue.getKey().equals("3")){
				CommonPanel FeaturesCalculate1Panel = Module1DInput1View.getCommonPanel(5);
				FeaturesCalculate1Panel.setReadonly(false);
				CommonPanel FeaturesCalculate2Panel = Module1DInput1View.getCommonPanel(6);
				FeaturesCalculate2Panel.setReadonly(false);
				CommonPanel FeaturesCalculate3Panel = Module1DInput1View.getCommonPanel(7);
				FeaturesCalculate3Panel.setReadonly(false);
				
				CommonPanel aspectRatioCalculatePanel = Module1DInput1View.getCommonPanel(8);
				aspectRatioCalculatePanel.setReadonly(true);
			}
			
			if(newValue!=null && newValue.getKey().equals("4")){
				CommonPanel FeaturesCalculate1Panel = Module1DInput1View.getCommonPanel(5);
				FeaturesCalculate1Panel.setReadonly(false);
				CommonPanel FeaturesCalculate2Panel = Module1DInput1View.getCommonPanel(6);
				FeaturesCalculate2Panel.setReadonly(false);
				CommonPanel FeaturesCalculate3Panel = Module1DInput1View.getCommonPanel(7);
				FeaturesCalculate3Panel.setReadonly(false);
				
				CommonPanel aspectRatioCalculatePanel = Module1DInput1View.getCommonPanel(8);
				aspectRatioCalculatePanel.setReadonly(false);
			}
		}
		
		if(inputId!=null && inputId.equals(FeaturesCalculateConstant.控制参数KGKA)){
			//kgka 0-特性2不输 1-特性2输
			if(newValue!=null && newValue.getKey().equals("0")){
				CommonPanel FeaturesCalculate2Panel = Module1DInput1View.getCommonPanel(6);
				FeaturesCalculate2Panel.setReadonly(true);
			}
			
			if(newValue!=null && newValue.getKey().equals("1")){
				CommonPanel FeaturesCalculate2Panel = Module1DInput1View.getCommonPanel(6);
				FeaturesCalculate2Panel.setReadonly(false);
			}
		}
		
		if(inputId!=null && inputId.equals(FeaturesCalculateConstant.控制参数IGKA)){
			//igka 0-特性3不输 1-特性3输
			if(newValue!=null && newValue.getKey().equals("0")){
				CommonPanel FeaturesCalculate3Panel = Module1DInput1View.getCommonPanel(7);
				FeaturesCalculate3Panel.setReadonly(true);
			}
			
			if(newValue!=null && newValue.getKey().equals("1")){
				CommonPanel FeaturesCalculate3Panel = Module1DInput1View.getCommonPanel(7);
				FeaturesCalculate3Panel.setReadonly(false);
			}
		}
		
		if(inputId!=null && inputId.equals(ControlVariableConstant.损失修正符_IZI)){
			CommonPanel controlVariablePanel = Module1DInput1View.getCommonPanel(0);
			//izi 0-不修正 1-修正
			if(newValue!=null && newValue.getKey().equals("0")){
				controlVariablePanel.setReadonly(ControlVariableConstant.损失校正系数ALN,true);
				controlVariablePanel.setReadonly(ControlVariableConstant.ALW,true);
				controlVariablePanel.setReadonly(ControlVariableConstant.PKN,true);
				controlVariablePanel.setReadonly(ControlVariableConstant.PKW,true);
			}
			
			if(newValue!=null && newValue.getKey().equals("1")){
				controlVariablePanel.setReadonly(ControlVariableConstant.损失校正系数ALN,false);
				controlVariablePanel.setReadonly(ControlVariableConstant.ALW,false);
				controlVariablePanel.setReadonly(ControlVariableConstant.PKN,false);
				controlVariablePanel.setReadonly(ControlVariableConstant.PKW,false);
			}
		}
		
		if(inputId!=null && inputId.equals(ControlVariableConstant.静叶可调_IREG)){
			CommonPanel FeaturesCalculate1Panel = Module1DInput1View.getCommonPanel(5);
			//ireg 0-不调 1-调静叶并输入
			if(newValue!=null && newValue.getKey().equals("0")){
				FeaturesCalculate1Panel.setReadonly("FeaturesCalculate1Panel.grid3",true);
			}
			
			if(newValue!=null && newValue.getKey().equals("1")){
				FeaturesCalculate1Panel.setReadonly("FeaturesCalculate1Panel.grid3",false);
			}
		}
	}

}

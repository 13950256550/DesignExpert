package com.xianhe.mis.module.module1D.readwritefile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xianhe.mis.module.module1D.constant.AspectRatioCalculateConstant;
import com.xianhe.mis.module.module1D.constant.CheckQuestionConstant;
import com.xianhe.mis.module.module1D.constant.Constant;
import com.xianhe.mis.module.module1D.constant.ControlVariableConstant;
import com.xianhe.mis.module.module1D.constant.DesignProblemConstant;
import com.xianhe.mis.module.module1D.constant.FeaturesCalculateConstant;
import com.xianhe.mis.module.module1D.constant.ZXBCalculateConstant;
import com.xianhe.mis.module.module1D.view.input1.Module1DInput1View;

public class WriteDataToFile {
	public static String fileName = "1d_in1_out";
	public static void main(String[] args) {
		List<String> list = ReadInputFileData.readFile();
		Map map = ReadInputFileData.parse1D(list);
		
		Map<String,List<List<String>>> gridDatas = new HashMap<String,List<List<String>>>();
		gridDatas.put("grid1", ReadInputFileGridData.readGrid1(list));
		gridDatas.put("grid2", ReadInputFileGridData.readGrid2(list));
		gridDatas.put("grid3", ReadInputFileGridData.readGrid3(list));
		gridDatas.put("grid4", ReadInputFileGridData.readGrid4(list));
		gridDatas.put("grid5", ReadInputFileGridData.readGrid5(list));
		gridDatas.put("grid6", ReadInputFileGridData.readGrid6(list));
		
		WriteDataToFile(map,gridDatas);
	}
	
	public static void WriteDataToFile(Map map,Map<String,List<List<String>>> gridDatas){
		String path = ReadInputFileData.class.getResource("/").getPath();
		File file = new File(path+fileName);
		WriteDataToFile(file,map,gridDatas);
	}
	
	public static StringBuffer getBuffer(Map map){
		StringBuffer sb = new StringBuffer();
		
		sb.append(map.get(ControlVariableConstant.作业题目_TITLT)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.气压机个数_IRE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.机组个数_NV)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.解题类型_K)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.检查或设计_K12)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.损失修正符_IZI)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.静叶可调_IREG)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.两特性同图IHAR)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.流路转换_IZX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.叶排轴向长度缩放_IDX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.性能参数分布_IPE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.叶型参数分布_IFH)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.叶排内设站_INZ)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.RPM转速度或第一级转子叶尖切线速度)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PR总压比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.G流量)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PO进口总压)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.TO进口总温)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.EFF绝热效率)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KH功率存储系数)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ISTAGE级数)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KPATH流路输入标识)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KF叶型标识)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KC压气机类型)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGO进口段总压回复)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGV进口导叶总压回复)).append(Constant.newLine);
		
		//sb.append(map.get(CheckQuestion1Constant.外径DTK)).append(Constant.newLine);
		//sb.append(map.get(CheckQuestion1Constant.内径DHK)).append(Constant.newLine);
		
		writeGridToBuffer(sb,GridDataUtil.transform((List<List<String>>)map.get("grid1")));
		writeGridToBuffer(sb,GridDataUtil.transform((List<List<String>>)map.get("grid2")));
		
		sb.append(map.get(CheckQuestionConstant.ALFO一转进气流角)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.KH1第一级)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DKH逐级递减)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KHMIN最小值)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.KG流量缩放系数)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASP1一转展旋比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPK最后级展旋比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABV进口导叶)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABR转子叶片)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABS静子叶片)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTHV尖根弦长比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPV展弦比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTV稠度)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DHO出口内直径)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DTO出口外直径)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTH1一转尖根弦长比)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.E1第一级)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DE最后级与第一级差)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.CMV进口导叶最大相对厚度)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENR转件)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENS静件)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENB叶片)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DRES转子根许用应力)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ALFK最后静子出口气流角)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PRO本气压机前已有压比)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.HORDA最小弦比)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.等转速条线数N)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.气体常数R)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.绝热指数K)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.状态点间隔DQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.垂直段误差精度Q值EQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.总压系数ESIG)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.控制参数KGKA)).append(Constant.newLine);

		sb.append(map.get(FeaturesCalculateConstant.控制参数IGKA)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.转速和状态点控制IVAR1)).append(Constant.newLine);
		
		writeGridToBuffer(sb,GridDataUtil.transform((List<List<String>>)map.get("grid3")));
		
		sb.append(map.get(FeaturesCalculateConstant.状态点计算控制IQP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.搜索共同工作点IZAP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.共同工作线给定LSR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.堵点失速点输出KPATH1)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.计算结果输出KPATH2)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.流量储备系数KG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.总压恢复步长DSIG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.喘振裕度SM)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.压比收敛精度EPR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.垂直段单点压比PR2)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.上起点压比与最小压比之比PRB)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.转速线起始NNS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.终止NNF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.计算级起始IIS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.终止IIF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.Qλ限制最小值QQS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.最大值QQF)).append(Constant.newLine);
		
		writeGridToBuffer(sb,(List<List<String>>)map.get("grid4"));
		writeGridToBuffer(sb,(List<List<String>>)map.get("grid5"));
		
		sb.append(map.get(ZXBCalculateConstant.喘振裕度输入NCU)).append(Constant.newLine);
		
		writeGridToBuffer(sb,(List<List<String>>)map.get("grid6"));;
		
		return sb;
	}
	
	public static StringBuffer getBuffer(Map map,Map<String,List<List<String>>> gridDatas){
		StringBuffer sb = new StringBuffer();
		
		sb.append(map.get(ControlVariableConstant.作业题目_TITLT)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.气压机个数_IRE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.机组个数_NV)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.解题类型_K)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.检查或设计_K12)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.损失修正符_IZI)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.静叶可调_IREG)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.两特性同图IHAR)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.流路转换_IZX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.叶排轴向长度缩放_IDX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.性能参数分布_IPE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.叶型参数分布_IFH)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.叶排内设站_INZ)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.RPM转速度或第一级转子叶尖切线速度)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PR总压比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.G流量)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PO进口总压)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.TO进口总温)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.EFF绝热效率)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KH功率存储系数)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ISTAGE级数)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KPATH流路输入标识)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KF叶型标识)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KC压气机类型)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGO进口段总压回复)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGV进口导叶总压回复)).append(Constant.newLine);
		
		//sb.append(map.get(CheckQuestion1Constant.外径DTK)).append(Constant.newLine);
		//sb.append(map.get(CheckQuestion1Constant.内径DHK)).append(Constant.newLine);
		
		writeGridToBuffer(sb,gridDatas.get("grid1"));
		writeGridToBuffer(sb,gridDatas.get("grid2"));
		
		sb.append(map.get(CheckQuestionConstant.ALFO一转进气流角)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.KH1第一级)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DKH逐级递减)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KHMIN最小值)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.KG流量缩放系数)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASP1一转展旋比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPK最后级展旋比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABV进口导叶)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABR转子叶片)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABS静子叶片)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTHV尖根弦长比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPV展弦比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTV稠度)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DHO出口内直径)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DTO出口外直径)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTH1一转尖根弦长比)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.E1第一级)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DE最后级与第一级差)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.CMV进口导叶最大相对厚度)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENR转件)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENS静件)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENB叶片)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DRES转子根许用应力)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ALFK最后静子出口气流角)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PRO本气压机前已有压比)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.HORDA最小弦比)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.等转速条线数N)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.气体常数R)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.绝热指数K)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.状态点间隔DQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.垂直段误差精度Q值EQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.总压系数ESIG)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.控制参数KGKA)).append(Constant.newLine);

		sb.append(map.get(FeaturesCalculateConstant.控制参数IGKA)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.转速和状态点控制IVAR1)).append(Constant.newLine);
		
		writeGridToBuffer(sb,gridDatas.get("grid3"));
		
		sb.append(map.get(FeaturesCalculateConstant.状态点计算控制IQP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.搜索共同工作点IZAP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.共同工作线给定LSR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.堵点失速点输出KPATH1)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.计算结果输出KPATH2)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.流量储备系数KG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.总压恢复步长DSIG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.喘振裕度SM)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.压比收敛精度EPR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.垂直段单点压比PR2)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.上起点压比与最小压比之比PRB)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.转速线起始NNS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.终止NNF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.计算级起始IIS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.终止IIF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.Qλ限制最小值QQS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.最大值QQF)).append(Constant.newLine);
		
		writeGridToBuffer(sb,gridDatas.get("grid4"));
		writeGridToBuffer(sb,gridDatas.get("grid5"));
		
		sb.append(map.get(ZXBCalculateConstant.喘振裕度输入NCU)).append(Constant.newLine);
		
		writeGridToBuffer(sb,gridDatas.get("grid6"));;
		
		return sb;
	}
	
	public static void writeGridToBuffer(StringBuffer sb,List<List<String>> gridData){
		if(gridData!=null){
			for(List<String> row:gridData){
				for(int i=0;i<row.size();i++){
					sb.append(row.get(i)).append(Constant.blank);
				}
				sb.append(Constant.newLine);
			}
		}
	}
	
	public static void WriteDataToFile(File file,Map map){
		StringBuffer sb = getBuffer(map);
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			writeStringBuffserToStream(sb,os);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void WriteDataToFile(File file,Map map,Map<String,List<List<String>>> gridDatas){
		StringBuffer sb = getBuffer(map,gridDatas);
		OutputStream os = null;
		System.out.println(file.getAbsolutePath());
		try {
			os = new FileOutputStream(file);
			writeStringBuffserToStream(sb,os);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void writeStringBuffserToStream(StringBuffer buffer,OutputStream os) {
		writeStringToStream(buffer.toString(), os);
		buffer.delete(0, buffer.length());
	}
	
	public static void writeStringToStream(String data, OutputStream os) {
		byte[] buffer = null;
		try {
			buffer = data.getBytes();
			os.write(buffer, 0, buffer.length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void getControlVariableData(Map map,StringBuffer sb){
		//控制变量
		//#1:IRE,NV IRE─串列压气机的个数 NV─机组（一台压气机可分几个机组）个数，如IRE>1 可写0
		sb.append(map.get(ControlVariableConstant.气压机个数_IRE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.机组个数_NV)).append(Constant.newLine);
		
		//#2:K─作业解题的类型
		sb.append(map.get(ControlVariableConstant.解题类型_K)).append(Constant.newLine);
		
		//#3:K12,IZI─如果K=2 不输 K12─=1 解设计问题，=2 解检查问题 IZI─损失修正标志，=0 不修正，=1 修正
		sb.append(map.get(ControlVariableConstant.检查或设计_K12)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.损失修正符_IZI)).append(Constant.newLine);
		
		//#4:ALN,ALW,PKN,PKW─IZI=0 不输 损失校正系数，注意：ALN(λmin)应大于ALW（λmax),否则停机
		String izi = (String)map.get(ControlVariableConstant.损失修正符_IZI);
		if(izi!=null && !"0".equals(izi)){
			sb.append(map.get(ControlVariableConstant.损失校正系数ALN)).append(Constant.blank);
			sb.append(map.get(ControlVariableConstant.ALW)).append(Constant.blank);
			sb.append(map.get(ControlVariableConstant.PKN)).append(Constant.blank);
			sb.append(map.get(ControlVariableConstant.PKW)).append(Constant.newLine);
		}
		
		//#5:IREG,IHAR─如K=1 ;不输 IREG─=1 特性计算考虑静叶可调，输入调节角度，=0 不考虑;IHAR─把两个特性画在一张图上，无此功能，写0
		String k = (String)map.get(ControlVariableConstant.解题类型_K);
		if(k!=null && !"1".equals(k)){
			sb.append(map.get(ControlVariableConstant.静叶可调_IREG)).append(Constant.blank);
			sb.append(map.get(ControlVariableConstant.两特性同图IHAR)).append(Constant.newLine);
		}
		
		//#6:IZX,IDX,IPE,IFH,INZ─将一维结果转成二维输入数据文件的控制符
		sb.append(map.get(ControlVariableConstant.流路转换_IZX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.叶排轴向长度缩放_IDX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.性能参数分布_IPE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.叶型参数分布_IFH)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.叶排内设站_INZ)).append(Constant.newLine);

	}
	
	public static void getDesignProblemData(Map map,StringBuffer sb){
		//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV─13 个总参数
		sb.append(map.get(DesignProblemConstant.RPM转速或第一级转子叶尖切线速度)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.PR总压比)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.G流量)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.PO进口总压)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.TO进口总温)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.EFF绝热效率)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DKH逐级递减值)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ISTAGE级数)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.KPATH流路输入标识)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.KF叶型标识)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.KC压气机类型)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.SIGO进口段总压恢复)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.SIGV进口导叶总压恢复)).append(Constant.newLine);
		
		//#2:DT1，D1，DH1，DTC，DMC，DHC，DTK，DFF，DHK─给定流路的9 个直径值
		writeGridToBuffer(sb,(List<List<String>>)map.get("DesignProblemGrid1"));
		
		//#3A:DRT1(1:ISTAGE)，DCTK─KPATH=1 输入，否则不输;DRT1─各级转子进口外径;DCTK─压气机出口外径
		//#3B:DRM1(1:ISTAGE)，DCMK─KPATH=2 时输入，否则不输;DRM1─各级转子进口平均直径，m;DCMK─压气机出口平均直径，m
		//#3C:DRH1(1:ISTAGE)，DCHK,KPATH=3 输入，否则不输;DRH1─各级转子进口内径，m;DCHK─压气机出口内径，m
		String kpath = (String)map.get(DesignProblemConstant.KPATH流路输入标识);
		if(kpath!=null && !"0".equals(kpath)){
			List<List<String>> grid = null;
			List<String> rowData = null;
			if("1".equals(kpath)){
				grid = (List<List<String>>)map.get("DesignProblemDRT1Grid");
				grid.get(0).add(String.valueOf(map.get(DesignProblemConstant.DCTK压气机出口外径)));
				writeGridToBuffer(sb,grid);
			}else if("2".equals(kpath)){
				grid = (List<List<String>>)map.get("DesignProblemDRM1Grid");
				grid.get(0).add(String.valueOf(map.get(DesignProblemConstant.DCMK压气机出口平均直径)));
				writeGridToBuffer(sb,grid);
			}else if("3".equals(kpath)){
				grid = (List<List<String>>)map.get("DesignProblemDRH1Grid");
				grid.get(0).add(String.valueOf(map.get(DesignProblemConstant.DCHK压气机出口内径)));
				writeGridToBuffer(sb,grid);
			}
		}
		
		//#6:VA1，VAM，VAC，ALF1，OMGN，DOMG，HZ1，HZM，HZK,KH1,DKH，KHMIN ─12 个气动参数
		sb.append(map.get(DesignProblemConstant.VA1一级进轴速度)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.VAM中段轴速度)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.VAC出口轴速)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ALF1一转进气流角)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.OMGN第中级反力度)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DOMG第中级后反力度增量)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.HZ1第一级)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.HZM平均级)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.HZK最后级)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.KH1第一级)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DKH逐级递减值)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.KHMIN最小值)).append(Constant.newLine);
		
		
		//#7:KG，ASP1，ASPK，ABV，ABR，ABS，BTHV，ASPV，BTV，DH0，DT0，BTH1─12 个几何参数
		sb.append(map.get(DesignProblemConstant.KG流量缩放系数)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ASP1一转展弦比)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ASPK末转展弦比)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ABV进口导叶)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ABR转子叶片)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ABS静子叶片)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.BTHV尖根弦长比)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ASPV展弦比)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.BTV稠度)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DHO出口内直径)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DTO出口外直径)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.BTH1一转尖根弦长比)).append(Constant.newLine);
		
		//#8:E1，DE，CMV，DENR，DENS，DENB，DRES，ALFK，PR0─9 个参数
		sb.append(map.get(DesignProblemConstant.E1第一级)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DE最后级与第一级差)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.CMV进口导叶最大相对厚度)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DENR转件)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DENS静件)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DENB叶片)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DRES转子根许用应力)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ALFK最后静子出口气流角)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.PRO本压气机前已有压比)).append(Constant.newLine);

		//#9:HORDA─最小弦长，m
		sb.append(map.get(DesignProblemConstant.HORDA最小弦长)).append(Constant.newLine);
	}
	
	public static void getCheckQuestionData(Map map,StringBuffer sb){
		//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV─13 个总参数
		sb.append(map.get(CheckQuestionConstant.RPM转速度或第一级转子叶尖切线速度)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PR总压比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.G流量)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PO进口总压)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.TO进口总温)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.EFF绝热效率)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DKH逐级递减)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ISTAGE级数)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KPATH流路输入标识)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KF叶型标识)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KC压气机类型)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGO进口段总压回复)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGV进口导叶总压回复)).append(Constant.newLine);
		
		//准备工作,初始化两个grid,级数
		List<List<String>> grid1 = (List<List<String>>)map.get("CheckQuestion2Panel.grid1");
		List<List<String>> grid2 = (List<List<String>>)map.get("CheckQuestion3Panel.grid1");
		
		grid1 = GridDataUtil.transform(grid1);
		grid2 = GridDataUtil.transform(grid2);
		
		grid1.get(0).add(String.valueOf(map.get(CheckQuestionConstant.DTK外径)));
		grid1.get(1).add(String.valueOf(map.get(CheckQuestionConstant.DHK内径)));
		
		List<String> rowData = grid1.get(grid1.size()-1);
		grid1.remove(rowData);
		grid2.add(3, rowData);
		
		writeGridToBuffer(sb,grid1);
		writeGridToBuffer(sb,grid2);
		
		//#18:ALF0─第一级转子前绝对气流角
		sb.append(map.get(CheckQuestionConstant.ALFO一转进气流角)).append(Constant.newLine);
		
		//#19:KH1，DKH，KHMIN─如已输入KHI 值，此三量均写0.0
		sb.append(map.get(CheckQuestionConstant.KH1第一级)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DKH逐级递减)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KHMIN最小值)).append(Constant.newLine);
		
		//#20:KG，FF，FF，ABV，ABR，ABS，BTHV，ASPV，BTV，DH0，DT0，BTH1─12 个结构参数
		sb.append(map.get(CheckQuestionConstant.KG流量缩放系数)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASP1一转展旋比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPK最后级展旋比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABV进口导叶)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABR转子叶片)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABS静子叶片)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTHV尖根弦长比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPV展弦比)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTV稠度)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DHO出口内直径)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DTO出口外直径)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTH1一转尖根弦长比)).append(Constant.newLine);
		
		//#21:E1，DE，CMV，DENR，DENS,DENB，DRES，ALFK，PR0─9 个参数
		sb.append(map.get(CheckQuestionConstant.E1第一级)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DE最后级与第一级差)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.CMV进口导叶最大相对厚度)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENR转件)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENS静件)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENB叶片)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DRES转子根许用应力)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ALFK最后静子出口气流角)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PRO本气压机前已有压比)).append(Constant.newLine);
		
		//#22:HORDA─最小弦长，m
		sb.append(map.get(CheckQuestionConstant.HORDA最小弦比)).append(Constant.newLine);
	}
	
	public static void getFeaturesCalculateData(Map map,StringBuffer sb){
		//#1:N─等转速线条数
		sb.append(map.get(FeaturesCalculateConstant.等转速条线数N)).append(Constant.newLine);
		
		//#2:R，K，DQ,EQ，ESIG
		sb.append(map.get(FeaturesCalculateConstant.气体常数R)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.绝热指数K)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.状态点间隔DQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.垂直段误差精度Q值EQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.总压系数ESIG)).append(Constant.newLine);

		//#3:KGKA─控制以下6 组数据输入
		//=0 使用程序标准值，#4~#9 不再输入
		//=1 在下面自行输入,但全输0.0 也釆用程序中标准值
		sb.append(map.get(FeaturesCalculateConstant.控制参数KGKA)).append(Constant.newLine);
		
		String kgka = String.valueOf(map.get(FeaturesCalculateConstant.控制参数KGKA));
		if("1".equals(kgka)){
			List<List<String>> grid = (List<List<String>>)map.get("FeaturesCalculate2Panel.grid1");
			grid = GridDataUtil.transform(grid);
			writeGridToBuffer(sb,grid);
		}
		
		//#10:IGKA─控制以下4 组数据输入
		//=0 使用程序标准值，#11~#14 不再输入
		//=1 在下面自行输入
		sb.append(map.get(FeaturesCalculateConstant.控制参数IGKA)).append(Constant.newLine);
		
		String igka = String.valueOf(map.get(FeaturesCalculateConstant.控制参数IGKA));
		if("1".equals(igka)){
			List<List<String>> grid = (List<List<String>>)map.get("FeaturesCalculate3Panel.grid1");
			grid = GridDataUtil.transform(grid);
			writeGridToBuffer(sb,grid);
		}
		
		//#15:IVAR1─控制相对转速和q(λ)初值输入
		//=0，按程序设定（n=0.7，0.8，0.9，1.0)
		//=1，自行输入#16
		sb.append(map.get(FeaturesCalculateConstant.转速和状态点控制IVAR1)).append(Constant.newLine);
		
		String ivar1 = String.valueOf(map.get(FeaturesCalculateConstant.转速和状态点控制IVAR1));
		int n = 0;
		try {
			n = Integer.parseInt(String.valueOf(map.get(FeaturesCalculateConstant.等转速条线数N)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if("1".equals(ivar1)){
			//#16:NR，QL(1:N)─各特性线相对转速和q(λ)初值
			List<List<String>> grid = (List<List<String>>)map.get("FeaturesCalculate1Panel.grid1");
			grid = GridDataUtil.transform(grid);
			if(grid.size()>n){
				grid = GridDataUtil.trim(grid, 0, n-1);
			}
			writeGridToBuffer(sb,grid);
		}
		
		//#17:IQP，IZAP，LSR，KPAH1，KPAH2─5 个控制参数
		sb.append(map.get(FeaturesCalculateConstant.状态点计算控制IQP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.搜索共同工作点IZAP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.共同工作线给定LSR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.堵点失速点输出KPATH1)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.计算结果输出KPATH2)).append(Constant.newLine);
		
		//#18:KG，DSIG，SM，EPR，PR2，PRB─6 个性能参数
		sb.append(map.get(FeaturesCalculateConstant.流量储备系数KG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.总压恢复步长DSIG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.喘振裕度SM)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.压比收敛精度EPR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.垂直段单点压比PR2)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.上起点压比与最小压比之比PRB)).append(Constant.newLine);
		
		//#19:NNS，NNF，IIS，IIF，QQS，QQF─6 个限定作部分特性计算的参数
		sb.append(map.get(FeaturesCalculateConstant.转速线起始NNS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.终止NNF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.计算级起始IIS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.终止IIF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.Qλ限制最小值QQS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.最大值QQF)).append(Constant.newLine);
		
		//准备工作
		int lsr = 0;
		try {
			lsr = Integer.parseInt(String.valueOf(map.get(FeaturesCalculateConstant.共同工作线给定LSR)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if(lsr!=0){
			List<List<String>> grid = (List<List<String>>)map.get("FeaturesCalculate1Panel.grid2");
			writeGridToBuffer(sb,grid);
			//#20:LSR≠0 由低向高输入L 点的共同工作线，2≤L≤10。LSR=0 不输。
			//GCOR(1:L)─换算流量
		}
		
		String ireg = String.valueOf(map.get(ControlVariableConstant.静叶可调_IREG));
		if("1".equals(ireg)){
			List<List<String>> grid = (List<List<String>>)map.get("FeaturesCalculate1Panel.grid3");
			/*
			int istage = Module1DInput1View.getISTAGE();
			for(List<String> row:grid){
				while(row.size()>istage+1){
					row.remove(row.size()-1);
				}
			}
			*/
			writeGridToBuffer(sb,grid);
		}
	}
	
	public static void getAspectRatioCalculateData(Map map,StringBuffer sb){
		//#1:NCU─输入各转速喘振裕度SM 的标识
		sb.append(map.get(AspectRatioCalculateConstant.喘振裕度输入NCU)).append(Constant.newLine);
		
		int n = 0;
		try {
			n = Integer.parseInt(String.valueOf(map.get(FeaturesCalculateConstant.等转速条线数N)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		String ncu = String.valueOf(map.get(AspectRatioCalculateConstant.喘振裕度输入NCU));
		if("3".equals(ncu)){
			List<List<String>> grid = (List<List<String>>)map.get("AspectRatioCalculatePanel.grid1");
			writeGridToBuffer(sb,grid);
			
			//#2:SMI(1:N)─各转速要求的喘振裕度
		}
	}
	
	public static StringBuffer getBufferFromMap(Map map){
		StringBuffer sb = new StringBuffer();
		
		sb.append(map.get(ControlVariableConstant.作业题目_TITLT)).append(Constant.newLine);
		
		//控制变量
		getControlVariableData(map,sb);
		
		String k12 = String.valueOf(map.get(ControlVariableConstant.检查或设计_K12));
		if("1".equals(k12)){
			//设计问题
			getDesignProblemData(map,sb);
		}else if("2".equals(k12)){
			//检查问题
			getCheckQuestionData(map,sb);
		}
		
		String k = String.valueOf(map.get(ControlVariableConstant.解题类型_K));
		//1-设计+检查 2-特性 3-设计+检查+特性 4-设计+检查+特性+展弦比
		if("1".equals(k)){
			//设计+检查
		}else if("2".equals(k)){
			//特性计算
		}else if("3".equals(k)){
			//特性计算
			getFeaturesCalculateData(map,sb);
		}else if("4".equals(k)){
			//特性计算
			getFeaturesCalculateData(map,sb);
			//展弦比计算
			getAspectRatioCalculateData(map,sb);
		}

		return sb;
	}
}

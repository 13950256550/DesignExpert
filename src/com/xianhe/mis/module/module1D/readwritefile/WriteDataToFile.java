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
import com.xianhe.mis.module.module1D.constant.CheckQuestion1Constant;
import com.xianhe.mis.module.module1D.constant.Constant;
import com.xianhe.mis.module.module1D.constant.ControlVariableConstant;
import com.xianhe.mis.module.module1D.constant.DesignProblemConstant;
import com.xianhe.mis.module.module1D.constant.FeaturesCalculateConstant;
import com.xianhe.mis.module.module1D.constant.ZXBCalculateConstant;

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
		
		sb.append(map.get(CheckQuestion1Constant.转速度或第一级转子叶尖切线速度_RPM)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.总压比_PR)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.流量_G)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口总压_PO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口总温_TO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.绝热效率_EFF)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.功率存储系数KH)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.级数_ISTAGE)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.流路输入标识KPATH)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.叶型标识KF)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.压气机类型KC)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口段总压回复SIGO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口导叶总压回复SIGV)).append(Constant.newLine);
		
		//sb.append(map.get(CheckQuestion1Constant.外径DTK)).append(Constant.newLine);
		//sb.append(map.get(CheckQuestion1Constant.内径DHK)).append(Constant.newLine);
		
		writeGridToBuffer(sb,GridDataUtil.transform((List<List<String>>)map.get("grid1")));
		writeGridToBuffer(sb,GridDataUtil.transform((List<List<String>>)map.get("grid2")));
		
		sb.append(map.get(CheckQuestion1Constant.一转进气流角ALFO)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestion1Constant.第一级KH1)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.逐级递减DKH)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最小值KHMIN)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestion1Constant.流量缩放系数KG)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.一转展旋比ASP1)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最后级展旋比ASPK)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口导叶ABV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.转子叶片ABR)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.静子叶片ABS)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.尖根弦长比BTHV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.展弦比ASPV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.稠度BTV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.出口内直径DHO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.出口外直径DTO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.一转尖根弦长比BTH1)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestion1Constant.第一级E1)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最后级与第一级差DE)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口导叶最大相对厚度CMV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.转件DENR)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.静件DENS)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.叶片DENB)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.转子根许用应力DRES)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最后静子出口气流角ALFK)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.本气压机前已有压比PRO)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestion1Constant.最小弦比HORDA)).append(Constant.newLine);
		
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
		
		sb.append(map.get(CheckQuestion1Constant.转速度或第一级转子叶尖切线速度_RPM)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.总压比_PR)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.流量_G)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口总压_PO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口总温_TO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.绝热效率_EFF)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.功率存储系数KH)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.级数_ISTAGE)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.流路输入标识KPATH)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.叶型标识KF)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.压气机类型KC)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口段总压回复SIGO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口导叶总压回复SIGV)).append(Constant.newLine);
		
		//sb.append(map.get(CheckQuestion1Constant.外径DTK)).append(Constant.newLine);
		//sb.append(map.get(CheckQuestion1Constant.内径DHK)).append(Constant.newLine);
		
		writeGridToBuffer(sb,gridDatas.get("grid1"));
		writeGridToBuffer(sb,gridDatas.get("grid2"));
		
		sb.append(map.get(CheckQuestion1Constant.一转进气流角ALFO)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestion1Constant.第一级KH1)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.逐级递减DKH)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最小值KHMIN)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestion1Constant.流量缩放系数KG)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.一转展旋比ASP1)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最后级展旋比ASPK)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口导叶ABV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.转子叶片ABR)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.静子叶片ABS)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.尖根弦长比BTHV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.展弦比ASPV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.稠度BTV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.出口内直径DHO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.出口外直径DTO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.一转尖根弦长比BTH1)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestion1Constant.第一级E1)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最后级与第一级差DE)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口导叶最大相对厚度CMV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.转件DENR)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.静件DENS)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.叶片DENB)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.转子根许用应力DRES)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最后静子出口气流角ALFK)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.本气压机前已有压比PRO)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestion1Constant.最小弦比HORDA)).append(Constant.newLine);
		
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
		sb.append(map.get(DesignProblemConstant.转速或第一级转子叶尖切线速度RPM)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.总压比PR)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.流量G)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.进口总压PO)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.进口总温TO)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.绝热效率EFF)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.逐级递减值DKH)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.级数ISTAGE)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.流路输入标识KPATH)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.叶型标识KF)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.压气机类型KC)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.进口段总压恢复SIGO)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.进口导叶总压恢复SIGV)).append(Constant.newLine);
		
		//#2:DT1，D1，DH1，DTC，DMC，DHC，DTK，DFF，DHK─给定流路的9 个直径值
		writeGridToBuffer(sb,(List<List<String>>)map.get("DesignProblemGrid1"));
		
		//#3A:DRT1(1:ISTAGE)，DCTK─KPATH=1 输入，否则不输;DRT1─各级转子进口外径;DCTK─压气机出口外径
		//#3B:DRM1(1:ISTAGE)，DCMK─KPATH=2 时输入，否则不输;DRM1─各级转子进口平均直径，m;DCMK─压气机出口平均直径，m
		//#3C:DRH1(1:ISTAGE)，DCHK,KPATH=3 输入，否则不输;DRH1─各级转子进口内径，m;DCHK─压气机出口内径，m
		String kpath = (String)map.get(DesignProblemConstant.流路输入标识KPATH);
		if(kpath!=null && !"0".equals(kpath)){
			List<List<String>> grid = null;
			List<String> rowData = null;
			if("1".equals(kpath)){
				grid = (List<List<String>>)map.get("DesignProblemDRT1Grid");
				grid.get(0).add(String.valueOf(map.get(DesignProblemConstant.压气机出口外径DCTK)));
				writeGridToBuffer(sb,grid);
			}else if("2".equals(kpath)){
				grid = (List<List<String>>)map.get("DesignProblemDRM1Grid");
				grid.get(0).add(String.valueOf(map.get(DesignProblemConstant.压气机出口平均直径DCMK)));
				writeGridToBuffer(sb,grid);
			}else if("3".equals(kpath)){
				grid = (List<List<String>>)map.get("DesignProblemDRH1Grid");
				grid.get(0).add(String.valueOf(map.get(DesignProblemConstant.压气机出口内径DCHK)));
				writeGridToBuffer(sb,grid);
			}
		}
		
		//#6:VA1，VAM，VAC，ALF1，OMGN，DOMG，HZ1，HZM，HZK,KH1,DKH，KHMIN ─12 个气动参数
		sb.append(map.get(DesignProblemConstant.一级进轴速度VA1)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.中段轴速度VAM)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.出口轴速VAC)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.一转进气流角ALF1)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.第中级反力度OMGN)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.第中级后反力度增量DOMG)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.第一级HZ1)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.平均级HZM)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.最后级HZK)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.第一级KH1)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.逐级递减值DKH)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.最小值KHMIN)).append(Constant.newLine);
		
		
		//#7:KG，ASP1，ASPK，ABV，ABR，ABS，BTHV，ASPV，BTV，DH0，DT0，BTH1─12 个几何参数
		sb.append(map.get(DesignProblemConstant.流量缩放系数KG)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.一转展弦比ASP1)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.末转展弦比ASPK)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.进口导叶ABV)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.转子叶片ABR)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.静子叶片ABS)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.尖根弦长比BTHV)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.展弦比ASPV)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.稠度BTV)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.出口内直径DHO)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.出口外直径DTO)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.一转尖根弦长比BTH1)).append(Constant.newLine);
		
		//#8:E1，DE，CMV，DENR，DENS，DENB，DRES，ALFK，PR0─9 个参数
		sb.append(map.get(DesignProblemConstant.第一级E1)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.最后级与第一级差DE)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.进口导叶最大相对厚度CMV)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.转件DENR)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.静件DENS)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.叶片DENB)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.转子根许用应力DRES)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.最后静子出口气流角ALFK)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.本压气机前已有压比PRO)).append(Constant.newLine);

		//#9:HORDA─最小弦长，m
		sb.append(map.get(DesignProblemConstant.最小弦长HORDA)).append(Constant.newLine);
	}
	
	public static void getCheckQuestionData(Map map,StringBuffer sb){
		//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV─13 个总参数
		sb.append(map.get(CheckQuestion1Constant.转速度或第一级转子叶尖切线速度_RPM)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.总压比_PR)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.流量_G)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口总压_PO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口总温_TO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.绝热效率_EFF)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.逐级递减DKH)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.级数_ISTAGE)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.流路输入标识KPATH)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.叶型标识KF)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.压气机类型KC)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口段总压回复SIGO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口导叶总压回复SIGV)).append(Constant.newLine);
		
		//准备工作,初始化两个grid,级数
		List<List<String>> grid1 = (List<List<String>>)map.get("CheckQuestion2Panel.grid1");
		List<List<String>> grid2 = (List<List<String>>)map.get("CheckQuestion3Panel.grid1");
		
		grid1 = GridDataUtil.transform(grid1);
		grid2 = GridDataUtil.transform(grid2);
		
		grid1.get(0).add(String.valueOf(map.get(CheckQuestion1Constant.外径DTK)));
		grid1.get(1).add(String.valueOf(map.get(CheckQuestion1Constant.内径DHK)));
		
		List<String> rowData = grid1.get(grid1.size()-1);
		grid1.remove(rowData);
		grid2.add(3, rowData);
		
		writeGridToBuffer(sb,grid1);
		writeGridToBuffer(sb,grid2);
		
		//#18:ALF0─第一级转子前绝对气流角
		sb.append(map.get(CheckQuestion1Constant.一转进气流角ALFO)).append(Constant.newLine);
		
		//#19:KH1，DKH，KHMIN─如已输入KHI 值，此三量均写0.0
		sb.append(map.get(CheckQuestion1Constant.第一级KH1)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.逐级递减DKH)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最小值KHMIN)).append(Constant.newLine);
		
		//#20:KG，FF，FF，ABV，ABR，ABS，BTHV，ASPV，BTV，DH0，DT0，BTH1─12 个结构参数
		sb.append(map.get(CheckQuestion1Constant.流量缩放系数KG)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.一转展旋比ASP1)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最后级展旋比ASPK)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口导叶ABV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.转子叶片ABR)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.静子叶片ABS)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.尖根弦长比BTHV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.展弦比ASPV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.稠度BTV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.出口内直径DHO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.出口外直径DTO)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.一转尖根弦长比BTH1)).append(Constant.newLine);
		
		//#21:E1，DE，CMV，DENR，DENS,DENB，DRES，ALFK，PR0─9 个参数
		sb.append(map.get(CheckQuestion1Constant.第一级E1)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最后级与第一级差DE)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.进口导叶最大相对厚度CMV)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.转件DENR)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.静件DENS)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.叶片DENB)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.转子根许用应力DRES)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.最后静子出口气流角ALFK)).append(Constant.blank);
		sb.append(map.get(CheckQuestion1Constant.本气压机前已有压比PRO)).append(Constant.newLine);
		
		//#22:HORDA─最小弦长，m
		sb.append(map.get(CheckQuestion1Constant.最小弦比HORDA)).append(Constant.newLine);
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
			writeGridToBuffer(sb,grid);
		}
		
		//#10:IGKA─控制以下4 组数据输入
		//=0 使用程序标准值，#11~#14 不再输入
		//=1 在下面自行输入
		sb.append(map.get(FeaturesCalculateConstant.控制参数IGKA)).append(Constant.newLine);
		
		String igka = String.valueOf(map.get(FeaturesCalculateConstant.控制参数IGKA));
		if("1".equals(kgka)){
			List<List<String>> grid = (List<List<String>>)map.get("FeaturesCalculate3Panel.grid1");
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
		}

		//检查问题
		getCheckQuestionData(map,sb);
		
		//特性计算
		getFeaturesCalculateData(map,sb);
		
		//展弦比计算
		getAspectRatioCalculateData(map,sb);
		
		return sb;
	}
}

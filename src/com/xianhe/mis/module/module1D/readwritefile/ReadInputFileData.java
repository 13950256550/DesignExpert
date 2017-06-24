package com.xianhe.mis.module.module1D.readwritefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xianhe.core.common.EnvReadWriteUtil;
import com.xianhe.mis.module.module1D.constant.AspectRatioCalculateConstant;
import com.xianhe.mis.module.module1D.constant.CheckQuestion1Constant;
import com.xianhe.mis.module.module1D.constant.ControlVariableConstant;
import com.xianhe.mis.module.module1D.constant.DesignProblemConstant;
import com.xianhe.mis.module.module1D.constant.FeaturesCalculateConstant;
import com.xianhe.mis.module.module1D.constant.ZXBCalculateConstant;

public class ReadInputFileData {
	public static void main(String[] args) {
		//File file = PathUtil.get1D_in1File();
		//List<String> datas = ReadInputFileData.readFile(file);
		Map<String,Object> map = parse1D_in1();
		System.out.println(map.get("grid1"));
	}
	
	public static Map<String,Object> parse1D(){
		/*
		List<String> datas = readFile();
		Map<String,Object> result = parse1D(datas);
		
		if(result!=null){
			result.put("grid1", GridDataUtil.transform(ReadInputFileGridData.readGrid1(datas)));
			result.put("grid2", GridDataUtil.transform(ReadInputFileGridData.readGrid2(datas)));
			result.put("grid3", GridDataUtil.transform(ReadInputFileGridData.readGrid3(datas)));
			result.put("grid4", ReadInputFileGridData.readGrid4(datas));
			result.put("grid5", ReadInputFileGridData.readGrid5(datas));
			result.put("grid6", ReadInputFileGridData.readGrid6(datas));
		}
		
		return result;
		*/
		
		return ReadInputFileData.parse1D_in1();
	}
	
	public static List<String> readFile(){
		File file = EnvReadWriteUtil.getFile("/1D/1d_in1");
		return readFile(file);
	}
	
	public static List<String> readFile(File file){
		List<String> result = new ArrayList<String>();
		
		BufferedReader in = null;
		long count = 0;
		
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;
			while((line = in.readLine())!=null){
				result.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public static Map<String,Object> parse1D(List<String> list){
		Map<String,Object> result = new HashMap<String,Object>();
		
		//控制变量
		int row = 0;
		result.put(ControlVariableConstant.作业题目_TITLT, list.get(row));
		
		row++;
		String[] arrayString = list.get(row).split(" ");
		if(arrayString.length==2){
			result.put(ControlVariableConstant.气压机个数_IRE, arrayString[0]);
			result.put(ControlVariableConstant.机组个数_NV, arrayString[1]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		row++;
		result.put(ControlVariableConstant.解题类型_K, list.get(row));
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==2){
			result.put(ControlVariableConstant.检查或设计_K12, arrayString[0]);
			result.put(ControlVariableConstant.损失修正符_IZI, arrayString[1]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==2){
			result.put(ControlVariableConstant.静叶可调_IREG, arrayString[0]);
			result.put(ControlVariableConstant.两特性同图IHAR, arrayString[1]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==5){
			result.put(ControlVariableConstant.流路转换_IZX, arrayString[0]);
			result.put(ControlVariableConstant.叶排轴向长度缩放_IDX, arrayString[1]);
			result.put(ControlVariableConstant.性能参数分布_IPE, arrayString[2]);
			result.put(ControlVariableConstant.叶型参数分布_IFH, arrayString[3]);
			result.put(ControlVariableConstant.叶排内设站_INZ, arrayString[4]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		//设计问题
		
		//检查问题(1)
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==13){
			result.put(CheckQuestion1Constant.转速度或第一级转子叶尖切线速度_RPM, arrayString[0]);
			result.put(CheckQuestion1Constant.总压比_PR, arrayString[1]);
			result.put(CheckQuestion1Constant.流量_G, arrayString[2]);
			result.put(CheckQuestion1Constant.进口总压_PO, arrayString[3]);
			result.put(CheckQuestion1Constant.进口总温_TO, arrayString[4]);
			result.put(CheckQuestion1Constant.绝热效率_EFF, arrayString[5]);
			result.put(CheckQuestion1Constant.功率存储系数KH, arrayString[6]);
			result.put(CheckQuestion1Constant.级数_ISTAGE, arrayString[7]);
			result.put(CheckQuestion1Constant.流路输入标识KPATH, arrayString[8]);
			result.put(CheckQuestion1Constant.叶型标识KF, arrayString[9]);
			result.put(CheckQuestion1Constant.压气机类型KC, arrayString[10]);
			result.put(CheckQuestion1Constant.进口段总压回复SIGO, arrayString[11]);
			result.put(CheckQuestion1Constant.进口导叶总压回复SIGV, arrayString[12]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		result.put(CheckQuestion1Constant.外径DTK, arrayString[arrayString.length-1]);
		
		row++;
		arrayString = list.get(row).split(" ");
		result.put(CheckQuestion1Constant.内径DHK, arrayString[arrayString.length-1]);
		
		row++;
		row++;
		row++;
		row++;
		row++;
		
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		
		row++;
		result.put(CheckQuestion1Constant.一转进气流角ALFO, list.get(row));
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==3){
			result.put(CheckQuestion1Constant.第一级KH1, arrayString[0]);
			result.put(CheckQuestion1Constant.逐级递减DKH, arrayString[1]);
			result.put(CheckQuestion1Constant.最小值KHMIN, arrayString[2]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==12){
			result.put(CheckQuestion1Constant.流量缩放系数KG, arrayString[0]);
			result.put(CheckQuestion1Constant.一转展旋比ASP1, arrayString[1]);
			result.put(CheckQuestion1Constant.最后级展旋比ASPK, arrayString[2]);
			result.put(CheckQuestion1Constant.进口导叶ABV, arrayString[3]);
			result.put(CheckQuestion1Constant.转子叶片ABR, arrayString[4]);
			result.put(CheckQuestion1Constant.静子叶片ABS, arrayString[5]);
			result.put(CheckQuestion1Constant.尖根弦长比BTHV, arrayString[6]);
			result.put(CheckQuestion1Constant.展弦比ASPV, arrayString[7]);
			result.put(CheckQuestion1Constant.稠度BTV, arrayString[8]);
			result.put(CheckQuestion1Constant.出口内直径DHO, arrayString[9]);
			result.put(CheckQuestion1Constant.出口外直径DTO, arrayString[10]);
			result.put(CheckQuestion1Constant.一转尖根弦长比BTH1, arrayString[11]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==9){
			result.put(CheckQuestion1Constant.第一级E1, arrayString[0]);
			result.put(CheckQuestion1Constant.最后级与第一级差DE, arrayString[1]);
			result.put(CheckQuestion1Constant.进口导叶最大相对厚度CMV, arrayString[2]);
			result.put(CheckQuestion1Constant.转件DENR, arrayString[3]);
			result.put(CheckQuestion1Constant.静件DENS, arrayString[4]);
			result.put(CheckQuestion1Constant.叶片DENB, arrayString[5]);
			result.put(CheckQuestion1Constant.转子根许用应力DRES, arrayString[6]);
			result.put(CheckQuestion1Constant.最后静子出口气流角ALFK, arrayString[7]);
			result.put(CheckQuestion1Constant.本气压机前已有压比PRO, arrayString[8]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		row++;
		result.put(CheckQuestion1Constant.最小弦比HORDA, list.get(row));
		
		//特性计算1
		row++;
		result.put(FeaturesCalculateConstant.等转速条线数N, list.get(row));
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==5){
			result.put(FeaturesCalculateConstant.气体常数R, arrayString[0]);
			result.put(FeaturesCalculateConstant.绝热指数K, arrayString[1]);
			result.put(FeaturesCalculateConstant.状态点间隔DQ, arrayString[2]);
			result.put(FeaturesCalculateConstant.垂直段误差精度Q值EQ, arrayString[3]);
			result.put(FeaturesCalculateConstant.总压系数ESIG, arrayString[4]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		row++;
		result.put(FeaturesCalculateConstant.控制参数KGKA, list.get(row));
		
		row++;
		result.put(FeaturesCalculateConstant.控制参数IGKA, list.get(row));
		
		row++;
		result.put(FeaturesCalculateConstant.转速和状态点控制IVAR1, list.get(row));
		
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==5){
			result.put(FeaturesCalculateConstant.状态点计算控制IQP, arrayString[0]);
			result.put(FeaturesCalculateConstant.搜索共同工作点IZAP, arrayString[1]);
			result.put(FeaturesCalculateConstant.共同工作线给定LSR, arrayString[2]);
			result.put(FeaturesCalculateConstant.堵点失速点输出KPATH1, arrayString[3]);
			result.put(FeaturesCalculateConstant.计算结果输出KPATH2, arrayString[4]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==6){
			result.put(FeaturesCalculateConstant.流量储备系数KG, arrayString[0]);
			result.put(FeaturesCalculateConstant.总压恢复步长DSIG, arrayString[1]);
			result.put(FeaturesCalculateConstant.喘振裕度SM, arrayString[2]);
			result.put(FeaturesCalculateConstant.压比收敛精度EPR, arrayString[3]);
			result.put(FeaturesCalculateConstant.垂直段单点压比PR2, arrayString[4]);
			result.put(FeaturesCalculateConstant.上起点压比与最小压比之比PRB, arrayString[5]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==6){
			result.put(FeaturesCalculateConstant.转速线起始NNS, arrayString[0]);
			result.put(FeaturesCalculateConstant.终止NNF, arrayString[1]);
			result.put(FeaturesCalculateConstant.计算级起始IIS, arrayString[2]);
			result.put(FeaturesCalculateConstant.终止IIF, arrayString[3]);
			result.put(FeaturesCalculateConstant.Qλ限制最小值QQS, arrayString[4]);
			result.put(FeaturesCalculateConstant.最大值QQF, arrayString[5]);
		}else{
			System.out.println(list.get(row));
			System.out.println("解析第"+row+"行报错,希望两个字段，实际:"+arrayString.length);
		}
		
		row++;
		row++;
		
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		row++;
		
		row++;
		result.put(ZXBCalculateConstant.喘振裕度输入NCU, list.get(row));
		
		return result;
	}
	
	public static String[] spliteRow(String row,int count){
		String[] result = new String[count];
		if(row!=null){
			String[] temp = row.split(" ");
			if(temp!=null){
				if(temp.length==count){
					result = temp;
				}else if(temp.length>count){
					for(int i=0;i<count;i++){
						result[i] = temp[i];
					}
				}else if(temp.length<count){
					for(int i=0;i<temp.length;i++){
						result[i] = temp[i];
					}
				}
			}
		}
		return result;
	}
	
	public static int parseControlVariable(Map<String,Object> map,List<String> list,int row){
		String[] arrayString = null;
		//控制变量
		//#1:IRE,NV IRE─串列压气机的个数 NV─机组（一台压气机可分几个机组）个数，如IRE>1 可写0
		row++;
		arrayString = spliteRow(list.get(row),2);
		map.put(ControlVariableConstant.气压机个数_IRE, arrayString[0]);
		map.put(ControlVariableConstant.机组个数_NV, arrayString[1]);
		
		//#2:K─作业解题的类型
		row++;
		map.put(ControlVariableConstant.解题类型_K, list.get(row));
		
		//#3:K12,IZI─如果K=2 不输 K12─=1 解设计问题，=2 解检查问题 IZI─损失修正标志，=0 不修正，=1 修正
		row++;
		arrayString = spliteRow(list.get(row),2);
		map.put(ControlVariableConstant.检查或设计_K12, arrayString[0]);
		map.put(ControlVariableConstant.损失修正符_IZI, arrayString[1]);
		
		//#4:ALN,ALW,PKN,PKW─IZI=0 不输 损失校正系数，注意：ALN(λmin)应大于ALW（λmax),否则停机
		String izi = (String)map.get(ControlVariableConstant.损失修正符_IZI);
		if(izi!=null && !"0".equals(izi)){
			row++;
			arrayString = spliteRow(list.get(row),4);
			map.put(ControlVariableConstant.损失校正系数ALN, arrayString[0]);
			map.put(ControlVariableConstant.ALW, arrayString[1]);
			map.put(ControlVariableConstant.PKN, arrayString[2]);
			map.put(ControlVariableConstant.PKW, arrayString[3]);
		}
		
		//#5:IREG,IHAR─如K=1 ;不输 IREG─=1 特性计算考虑静叶可调，输入调节角度，=0 不考虑;IHAR─把两个特性画在一张图上，无此功能，写0
		String k = (String)map.get(ControlVariableConstant.解题类型_K);
		if(k!=null && !"1".equals(k)){
			row++;
			arrayString = spliteRow(list.get(row),2);
			map.put(ControlVariableConstant.静叶可调_IREG, arrayString[0]);
			map.put(ControlVariableConstant.两特性同图IHAR, arrayString[1]);
		}
		
		//#6:IZX,IDX,IPE,IFH,INZ─将一维结果转成二维输入数据文件的控制符
		row++;
		arrayString = spliteRow(list.get(row),5);
		map.put(ControlVariableConstant.流路转换_IZX, arrayString[0]);
		map.put(ControlVariableConstant.叶排轴向长度缩放_IDX, arrayString[1]);
		map.put(ControlVariableConstant.性能参数分布_IPE, arrayString[2]);
		map.put(ControlVariableConstant.叶型参数分布_IFH, arrayString[3]);
		map.put(ControlVariableConstant.叶排内设站_INZ, arrayString[4]);
		
		return row;
	}
	
	public static int parseDesignProblem(Map<String,Object> map,List<String> list,int row){
		String[] arrayString = null;
		List<List<String>> grid = null;
		List<String> rowList = null;
		//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV─13 个总参数
		row++;
		arrayString = spliteRow(list.get(row),13);
		map.put(DesignProblemConstant.转速或第一级转子叶尖切线速度RPM, arrayString[0]);
		map.put(DesignProblemConstant.总压比PR, arrayString[1]);
		map.put(DesignProblemConstant.流量G, arrayString[2]);
		map.put(DesignProblemConstant.进口总压PO, arrayString[3]);
		map.put(DesignProblemConstant.进口总温TO, arrayString[4]);
		map.put(DesignProblemConstant.绝热效率EFF, arrayString[5]);
		map.put(DesignProblemConstant.逐级递减值DKH, arrayString[6]);
		map.put(DesignProblemConstant.级数ISTAGE, arrayString[7]);
		map.put(DesignProblemConstant.流路输入标识KPATH, arrayString[8]);
		map.put(DesignProblemConstant.叶型标识KF, arrayString[9]);
		map.put(DesignProblemConstant.压气机类型KC, arrayString[10]);
		map.put(DesignProblemConstant.进口段总压恢复SIGO, arrayString[11]);
		map.put(DesignProblemConstant.进口导叶总压恢复SIGV, arrayString[12]);
		
		//#2:DT1，D1，DH1，DTC，DMC，DHC，DTK，DFF，DHK─给定流路的9 个直径值
		row++;
		grid = new ArrayList<List<String>>();
		arrayString = spliteRow(list.get(row),9);
		rowList = new ArrayList<String>();
		for(String colDate :arrayString){
			rowList.add(colDate);
		}
		grid.add(rowList);
		map.put("DesignProblemGrid1", grid);
		
		//#3A:DRT1(1:ISTAGE)，DCTK─KPATH=1 输入，否则不输;DRT1─各级转子进口外径;DCTK─压气机出口外径
		//#3B:DRM1(1:ISTAGE)，DCMK─KPATH=2 时输入，否则不输;DRM1─各级转子进口平均直径，m;DCMK─压气机出口平均直径，m
		//#3C:DRH1(1:ISTAGE)，DCHK,KPATH=3 输入，否则不输;DRH1─各级转子进口内径，m;DCHK─压气机出口内径，m
		String kpath = (String)map.get(DesignProblemConstant.流路输入标识KPATH);
		if(kpath!=null && !"0".equals(kpath)){
			row++;
			int ISTAGE = 0;
			try {
				ISTAGE = Integer.parseInt((String)map.get(DesignProblemConstant.级数ISTAGE));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			arrayString = spliteRow(list.get(row),ISTAGE+1);
			grid = new ArrayList<List<String>>();
			rowList = new ArrayList<String>();
			
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			if("1".equals(kpath)){
				map.put(DesignProblemConstant.压气机出口外径DCTK, arrayString[ISTAGE]);
				map.put("DesignProblemDRT1Grid", grid);
			}else if("2".equals(kpath)){
				map.put(DesignProblemConstant.压气机出口平均直径DCMK, arrayString[ISTAGE]);
				map.put("DesignProblemDRM1Grid", grid);
			}else if("3".equals(kpath)){
				map.put(DesignProblemConstant.压气机出口内径DCHK, arrayString[ISTAGE]);
				map.put("DesignProblemDRH1Grid", grid);
			}
		}
		
		//#6:VA1，VAM，VAC，ALF1，OMGN，DOMG，HZ1，HZM，HZK,KH1,DKH，KHMIN ─12 个气动参数
		row++;
		arrayString = spliteRow(list.get(row),12);
		map.put(DesignProblemConstant.一级进轴速度VA1, arrayString[0]);
		map.put(DesignProblemConstant.中段轴速度VAM, arrayString[1]);
		map.put(DesignProblemConstant.出口轴速VAC, arrayString[2]);
		map.put(DesignProblemConstant.一转进气流角ALF1, arrayString[3]);
		map.put(DesignProblemConstant.第中级反力度OMGN, arrayString[4]);
		map.put(DesignProblemConstant.第中级后反力度增量DOMG, arrayString[5]);
		map.put(DesignProblemConstant.第一级HZ1, arrayString[6]);
		map.put(DesignProblemConstant.平均级HZM, arrayString[7]);
		map.put(DesignProblemConstant.最后级HZK, arrayString[8]);
		map.put(DesignProblemConstant.第一级KH1, arrayString[9]);
		map.put(DesignProblemConstant.逐级递减值DKH, arrayString[10]);
		map.put(DesignProblemConstant.最小值KHMIN, arrayString[11]);
		
		
		//#7:KG，ASP1，ASPK，ABV，ABR，ABS，BTHV，ASPV，BTV，DH0，DT0，BTH1─12 个几何参数
		row++;
		arrayString = spliteRow(list.get(row),12);
		map.put(DesignProblemConstant.流量缩放系数KG, arrayString[0]);
		map.put(DesignProblemConstant.一转展弦比ASP1, arrayString[1]);
		map.put(DesignProblemConstant.末转展弦比ASPK, arrayString[2]);
		map.put(DesignProblemConstant.进口导叶ABV, arrayString[3]);
		map.put(DesignProblemConstant.转子叶片ABR, arrayString[4]);
		map.put(DesignProblemConstant.静子叶片ABS, arrayString[5]);
		map.put(DesignProblemConstant.尖根弦长比BTHV, arrayString[6]);
		map.put(DesignProblemConstant.展弦比ASPV, arrayString[7]);
		map.put(DesignProblemConstant.稠度BTV, arrayString[8]);
		map.put(DesignProblemConstant.出口内直径DHO, arrayString[9]);
		map.put(DesignProblemConstant.出口外直径DTO, arrayString[10]);
		map.put(DesignProblemConstant.一转尖根弦长比BTH1, arrayString[11]);
		
		//#8:E1，DE，CMV，DENR，DENS，DENB，DRES，ALFK，PR0─9 个参数
		row++;
		arrayString = spliteRow(list.get(row),12);
		map.put(DesignProblemConstant.第一级E1, arrayString[0]);
		map.put(DesignProblemConstant.最后级与第一级差DE, arrayString[1]);
		map.put(DesignProblemConstant.进口导叶最大相对厚度CMV, arrayString[2]);
		map.put(DesignProblemConstant.转件DENR, arrayString[3]);
		map.put(DesignProblemConstant.静件DENS, arrayString[4]);
		map.put(DesignProblemConstant.叶片DENB, arrayString[5]);
		map.put(DesignProblemConstant.转子根许用应力DRES, arrayString[6]);
		map.put(DesignProblemConstant.最后静子出口气流角ALFK, arrayString[7]);
		map.put(DesignProblemConstant.本压气机前已有压比PRO, arrayString[8]);

		//#9:HORDA─最小弦长，m
		row++;
		map.put(DesignProblemConstant.最小弦长HORDA, list.get(row));
		
		return row;
	}
	
	public static int parseCheckQuestion(Map<String,Object> map,List<String> list,int row){
		String[] arrayString = null;
		List<List<String>> grid1 = null;
		List<List<String>> grid2 = null;
		List<String> rowList = null;
		//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV─13 个总参数
		row++;
		arrayString = spliteRow(list.get(row),13);
		map.put(CheckQuestion1Constant.转速度或第一级转子叶尖切线速度_RPM, arrayString[0]);
		map.put(CheckQuestion1Constant.总压比_PR, arrayString[1]);
		map.put(CheckQuestion1Constant.流量_G, arrayString[2]);
		map.put(CheckQuestion1Constant.进口总压_PO, arrayString[3]);
		map.put(CheckQuestion1Constant.进口总温_TO, arrayString[4]);
		map.put(CheckQuestion1Constant.绝热效率_EFF, arrayString[5]);
		map.put(CheckQuestion1Constant.功率存储系数KH, arrayString[6]);
		map.put(CheckQuestion1Constant.级数_ISTAGE, arrayString[7]);
		map.put(CheckQuestion1Constant.流路输入标识KPATH, arrayString[8]);
		map.put(CheckQuestion1Constant.叶型标识KF, arrayString[9]);
		map.put(CheckQuestion1Constant.压气机类型KC, arrayString[10]);
		map.put(CheckQuestion1Constant.进口段总压回复SIGO, arrayString[11]);
		map.put(CheckQuestion1Constant.进口导叶总压回复SIGV, arrayString[12]);
		
		//准备工作,初始化两个grid,级数
		grid1 = new ArrayList<List<String>>();
		grid2 = new ArrayList<List<String>>();
		
		int ISTAGE = 0;
		try {
			ISTAGE = Integer.parseInt((String)map.get(CheckQuestion1Constant.级数_ISTAGE));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		//#2:DT1(1:ISTAGE),DTK─外径，m
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE+1);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		map.put(CheckQuestion1Constant.外径DTK, arrayString[ISTAGE]);
		
		//#3:DH1(1:ISTAGE),DHK─内径，m
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE+1);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		map.put(CheckQuestion1Constant.内径DHK, arrayString[ISTAGE]);
		
		//#4:DT2(1:ISTAGE)─各级转子出口外径
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#5:DH2(1:ISTAGE)─各级转子出口内径
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#6:HZ(1:ISTAGE)─各级加功因子
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#7:CMXR(1:ISTAGE)─各级转子叶片最大相对厚度，如未知可写0.0，由程序定
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#8:CMXS(1:ISTAGE)─各级静子叶片最大相对厚度，如未知可写0.0，由程序定
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#9:BTR(1:ISTAGE)─各级转子稠度，=0.0 由程序定
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#10:BTS(1:ISTAGE)─各级静子稠度，=0.0 由程序定
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#11:ALF(1:ISTAGE+1)─各级转子进口及压气机出口绝对气流角
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE+1);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE+1;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#12:KGI(1:ISTAGE)─各级流量储备系数，如各级为常值写0.0
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#13:IZR 或ASPR(1:ISTAGE)─各级转子叶片数或展弦比;如前输稠度BTR，此处输叶片数；如前写BTR=0，此处输展弦比。后者优选
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#14:IZS 或ASPS(1:ISTAGE)─各级静子叶片数或展弦比;如前输稠度BTS，此处输叶片数；如前写BTS=0，此处输展弦比。后者优选
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#15:ABR(1:ISTAGE)─各级转子叶片最大挠度相对位置，如各级相同则写0.0
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#16:ABS(1:ISTAGE)─各级静子叶片最大挠度相对位置，如各级相同则写0.0
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#17:KHI(1:ISTAGE)─各级理论功储备系数，如沿流路各级递减量为常值则此值写0.0
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		map.put("CheckQuestion2Panel.grid1", GridDataUtil.transform(grid1));
		map.put("CheckQuestion3Panel.grid1", GridDataUtil.transform(grid2));
		
		//#18:ALF0─第一级转子前绝对气流角
		row++;
		map.put(CheckQuestion1Constant.一转进气流角ALFO, list.get(row));
		
		//#19:KH1，DKH，KHMIN─如已输入KHI 值，此三量均写0.0
		row++;
		arrayString = spliteRow(list.get(row),3);
		map.put(CheckQuestion1Constant.第一级KH1, arrayString[0]);
		map.put(CheckQuestion1Constant.逐级递减DKH, arrayString[1]);
		map.put(CheckQuestion1Constant.最小值KHMIN, arrayString[2]);
		
		//#20:KG，FF，FF，ABV，ABR，ABS，BTHV，ASPV，BTV，DH0，DT0，BTH1─12 个结构参数
		row++;
		arrayString = spliteRow(list.get(row),12);
		map.put(CheckQuestion1Constant.流量缩放系数KG, arrayString[0]);
		map.put(CheckQuestion1Constant.一转展旋比ASP1, arrayString[1]);
		map.put(CheckQuestion1Constant.最后级展旋比ASPK, arrayString[2]);
		map.put(CheckQuestion1Constant.进口导叶ABV, arrayString[3]);
		map.put(CheckQuestion1Constant.转子叶片ABR, arrayString[4]);
		map.put(CheckQuestion1Constant.静子叶片ABS, arrayString[5]);
		map.put(CheckQuestion1Constant.尖根弦长比BTHV, arrayString[6]);
		map.put(CheckQuestion1Constant.展弦比ASPV, arrayString[7]);
		map.put(CheckQuestion1Constant.稠度BTV, arrayString[8]);
		map.put(CheckQuestion1Constant.出口内直径DHO, arrayString[9]);
		map.put(CheckQuestion1Constant.出口外直径DTO, arrayString[10]);
		map.put(CheckQuestion1Constant.一转尖根弦长比BTH1, arrayString[11]);
		
		//#21:E1，DE，CMV，DENR，DENS,DENB，DRES，ALFK，PR0─9 个参数
		row++;
		arrayString = spliteRow(list.get(row),9);
		map.put(CheckQuestion1Constant.第一级E1, arrayString[0]);
		map.put(CheckQuestion1Constant.最后级与第一级差DE, arrayString[1]);
		map.put(CheckQuestion1Constant.进口导叶最大相对厚度CMV, arrayString[2]);
		map.put(CheckQuestion1Constant.转件DENR, arrayString[3]);
		map.put(CheckQuestion1Constant.静件DENS, arrayString[4]);
		map.put(CheckQuestion1Constant.叶片DENB, arrayString[5]);
		map.put(CheckQuestion1Constant.转子根许用应力DRES, arrayString[6]);
		map.put(CheckQuestion1Constant.最后静子出口气流角ALFK, arrayString[7]);
		map.put(CheckQuestion1Constant.本气压机前已有压比PRO, arrayString[8]);
		
		//#22:HORDA─最小弦长，m
		row++;
		map.put(CheckQuestion1Constant.最小弦比HORDA, list.get(row));
		
		return row;
	}
	
	public static int parseFeaturesCalculate(Map<String,Object> map,List<String> list,int row){
		String[] arrayString = null;
		List<List<String>> grid = null;
		List<String> rowList = null;
		//#1:N─等转速线条数
		row++;
		map.put(FeaturesCalculateConstant.等转速条线数N,list.get(row));
		
		//#2:R，K，DQ,EQ，ESIG
		row++;
		arrayString = spliteRow(list.get(row),5);
		map.put(FeaturesCalculateConstant.气体常数R, arrayString[0]);
		map.put(FeaturesCalculateConstant.绝热指数K, arrayString[1]);
		map.put(FeaturesCalculateConstant.状态点间隔DQ, arrayString[2]);
		map.put(FeaturesCalculateConstant.垂直段误差精度Q值EQ, arrayString[3]);
		map.put(FeaturesCalculateConstant.总压系数ESIG, arrayString[4]);

		//#3:KGKA─控制以下6 组数据输入
		//=0 使用程序标准值，#4~#9 不再输入
		//=1 在下面自行输入,但全输0.0 也釆用程序中标准值
		row++;
		map.put(FeaturesCalculateConstant.控制参数KGKA,list.get(row));
		
		String kgka = String.valueOf(map.get(FeaturesCalculateConstant.控制参数KGKA));
		if("1".equals(kgka)){
			grid = new ArrayList<List<String>>();
			
			int ISTAGE = 0;
			try {
				ISTAGE = Integer.parseInt((String)map.get(CheckQuestion1Constant.级数_ISTAGE));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			//#4:DIR(1:ISTAGE)─各亚音转子攻角的修正值
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#5:KPR(1:ISTAGE)─各级流量-压比特性线斜率变化系数
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#6:FAIR(1:STAGE)─各级转子（失速）负荷判据，推荐1.3-0.82
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#7:DIS(1:ISTAGE)─各亚音静子攻角的修正值
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#8:AGR(1:ISTAGE)─各级转子槽道喉部面积修正系数
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#9:AGS(1:ISTAGE)─各级静子槽道喉部面积修正系数
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			map.put("FeaturesCalculate2Panel.grid1",grid);
		}
		
		//#10:IGKA─控制以下4 组数据输入
		//=0 使用程序标准值，#11~#14 不再输入
		//=1 在下面自行输入
		row++;
		map.put(FeaturesCalculateConstant.控制参数IGKA,list.get(row));
		
		String igka = String.valueOf(map.get(FeaturesCalculateConstant.控制参数IGKA));
		if("1".equals(kgka)){
			grid = new ArrayList<List<String>>();
			
			int ISTAGE = 0;
			try {
				ISTAGE = Integer.parseInt((String)map.get(CheckQuestion1Constant.级数_ISTAGE));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			//#11:KD(1:ISTAGE)─各级落后角补偿系数
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#12:KGB(1:ISTAGE)─各级流量堵塞系数
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#13:KHS(1:ISTAGE)─各级理论功储备系数
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#14:KEF(1:ISTAGE)─各级最大效率衰减系数
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			map.put("FeaturesCalculate3Panel.grid1",grid);
		}
		
		//#15:IVAR1─控制相对转速和q(λ)初值输入
		//=0，按程序设定（n=0.7，0.8，0.9，1.0)
		//=1，自行输入#16
		row++;
		map.put(FeaturesCalculateConstant.转速和状态点控制IVAR1,list.get(row));
		
		String ivar1 = String.valueOf(map.get(FeaturesCalculateConstant.转速和状态点控制IVAR1));
		int n = 0;
		try {
			n = Integer.parseInt(String.valueOf(map.get(FeaturesCalculateConstant.等转速条线数N)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if("1".equals(ivar1)){
			//#16:NR，QL(1:N)─各特性线相对转速和q(λ)初值
			grid = new ArrayList<List<String>>();
			for(int i=0;i<n;i++){
				row++;
				arrayString = spliteRow(list.get(row),2);
				rowList = new ArrayList<String>();
				for(String colData:arrayString){
					rowList.add(colData);
				}
				grid.add(rowList);
			}
			
			map.put("FeaturesCalculate1Panel.grid1",GridDataUtil.transform(grid));
		}
		
		//#17:IQP，IZAP，LSR，KPAH1，KPAH2─5 个控制参数
		row++;
		arrayString = spliteRow(list.get(row),5);
		map.put(FeaturesCalculateConstant.状态点计算控制IQP, arrayString[0]);
		map.put(FeaturesCalculateConstant.搜索共同工作点IZAP, arrayString[1]);
		map.put(FeaturesCalculateConstant.共同工作线给定LSR, arrayString[2]);
		map.put(FeaturesCalculateConstant.堵点失速点输出KPATH1, arrayString[3]);
		map.put(FeaturesCalculateConstant.计算结果输出KPATH2, arrayString[4]);
		
		//#18:KG，DSIG，SM，EPR，PR2，PRB─6 个性能参数
		row++;
		arrayString = spliteRow(list.get(row),6);
		map.put(FeaturesCalculateConstant.流量储备系数KG, arrayString[0]);
		map.put(FeaturesCalculateConstant.总压恢复步长DSIG, arrayString[1]);
		map.put(FeaturesCalculateConstant.喘振裕度SM, arrayString[2]);
		map.put(FeaturesCalculateConstant.压比收敛精度EPR, arrayString[3]);
		map.put(FeaturesCalculateConstant.垂直段单点压比PR2, arrayString[4]);
		map.put(FeaturesCalculateConstant.上起点压比与最小压比之比PRB, arrayString[5]);
		
		//#19:NNS，NNF，IIS，IIF，QQS，QQF─6 个限定作部分特性计算的参数
		row++;
		arrayString = spliteRow(list.get(row),6);
		map.put(FeaturesCalculateConstant.转速线起始NNS, arrayString[0]);
		map.put(FeaturesCalculateConstant.终止NNF, arrayString[1]);
		map.put(FeaturesCalculateConstant.计算级起始IIS, arrayString[2]);
		map.put(FeaturesCalculateConstant.终止IIF, arrayString[3]);
		map.put(FeaturesCalculateConstant.Qλ限制最小值QQS, arrayString[4]);
		map.put(FeaturesCalculateConstant.最大值QQF, arrayString[5]);
		
		//准备工作
		int lsr = 0;
		try {
			lsr = Integer.parseInt(String.valueOf(map.get(FeaturesCalculateConstant.共同工作线给定LSR)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if(lsr!=0){
			grid = new ArrayList<List<String>>();
			//#20:LSR≠0 由低向高输入L 点的共同工作线，2≤L≤10。LSR=0 不输。
			//GCOR(1:L)─换算流量
			row++;
			arrayString = spliteRow(list.get(row),lsr);
			rowList = new ArrayList<String>();
			for(int i=0;i<lsr;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//PRW(1:L)─压比
			row++;
			arrayString = spliteRow(list.get(row),lsr);
			rowList = new ArrayList<String>();
			for(int i=0;i<lsr;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			map.put("FeaturesCalculate1Panel.grid2",grid);
		}
		
		String ireg = String.valueOf(map.get(ControlVariableConstant.静叶可调_IREG));
		if("1".equals(ireg)){
			grid = new ArrayList<List<String>>();
			
			int ISTAGE = 0;
			try {
				ISTAGE = Integer.parseInt((String)map.get(CheckQuestion1Constant.级数_ISTAGE));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			//#21:DALF(N,ISTAGE+1)─主程序中IREG=1 时输入静子调节角度。
			for(int i=0;i<n;i++){
				row++;
				arrayString = spliteRow(list.get(row),ISTAGE+1);
				rowList = new ArrayList<String>();
				for(String colData:arrayString){
					rowList.add(colData);
				}
				grid.add(rowList);
			}
			map.put("FeaturesCalculate1Panel.grid3",grid);
		}
		
		return row;
	}

	public static int parseAspectRatioCalculate(Map<String,Object> map,List<String> list,int row){
		String[] arrayString = null;
		List<List<String>> grid = null;
		List<String> rowList = null;
		//#1:NCU─输入各转速喘振裕度SM 的标识
		row++;
		map.put(AspectRatioCalculateConstant.喘振裕度输入NCU, list.get(row));
		
		String ncu = String.valueOf(map.get(AspectRatioCalculateConstant.喘振裕度输入NCU));
		if("3".equals(ncu)){
			grid = new ArrayList<List<String>>();
			
			//#2:SMI(1:N)─各转速要求的喘振裕度
			row++;
			arrayString = spliteRow(list.get(row),4);
			rowList = new ArrayList<String>();
			for(String colData:arrayString){
				rowList.add(colData);
			}
			grid.add(rowList);
			
			map.put("AspectRatioCalculatePanel.grid1",grid);
		}
		return row;
	}
	
	public static Map<String,Object> parse1D_in1(List<String> list){
		Map<String,Object> result = new HashMap<String,Object>();
		
		int row = 0;
		//作业题目
		result.put(ControlVariableConstant.作业题目_TITLT, list.get(row));
		
		//控制变量
		row = parseControlVariable(result,list,row);

		String k12 = String.valueOf(result.get(ControlVariableConstant.检查或设计_K12));
		if("1".equals(k12)){
			//设计问题
			row = parseDesignProblem(result,list,row);
		}
			
		//检查问题
		row = parseCheckQuestion(result,list,row);
		
		//特性计算
		row = parseFeaturesCalculate(result,list,row);
		
		//展弦比计算
		row = parseAspectRatioCalculate(result,list,row);
		
		return result;
	}
	
	public static Map<String,Object> parse1D_in1(){
		List<String> datas = readFile();
		Map<String,Object> result = parse1D_in1(datas);
		
		return result;
	}
}

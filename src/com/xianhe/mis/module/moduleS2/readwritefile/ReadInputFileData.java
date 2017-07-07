package com.xianhe.mis.module.moduleS2.readwritefile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xianhe.mis.module.ReadDataFile;
import com.xianhe.mis.module.module1D.constant.CheckQuestionConstant;
import com.xianhe.mis.module.moduleS2.constant.ControlVariableConstant;

public class ReadInputFileData extends ReadDataFile{
	public static void main(String[] args) {
		Map<String,Object> map = parseS2_in("/S2/S2_in");
		System.out.println(map);
	}
	public static Map<String,Object> parseS2_in(String path){
		List<String> datas = ReadInputFileData.readFile(path);
		return parseS2_in(datas);
	}
	
	public static Map<String,Object> parseS2_in(List<String> list){
		Map<String,Object> result = new HashMap<String,Object>();
		String[] arrayString = null;
		List<List<String>> grid = null;
		int row = 0;
		
		result.put(ControlVariableConstant.TITLE��Ŀ, list.get(row));
		
		row++;
		arrayString = spliteRow(list.get(row),6,12);
		result.put(ControlVariableConstant.TETAO��˳ϵ��, arrayString[0]);
		result.put(ControlVariableConstant.NPRK��˳����, arrayString[1]);
		result.put(ControlVariableConstant.KPR����ӡ, arrayString[2]);
		result.put(ControlVariableConstant.JDK����ǰվ��, arrayString[3]);
		result.put(ControlVariableConstant.NPR��������, arrayString[4]);
		result.put(ControlVariableConstant.PROD�����������, arrayString[5]);
		result.put(ControlVariableConstant.G��������, arrayString[6]);
		result.put(ControlVariableConstant.K����ָ��, arrayString[7]);
		result.put(ControlVariableConstant.R���峣��, arrayString[8]);
		result.put(ControlVariableConstant.TETAO��˳ϵ��, arrayString[9]);
		result.put(ControlVariableConstant.NPRK��˳����, arrayString[10]);
		result.put(ControlVariableConstant.KPR����ӡ, arrayString[11]);
		
		row++;
		arrayString = spliteRow(list.get(row),6,12);
		int n= (int)Double.parseDouble(arrayString[6].trim());
		//logger.info(n);
		
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
		
		
		int count = 0;
		List<List<String>> grid1 = new ArrayList<List<String>>();
		List<String> line = new ArrayList<String>();
		while(count<n){
			row++;
			List<String> cols = spliteRowByWidth(list.get(row),6);
			line.addAll(cols);
			count += cols.size();
		}
		grid1.add(line);
		//logger.info(line);

		count = 0;
		line = new ArrayList<String>();
		while(count<n){
			row++;
			List<String> cols = spliteRowByWidth(list.get(row),6);
			line.addAll(cols);
			count += cols.size();
		}
		grid1.add(line);
		//logger.info(line);
		
		row++;
		
		count = 0;
		line = new ArrayList<String>();
		while(count<n){
			row++;
			List<String> cols = spliteRowByWidth(list.get(row),6);
			line.addAll(cols);
			count += cols.size();
		}
		grid1.add(line);
		//logger.info(line);
		
		count = 0;
		line = new ArrayList<String>();
		while(count<n){
			row++;
			List<String> cols = spliteRowByWidth(list.get(row),6);
			line.addAll(cols);
			count += cols.size();
		}
		grid1.add(line);
		//logger.info(line);
		
		//logger.info(grid1);
		result.put("grid1", grid1);
		return result;
	}
}

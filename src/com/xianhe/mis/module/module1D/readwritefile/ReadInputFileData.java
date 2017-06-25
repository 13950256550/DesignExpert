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
import com.xianhe.mis.module.module1D.constant.CheckQuestionConstant;
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
		
		//���Ʊ���
		int row = 0;
		result.put(ControlVariableConstant.��ҵ��Ŀ_TITLT, list.get(row));
		
		row++;
		String[] arrayString = list.get(row).split(" ");
		if(arrayString.length==2){
			result.put(ControlVariableConstant.��ѹ������_IRE, arrayString[0]);
			result.put(ControlVariableConstant.�������_NV, arrayString[1]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
		}
		
		row++;
		result.put(ControlVariableConstant.��������_K, list.get(row));
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==2){
			result.put(ControlVariableConstant.�������_K12, arrayString[0]);
			result.put(ControlVariableConstant.��ʧ������_IZI, arrayString[1]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==2){
			result.put(ControlVariableConstant.��Ҷ�ɵ�_IREG, arrayString[0]);
			result.put(ControlVariableConstant.������ͬͼIHAR, arrayString[1]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==5){
			result.put(ControlVariableConstant.��·ת��_IZX, arrayString[0]);
			result.put(ControlVariableConstant.Ҷ�����򳤶�����_IDX, arrayString[1]);
			result.put(ControlVariableConstant.���ܲ����ֲ�_IPE, arrayString[2]);
			result.put(ControlVariableConstant.Ҷ�Ͳ����ֲ�_IFH, arrayString[3]);
			result.put(ControlVariableConstant.Ҷ������վ_INZ, arrayString[4]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
		}
		
		//�������
		
		//�������(1)
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==13){
			result.put(CheckQuestionConstant.RPMת�ٶȻ��һ��ת��Ҷ�������ٶ�, arrayString[0]);
			result.put(CheckQuestionConstant.PR��ѹ��, arrayString[1]);
			result.put(CheckQuestionConstant.G����, arrayString[2]);
			result.put(CheckQuestionConstant.PO������ѹ, arrayString[3]);
			result.put(CheckQuestionConstant.TO��������, arrayString[4]);
			result.put(CheckQuestionConstant.EFF����Ч��, arrayString[5]);
			result.put(CheckQuestionConstant.KH���ʴ洢ϵ��, arrayString[6]);
			result.put(CheckQuestionConstant.ISTAGE����, arrayString[7]);
			result.put(CheckQuestionConstant.KPATH��·�����ʶ, arrayString[8]);
			result.put(CheckQuestionConstant.KFҶ�ͱ�ʶ, arrayString[9]);
			result.put(CheckQuestionConstant.KCѹ��������, arrayString[10]);
			result.put(CheckQuestionConstant.SIGO���ڶ���ѹ�ظ�, arrayString[11]);
			result.put(CheckQuestionConstant.SIGV���ڵ�Ҷ��ѹ�ظ�, arrayString[12]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		result.put(CheckQuestionConstant.DTK�⾶, arrayString[arrayString.length-1]);
		
		row++;
		arrayString = list.get(row).split(" ");
		result.put(CheckQuestionConstant.DHK�ھ�, arrayString[arrayString.length-1]);
		
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
		result.put(CheckQuestionConstant.ALFOһת��������, list.get(row));
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==3){
			result.put(CheckQuestionConstant.KH1��һ��, arrayString[0]);
			result.put(CheckQuestionConstant.DKH�𼶵ݼ�, arrayString[1]);
			result.put(CheckQuestionConstant.KHMIN��Сֵ, arrayString[2]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==12){
			result.put(CheckQuestionConstant.KG��������ϵ��, arrayString[0]);
			result.put(CheckQuestionConstant.ASP1һתչ����, arrayString[1]);
			result.put(CheckQuestionConstant.ASPK���չ����, arrayString[2]);
			result.put(CheckQuestionConstant.ABV���ڵ�Ҷ, arrayString[3]);
			result.put(CheckQuestionConstant.ABRת��ҶƬ, arrayString[4]);
			result.put(CheckQuestionConstant.ABS����ҶƬ, arrayString[5]);
			result.put(CheckQuestionConstant.BTHV����ҳ���, arrayString[6]);
			result.put(CheckQuestionConstant.ASPVչ�ұ�, arrayString[7]);
			result.put(CheckQuestionConstant.BTV���, arrayString[8]);
			result.put(CheckQuestionConstant.DHO������ֱ��, arrayString[9]);
			result.put(CheckQuestionConstant.DTO������ֱ��, arrayString[10]);
			result.put(CheckQuestionConstant.BTH1һת����ҳ���, arrayString[11]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==9){
			result.put(CheckQuestionConstant.E1��һ��, arrayString[0]);
			result.put(CheckQuestionConstant.DE������һ����, arrayString[1]);
			result.put(CheckQuestionConstant.CMV���ڵ�Ҷ�����Ժ��, arrayString[2]);
			result.put(CheckQuestionConstant.DENRת��, arrayString[3]);
			result.put(CheckQuestionConstant.DENS����, arrayString[4]);
			result.put(CheckQuestionConstant.DENBҶƬ, arrayString[5]);
			result.put(CheckQuestionConstant.DRESת�Ӹ�����Ӧ��, arrayString[6]);
			result.put(CheckQuestionConstant.ALFK����ӳ���������, arrayString[7]);
			result.put(CheckQuestionConstant.PRO����ѹ��ǰ����ѹ��, arrayString[8]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
		}
		
		row++;
		result.put(CheckQuestionConstant.HORDA��С�ұ�, list.get(row));
		
		//���Լ���1
		row++;
		result.put(FeaturesCalculateConstant.��ת��������N, list.get(row));
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==5){
			result.put(FeaturesCalculateConstant.���峣��R, arrayString[0]);
			result.put(FeaturesCalculateConstant.����ָ��K, arrayString[1]);
			result.put(FeaturesCalculateConstant.״̬����DQ, arrayString[2]);
			result.put(FeaturesCalculateConstant.��ֱ������QֵEQ, arrayString[3]);
			result.put(FeaturesCalculateConstant.��ѹϵ��ESIG, arrayString[4]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
		}
		
		row++;
		result.put(FeaturesCalculateConstant.���Ʋ���KGKA, list.get(row));
		
		row++;
		result.put(FeaturesCalculateConstant.���Ʋ���IGKA, list.get(row));
		
		row++;
		result.put(FeaturesCalculateConstant.ת�ٺ�״̬�����IVAR1, list.get(row));
		
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
			result.put(FeaturesCalculateConstant.״̬��������IQP, arrayString[0]);
			result.put(FeaturesCalculateConstant.������ͬ������IZAP, arrayString[1]);
			result.put(FeaturesCalculateConstant.��ͬ�����߸���LSR, arrayString[2]);
			result.put(FeaturesCalculateConstant.�µ�ʧ�ٵ����KPATH1, arrayString[3]);
			result.put(FeaturesCalculateConstant.���������KPATH2, arrayString[4]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==6){
			result.put(FeaturesCalculateConstant.��������ϵ��KG, arrayString[0]);
			result.put(FeaturesCalculateConstant.��ѹ�ָ�����DSIG, arrayString[1]);
			result.put(FeaturesCalculateConstant.����ԣ��SM, arrayString[2]);
			result.put(FeaturesCalculateConstant.ѹ����������EPR, arrayString[3]);
			result.put(FeaturesCalculateConstant.��ֱ�ε���ѹ��PR2, arrayString[4]);
			result.put(FeaturesCalculateConstant.�����ѹ������Сѹ��֮��PRB, arrayString[5]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
		}
		
		row++;
		arrayString = list.get(row).split(" ");
		if(arrayString.length==6){
			result.put(FeaturesCalculateConstant.ת������ʼNNS, arrayString[0]);
			result.put(FeaturesCalculateConstant.��ֹNNF, arrayString[1]);
			result.put(FeaturesCalculateConstant.���㼶��ʼIIS, arrayString[2]);
			result.put(FeaturesCalculateConstant.��ֹIIF, arrayString[3]);
			result.put(FeaturesCalculateConstant.Q��������СֵQQS, arrayString[4]);
			result.put(FeaturesCalculateConstant.���ֵQQF, arrayString[5]);
		}else{
			System.out.println(list.get(row));
			System.out.println("������"+row+"�б���,ϣ�������ֶΣ�ʵ��:"+arrayString.length);
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
		result.put(ZXBCalculateConstant.����ԣ������NCU, list.get(row));
		
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
		//���Ʊ���
		//#1:IRE,NV IRE������ѹ�����ĸ��� NV�����飨һ̨ѹ�����ɷּ������飩��������IRE>1 ��д0
		row++;
		arrayString = spliteRow(list.get(row),2);
		map.put(ControlVariableConstant.��ѹ������_IRE, arrayString[0]);
		map.put(ControlVariableConstant.�������_NV, arrayString[1]);
		
		//#2:K����ҵ���������
		row++;
		map.put(ControlVariableConstant.��������_K, list.get(row));
		
		//#3:K12,IZI�����K=2 ���� K12��=1 ��������⣬=2 �������� IZI����ʧ������־��=0 ��������=1 ����
		row++;
		arrayString = spliteRow(list.get(row),2);
		map.put(ControlVariableConstant.�������_K12, arrayString[0]);
		map.put(ControlVariableConstant.��ʧ������_IZI, arrayString[1]);
		
		//#4:ALN,ALW,PKN,PKW��IZI=0 ���� ��ʧУ��ϵ����ע�⣺ALN(��min)Ӧ����ALW����max),����ͣ��
		String izi = (String)map.get(ControlVariableConstant.��ʧ������_IZI);
		if(izi!=null && !"0".equals(izi)){
			row++;
			arrayString = spliteRow(list.get(row),4);
			map.put(ControlVariableConstant.��ʧУ��ϵ��ALN, arrayString[0]);
			map.put(ControlVariableConstant.ALW, arrayString[1]);
			map.put(ControlVariableConstant.PKN, arrayString[2]);
			map.put(ControlVariableConstant.PKW, arrayString[3]);
		}
		
		//#5:IREG,IHAR����K=1 ;���� IREG��=1 ���Լ��㿼�Ǿ�Ҷ�ɵ���������ڽǶȣ�=0 ������;IHAR�����������Ի���һ��ͼ�ϣ��޴˹��ܣ�д0
		String k = (String)map.get(ControlVariableConstant.��������_K);
		if(k!=null && !"1".equals(k)){
			row++;
			arrayString = spliteRow(list.get(row),2);
			map.put(ControlVariableConstant.��Ҷ�ɵ�_IREG, arrayString[0]);
			map.put(ControlVariableConstant.������ͬͼIHAR, arrayString[1]);
		}
		
		//#6:IZX,IDX,IPE,IFH,INZ����һά���ת�ɶ�ά���������ļ��Ŀ��Ʒ�
		row++;
		arrayString = spliteRow(list.get(row),5);
		map.put(ControlVariableConstant.��·ת��_IZX, arrayString[0]);
		map.put(ControlVariableConstant.Ҷ�����򳤶�����_IDX, arrayString[1]);
		map.put(ControlVariableConstant.���ܲ����ֲ�_IPE, arrayString[2]);
		map.put(ControlVariableConstant.Ҷ�Ͳ����ֲ�_IFH, arrayString[3]);
		map.put(ControlVariableConstant.Ҷ������վ_INZ, arrayString[4]);
		
		return row;
	}
	
	public static int parseDesignProblem(Map<String,Object> map,List<String> list,int row){
		String[] arrayString = null;
		List<List<String>> grid = null;
		List<String> rowList = null;
		//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV��13 ���ܲ���
		row++;
		arrayString = spliteRow(list.get(row),13);
		map.put(DesignProblemConstant.RPMת�ٻ��һ��ת��Ҷ�������ٶ�, arrayString[0]);
		map.put(DesignProblemConstant.PR��ѹ��, arrayString[1]);
		map.put(DesignProblemConstant.G����, arrayString[2]);
		map.put(DesignProblemConstant.PO������ѹ, arrayString[3]);
		map.put(DesignProblemConstant.TO��������, arrayString[4]);
		map.put(DesignProblemConstant.EFF����Ч��, arrayString[5]);
		map.put(DesignProblemConstant.DKH�𼶵ݼ�ֵ, arrayString[6]);
		map.put(DesignProblemConstant.ISTAGE����, arrayString[7]);
		map.put(DesignProblemConstant.KPATH��·�����ʶ, arrayString[8]);
		map.put(DesignProblemConstant.KFҶ�ͱ�ʶ, arrayString[9]);
		map.put(DesignProblemConstant.KCѹ��������, arrayString[10]);
		map.put(DesignProblemConstant.SIGO���ڶ���ѹ�ָ�, arrayString[11]);
		map.put(DesignProblemConstant.SIGV���ڵ�Ҷ��ѹ�ָ�, arrayString[12]);
		
		//#2:DT1��D1��DH1��DTC��DMC��DHC��DTK��DFF��DHK��������·��9 ��ֱ��ֵ
		row++;
		grid = new ArrayList<List<String>>();
		arrayString = spliteRow(list.get(row),9);
		rowList = new ArrayList<String>();
		for(String colDate :arrayString){
			rowList.add(colDate);
		}
		grid.add(rowList);
		map.put("DesignProblemGrid1", grid);
		
		//#3A:DRT1(1:ISTAGE)��DCTK��KPATH=1 ���룬������;DRT1������ת�ӽ����⾶;DCTK��ѹ���������⾶
		//#3B:DRM1(1:ISTAGE)��DCMK��KPATH=2 ʱ���룬������;DRM1������ת�ӽ���ƽ��ֱ����m;DCMK��ѹ��������ƽ��ֱ����m
		//#3C:DRH1(1:ISTAGE)��DCHK,KPATH=3 ���룬������;DRH1������ת�ӽ����ھ���m;DCHK��ѹ���������ھ���m
		String kpath = (String)map.get(DesignProblemConstant.KPATH��·�����ʶ);
		if(kpath!=null && !"0".equals(kpath)){
			row++;
			int ISTAGE = 0;
			try {
				ISTAGE = Integer.parseInt((String)map.get(DesignProblemConstant.ISTAGE����));
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
				map.put(DesignProblemConstant.DCTKѹ���������⾶, arrayString[ISTAGE]);
				map.put("DesignProblemDRT1Grid", grid);
			}else if("2".equals(kpath)){
				map.put(DesignProblemConstant.DCMKѹ��������ƽ��ֱ��, arrayString[ISTAGE]);
				map.put("DesignProblemDRM1Grid", grid);
			}else if("3".equals(kpath)){
				map.put(DesignProblemConstant.DCHKѹ���������ھ�, arrayString[ISTAGE]);
				map.put("DesignProblemDRH1Grid", grid);
			}
		}
		
		//#6:VA1��VAM��VAC��ALF1��OMGN��DOMG��HZ1��HZM��HZK,KH1,DKH��KHMIN ��12 ����������
		row++;
		arrayString = spliteRow(list.get(row),12);
		map.put(DesignProblemConstant.VA1һ�������ٶ�, arrayString[0]);
		map.put(DesignProblemConstant.VAM�ж����ٶ�, arrayString[1]);
		map.put(DesignProblemConstant.VAC��������, arrayString[2]);
		map.put(DesignProblemConstant.ALF1һת��������, arrayString[3]);
		map.put(DesignProblemConstant.OMGN���м�������, arrayString[4]);
		map.put(DesignProblemConstant.DOMG���м�����������, arrayString[5]);
		map.put(DesignProblemConstant.HZ1��һ��, arrayString[6]);
		map.put(DesignProblemConstant.HZMƽ����, arrayString[7]);
		map.put(DesignProblemConstant.HZK���, arrayString[8]);
		map.put(DesignProblemConstant.KH1��һ��, arrayString[9]);
		map.put(DesignProblemConstant.DKH�𼶵ݼ�ֵ, arrayString[10]);
		map.put(DesignProblemConstant.KHMIN��Сֵ, arrayString[11]);
		
		
		//#7:KG��ASP1��ASPK��ABV��ABR��ABS��BTHV��ASPV��BTV��DH0��DT0��BTH1��12 �����β���
		row++;
		arrayString = spliteRow(list.get(row),12);
		map.put(DesignProblemConstant.KG��������ϵ��, arrayString[0]);
		map.put(DesignProblemConstant.ASP1һתչ�ұ�, arrayString[1]);
		map.put(DesignProblemConstant.ASPKĩתչ�ұ�, arrayString[2]);
		map.put(DesignProblemConstant.ABV���ڵ�Ҷ, arrayString[3]);
		map.put(DesignProblemConstant.ABRת��ҶƬ, arrayString[4]);
		map.put(DesignProblemConstant.ABS����ҶƬ, arrayString[5]);
		map.put(DesignProblemConstant.BTHV����ҳ���, arrayString[6]);
		map.put(DesignProblemConstant.ASPVչ�ұ�, arrayString[7]);
		map.put(DesignProblemConstant.BTV���, arrayString[8]);
		map.put(DesignProblemConstant.DHO������ֱ��, arrayString[9]);
		map.put(DesignProblemConstant.DTO������ֱ��, arrayString[10]);
		map.put(DesignProblemConstant.BTH1һת����ҳ���, arrayString[11]);
		
		//#8:E1��DE��CMV��DENR��DENS��DENB��DRES��ALFK��PR0��9 ������
		row++;
		arrayString = spliteRow(list.get(row),12);
		map.put(DesignProblemConstant.E1��һ��, arrayString[0]);
		map.put(DesignProblemConstant.DE������һ����, arrayString[1]);
		map.put(DesignProblemConstant.CMV���ڵ�Ҷ�����Ժ��, arrayString[2]);
		map.put(DesignProblemConstant.DENRת��, arrayString[3]);
		map.put(DesignProblemConstant.DENS����, arrayString[4]);
		map.put(DesignProblemConstant.DENBҶƬ, arrayString[5]);
		map.put(DesignProblemConstant.DRESת�Ӹ�����Ӧ��, arrayString[6]);
		map.put(DesignProblemConstant.ALFK����ӳ���������, arrayString[7]);
		map.put(DesignProblemConstant.PRO��ѹ����ǰ����ѹ��, arrayString[8]);

		//#9:HORDA����С�ҳ���m
		row++;
		map.put(DesignProblemConstant.HORDA��С�ҳ�, list.get(row));
		
		return row;
	}
	
	public static int parseCheckQuestion(Map<String,Object> map,List<String> list,int row){
		String[] arrayString = null;
		List<List<String>> grid1 = null;
		List<List<String>> grid2 = null;
		List<String> rowList = null;
		//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV��13 ���ܲ���
		row++;
		arrayString = spliteRow(list.get(row),13);
		map.put(CheckQuestionConstant.RPMת�ٶȻ��һ��ת��Ҷ�������ٶ�, arrayString[0]);
		map.put(CheckQuestionConstant.PR��ѹ��, arrayString[1]);
		map.put(CheckQuestionConstant.G����, arrayString[2]);
		map.put(CheckQuestionConstant.PO������ѹ, arrayString[3]);
		map.put(CheckQuestionConstant.TO��������, arrayString[4]);
		map.put(CheckQuestionConstant.EFF����Ч��, arrayString[5]);
		map.put(CheckQuestionConstant.KH���ʴ洢ϵ��, arrayString[6]);
		map.put(CheckQuestionConstant.ISTAGE����, arrayString[7]);
		map.put(CheckQuestionConstant.KPATH��·�����ʶ, arrayString[8]);
		map.put(CheckQuestionConstant.KFҶ�ͱ�ʶ, arrayString[9]);
		map.put(CheckQuestionConstant.KCѹ��������, arrayString[10]);
		map.put(CheckQuestionConstant.SIGO���ڶ���ѹ�ظ�, arrayString[11]);
		map.put(CheckQuestionConstant.SIGV���ڵ�Ҷ��ѹ�ظ�, arrayString[12]);
		
		//׼������,��ʼ������grid,����
		grid1 = new ArrayList<List<String>>();
		grid2 = new ArrayList<List<String>>();
		
		int ISTAGE = 0;
		try {
			ISTAGE = Integer.parseInt((String)map.get(CheckQuestionConstant.ISTAGE����));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		//#2:DT1(1:ISTAGE),DTK���⾶��m
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE+1);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		map.put(CheckQuestionConstant.DTK�⾶, arrayString[ISTAGE]);
		
		//#3:DH1(1:ISTAGE),DHK���ھ���m
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE+1);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		map.put(CheckQuestionConstant.DHK�ھ�, arrayString[ISTAGE]);
		
		//#4:DT2(1:ISTAGE)������ת�ӳ����⾶
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#5:DH2(1:ISTAGE)������ת�ӳ����ھ�
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#6:HZ(1:ISTAGE)�������ӹ�����
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#7:CMXR(1:ISTAGE)������ת��ҶƬ�����Ժ�ȣ���δ֪��д0.0���ɳ���
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#8:CMXS(1:ISTAGE)����������ҶƬ�����Ժ�ȣ���δ֪��д0.0���ɳ���
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#9:BTR(1:ISTAGE)������ת�ӳ�ȣ�=0.0 �ɳ���
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#10:BTS(1:ISTAGE)���������ӳ�ȣ�=0.0 �ɳ���
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#11:ALF(1:ISTAGE+1)������ת�ӽ��ڼ�ѹ�������ھ���������
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE+1);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE+1;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#12:KGI(1:ISTAGE)��������������ϵ���������Ϊ��ֵд0.0
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid1.add(rowList);
		
		//#13:IZR ��ASPR(1:ISTAGE)������ת��ҶƬ����չ�ұ�;��ǰ����BTR���˴���ҶƬ������ǰдBTR=0���˴���չ�ұȡ�������ѡ
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#14:IZS ��ASPS(1:ISTAGE)����������ҶƬ����չ�ұ�;��ǰ����BTS���˴���ҶƬ������ǰдBTS=0���˴���չ�ұȡ�������ѡ
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#15:ABR(1:ISTAGE)������ת��ҶƬ����Ӷ����λ�ã��������ͬ��д0.0
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#16:ABS(1:ISTAGE)����������ҶƬ����Ӷ����λ�ã��������ͬ��д0.0
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		//#17:KHI(1:ISTAGE)���������۹�����ϵ����������·�����ݼ���Ϊ��ֵ���ֵд0.0
		row++;
		arrayString = spliteRow(list.get(row),ISTAGE);
		rowList = new ArrayList<String>();
		for(int i=0;i<ISTAGE;i++){
			rowList.add(arrayString[i]);
		}
		grid2.add(rowList);
		
		map.put("CheckQuestion2Panel.grid1", GridDataUtil.transform(grid1));
		map.put("CheckQuestion3Panel.grid1", GridDataUtil.transform(grid2));
		
		//#18:ALF0����һ��ת��ǰ����������
		row++;
		map.put(CheckQuestionConstant.ALFOһת��������, list.get(row));
		
		//#19:KH1��DKH��KHMIN����������KHI ֵ����������д0.0
		row++;
		arrayString = spliteRow(list.get(row),3);
		map.put(CheckQuestionConstant.KH1��һ��, arrayString[0]);
		map.put(CheckQuestionConstant.DKH�𼶵ݼ�, arrayString[1]);
		map.put(CheckQuestionConstant.KHMIN��Сֵ, arrayString[2]);
		
		//#20:KG��FF��FF��ABV��ABR��ABS��BTHV��ASPV��BTV��DH0��DT0��BTH1��12 ���ṹ����
		row++;
		arrayString = spliteRow(list.get(row),12);
		map.put(CheckQuestionConstant.KG��������ϵ��, arrayString[0]);
		map.put(CheckQuestionConstant.ASP1һתչ����, arrayString[1]);
		map.put(CheckQuestionConstant.ASPK���չ����, arrayString[2]);
		map.put(CheckQuestionConstant.ABV���ڵ�Ҷ, arrayString[3]);
		map.put(CheckQuestionConstant.ABRת��ҶƬ, arrayString[4]);
		map.put(CheckQuestionConstant.ABS����ҶƬ, arrayString[5]);
		map.put(CheckQuestionConstant.BTHV����ҳ���, arrayString[6]);
		map.put(CheckQuestionConstant.ASPVչ�ұ�, arrayString[7]);
		map.put(CheckQuestionConstant.BTV���, arrayString[8]);
		map.put(CheckQuestionConstant.DHO������ֱ��, arrayString[9]);
		map.put(CheckQuestionConstant.DTO������ֱ��, arrayString[10]);
		map.put(CheckQuestionConstant.BTH1һת����ҳ���, arrayString[11]);
		
		//#21:E1��DE��CMV��DENR��DENS,DENB��DRES��ALFK��PR0��9 ������
		row++;
		arrayString = spliteRow(list.get(row),9);
		map.put(CheckQuestionConstant.E1��һ��, arrayString[0]);
		map.put(CheckQuestionConstant.DE������һ����, arrayString[1]);
		map.put(CheckQuestionConstant.CMV���ڵ�Ҷ�����Ժ��, arrayString[2]);
		map.put(CheckQuestionConstant.DENRת��, arrayString[3]);
		map.put(CheckQuestionConstant.DENS����, arrayString[4]);
		map.put(CheckQuestionConstant.DENBҶƬ, arrayString[5]);
		map.put(CheckQuestionConstant.DRESת�Ӹ�����Ӧ��, arrayString[6]);
		map.put(CheckQuestionConstant.ALFK����ӳ���������, arrayString[7]);
		map.put(CheckQuestionConstant.PRO����ѹ��ǰ����ѹ��, arrayString[8]);
		
		//#22:HORDA����С�ҳ���m
		row++;
		map.put(CheckQuestionConstant.HORDA��С�ұ�, list.get(row));
		
		return row;
	}
	
	public static int parseFeaturesCalculate(Map<String,Object> map,List<String> list,int row){
		String[] arrayString = null;
		List<List<String>> grid = null;
		List<String> rowList = null;
		//#1:N����ת��������
		row++;
		map.put(FeaturesCalculateConstant.��ת��������N,list.get(row));
		
		//#2:R��K��DQ,EQ��ESIG
		row++;
		arrayString = spliteRow(list.get(row),5);
		map.put(FeaturesCalculateConstant.���峣��R, arrayString[0]);
		map.put(FeaturesCalculateConstant.����ָ��K, arrayString[1]);
		map.put(FeaturesCalculateConstant.״̬����DQ, arrayString[2]);
		map.put(FeaturesCalculateConstant.��ֱ������QֵEQ, arrayString[3]);
		map.put(FeaturesCalculateConstant.��ѹϵ��ESIG, arrayString[4]);

		//#3:KGKA����������6 ����������
		//=0 ʹ�ó����׼ֵ��#4~#9 ��������
		//=1 ��������������,��ȫ��0.0 Ҳ��ó����б�׼ֵ
		row++;
		map.put(FeaturesCalculateConstant.���Ʋ���KGKA,list.get(row));
		
		String kgka = String.valueOf(map.get(FeaturesCalculateConstant.���Ʋ���KGKA));
		if("1".equals(kgka)){
			grid = new ArrayList<List<String>>();
			
			int ISTAGE = 0;
			try {
				ISTAGE = Integer.parseInt((String)map.get(CheckQuestionConstant.ISTAGE����));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			//#4:DIR(1:ISTAGE)��������ת�ӹ��ǵ�����ֵ
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#5:KPR(1:ISTAGE)����������-ѹ��������б�ʱ仯ϵ��
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#6:FAIR(1:STAGE)������ת�ӣ�ʧ�٣������оݣ��Ƽ�1.3-0.82
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#7:DIS(1:ISTAGE)�����������ӹ��ǵ�����ֵ
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#8:AGR(1:ISTAGE)������ת�Ӳ۵����������ϵ��
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#9:AGS(1:ISTAGE)���������Ӳ۵����������ϵ��
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			map.put("FeaturesCalculate2Panel.grid1",GridDataUtil.transform(grid));
		}
		
		//#10:IGKA����������4 ����������
		//=0 ʹ�ó����׼ֵ��#11~#14 ��������
		//=1 ��������������
		row++;
		map.put(FeaturesCalculateConstant.���Ʋ���IGKA,list.get(row));
		
		String igka = String.valueOf(map.get(FeaturesCalculateConstant.���Ʋ���IGKA));
		if("1".equals(igka)){
			grid = new ArrayList<List<String>>();
			
			int ISTAGE = 0;
			try {
				ISTAGE = Integer.parseInt((String)map.get(CheckQuestionConstant.ISTAGE����));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			//#11:KD(1:ISTAGE)���������ǲ���ϵ��
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#12:KGB(1:ISTAGE)��������������ϵ��
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#13:KHS(1:ISTAGE)���������۹�����ϵ��
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//#14:KEF(1:ISTAGE)���������Ч��˥��ϵ��
			row++;
			arrayString = spliteRow(list.get(row),ISTAGE);
			rowList = new ArrayList<String>();
			for(int i=0;i<ISTAGE;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			map.put("FeaturesCalculate3Panel.grid1",GridDataUtil.transform(grid));
		}
		
		//#15:IVAR1���������ת�ٺ�q(��)��ֵ����
		//=0���������趨��n=0.7��0.8��0.9��1.0)
		//=1����������#16
		row++;
		map.put(FeaturesCalculateConstant.ת�ٺ�״̬�����IVAR1,list.get(row));
		
		String ivar1 = String.valueOf(map.get(FeaturesCalculateConstant.ת�ٺ�״̬�����IVAR1));
		int n = 0;
		try {
			n = Integer.parseInt(String.valueOf(map.get(FeaturesCalculateConstant.��ת��������N)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if("1".equals(ivar1)){
			//#16:NR��QL(1:N)�������������ת�ٺ�q(��)��ֵ
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
		
		//#17:IQP��IZAP��LSR��KPAH1��KPAH2��5 �����Ʋ���
		row++;
		arrayString = spliteRow(list.get(row),5);
		map.put(FeaturesCalculateConstant.״̬��������IQP, arrayString[0]);
		map.put(FeaturesCalculateConstant.������ͬ������IZAP, arrayString[1]);
		map.put(FeaturesCalculateConstant.��ͬ�����߸���LSR, arrayString[2]);
		map.put(FeaturesCalculateConstant.�µ�ʧ�ٵ����KPATH1, arrayString[3]);
		map.put(FeaturesCalculateConstant.���������KPATH2, arrayString[4]);
		
		//#18:KG��DSIG��SM��EPR��PR2��PRB��6 �����ܲ���
		row++;
		arrayString = spliteRow(list.get(row),6);
		map.put(FeaturesCalculateConstant.��������ϵ��KG, arrayString[0]);
		map.put(FeaturesCalculateConstant.��ѹ�ָ�����DSIG, arrayString[1]);
		map.put(FeaturesCalculateConstant.����ԣ��SM, arrayString[2]);
		map.put(FeaturesCalculateConstant.ѹ����������EPR, arrayString[3]);
		map.put(FeaturesCalculateConstant.��ֱ�ε���ѹ��PR2, arrayString[4]);
		map.put(FeaturesCalculateConstant.�����ѹ������Сѹ��֮��PRB, arrayString[5]);
		
		//#19:NNS��NNF��IIS��IIF��QQS��QQF��6 ���޶����������Լ���Ĳ���
		row++;
		arrayString = spliteRow(list.get(row),6);
		map.put(FeaturesCalculateConstant.ת������ʼNNS, arrayString[0]);
		map.put(FeaturesCalculateConstant.��ֹNNF, arrayString[1]);
		map.put(FeaturesCalculateConstant.���㼶��ʼIIS, arrayString[2]);
		map.put(FeaturesCalculateConstant.��ֹIIF, arrayString[3]);
		map.put(FeaturesCalculateConstant.Q��������СֵQQS, arrayString[4]);
		map.put(FeaturesCalculateConstant.���ֵQQF, arrayString[5]);
		
		//׼������
		int lsr = 0;
		try {
			lsr = Integer.parseInt(String.valueOf(map.get(FeaturesCalculateConstant.��ͬ�����߸���LSR)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if(lsr!=0){
			grid = new ArrayList<List<String>>();
			//#20:LSR��0 �ɵ��������L ��Ĺ�ͬ�����ߣ�2��L��10��LSR=0 ���䡣
			//GCOR(1:L)����������
			row++;
			arrayString = spliteRow(list.get(row),lsr);
			rowList = new ArrayList<String>();
			for(int i=0;i<lsr;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			//PRW(1:L)��ѹ��
			row++;
			arrayString = spliteRow(list.get(row),lsr);
			rowList = new ArrayList<String>();
			for(int i=0;i<lsr;i++){
				rowList.add(arrayString[i]);
			}
			grid.add(rowList);
			
			map.put("FeaturesCalculate1Panel.grid2",grid);
		}
		
		String ireg = String.valueOf(map.get(ControlVariableConstant.��Ҷ�ɵ�_IREG));
		if("1".equals(ireg)){
			grid = new ArrayList<List<String>>();
			
			int ISTAGE = 0;
			try {
				ISTAGE = Integer.parseInt((String)map.get(CheckQuestionConstant.ISTAGE����));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			//#21:DALF(N,ISTAGE+1)����������IREG=1 ʱ���뾲�ӵ��ڽǶȡ�
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
		//#1:NCU�������ת�ٴ���ԣ��SM �ı�ʶ
		row++;
		map.put(AspectRatioCalculateConstant.����ԣ������NCU, list.get(row));
		
		String ncu = String.valueOf(map.get(AspectRatioCalculateConstant.����ԣ������NCU));
		if("3".equals(ncu)){
			grid = new ArrayList<List<String>>();
			
			//#2:SMI(1:N)����ת��Ҫ��Ĵ���ԣ��
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
		//��ҵ��Ŀ
		result.put(ControlVariableConstant.��ҵ��Ŀ_TITLT, list.get(row));
		
		//���Ʊ���
		row = parseControlVariable(result,list,row);

		String k12 = String.valueOf(result.get(ControlVariableConstant.�������_K12));
		//1-������� 2-�������
		if("1".equals(k12)){
			//�������
			row = parseDesignProblem(result,list,row);
		}else if("2".equals(k12)){
			//�������
			row = parseCheckQuestion(result,list,row);
		}
		
		String k = String.valueOf(result.get(ControlVariableConstant.��������_K));
		//1-���+��� 2-���� 3-���+���+���� 4-���+���+����+չ�ұ�
		if("1".equals(k)){
			//���+���
		}else if("2".equals(k)){
			//���Լ���
		}else if("3".equals(k)){
			//���Լ���
			row = parseFeaturesCalculate(result,list,row);
		}else if("4".equals(k)){
			//���Լ���
			row = parseFeaturesCalculate(result,list,row);
			//չ�ұȼ���
			row = parseAspectRatioCalculate(result,list,row);
		}
		
		return result;
	}
	
	public static Map<String,Object> parse1D_in1(){
		List<String> datas = readFile();
		Map<String,Object> result = parse1D_in1(datas);
		
		return result;
	}
}

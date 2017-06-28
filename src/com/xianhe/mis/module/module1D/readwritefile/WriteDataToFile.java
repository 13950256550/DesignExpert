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
		
		sb.append(map.get(ControlVariableConstant.��ҵ��Ŀ_TITLT)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.��ѹ������_IRE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.�������_NV)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.��������_K)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.�������_K12)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.��ʧ������_IZI)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.��Ҷ�ɵ�_IREG)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.������ͬͼIHAR)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.��·ת��_IZX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.Ҷ�����򳤶�����_IDX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.���ܲ����ֲ�_IPE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.Ҷ�Ͳ����ֲ�_IFH)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.Ҷ������վ_INZ)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.RPMת�ٶȻ��һ��ת��Ҷ�������ٶ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PR��ѹ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.G����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PO������ѹ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.TO��������)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.EFF����Ч��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KH���ʴ洢ϵ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ISTAGE����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KPATH��·�����ʶ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KFҶ�ͱ�ʶ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KCѹ��������)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGO���ڶ���ѹ�ظ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGV���ڵ�Ҷ��ѹ�ظ�)).append(Constant.newLine);
		
		//sb.append(map.get(CheckQuestion1Constant.�⾶DTK)).append(Constant.newLine);
		//sb.append(map.get(CheckQuestion1Constant.�ھ�DHK)).append(Constant.newLine);
		
		writeGridToBuffer(sb,GridDataUtil.transform((List<List<String>>)map.get("grid1")));
		writeGridToBuffer(sb,GridDataUtil.transform((List<List<String>>)map.get("grid2")));
		
		sb.append(map.get(CheckQuestionConstant.ALFOһת��������)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.KH1��һ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DKH�𼶵ݼ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KHMIN��Сֵ)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.KG��������ϵ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASP1һתչ����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPK���չ����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABV���ڵ�Ҷ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABRת��ҶƬ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABS����ҶƬ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTHV����ҳ���)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPVչ�ұ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTV���)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DHO������ֱ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DTO������ֱ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTH1һת����ҳ���)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.E1��һ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DE������һ����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.CMV���ڵ�Ҷ�����Ժ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENRת��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENS����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENBҶƬ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DRESת�Ӹ�����Ӧ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ALFK����ӳ���������)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PRO����ѹ��ǰ����ѹ��)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.HORDA��С�ұ�)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.��ת��������N)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.���峣��R)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.����ָ��K)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.״̬����DQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֱ������QֵEQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ѹϵ��ESIG)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.���Ʋ���KGKA)).append(Constant.newLine);

		sb.append(map.get(FeaturesCalculateConstant.���Ʋ���IGKA)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.ת�ٺ�״̬�����IVAR1)).append(Constant.newLine);
		
		writeGridToBuffer(sb,GridDataUtil.transform((List<List<String>>)map.get("grid3")));
		
		sb.append(map.get(FeaturesCalculateConstant.״̬��������IQP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.������ͬ������IZAP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ͬ�����߸���LSR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.�µ�ʧ�ٵ����KPATH1)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.���������KPATH2)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.��������ϵ��KG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ѹ�ָ�����DSIG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.����ԣ��SM)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.ѹ����������EPR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֱ�ε���ѹ��PR2)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.�����ѹ������Сѹ��֮��PRB)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.ת������ʼNNS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֹNNF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.���㼶��ʼIIS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֹIIF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.Q��������СֵQQS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.���ֵQQF)).append(Constant.newLine);
		
		writeGridToBuffer(sb,(List<List<String>>)map.get("grid4"));
		writeGridToBuffer(sb,(List<List<String>>)map.get("grid5"));
		
		sb.append(map.get(ZXBCalculateConstant.����ԣ������NCU)).append(Constant.newLine);
		
		writeGridToBuffer(sb,(List<List<String>>)map.get("grid6"));;
		
		return sb;
	}
	
	public static StringBuffer getBuffer(Map map,Map<String,List<List<String>>> gridDatas){
		StringBuffer sb = new StringBuffer();
		
		sb.append(map.get(ControlVariableConstant.��ҵ��Ŀ_TITLT)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.��ѹ������_IRE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.�������_NV)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.��������_K)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.�������_K12)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.��ʧ������_IZI)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.��Ҷ�ɵ�_IREG)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.������ͬͼIHAR)).append(Constant.newLine);
		
		sb.append(map.get(ControlVariableConstant.��·ת��_IZX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.Ҷ�����򳤶�����_IDX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.���ܲ����ֲ�_IPE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.Ҷ�Ͳ����ֲ�_IFH)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.Ҷ������վ_INZ)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.RPMת�ٶȻ��һ��ת��Ҷ�������ٶ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PR��ѹ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.G����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PO������ѹ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.TO��������)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.EFF����Ч��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KH���ʴ洢ϵ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ISTAGE����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KPATH��·�����ʶ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KFҶ�ͱ�ʶ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KCѹ��������)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGO���ڶ���ѹ�ظ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGV���ڵ�Ҷ��ѹ�ظ�)).append(Constant.newLine);
		
		//sb.append(map.get(CheckQuestion1Constant.�⾶DTK)).append(Constant.newLine);
		//sb.append(map.get(CheckQuestion1Constant.�ھ�DHK)).append(Constant.newLine);
		
		writeGridToBuffer(sb,gridDatas.get("grid1"));
		writeGridToBuffer(sb,gridDatas.get("grid2"));
		
		sb.append(map.get(CheckQuestionConstant.ALFOһת��������)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.KH1��һ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DKH�𼶵ݼ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KHMIN��Сֵ)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.KG��������ϵ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASP1һתչ����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPK���չ����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABV���ڵ�Ҷ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABRת��ҶƬ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABS����ҶƬ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTHV����ҳ���)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPVչ�ұ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTV���)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DHO������ֱ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DTO������ֱ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTH1һת����ҳ���)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.E1��һ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DE������һ����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.CMV���ڵ�Ҷ�����Ժ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENRת��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENS����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENBҶƬ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DRESת�Ӹ�����Ӧ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ALFK����ӳ���������)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PRO����ѹ��ǰ����ѹ��)).append(Constant.newLine);
		
		sb.append(map.get(CheckQuestionConstant.HORDA��С�ұ�)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.��ת��������N)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.���峣��R)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.����ָ��K)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.״̬����DQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֱ������QֵEQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ѹϵ��ESIG)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.���Ʋ���KGKA)).append(Constant.newLine);

		sb.append(map.get(FeaturesCalculateConstant.���Ʋ���IGKA)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.ת�ٺ�״̬�����IVAR1)).append(Constant.newLine);
		
		writeGridToBuffer(sb,gridDatas.get("grid3"));
		
		sb.append(map.get(FeaturesCalculateConstant.״̬��������IQP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.������ͬ������IZAP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ͬ�����߸���LSR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.�µ�ʧ�ٵ����KPATH1)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.���������KPATH2)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.��������ϵ��KG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ѹ�ָ�����DSIG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.����ԣ��SM)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.ѹ����������EPR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֱ�ε���ѹ��PR2)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.�����ѹ������Сѹ��֮��PRB)).append(Constant.newLine);
		
		sb.append(map.get(FeaturesCalculateConstant.ת������ʼNNS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֹNNF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.���㼶��ʼIIS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֹIIF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.Q��������СֵQQS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.���ֵQQF)).append(Constant.newLine);
		
		writeGridToBuffer(sb,gridDatas.get("grid4"));
		writeGridToBuffer(sb,gridDatas.get("grid5"));
		
		sb.append(map.get(ZXBCalculateConstant.����ԣ������NCU)).append(Constant.newLine);
		
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
		//���Ʊ���
		//#1:IRE,NV IRE������ѹ�����ĸ��� NV�����飨һ̨ѹ�����ɷּ������飩��������IRE>1 ��д0
		sb.append(map.get(ControlVariableConstant.��ѹ������_IRE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.�������_NV)).append(Constant.newLine);
		
		//#2:K����ҵ���������
		sb.append(map.get(ControlVariableConstant.��������_K)).append(Constant.newLine);
		
		//#3:K12,IZI�����K=2 ���� K12��=1 ��������⣬=2 �������� IZI����ʧ������־��=0 ��������=1 ����
		sb.append(map.get(ControlVariableConstant.�������_K12)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.��ʧ������_IZI)).append(Constant.newLine);
		
		//#4:ALN,ALW,PKN,PKW��IZI=0 ���� ��ʧУ��ϵ����ע�⣺ALN(��min)Ӧ����ALW����max),����ͣ��
		String izi = (String)map.get(ControlVariableConstant.��ʧ������_IZI);
		if(izi!=null && !"0".equals(izi)){
			sb.append(map.get(ControlVariableConstant.��ʧУ��ϵ��ALN)).append(Constant.blank);
			sb.append(map.get(ControlVariableConstant.ALW)).append(Constant.blank);
			sb.append(map.get(ControlVariableConstant.PKN)).append(Constant.blank);
			sb.append(map.get(ControlVariableConstant.PKW)).append(Constant.newLine);
		}
		
		//#5:IREG,IHAR����K=1 ;���� IREG��=1 ���Լ��㿼�Ǿ�Ҷ�ɵ���������ڽǶȣ�=0 ������;IHAR�����������Ի���һ��ͼ�ϣ��޴˹��ܣ�д0
		String k = (String)map.get(ControlVariableConstant.��������_K);
		if(k!=null && !"1".equals(k)){
			sb.append(map.get(ControlVariableConstant.��Ҷ�ɵ�_IREG)).append(Constant.blank);
			sb.append(map.get(ControlVariableConstant.������ͬͼIHAR)).append(Constant.newLine);
		}
		
		//#6:IZX,IDX,IPE,IFH,INZ����һά���ת�ɶ�ά���������ļ��Ŀ��Ʒ�
		sb.append(map.get(ControlVariableConstant.��·ת��_IZX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.Ҷ�����򳤶�����_IDX)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.���ܲ����ֲ�_IPE)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.Ҷ�Ͳ����ֲ�_IFH)).append(Constant.blank);
		sb.append(map.get(ControlVariableConstant.Ҷ������վ_INZ)).append(Constant.newLine);

	}
	
	public static void getDesignProblemData(Map map,StringBuffer sb){
		//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV��13 ���ܲ���
		sb.append(map.get(DesignProblemConstant.RPMת�ٻ��һ��ת��Ҷ�������ٶ�)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.PR��ѹ��)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.G����)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.PO������ѹ)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.TO��������)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.EFF����Ч��)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DKH�𼶵ݼ�ֵ)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ISTAGE����)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.KPATH��·�����ʶ)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.KFҶ�ͱ�ʶ)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.KCѹ��������)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.SIGO���ڶ���ѹ�ָ�)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.SIGV���ڵ�Ҷ��ѹ�ָ�)).append(Constant.newLine);
		
		//#2:DT1��D1��DH1��DTC��DMC��DHC��DTK��DFF��DHK��������·��9 ��ֱ��ֵ
		writeGridToBuffer(sb,(List<List<String>>)map.get("DesignProblemGrid1"));
		
		//#3A:DRT1(1:ISTAGE)��DCTK��KPATH=1 ���룬������;DRT1������ת�ӽ����⾶;DCTK��ѹ���������⾶
		//#3B:DRM1(1:ISTAGE)��DCMK��KPATH=2 ʱ���룬������;DRM1������ת�ӽ���ƽ��ֱ����m;DCMK��ѹ��������ƽ��ֱ����m
		//#3C:DRH1(1:ISTAGE)��DCHK,KPATH=3 ���룬������;DRH1������ת�ӽ����ھ���m;DCHK��ѹ���������ھ���m
		String kpath = (String)map.get(DesignProblemConstant.KPATH��·�����ʶ);
		if(kpath!=null && !"0".equals(kpath)){
			List<List<String>> grid = null;
			List<String> rowData = null;
			if("1".equals(kpath)){
				grid = (List<List<String>>)map.get("DesignProblemDRT1Grid");
				grid.get(0).add(String.valueOf(map.get(DesignProblemConstant.DCTKѹ���������⾶)));
				writeGridToBuffer(sb,grid);
			}else if("2".equals(kpath)){
				grid = (List<List<String>>)map.get("DesignProblemDRM1Grid");
				grid.get(0).add(String.valueOf(map.get(DesignProblemConstant.DCMKѹ��������ƽ��ֱ��)));
				writeGridToBuffer(sb,grid);
			}else if("3".equals(kpath)){
				grid = (List<List<String>>)map.get("DesignProblemDRH1Grid");
				grid.get(0).add(String.valueOf(map.get(DesignProblemConstant.DCHKѹ���������ھ�)));
				writeGridToBuffer(sb,grid);
			}
		}
		
		//#6:VA1��VAM��VAC��ALF1��OMGN��DOMG��HZ1��HZM��HZK,KH1,DKH��KHMIN ��12 ����������
		sb.append(map.get(DesignProblemConstant.VA1һ�������ٶ�)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.VAM�ж����ٶ�)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.VAC��������)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ALF1һת��������)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.OMGN���м�������)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DOMG���м�����������)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.HZ1��һ��)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.HZMƽ����)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.HZK���)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.KH1��һ��)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DKH�𼶵ݼ�ֵ)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.KHMIN��Сֵ)).append(Constant.newLine);
		
		
		//#7:KG��ASP1��ASPK��ABV��ABR��ABS��BTHV��ASPV��BTV��DH0��DT0��BTH1��12 �����β���
		sb.append(map.get(DesignProblemConstant.KG��������ϵ��)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ASP1һתչ�ұ�)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ASPKĩתչ�ұ�)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ABV���ڵ�Ҷ)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ABRת��ҶƬ)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ABS����ҶƬ)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.BTHV����ҳ���)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ASPVչ�ұ�)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.BTV���)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DHO������ֱ��)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DTO������ֱ��)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.BTH1һת����ҳ���)).append(Constant.newLine);
		
		//#8:E1��DE��CMV��DENR��DENS��DENB��DRES��ALFK��PR0��9 ������
		sb.append(map.get(DesignProblemConstant.E1��һ��)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DE������һ����)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.CMV���ڵ�Ҷ�����Ժ��)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DENRת��)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DENS����)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DENBҶƬ)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.DRESת�Ӹ�����Ӧ��)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.ALFK����ӳ���������)).append(Constant.blank);
		sb.append(map.get(DesignProblemConstant.PRO��ѹ����ǰ����ѹ��)).append(Constant.newLine);

		//#9:HORDA����С�ҳ���m
		sb.append(map.get(DesignProblemConstant.HORDA��С�ҳ�)).append(Constant.newLine);
	}
	
	public static void getCheckQuestionData(Map map,StringBuffer sb){
		//#1:RPM,PR,G,P0,T0,EFF,KH,ISTAGE,KPATH,KF,KC,SIG0,SIGV��13 ���ܲ���
		sb.append(map.get(CheckQuestionConstant.RPMת�ٶȻ��һ��ת��Ҷ�������ٶ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PR��ѹ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.G����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PO������ѹ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.TO��������)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.EFF����Ч��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DKH�𼶵ݼ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ISTAGE����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KPATH��·�����ʶ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KFҶ�ͱ�ʶ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KCѹ��������)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGO���ڶ���ѹ�ظ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.SIGV���ڵ�Ҷ��ѹ�ظ�)).append(Constant.newLine);
		
		//׼������,��ʼ������grid,����
		List<List<String>> grid1 = (List<List<String>>)map.get("CheckQuestion2Panel.grid1");
		List<List<String>> grid2 = (List<List<String>>)map.get("CheckQuestion3Panel.grid1");
		
		grid1 = GridDataUtil.transform(grid1);
		grid2 = GridDataUtil.transform(grid2);
		
		grid1.get(0).add(String.valueOf(map.get(CheckQuestionConstant.DTK�⾶)));
		grid1.get(1).add(String.valueOf(map.get(CheckQuestionConstant.DHK�ھ�)));
		
		List<String> rowData = grid1.get(grid1.size()-1);
		grid1.remove(rowData);
		grid2.add(3, rowData);
		
		writeGridToBuffer(sb,grid1);
		writeGridToBuffer(sb,grid2);
		
		//#18:ALF0����һ��ת��ǰ����������
		sb.append(map.get(CheckQuestionConstant.ALFOһת��������)).append(Constant.newLine);
		
		//#19:KH1��DKH��KHMIN����������KHI ֵ����������д0.0
		sb.append(map.get(CheckQuestionConstant.KH1��һ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DKH�𼶵ݼ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.KHMIN��Сֵ)).append(Constant.newLine);
		
		//#20:KG��FF��FF��ABV��ABR��ABS��BTHV��ASPV��BTV��DH0��DT0��BTH1��12 ���ṹ����
		sb.append(map.get(CheckQuestionConstant.KG��������ϵ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASP1һתչ����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPK���չ����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABV���ڵ�Ҷ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABRת��ҶƬ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ABS����ҶƬ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTHV����ҳ���)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ASPVչ�ұ�)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTV���)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DHO������ֱ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DTO������ֱ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.BTH1һת����ҳ���)).append(Constant.newLine);
		
		//#21:E1��DE��CMV��DENR��DENS,DENB��DRES��ALFK��PR0��9 ������
		sb.append(map.get(CheckQuestionConstant.E1��һ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DE������һ����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.CMV���ڵ�Ҷ�����Ժ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENRת��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENS����)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DENBҶƬ)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.DRESת�Ӹ�����Ӧ��)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.ALFK����ӳ���������)).append(Constant.blank);
		sb.append(map.get(CheckQuestionConstant.PRO����ѹ��ǰ����ѹ��)).append(Constant.newLine);
		
		//#22:HORDA����С�ҳ���m
		sb.append(map.get(CheckQuestionConstant.HORDA��С�ұ�)).append(Constant.newLine);
	}
	
	public static void getFeaturesCalculateData(Map map,StringBuffer sb){
		//#1:N����ת��������
		sb.append(map.get(FeaturesCalculateConstant.��ת��������N)).append(Constant.newLine);
		
		//#2:R��K��DQ,EQ��ESIG
		sb.append(map.get(FeaturesCalculateConstant.���峣��R)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.����ָ��K)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.״̬����DQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֱ������QֵEQ)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ѹϵ��ESIG)).append(Constant.newLine);

		//#3:KGKA����������6 ����������
		//=0 ʹ�ó����׼ֵ��#4~#9 ��������
		//=1 ��������������,��ȫ��0.0 Ҳ��ó����б�׼ֵ
		sb.append(map.get(FeaturesCalculateConstant.���Ʋ���KGKA)).append(Constant.newLine);
		
		String kgka = String.valueOf(map.get(FeaturesCalculateConstant.���Ʋ���KGKA));
		if("1".equals(kgka)){
			List<List<String>> grid = (List<List<String>>)map.get("FeaturesCalculate2Panel.grid1");
			grid = GridDataUtil.transform(grid);
			writeGridToBuffer(sb,grid);
		}
		
		//#10:IGKA����������4 ����������
		//=0 ʹ�ó����׼ֵ��#11~#14 ��������
		//=1 ��������������
		sb.append(map.get(FeaturesCalculateConstant.���Ʋ���IGKA)).append(Constant.newLine);
		
		String igka = String.valueOf(map.get(FeaturesCalculateConstant.���Ʋ���IGKA));
		if("1".equals(igka)){
			List<List<String>> grid = (List<List<String>>)map.get("FeaturesCalculate3Panel.grid1");
			grid = GridDataUtil.transform(grid);
			writeGridToBuffer(sb,grid);
		}
		
		//#15:IVAR1���������ת�ٺ�q(��)��ֵ����
		//=0���������趨��n=0.7��0.8��0.9��1.0)
		//=1����������#16
		sb.append(map.get(FeaturesCalculateConstant.ת�ٺ�״̬�����IVAR1)).append(Constant.newLine);
		
		String ivar1 = String.valueOf(map.get(FeaturesCalculateConstant.ת�ٺ�״̬�����IVAR1));
		int n = 0;
		try {
			n = Integer.parseInt(String.valueOf(map.get(FeaturesCalculateConstant.��ת��������N)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if("1".equals(ivar1)){
			//#16:NR��QL(1:N)�������������ת�ٺ�q(��)��ֵ
			List<List<String>> grid = (List<List<String>>)map.get("FeaturesCalculate1Panel.grid1");
			grid = GridDataUtil.transform(grid);
			if(grid.size()>n){
				grid = GridDataUtil.trim(grid, 0, n-1);
			}
			writeGridToBuffer(sb,grid);
		}
		
		//#17:IQP��IZAP��LSR��KPAH1��KPAH2��5 �����Ʋ���
		sb.append(map.get(FeaturesCalculateConstant.״̬��������IQP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.������ͬ������IZAP)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ͬ�����߸���LSR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.�µ�ʧ�ٵ����KPATH1)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.���������KPATH2)).append(Constant.newLine);
		
		//#18:KG��DSIG��SM��EPR��PR2��PRB��6 �����ܲ���
		sb.append(map.get(FeaturesCalculateConstant.��������ϵ��KG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ѹ�ָ�����DSIG)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.����ԣ��SM)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.ѹ����������EPR)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֱ�ε���ѹ��PR2)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.�����ѹ������Сѹ��֮��PRB)).append(Constant.newLine);
		
		//#19:NNS��NNF��IIS��IIF��QQS��QQF��6 ���޶����������Լ���Ĳ���
		sb.append(map.get(FeaturesCalculateConstant.ת������ʼNNS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֹNNF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.���㼶��ʼIIS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.��ֹIIF)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.Q��������СֵQQS)).append(Constant.blank);
		sb.append(map.get(FeaturesCalculateConstant.���ֵQQF)).append(Constant.newLine);
		
		//׼������
		int lsr = 0;
		try {
			lsr = Integer.parseInt(String.valueOf(map.get(FeaturesCalculateConstant.��ͬ�����߸���LSR)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if(lsr!=0){
			List<List<String>> grid = (List<List<String>>)map.get("FeaturesCalculate1Panel.grid2");
			writeGridToBuffer(sb,grid);
			//#20:LSR��0 �ɵ��������L ��Ĺ�ͬ�����ߣ�2��L��10��LSR=0 ���䡣
			//GCOR(1:L)����������
		}
		
		String ireg = String.valueOf(map.get(ControlVariableConstant.��Ҷ�ɵ�_IREG));
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
		//#1:NCU�������ת�ٴ���ԣ��SM �ı�ʶ
		sb.append(map.get(AspectRatioCalculateConstant.����ԣ������NCU)).append(Constant.newLine);
		
		int n = 0;
		try {
			n = Integer.parseInt(String.valueOf(map.get(FeaturesCalculateConstant.��ת��������N)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		String ncu = String.valueOf(map.get(AspectRatioCalculateConstant.����ԣ������NCU));
		if("3".equals(ncu)){
			List<List<String>> grid = (List<List<String>>)map.get("AspectRatioCalculatePanel.grid1");
			writeGridToBuffer(sb,grid);
			
			//#2:SMI(1:N)����ת��Ҫ��Ĵ���ԣ��
		}
	}
	
	public static StringBuffer getBufferFromMap(Map map){
		StringBuffer sb = new StringBuffer();
		
		sb.append(map.get(ControlVariableConstant.��ҵ��Ŀ_TITLT)).append(Constant.newLine);
		
		//���Ʊ���
		getControlVariableData(map,sb);
		
		String k12 = String.valueOf(map.get(ControlVariableConstant.�������_K12));
		if("1".equals(k12)){
			//�������
			getDesignProblemData(map,sb);
		}else if("2".equals(k12)){
			//�������
			getCheckQuestionData(map,sb);
		}
		
		String k = String.valueOf(map.get(ControlVariableConstant.��������_K));
		//1-���+��� 2-���� 3-���+���+���� 4-���+���+����+չ�ұ�
		if("1".equals(k)){
			//���+���
		}else if("2".equals(k)){
			//���Լ���
		}else if("3".equals(k)){
			//���Լ���
			getFeaturesCalculateData(map,sb);
		}else if("4".equals(k)){
			//���Լ���
			getFeaturesCalculateData(map,sb);
			//չ�ұȼ���
			getAspectRatioCalculateData(map,sb);
		}

		return sb;
	}
}

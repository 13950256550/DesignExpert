package com.xianhe.mis.module.module1D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xianhe.core.common.Code;
import com.xianhe.mis.module.module1D.constant.ControlVariableConstant;
import com.xianhe.mis.module.module1D.constant.DesignProblemConstant;
import com.xianhe.mis.module.module1D.constant.FeaturesCalculateConstant;

public class CodeList {
	public static Map<String,CodeList> codeListMap = new HashMap<String,CodeList>();
	static{
		//���Ʊ���
		String name = ControlVariableConstant.��������_K;
		CodeList codeList = new CodeList(name,new String[][]{
													new String[]{"1","��ƻ���"},
													new String[]{"2","����"},
													new String[]{"3","(1+2)"},
													new String[]{"4","(3+չ����)"}
												});
		codeListMap.put(name, codeList);
		
		name = ControlVariableConstant.�������_K12;
		codeList = new CodeList(name,new String[][]{
											new String[]{"1","�������"},
											new String[]{"2","�������"}
										});
		codeListMap.put(name, codeList);
		
		name = ControlVariableConstant.��ʧ������_IZI;
		codeList = new CodeList(name,new String[][]{
											new String[]{"0","������"},
											new String[]{"1","����"}
										});
		codeListMap.put(name, codeList);
		
		name = ControlVariableConstant.��Ҷ�ɵ�_IREG;
		codeList = new CodeList(name,new String[][]{
											new String[]{"0","����"},
											new String[]{"1","����Ҷ������"}
										});
		codeListMap.put(name, codeList);
		
		name = ControlVariableConstant.��·ת��_IZX;
		codeList = new CodeList(name,new String[][]{
											new String[]{"0","������GAZD.D"},
											new String[]{"1","վΪ��ֱ��"},
											new String[]{"2","���ͬ��(��DGAZD.D)"},
											new String[]{"3","ֻ�޼ⲿ(��DGAZD.D)"}
										});
		codeListMap.put(name, codeList);
		
		name = ControlVariableConstant.Ҷ�����򳤶�����_IDX;
		codeList = new CodeList(name,new String[][]{
											new String[]{"1","������"},
											new String[]{"2","��DGAZD.D����"}
										});
		codeListMap.put(name, codeList);
		
		name = ControlVariableConstant.���ܲ����ֲ�_IPE;
		codeList = new CodeList(name,new String[][]{
											new String[]{"1","������"},
											new String[]{"2","�ֶ�����"},
											new String[]{"3","��E3��������"},
											new String[]{"4","��E3ģʽ����"}
										});
		codeListMap.put(name, codeList);
		
		name = ControlVariableConstant.Ҷ�Ͳ����ֲ�_IFH;
		codeList = new CodeList(name,new String[][]{
											new String[]{"0","������DROW**.D"},
											new String[]{"1","������"},
											new String[]{"2","��E3ģʽ����"}
										});
		codeListMap.put(name, codeList);
		
		name = ControlVariableConstant.Ҷ������վ_INZ;
		codeList = new CodeList(name,new String[][]{
											new String[]{"0","Ҷ����1վ"},
											new String[]{"1","��DGAZD.D������վ"}
										});
		codeListMap.put(name, codeList);
		
		//�������
		name = DesignProblemConstant.KFҶ�ͱ�ʶ;
		codeList = new CodeList(name,new String[][]{
					new String[]{"1","BC10"},
					new String[]{"2","C4"},
					new String[]{"3","NACA65"}
				});
		codeListMap.put(name, codeList);
		
		name = DesignProblemConstant.KCѹ��������;
		codeList = new CodeList(name,new String[][]{
					new String[]{"1","��ѹ����"},
					new String[]{"2","����˫���еĵ�ѹ"},
					new String[]{"3","����˫���еĸ�ѹ"},
					new String[]{"4","˫���еķ���"},
					new String[]{"5","˫���е���ѹ��"},
					new String[]{"6","�����е���ѹ,˫��"},
					new String[]{"7","˫���еĸ�ѹ"},
					new String[]{"8","�����еĸ�ѹ"}
				});
		codeListMap.put(name, codeList);
		
		name = DesignProblemConstant.KPATH��·�����ʶ;
		codeList = new CodeList(name,new String[][]{
					new String[]{"0","������⡢�С��ھ�����������ڻ�������⾶"},
					new String[]{"1","�������ת�ӽ����⾶��ѹ���������⾶"},
					new String[]{"2","�������ת�ӽ����о���ѹ���������о�"},
					new String[]{"3","����ת�ӽ����ھ���ѹ���������ھ�"}
				});
		codeListMap.put(name, codeList);
		
		//���Լ���
		name = FeaturesCalculateConstant.���Ʋ���KGKA;
		codeList = new CodeList(name,new String[][]{
					new String[]{"0","����(2)����"},
					new String[]{"1","����(2)��"}
				});
		codeListMap.put(name, codeList);	
		
		name = FeaturesCalculateConstant.���Ʋ���IGKA;
		codeList = new CodeList(name,new String[][]{
					new String[]{"0","����(3)����"},
					new String[]{"1","����(3)��"}
				});
		codeListMap.put(name, codeList);
		
		name = FeaturesCalculateConstant.ת�ٺ�״̬�����IVAR1;
		codeList = new CodeList(name,new String[][]{
					new String[]{"0","ȫ������"},
					new String[]{"1","���㵥��(QL)"},
					new String[]{"2","��ֱ�ε���(PR2)"}
				});
		codeListMap.put(name, codeList);
		
		name = FeaturesCalculateConstant.״̬��������IQP;
		codeList = new CodeList(name,new String[][]{
					new String[]{"0","ȫ������"},
					new String[]{"1","���㵥��(QL)"},
					new String[]{"2","��ֱ�ε���(PR2)"}
				});
		codeListMap.put(name, codeList);

		name = FeaturesCalculateConstant.������ͬ������IZAP;
		codeList = new CodeList(name,new String[][]{
					new String[]{"0","����"},
					new String[]{"1","������"}
				});
		codeListMap.put(name, codeList);
	}
	
	public static CodeList getCodeListByName(String name){
		return codeListMap.get(name);
	}
	
	private String codeName;
	private List<Code> codeList;
	
	public CodeList(String codeName, List<Code> codeList) {
		this.codeName = codeName;
		this.codeList = codeList;
	}

	public CodeList(String codeName,Code[] codes) {
		this.codeName = codeName;
		this.codeList = new ArrayList<Code>();
		for(Code code:codes){
			this.codeList.add(code);
		}
	}
	
	public CodeList(String codeName,String[][] codes) {
		this.codeName = codeName;
		this.codeList = new ArrayList<Code>();
		for(String[] code:codes){
			Code aCode = new Code(code[0],code[1]);
			this.codeList.add(aCode);
		}
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public List<Code> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<Code> codeList) {
		this.codeList = codeList;
	}
	
}

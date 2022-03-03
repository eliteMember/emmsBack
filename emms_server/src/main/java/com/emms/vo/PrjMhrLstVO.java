package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PrjMhrLstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3939018464876703933L;
	private String prjNum;		//������Ʈ��ȣ
	private String mhrKndCd;    //���������ڵ�
	private String memNum;      //�η¹�ȣ
	private String srtOdr;      //���ļ���
	private String wrkMcNm;     //������з���
	private String wrkScNm;     //�����ߺз���
	private String rolNm;       //���Ҹ�
	private String memRnkCd;    //�ηµ���ڵ�
	private String depStartDt;  //���Խ�������
	private String depEndDt;    //������������
	private String rmk;         //���
	private String wroCplYn;    //�ۼ��ϷῩ��
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ


	
}

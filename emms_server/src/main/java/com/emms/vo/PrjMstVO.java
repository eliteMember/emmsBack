package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PrjMstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5283176143364829396L;
	private String prjNum;		//������Ʈ��ȣ
	private String prjNm;       //������Ʈ��
	private String prjDivCd;    //������Ʈ�����ڵ�
	private String prjStsCd;    //������Ʈ�����ڵ�
	private String prjPrd;      //������Ʈ�Ⱓ
	private int    prjNom;      //������Ʈ������
	private String prjPlcNm;    //������Ʈ��Ҹ�
	private String prjRefCmt;   //������Ʈ��������
	private String timNum;      //����ȣ
	private float  dscPer;      //������
	private long   estAmt;      //�����ݾ�
	private String pmtMtdCd;    //��������ڵ�
	private String delYn;       //��������
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ

	
}

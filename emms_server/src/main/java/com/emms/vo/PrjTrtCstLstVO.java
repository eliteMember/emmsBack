package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PrjTrtCstLstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7341670981186976722L;
	private String prjNum;		//������Ʈ��ȣ
	private String cstKndCd;    //��������ڵ�
	private String trtYm;       //ó�����
	private int    cstSeq;      //����Ϸù�ȣ
	private String cstDivCd;    //��뱸���ڵ�
	private String cstItmNm;    //���ǰ���
	private long   fcstCstAmt;  //�������ݾ�
	private long   trtCstAmt;   //ó�����ݾ�
	private long   polAmt;      //���ͱݾ�
	private String rmk;         //���
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ

	
}

package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PrjBfrCstLstVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2557093816743638529L;
	private String prjNum;		//������Ʈ��ȣ
	private String cstKndCd;    //��������ڵ�
	private int    cstSeq;      //����Ϸù�ȣ
	private String cstDivCd;    //��뱸���ڵ�
	private String cstItmNm;    //���ǰ���
	private long   mmSalAmt;    //������ݾ�
	private long   mmCstUnp;    //�����ܰ�
	private int    mmCstQty;    //��������
	private long   mmCstAmt;    //�����ݾ�
	private long   memCstUnp;   //�ηº��ܰ�
	private int    memCstQty;   //�ηº�����
	private long   memCstAmt;   //�ηº��ݾ�
	private long   totPrfAmt;   //�����ͱݾ�
	private String rmk;         //���
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ

	
}

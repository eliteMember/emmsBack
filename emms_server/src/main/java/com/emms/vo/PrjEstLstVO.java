package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PrjEstLstVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4181971054644045305L;
	private String prjNum;		//������Ʈ��ȣ
	private int    estRnkSeq;   //��������Ϸù�ȣ
	private String estRnkCd;    //��������ڵ�
	private long   stdUnp;      //ǥ�شܰ�
	private long   dscAmt;      //���αݾ�
	private long   ofrUnp;      //���ȴܰ�
	private int    totDepQty;   //�����Լ���
	private long   estAmt;      //�����ݾ�
	private String rmk;         //���
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ

}

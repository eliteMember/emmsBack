package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class StdUnpLstVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 650710027635297259L;
	private int    unpSeq;		//�ܰ��Ϸù�ȣ
	private String estRnkCd;    //��������ڵ�
	private long   stdUnp;      //ǥ�شܰ�
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ

}

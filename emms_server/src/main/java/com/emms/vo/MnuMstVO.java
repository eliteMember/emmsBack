package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MnuMstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7511652607943934917L;
	private String mnuNum;		//�޴���ȣ
	private String mnuNm;       //�޴���
	private String mnuUrl;      //�޴�URL
	private String prtMnuNum;   //�����޴���ȣ
	private String srtOdr;      //���ļ���
	private String useYn;       //��뿩��
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ


}

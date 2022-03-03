package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class RelCopLstVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1680056821311543724L;
	private String prjNum;		//������Ʈ��ȣ
	private int    copSeq;      //��ü�Ϸù�ȣ
	private String copDivCd;    //��ü�����ڵ�
	private String copNm;       //��ü��
	private String copMgrName;  //��ü������̸�
	private String copMgrCtt;   //��ü����ڿ���ó
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ



}

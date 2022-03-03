package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MemMstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6938812680472073938L;
	private String memNum;		//�η¹�ȣ
	private String memName;     //�η��̸�
	private String memBirMd;    //�η»������
	private String incCd;       //�����ڵ�
	private String memRnkCd;    //�ηµ���ڵ�
	private String eduCd;       //�з��ڵ�
	private String ctfNm;       //�ڰ�����
	private long   memUnp;      //�η´ܰ�
	private long   memFcst;     //�η¿���
	private String memCtt;      //�η¿���ó
	private String memAdr;      //�η��ּ�
	private String affTimName;  //�Ҽ����̸�
	private String affCoName;   //�Ҽ�ȸ���̸�
	private String usrNum;      //����ڹ�ȣ
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ


	
}

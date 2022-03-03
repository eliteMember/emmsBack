package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserMstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6167946120658180056L;
	private String usrNum;		//����ڹ�ȣ
	private String usrName;     //������̸�
	private String usrBirMd;    //����ڻ������
	private String usrEmail;    //������̸���
	private String usrTelNum;   //�������ȭ��ȣ
	private String usrAdr;      //������ּ�
	private String incCd;       //�����ڵ�
	private String apoCd;       //��å�ڵ�
	private String eduCd;       //�з��ڵ�
	private String timNum;      //����ȣ
	private String loginId;     //�α���ID
	private String passNum;     //��й�ȣ
	private String joinYn;      //���Կ���
	private String delYn;       //��������
	private String rmk;         //���
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ

}

package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class AuthMstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6008642851587004986L;
	
	private String 	authNum;		//���ѹ�ȣ
	private String 	authNm;         //���Ѹ�
	private Date 	crtDtm;         //����Ͻ�
	private String 	crtUsrNum;      //��ϻ���ڹ�ȣ
	private Date 	mdfDtm;         //�����Ͻ�
	private String 	mdfUsrNum;      //��������ڹ�ȣ

	

}

package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class AuthLstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3367766610192307877L;
	private String authNum;		//���ѹ�ȣ
	private String mnuNum;      //�޴���ȣ
	private String rdAuthYn;    //�б���ѿ���
	private String wrtAuthYn;   //������ѿ���
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ


}

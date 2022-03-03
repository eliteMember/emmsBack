package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class RelDocLstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 610061053839217227L;
	private String prjNum;		//������Ʈ��ȣ
	private String relDocNum;   //���ü�����ȣ
	private String docClsCd;    //�����з��ڵ�
	private String filNm;       //���ϸ�
	private String filPth;      //���ϰ��
	private String orgFilNm;    //�������ϸ�
	private long   filSiz;      //����ũ��
	private String filExt;      //����Ȯ����
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ


}

package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CdLstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3212293541942208512L;
	private String cdDivVal;	//�ڵ屸�а�
	private String cdVal;       //�ڵ尪
	private String cdDivNm;     //�ڵ屸�и�
	private String cdNm;        //�ڵ��
	private String useYn;       //��뿩��
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ


}

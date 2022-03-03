package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PrjMhrMmLstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2097816352428144636L;
	private String prjNum;		//������Ʈ��ȣ
	private String mhrKndCd;    //���������ڵ�
	private String memNum;      //�η¹�ȣ
	private String mhrYm;       //�������
	private int    mmSalQty;    //���������
	private long   mmSalUnp;    //������ܰ�
	private long   mmSalAmt;    //������ݾ�
	private int    mmPurQty;    //�����Լ���
	private long   mmPurUnp;    //�����Դܰ�
	private long   mmPurAmt;    //�����Աݾ�
	private long   totPrfAmt;   //�����ͱݾ�
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ

}

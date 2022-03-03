package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TimMstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3304417455484365725L;
	private String timNum;		//����ȣ
	private String timNm;       //����
	private Date   crtDtm;      //����Ͻ�
	private String crtUsrNum;   //��ϻ���ڹ�ȣ
	private Date   mdfDtm;      //�����Ͻ�
	private String mdfUsrNum;   //��������ڹ�ȣ


}

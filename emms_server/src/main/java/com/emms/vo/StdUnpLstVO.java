package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class StdUnpLstVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 650710027635297259L;
	private int    unpSeq;		//단가일련번호
	private String estRnkCd;    //견적등급코드
	private long   stdUnp;      //표준단가
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호

}

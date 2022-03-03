package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PrjEstLstVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4181971054644045305L;
	private String prjNum;		//프로젝트번호
	private int    estRnkSeq;   //견적등급일련번호
	private String estRnkCd;    //견적등급코드
	private long   stdUnp;      //표준단가
	private long   dscAmt;      //할인금액
	private long   ofrUnp;      //제안단가
	private int    totDepQty;   //총투입수량
	private long   estAmt;      //견적금액
	private String rmk;         //비고
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호

}

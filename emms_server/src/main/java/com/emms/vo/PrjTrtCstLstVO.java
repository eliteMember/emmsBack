package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PrjTrtCstLstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7341670981186976722L;
	private String prjNum;		//프로젝트번호
	private String cstKndCd;    //비용종류코드
	private String trtYm;       //처리년월
	private int    cstSeq;      //비용일련번호
	private String cstDivCd;    //비용구분코드
	private String cstItmNm;    //비용품목명
	private long   fcstCstAmt;  //원가비용금액
	private long   trtCstAmt;   //처리비용금액
	private long   polAmt;      //손익금액
	private String rmk;         //비고
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호

	
}

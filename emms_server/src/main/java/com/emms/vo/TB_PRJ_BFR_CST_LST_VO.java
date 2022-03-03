package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TB_PRJ_BFR_CST_LST_VO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2557093816743638529L;
	private String prjNum;		//프로젝트번호
	private String cstKndCd;    //비용종류코드
	private int    cstSeq;      //비용일련번호
	private String cstDivCd;    //비용구분코드
	private String cstItmNm;    //비용품목명
	private long   mmSalAmt;    //월매출금액
	private long   mmCstUnp;    //월비용단가
	private int    mmCstQty;    //월비용수량
	private long   mmCstAmt;    //월비용금액
	private long   memCstUnp;   //인력비용단가
	private int    memCstQty;   //인력비용수량
	private long   memCstAmt;   //인력비용금액
	private long   totPrfAmt;   //총이익금액
	private String rmk;         //비고
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호

	
}

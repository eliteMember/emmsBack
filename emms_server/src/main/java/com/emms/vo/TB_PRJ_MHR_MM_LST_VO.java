package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TB_PRJ_MHR_MM_LST_VO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2097816352428144636L;
	private String prjNum;		//프로젝트번호
	private String mhrKndCd;    //공수종류코드
	private String memNum;      //인력번호
	private String mhrYm;       //공수년월
	private int    mmSalQty;    //월매출수량
	private long   mmSalUnp;    //월매출단가
	private long   mmSalAmt;    //월매출금액
	private int    mmPurQty;    //월매입수량
	private long   mmPurUnp;    //월매입단가
	private long   mmPurAmt;    //월매입금액
	private long   totPrfAmt;   //총이익금액
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호

}

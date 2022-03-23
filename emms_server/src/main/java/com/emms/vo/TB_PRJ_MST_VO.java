package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TB_PRJ_MST_VO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5283176143364829396L;
	private String prjNum;		//프로젝트번호
	private String prjNm;       //프로젝트명
	private String prjDivCd;    //프로젝트구분코드
	private String prjStsCd;    //프로젝트상태코드
	private int    prjNom;      //프로젝트개월수
	private String prjPlcNm;    //프로젝트장소명
	private String prjRefCmt;   //프로젝트참조내용
	private String timNum;      //팀번호
	private float  dscPer;      //할인율
	private long   estAmt;      //견적금액
	private String pmtMtdCd;    //결제방식코드
	private String delYn;       //삭제여부
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호
	
	private String prjStartYm;	//프로젝트시작년월
	private String prjEndYm;	//프로젝트종료년월	
}

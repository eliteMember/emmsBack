package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MnuMstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7511652607943934917L;
	private String mnuNum;		//메뉴번호
	private String mnuNm;       //메뉴명
	private String mnuUrl;      //메뉴URL
	private String prtMnuNum;   //상위메뉴번호
	private String srtOdr;      //정렬순서
	private String useYn;       //사용여부
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호


}

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
	private String cdDivVal;	//코드구분값
	private String cdVal;       //코드값
	private String cdDivNm;     //코드구분명
	private String cdNm;        //코드명
	private String useYn;       //사용여부
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호


}

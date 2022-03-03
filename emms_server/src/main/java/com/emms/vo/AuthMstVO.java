package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class AuthMstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6008642851587004986L;
	
	private String 	authNum;		//권한번호
	private String 	authNm;         //권한명
	private Date 	crtDtm;         //등록일시
	private String 	crtUsrNum;      //등록사용자번호
	private Date 	mdfDtm;         //수정일시
	private String 	mdfUsrNum;      //수정사용자번호

	

}

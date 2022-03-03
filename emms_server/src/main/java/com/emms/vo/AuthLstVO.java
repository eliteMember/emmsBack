package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class AuthLstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3367766610192307877L;
	private String authNum;		//권한번호
	private String mnuNum;      //메뉴번호
	private String rdAuthYn;    //읽기권한여부
	private String wrtAuthYn;   //쓰기권한여부
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호


}

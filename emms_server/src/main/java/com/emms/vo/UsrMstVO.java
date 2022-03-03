package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UsrMstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6167946120658180056L;
	private String usrNum;		//사용자번호
	private String usrName;     //사용자이름
	private String usrBirMd;    //사용자생년월일
	private String usrEmail;    //사용자이메일
	private String usrTelNum;   //사용자전화번호
	private String usrAdr;      //사용자주소
	private String incCd;       //직위코드
	private String apoCd;       //직책코드
	private String eduCd;       //학력코드
	private String timNum;      //팀번호
	private String loginId;     //로그인ID
	private String passNum;     //비밀번호
	private String joinYn;      //가입여부
	private String delYn;       //삭제여부
	private String rmk;         //비고
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호

}

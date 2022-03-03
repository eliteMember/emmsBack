package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MemMstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6938812680472073938L;
	private String memNum;		//인력번호
	private String memName;     //인력이름
	private String memBirMd;    //인력생년월일
	private String incCd;       //직위코드
	private String memRnkCd;    //인력등급코드
	private String eduCd;       //학력코드
	private String ctfNm;       //자격증명
	private long   memUnp;      //인력단가
	private long   memFcst;     //인력원가
	private String memCtt;      //인력연락처
	private String memAdr;      //인력주소
	private String affTimName;  //소속팀이름
	private String affCoName;   //소속회사이름
	private String usrNum;      //사용자번호
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호


	
}

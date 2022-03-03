package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PrjMhrLstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3939018464876703933L;
	private String prjNum;		//프로젝트번호
	private String mhrKndCd;    //공수종류코드
	private String memNum;      //인력번호
	private String srtOdr;      //정렬순서
	private String wrkMcNm;     //업무대분류명
	private String wrkScNm;     //업무중분류명
	private String rolNm;       //역할명
	private String memRnkCd;    //인력등급코드
	private String depStartDt;  //투입시작일자
	private String depEndDt;    //투입종료일자
	private String rmk;         //비고
	private String wroCplYn;    //작성완료여부
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호


	
}

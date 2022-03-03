package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class RelCopLstVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1680056821311543724L;
	private String prjNum;		//프로젝트번호
	private int    copSeq;      //업체일련번호
	private String copDivCd;    //업체구분코드
	private String copNm;       //업체명
	private String copMgrName;  //업체담당자이름
	private String copMgrCtt;   //업체담당자연락처
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호



}

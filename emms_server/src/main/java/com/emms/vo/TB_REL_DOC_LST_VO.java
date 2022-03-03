package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TB_REL_DOC_LST_VO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 610061053839217227L;
	private String prjNum;		//프로젝트번호
	private String relDocNum;   //관련서류번호
	private String docClsCd;    //서류분류코드
	private String filNm;       //파일명
	private String filPth;      //파일경로
	private String orgFilNm;    //원본파일명
	private long   filSiz;      //파일크기
	private String filExt;      //파일확장자
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호


}

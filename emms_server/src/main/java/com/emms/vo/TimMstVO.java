package com.emms.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TimMstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3304417455484365725L;
	private String timNum;		//팀번호
	private String timNm;       //팀명
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호


}

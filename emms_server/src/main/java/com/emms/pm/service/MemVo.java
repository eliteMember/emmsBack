package com.emms.pm.service;

import java.io.Serializable;
import java.util.List;

import com.emms.vo.TB_PRJ_MHR_MM_LST_VO;

import lombok.Data;

@Data
public class MemVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3939018464876703933L;
	private String rolNm;		//역할명
	private String memNum;	//작성완료여부
	private String memName;		//인력이름
	private String memRnkCd;	//인력등급
	private String depStartDt;	//투입시작일
	private String depEndDt;	//투입종료일
	private String wroCplYn;	//작성완료여부
	private List<TB_PRJ_MHR_MM_LST_VO> mhr;    //월투입공수
	
}

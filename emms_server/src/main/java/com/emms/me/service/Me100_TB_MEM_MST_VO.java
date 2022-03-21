package com.emms.me.service;

import java.io.Serializable;

import com.emms.vo.TB_MEM_MST_VO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Me100_TB_MEM_MST_VO extends TB_MEM_MST_VO implements Serializable{

	private static final long serialVersionUID = 7523988979467901844L;
	private String incNm;			//직위명
	private String memRnkNm;	//인력등급명
	private String eduNm;			//학력명
	
}

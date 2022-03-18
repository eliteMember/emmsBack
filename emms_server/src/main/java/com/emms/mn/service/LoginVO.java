package com.emms.mn.service;

import java.io.Serializable;

import com.emms.vo.TB_USR_MST_VO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class LoginVO extends TB_USR_MST_VO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 577995984161385602L;
	
	private String timNm;       //팀명

}

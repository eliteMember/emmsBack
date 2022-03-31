package com.emms.pm.service;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class WrkMcVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3939018464876703933L;
	private String wrkMcNm;			//대분류명
	private List<WrkScVo> wrkSc;    //공수종류코드
	
}

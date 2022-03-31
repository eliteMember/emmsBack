package com.emms.pm.service;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class WrkScVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3939018464876703933L;
	private String wrkScNm;		//중분류명
	private List<MemVo> mem;    //공수종류코드
	
}

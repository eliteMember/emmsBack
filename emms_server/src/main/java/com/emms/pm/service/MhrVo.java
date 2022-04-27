package com.emms.pm.service;

import java.io.Serializable;

import lombok.Data;

@Data
public class MhrVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3939018464876703933L;
	private String mhrYm;		//중분류명
	private String mmPurQty;    //공수종류코드
	
}

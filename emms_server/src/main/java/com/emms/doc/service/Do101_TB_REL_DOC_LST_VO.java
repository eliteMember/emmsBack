package com.emms.doc.service;

import java.io.Serializable;

import com.emms.vo.TB_REL_DOC_LST_VO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Do101_TB_REL_DOC_LST_VO extends TB_REL_DOC_LST_VO implements Serializable{
	
	private static final long serialVersionUID = -4071622418674179590L;
	private String prjNm;		//프로젝트명
	private String usrName; 	//사용자명
}

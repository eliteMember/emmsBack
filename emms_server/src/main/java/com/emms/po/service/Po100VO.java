package com.emms.po.service;

import java.io.Serializable;
import java.util.List;

import com.emms.vo.TB_REL_COP_LST_VO;
import com.emms.vo.TB_REL_DOC_LST_VO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Po100VO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5535100398829600060L;
	private String prjNewOrOld;
	private String prjNum		;  //프로젝트번호
	private String prjNm		;  //프로젝트명
	private String prjDivCd		;  //프로젝트구분코드
	private String prjStsCd		;  //프로젝트상태코드
	private String prjStartYm	;  //프로젝트시작년월
	private String prjEndYm		;  //프로젝트종료년월
	private Integer prjNom		;  //프로젝트개월수
	private String prjNomYear	;  //프로젝트개월수, 년
	private String prjNomMonth	;  //프로젝트개월수, 월
	private String prjPlcNm		;  //프로젝트장소명
	private String prjRefCmt	;  //프로젝트참조내용
	private String timNum		;  //팀번호
	
	private List<TB_REL_COP_LST_VO> copInfo1; //고객사
	private List<TB_REL_COP_LST_VO> copInfo2;	//수행사
	private List<TB_REL_COP_LST_VO> copInfo3;	//협력사
	
	private List<TB_REL_DOC_LST_VO> files;	//첨부파일
			

}

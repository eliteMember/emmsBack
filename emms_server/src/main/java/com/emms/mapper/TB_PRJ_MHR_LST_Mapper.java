
package com.emms.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.pm.service.MemVo;
import com.emms.pm.service.WrkMcVo;
import com.emms.pm.service.WrkScVo;
import com.emms.vo.TB_PRJ_MHR_LST_VO;

@Mapper
public interface TB_PRJ_MHR_LST_Mapper {
	//프로젝트공수내역 조회
	List<TB_PRJ_MHR_LST_VO> TB_PRJ_MHR_LST_PL001(HashMap<String,String> param);
	
	//프로젝트공수내역 대분류 조회
	List<WrkMcVo> TB_PRJ_MHR_LST_PL002(TB_PRJ_MHR_LST_VO param);
	
	//프로젝트공수내역 중분류 조회
	List<WrkScVo> TB_PRJ_MHR_LST_PL003(TB_PRJ_MHR_LST_VO param);
	
	//프로젝트공수내역 소분류(인력) 조회
	List<MemVo> TB_PRJ_MHR_LST_VL001(TB_PRJ_MHR_LST_VO param);
	
	//프로젝트공수내역 소분류(인력) 조회
	Integer TB_PRJ_MHR_LST_IL001(List<TB_PRJ_MHR_LST_VO> param);
}

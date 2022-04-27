
package com.emms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.pm.service.MhrVo;
import com.emms.vo.TB_PRJ_MHR_LST_VO;
import com.emms.vo.TB_PRJ_MHR_MM_LST_VO;

@Mapper
public interface TB_PRJ_MHR_MM_LST_Mapper {

	//프로젝트공수내역 소분류(인력) 조회
	List<MhrVo> TB_PRJ_MHR_MM_LST_PL001(TB_PRJ_MHR_LST_VO param);
}


package com.emms.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.vo.TB_CD_LST_VO;


@Mapper
public interface TB_CD_LST_Mapper {

	//공통 코드 조회
	List<TB_CD_LST_VO> TB_CD_LST_PL001(String val);
	
	List<TB_CD_LST_VO> TB_CD_LST_PL002();
}

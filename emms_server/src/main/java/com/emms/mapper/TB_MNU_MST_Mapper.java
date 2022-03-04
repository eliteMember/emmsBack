
package com.emms.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.vo.TB_MNU_MST_VO;


@Mapper
public interface TB_MNU_MST_Mapper {
	
	//메뉴 조회
	List<TB_MNU_MST_VO> TB_MNU_MST_PL001(HashMap<String, String> paramMap);
}

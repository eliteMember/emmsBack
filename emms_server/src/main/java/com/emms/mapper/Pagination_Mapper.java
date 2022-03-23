package com.emms.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.vo.TB_USR_MST_VO;

@Mapper
public interface Pagination_Mapper {
	
	List<TB_USR_MST_VO> TB_USR_MST_VL001(HashMap<String, Integer> map);
	
}

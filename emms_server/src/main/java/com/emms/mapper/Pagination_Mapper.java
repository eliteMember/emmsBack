package com.emms.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.mn.service.LoginVO;

@Mapper
public interface Pagination_Mapper {
	
	List<LoginVO> TB_USR_MST_VL001(HashMap<String, Integer> map);
	
}

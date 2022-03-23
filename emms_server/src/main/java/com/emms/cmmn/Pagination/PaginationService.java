package com.emms.cmmn.Pagination;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.Pagination_Mapper;
import com.emms.vo.TB_USR_MST_VO;

@Service
public class PaginationService {
	
	@Autowired
	Pagination_Mapper mapper;
	
	public List<TB_USR_MST_VO> selectList(HashMap<String, Integer> map) throws Exception{
		
		List<TB_USR_MST_VO> tbUsrMstVo = mapper.TB_USR_MST_VL001(map);
		
	return tbUsrMstVo;
	}
}

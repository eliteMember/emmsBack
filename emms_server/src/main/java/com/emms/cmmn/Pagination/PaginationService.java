package com.emms.cmmn.Pagination;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.Pagination_Mapper;
import com.emms.mn.service.LoginVO;

@Service
public class PaginationService {
	
	@Autowired
	Pagination_Mapper mapper;
	
	public List<LoginVO> selectList(HashMap<String, Integer> map) throws Exception{
		
		List<LoginVO> tbUsrMstVo = mapper.TB_USR_MST_VL001(map);
		
	return tbUsrMstVo;
	}
}

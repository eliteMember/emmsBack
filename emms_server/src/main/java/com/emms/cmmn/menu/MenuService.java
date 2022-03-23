package com.emms.cmmn.menu;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.TB_MNU_MST_Mapper;
import com.emms.vo.TB_MNU_MST_VO;

@Service("mnuService")
public class MenuService {

	@Autowired
	TB_MNU_MST_Mapper mnuMstMapper;

	public List<TB_MNU_MST_VO> getMenuList(HashMap<String, String> paramMap) throws Exception {

		return mnuMstMapper.TB_MNU_MST_PL001(paramMap);
	}
	
	

}
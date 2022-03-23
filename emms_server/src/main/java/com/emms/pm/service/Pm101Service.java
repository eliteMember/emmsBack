package com.emms.pm.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.TB_PRJ_MST_Mapper;
import com.emms.vo.TB_PRJ_MST_VO;

@Service("pm101Service")
public class Pm101Service {

	@Autowired
	private TB_PRJ_MST_Mapper tbPrjMstMapper;

	public List<TB_PRJ_MST_VO> listPrjMst(HashMap<String, String> paramMap) throws Exception {

		return tbPrjMstMapper.TB_PRJ_MST_PL001(paramMap);
	}
}
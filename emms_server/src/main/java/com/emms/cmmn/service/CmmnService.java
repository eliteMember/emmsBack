package com.emms.cmmn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.TB_TIM_MST_Mapper;
import com.emms.vo.TB_TIM_MST_VO;

@Service("cmmnService")
public class CmmnService {

	@Autowired
	private TB_TIM_MST_Mapper tbTimMstMapper;

	public List<TB_TIM_MST_VO> listTeam(TB_TIM_MST_VO vo) throws Exception {
		List<TB_TIM_MST_VO> list = tbTimMstMapper.TB_TIM_MST_PL001(vo);
		return list;
	}
	
	

}
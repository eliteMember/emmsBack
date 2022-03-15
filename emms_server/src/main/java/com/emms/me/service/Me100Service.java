package com.emms.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.TB_MEM_MST_Mapper;
import com.emms.vo.TB_MEM_MST_VO;

@Service("me100Service")
public class Me100Service {

	@Autowired
	private TB_MEM_MST_Mapper tbMemMstMapper;

	public List<TB_MEM_MST_VO> selectMemList(TB_MEM_MST_VO paramVO) throws Exception {
		return tbMemMstMapper.TB_MEM_MST_PL001(paramVO);
	}
	
	public TB_MEM_MST_VO selectMemTargetData(String memNum) throws Exception {
		return tbMemMstMapper.TB_MEM_MST_PL002(memNum);
	}

}
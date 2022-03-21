package com.emms.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emms.mapper.TB_MEM_MST_Mapper;

@Service("me100Service")
public class Me100Service {

	@Autowired
	private TB_MEM_MST_Mapper tbMemMstMapper;

	public List<Me100_TB_MEM_MST_VO> selectMemList(Me100_TB_MEM_MST_VO paramVO) throws Exception {
		return tbMemMstMapper.TB_MEM_MST_PL001(paramVO);
	}
	
	public Me100_TB_MEM_MST_VO selectMemTargetData(String memNum) throws Exception {
		return tbMemMstMapper.TB_MEM_MST_PL002(memNum);
	}
	
	@Transactional
	public Integer insertMemData(Me100_TB_MEM_MST_VO paramVO) throws Exception {
		
		int returnNum =  tbMemMstMapper.TB_MEM_MST_PL003(paramVO);
		if  ( returnNum == 1 )  {
			if  ( null != paramVO.getMemNum() && !"".equals(paramVO.getMemNum()) )  returnNum = tbMemMstMapper.TB_MEM_MST_PL004(paramVO);
		}
		
		return returnNum;
	}

}
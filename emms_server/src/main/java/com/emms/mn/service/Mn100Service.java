package com.emms.mn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.TB_USR_MST_Mapper;
import com.emms.vo.TB_USR_MST_VO;

@Service("mn100Service")
public class Mn100Service {

	@Autowired
	private TB_USR_MST_Mapper tbUsrMstMapper;

	public LoginVO selectMember(TB_USR_MST_VO vo) throws Exception {
		
		LoginVO loginVO = tbUsrMstMapper.TB_USR_MST_PS001(vo);

		return loginVO;
	}
	
	

}
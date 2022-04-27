package com.emms.mn.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.TB_CD_LST_Mapper;
import com.emms.mapper.TB_TIM_MST_Mapper;
import com.emms.mapper.TB_USR_MST_Mapper;
import com.emms.vo.TB_CD_LST_VO;
import com.emms.vo.TB_TIM_MST_VO;

@Service("Mn200Service")
public class Mn200Service {
	
	@Autowired
	private TB_USR_MST_Mapper tbUsrMstMapper;
	@Autowired
	private TB_CD_LST_Mapper tbCdLstMapper;
	@Autowired
	private TB_TIM_MST_Mapper tbTimMstMapper;
	
	// 가입여부 존재 체크
	public LoginVO existUserInfo(HashMap<String, String> map) throws Exception {
		
		LoginVO userInfo = tbUsrMstMapper.TB_USR_MST_PS009(map);
		
		
		return userInfo;
	}
	
	// 아이디 중복체크
	public Integer selectChild(HashMap<String , String> map) throws Exception{
		
		int returnNum = tbUsrMstMapper.TB_USR_MST_PS004(map);
		
		return returnNum;
		
	}
	
	 
	// 직위
	public List<TB_CD_LST_VO> listInc(TB_CD_LST_VO vo) throws Exception{
		
		List<TB_CD_LST_VO> incList = tbCdLstMapper.TB_CD_LST_PL003(vo);
		
		return incList;
	}
	
	// 직책
	public List<TB_CD_LST_VO> listApo(TB_CD_LST_VO vo) throws Exception{
		
		List<TB_CD_LST_VO> apoList = tbCdLstMapper.TB_CD_LST_PL004(vo);
		
		return apoList;
	}
	
	// 팀명 존재여부
	public TB_TIM_MST_VO existTeamName(HashMap<String, String> map) throws Exception {
		
		TB_TIM_MST_VO teamInfo = tbTimMstMapper.TB_TIM_MST_PS001(map);
		
		
		return teamInfo;
	}
	
	// 팀명이 없다면
	public Integer insertTeam(HashMap<String, String> map) throws Exception {
		
		int returnNum = tbTimMstMapper.TB_TIM_MST_PI001(map);
		
		return returnNum;
	}

	// 회원가입 (신규)
	public Integer insertMember(HashMap<String , String> map) throws Exception {
		
		int returnNum = tbUsrMstMapper.TB_USR_MST_PI002(map);
		
		return returnNum;
	}
	
	// 회원가입 (update)
	public Integer updateMember(HashMap<String , String> map) throws Exception{
		
		int returnNum = tbUsrMstMapper.TB_USR_MST_PU004(map);
		
		return returnNum;
	}

}
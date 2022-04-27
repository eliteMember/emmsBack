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

@Service("Mn300Service")
public class Mn300Service {
	
	@Autowired
	private TB_USR_MST_Mapper tbUsrMstMapper;
	@Autowired
	private TB_CD_LST_Mapper tbCdLstMapper;
	@Autowired
	private TB_TIM_MST_Mapper tbTimMstMapper;
	
	// 회원정보 select
	public LoginVO userInfo(HashMap<String, String> map) throws Exception {
		
		LoginVO userInfo = tbUsrMstMapper.TB_USR_MST_PS010(map);
		
		System.out.println("userInfo : " + userInfo);
		
		return userInfo;
	}
	
	// 기존 비밀번호 확인
	public Integer chkPw(HashMap<String, String> map) throws Exception {
		
		int returnNum = tbUsrMstMapper.TB_USR_MST_PS011(map);
		
		return returnNum;
	}
	
	// 팀명 존재여부
	public TB_TIM_MST_VO existTeamName(HashMap<String, String> map) throws Exception {
		
		TB_TIM_MST_VO teamInfo = tbTimMstMapper.TB_TIM_MST_PS002(map);
		
		System.out.println("teamInfo : " + teamInfo);
		
		return teamInfo;
	}
	
	// 팀명이 없다면
	public Integer insertTeam(HashMap<String, String> map) throws Exception {
		
		int returnNum = tbTimMstMapper.TB_TIM_MST_PI002(map);
		
		return returnNum;
	}
	
	// 회원수정 (update)
	public Integer updateMember(HashMap<String , String> map) throws Exception{
		
		int returnNum = tbUsrMstMapper.TB_USR_MST_PU004(map);
		
		return returnNum;
	}


}
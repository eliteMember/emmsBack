
package com.emms.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.mn.service.LoginVO;
import com.emms.vo.TB_USR_MST_VO;

@Mapper
public interface TB_USR_MST_Mapper {

	LoginVO TB_USR_MST_PS001(TB_USR_MST_VO vo);
	
	void TB_USR_MST_PU001(HashMap<String, String> map);
	
	void TB_USR_MST_PU002(HashMap<String, String> map);
	
	String TB_USR_MST_PS002();
	
	List<LoginVO> TB_USR_MST_PS003(String usrNum);
	
	public Integer TB_USR_MST_PI001(HashMap<String, String> map);
	
	public Integer TB_USR_MST_PU003(HashMap<String, String> map);
	
	List<LoginVO> TB_USR_MST_PL001(String usrName);
	
	// 회원가입 등록(insert)
	public Integer TB_USR_MST_PI002(HashMap<String, String> map);
	
	// 회원가입 등록(update)
	public Integer TB_USR_MST_PU004(HashMap<String, String> map);
	
	// 유저존재 기본 select 데이터
	LoginVO TB_USR_MST_PS009(HashMap<String, String> map);
	
	// 아이디 중복 체크
	public Integer TB_USR_MST_PS004(HashMap<String, String> map); 
	
	
	// 회원정보 가져오기 USR_NUM
	LoginVO TB_USR_MST_PS010(HashMap<String, String> map);
	
	// 기존 비밀번호 체크
	public Integer TB_USR_MST_PS011(HashMap<String, String> map); 
	
}

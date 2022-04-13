package com.emms.mn.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emms.mapper.TB_CD_LST_Mapper;
import com.emms.mapper.TB_USR_MST_Mapper;
import com.emms.vo.TB_CD_LST_VO;
import com.emms.vo.TB_TIM_MST_VO;
import com.emms.vo.TB_USR_MST_VO;

@Service("Mn200Service")
public class Mn200Service {
	
	@Autowired
	private TB_USR_MST_Mapper tbUsrMstMapper;
	@Autowired
	private TB_CD_LST_Mapper tbCdLstMapper;
	
	// 이름 생년월일 비교 체크
	public Integer nmBirChkData(HashMap<String , String> map) throws Exception {
		
		int returnNum = tbUsrMstMapper.TB_USR_MST_PS005(map);
		System.out.println("returnNum : " + returnNum);
		
		return returnNum;
	}
	
	// 회원가입 하기
	@Transactional
	public void insertMember(TB_USR_MST_VO vo) throws Exception {
		vo.setIncCd("0");
		vo.setEduCd("4");
		vo.setJoinYn("Y");
		vo.setDelYn("N");
		tbUsrMstMapper.TB_USR_MST_PI002(vo);
	}
	 
	
	public List<TB_USR_MST_VO> selectParent() throws Exception{
		
		List<TB_USR_MST_VO> tbUsrMstVo = tbUsrMstMapper.TB_USR_MST_PS006();
		
		return tbUsrMstVo;
	}
	
	public List<TB_USR_MST_VO> selectChild(String val) throws Exception{
		
		List<TB_USR_MST_VO> tbUsrMstVo = tbUsrMstMapper.TB_USR_MST_PS004(val);
		
		return tbUsrMstVo;
		
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
	


}
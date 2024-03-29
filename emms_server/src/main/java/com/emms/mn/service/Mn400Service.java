package com.emms.mn.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.TB_USR_MST_Mapper;
import com.emms.vo.TB_USR_MST_VO;

@Service("mn400service")
public class Mn400Service {
	
	@Autowired
	TB_USR_MST_Mapper tb_usr_mst_mapper;
	
	
	
	public void updateList(HashMap<String, String> map) throws Exception{

		tb_usr_mst_mapper.TB_USR_MST_PU001(map);
	}
	public void updatePW(HashMap<String, String> map) throws Exception{

		tb_usr_mst_mapper.TB_USR_MST_PU002(map);
	}
	
	public String totalCnt() throws Exception{
		
		String totalCnt = tb_usr_mst_mapper.TB_USR_MST_PS002();
		
		return totalCnt;
	}
	
	public List<LoginVO> targetData(String usrNum) throws Exception {
		
		List<LoginVO> loginVO = tb_usr_mst_mapper.TB_USR_MST_PS003(usrNum);

		return loginVO;
	}
	
	public Integer insertUsrData(HashMap<String , String> map) throws Exception{
		
		int returnNum = tb_usr_mst_mapper.TB_USR_MST_PI001(map);
		
		return returnNum;
	}
	
	public Integer updateUsrData(HashMap<String , String> map) throws Exception{
		
		int returnNum = tb_usr_mst_mapper.TB_USR_MST_PU003(map);
		
		return returnNum;
	}
	
	public List<LoginVO> searchName(String usrName) throws Exception {
		
		List<LoginVO> loginVO = tb_usr_mst_mapper.TB_USR_MST_PL001(usrName);

		return loginVO;
	}
}

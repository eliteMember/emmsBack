
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
	
}

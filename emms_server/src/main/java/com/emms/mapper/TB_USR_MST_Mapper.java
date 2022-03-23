
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
}


package com.emms.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.mn.service.LoginVO;
import com.emms.vo.TB_USR_MST_VO;

@Mapper
public interface TB_USR_MST_Mapper {

	LoginVO TB_USR_MST_PS001(TB_USR_MST_VO vo);
	
	List<TB_USR_MST_VO> TB_USR_MST_VL001();
	
	void TB_USR_MST_PU001(HashMap<String, String> map);
	
	void TB_USR_MST_PU002(String id, String bir);
}

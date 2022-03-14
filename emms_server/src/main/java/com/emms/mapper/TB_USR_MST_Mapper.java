
package com.emms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.vo.TB_USR_MST_VO;

@Mapper
public interface TB_USR_MST_Mapper {

	TB_USR_MST_VO TB_USR_MST_PS001(TB_USR_MST_VO vo);
	
	List<TB_USR_MST_VO> TB_USR_MST_VL001();
	
}

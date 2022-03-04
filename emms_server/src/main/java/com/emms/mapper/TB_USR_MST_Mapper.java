
package com.emms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.emms.vo.TB_USR_MST_VO;

@Mapper
public interface TB_USR_MST_Mapper {

	TB_USR_MST_VO TB_USR_MST_PS001(TB_USR_MST_VO vo);
	
}

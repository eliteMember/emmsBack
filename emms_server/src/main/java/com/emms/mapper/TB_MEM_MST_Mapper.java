
package com.emms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.emms.vo.TB_MEM_MST_VO;

@Mapper
public interface TB_MEM_MST_Mapper {

	public List<TB_MEM_MST_VO> TB_MEM_MST_PL001(TB_MEM_MST_VO paramVO) throws Exception;
	
	public TB_MEM_MST_VO TB_MEM_MST_PL002(@Param("memNum")String memNum) throws Exception;
	
	public Integer TB_MEM_MST_PL003(TB_MEM_MST_VO paramVO) throws Exception;
	
}

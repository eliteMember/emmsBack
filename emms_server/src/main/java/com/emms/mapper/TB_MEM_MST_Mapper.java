
package com.emms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.emms.me.service.Me100_TB_MEM_MST_VO;

@Mapper
public interface TB_MEM_MST_Mapper {

	public List<Me100_TB_MEM_MST_VO> TB_MEM_MST_PL001(Me100_TB_MEM_MST_VO paramVO) throws Exception;
	
	public Me100_TB_MEM_MST_VO TB_MEM_MST_PL002(@Param("memNum")String memNum) throws Exception;
	
	public Integer TB_MEM_MST_PL003(Me100_TB_MEM_MST_VO paramVO) throws Exception;
	
	public Integer TB_MEM_MST_PL004(Me100_TB_MEM_MST_VO paramVO) throws Exception;
	
}

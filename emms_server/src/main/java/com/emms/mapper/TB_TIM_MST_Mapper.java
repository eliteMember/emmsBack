
package com.emms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.vo.TB_MEM_MST_VO;
import com.emms.vo.TB_TIM_MST_VO;

@Mapper
public interface TB_TIM_MST_Mapper {

	public List<TB_TIM_MST_VO> TB_TIM_MST_PL001(TB_TIM_MST_VO paramVO) throws Exception;
	
}

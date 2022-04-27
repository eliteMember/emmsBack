
package com.emms.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.mn.service.LoginVO;
import com.emms.vo.TB_MEM_MST_VO;
import com.emms.vo.TB_TIM_MST_VO;

@Mapper
public interface TB_TIM_MST_Mapper {

	public List<TB_TIM_MST_VO> TB_TIM_MST_PL001(TB_TIM_MST_VO paramVO) throws Exception;
	
	// 팀 조회 (팀명비교)
	public TB_TIM_MST_VO TB_TIM_MST_PS001(HashMap<String, String> map);
	public TB_TIM_MST_VO TB_TIM_MST_PS002(HashMap<String, String> map);
	
	// 팀 생성
	public Integer TB_TIM_MST_PI001(HashMap<String, String> map);
	public Integer TB_TIM_MST_PI002(HashMap<String, String> map);
	
}

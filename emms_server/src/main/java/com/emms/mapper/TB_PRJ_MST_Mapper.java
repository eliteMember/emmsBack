
package com.emms.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.vo.TB_PRJ_MST_VO;

@Mapper
public interface TB_PRJ_MST_Mapper {

	List<TB_PRJ_MST_VO> TB_PRJ_MST_PL001(HashMap<String, String> paramMap);
}

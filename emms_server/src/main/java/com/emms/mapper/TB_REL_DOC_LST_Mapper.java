
package com.emms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emms.vo.TB_REL_DOC_LST_VO;

@Mapper
public interface TB_REL_DOC_LST_Mapper {

	List<TB_REL_DOC_LST_VO> TB_REL_DOC_LST_PL001();
	
}

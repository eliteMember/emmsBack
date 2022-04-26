
package com.emms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.emms.doc.service.Do101_TB_REL_DOC_LST_VO;
import com.emms.vo.TB_REL_DOC_LST_VO;

@Mapper
public interface TB_REL_DOC_LST_Mapper {

	List<TB_REL_DOC_LST_VO> TB_REL_DOC_LST_PL001();
	
	List<Do101_TB_REL_DOC_LST_VO> TB_REL_DOC_LST_PL002(Map<String, Object> map);
}

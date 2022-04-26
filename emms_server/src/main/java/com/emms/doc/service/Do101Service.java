package com.emms.doc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.TB_REL_DOC_LST_Mapper;
import com.emms.vo.TB_REL_DOC_LST_VO;

@Service("do400service")
public class Do101Service {
	
	@Autowired
	TB_REL_DOC_LST_Mapper tb_rel_doc_lst_mapper;
	
	public List<Do101_TB_REL_DOC_LST_VO> searchList(Map<String, Object> map) throws Exception{
		
		List<Do101_TB_REL_DOC_LST_VO> List = tb_rel_doc_lst_mapper.TB_REL_DOC_LST_PL002(map);
		
		return List;
	}
	
}

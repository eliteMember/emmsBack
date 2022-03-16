package com.emms.mn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.TB_USR_MST_Mapper;
import com.emms.vo.TB_USR_MST_VO;

@Service("mn400service")
public class Mn400Service {
	
	@Autowired
	TB_USR_MST_Mapper tb_usr_mst_mapper;
	
	public List<TB_USR_MST_VO> selectList() throws Exception{
		
		List<TB_USR_MST_VO> tbUsrMstVo = tb_usr_mst_mapper.TB_USR_MST_VL001();
		
		return tbUsrMstVo;
	}
}

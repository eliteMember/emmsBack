package com.emms.cmmn.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.TB_CD_LST_Mapper;
import com.emms.vo.TB_CD_LST_VO;

@Service("codeService")
public class CodeService {
	
	@Autowired
	private TB_CD_LST_Mapper tb_cd_lst_mapper;
	
	public List<TB_CD_LST_VO> selectParent() throws Exception{
		
		List<TB_CD_LST_VO> tbCdLstVo = tb_cd_lst_mapper.TB_CD_LST_PL002();
		
		return tbCdLstVo;
	}
	
	public List<TB_CD_LST_VO> selectChild(String val) throws Exception{
		
		List<TB_CD_LST_VO> tbCdLstVo = tb_cd_lst_mapper.TB_CD_LST_PL001(val);
		
		return tbCdLstVo;
		
	}
}

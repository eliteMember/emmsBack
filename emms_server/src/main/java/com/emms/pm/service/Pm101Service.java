package com.emms.pm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.mapper.TB_PRJ_MHR_LST_Mapper;
import com.emms.mapper.TB_PRJ_MHR_MM_LST_Mapper;
import com.emms.mapper.TB_PRJ_MST_Mapper;
import com.emms.vo.TB_PRJ_MHR_LST_VO;
import com.emms.vo.TB_PRJ_MHR_MM_LST_VO;
import com.emms.vo.TB_PRJ_MST_VO;

@Service("pm101Service")
public class Pm101Service {

	@Autowired
	private TB_PRJ_MST_Mapper tbPrjMstMapper;
	
	@Autowired
	private TB_PRJ_MHR_LST_Mapper tbPrjMhrLstMapper;
	
	@Autowired
	private TB_PRJ_MHR_MM_LST_Mapper tbPrjMhrMmLstMapper;

	/**
	 * 프로젝트 목록 조회
	 * @author : 오태윤
	 * @date   : 2022-03-28
	 * @return : List<TB_PRJ_MST_VO>
	 * @throws Exception 
	 */
	public List<TB_PRJ_MST_VO> listPrjMst(HashMap<String, String> paramMap) throws Exception {

		return tbPrjMstMapper.TB_PRJ_MST_PL001(paramMap);
	}
	
	/**
	 * 프로젝트 실투입공수 조회
	 * @author : 오태윤
	 * @date   : 2022-03-28
	 * @return : List<WrkMcVo>
	 * @throws Exception 
	 */
	public List<WrkMcVo> listPrjMhr(String prjNum) throws Exception {
		
		TB_PRJ_MHR_LST_VO paramMhr = new TB_PRJ_MHR_LST_VO();
		
		paramMhr.setPrjNum(prjNum);	//프로젝트번호
		paramMhr.setMhrKndCd("30");	//공수종류코드 - 10:제안, 20:투입, 30:실투입
		
		//대분류 조회
		List<WrkMcVo> lstWrkMc = tbPrjMhrLstMapper.TB_PRJ_MHR_LST_PL002(paramMhr);
		List<WrkMcVo> rsWrkMc = new ArrayList<WrkMcVo>(); 
		for(WrkMcVo mcRow : lstWrkMc) {
			//중분류 조회
			paramMhr.setWrkMcNm(mcRow.getWrkMcNm());
			List<WrkScVo> lstWrkSc = tbPrjMhrLstMapper.TB_PRJ_MHR_LST_PL003(paramMhr);
			List<WrkScVo> rsWrkSc = new ArrayList<WrkScVo>();
			for(WrkScVo scRow : lstWrkSc) {
				//소분류(인력) 조회
				paramMhr.setWrkScNm(scRow.getWrkScNm());
				List<MemVo> lstMem = tbPrjMhrLstMapper.TB_PRJ_MHR_LST_VL001(paramMhr);
				List<MemVo> rsMem = new ArrayList<MemVo>();
				for(MemVo memRow : lstMem) {
					//월투입공수 조회
					paramMhr.setMemNum(memRow.getMemNum());
					List<TB_PRJ_MHR_MM_LST_VO> 	rsMhr = tbPrjMhrMmLstMapper.TB_PRJ_MHR_MM_LST_PL001(paramMhr);
					
					//소분류(인력) 리스트 추가
					memRow.setMhr(rsMhr);
					rsMem.add(memRow);
				}
				//중분류 리스트 추가
				scRow.setMem(lstMem);
				rsWrkSc.add(scRow);
			}
			//대분류 리스트 추가
			mcRow.setWrkSc(lstWrkSc);
			rsWrkMc.add(mcRow);
		}
		
		return rsWrkMc;
	}
}
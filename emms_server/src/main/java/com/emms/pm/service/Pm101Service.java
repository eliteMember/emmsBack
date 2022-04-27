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
					List<MhrVo> rsMhr = tbPrjMhrMmLstMapper.TB_PRJ_MHR_MM_LST_PL001(paramMhr);
					
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
	
	/**
	 * 비어있는 프로젝트 기간 공수 조회
	 * @author : 오태윤
	 * @date   : 2022-04-25
	 * @return : List<MhrVo>
	 * @throws Exception 
	 */
	public List<MhrVo> listNewPrjMhr(String prjNum) throws Exception {
		
		TB_PRJ_MHR_LST_VO param = new TB_PRJ_MHR_LST_VO();
		
		param.setPrjNum(prjNum);
		param.setMhrKndCd("30");
		param.setMemNum("");
		
		List<MhrVo> rsMhr = tbPrjMhrMmLstMapper.TB_PRJ_MHR_MM_LST_PL001(param);
		
		return rsMhr;
	}
	
	/**
	 * 투입공수 저장
	 * @author : 오태윤
	 * @date   : 2022-04-26
	 * @return : Integer 저장 성공건수
	 * @throws Exception 
	 */
	public Integer saveMhr(List<WrkMcVo> paramList, String prjNum) throws Exception {
		
		//저장 건수
		Integer cntSaveMc = 0;
		
		List<TB_PRJ_MHR_LST_VO> saveList = new ArrayList<TB_PRJ_MHR_LST_VO>();
	
		for(WrkMcVo wrkMc : paramList) {
			for(WrkScVo wrkSc : wrkMc.getWrkSc()) {
				for(MemVo mem : wrkSc.getMem()) {
					TB_PRJ_MHR_LST_VO savePrjMhrVo = new TB_PRJ_MHR_LST_VO();
					savePrjMhrVo.setPrjNum(prjNum);
					savePrjMhrVo.setMhrKndCd("30");
					savePrjMhrVo.setMemNum(mem.getMemNum());
					savePrjMhrVo.setSrtOdr("0");
					savePrjMhrVo.setWrkMcNm(wrkMc.getWrkMcNm());
					savePrjMhrVo.setWrkScNm(wrkSc.getWrkScNm());
					savePrjMhrVo.setRolNm(mem.getRolNm());
					savePrjMhrVo.setMemRnkCd(mem.getMemRnkCd());
					
					int startFlag = 0;	//투입시작일자 플래그 ( 0 = 투입X / 1 = 투입)
					int endFlag = 0;	//투입종료일자 플래그 ( 0 = 투입종료X / 1 = 투입종료)
					
					for(MhrVo mhr : mem.getMhr()) {
						if(startFlag == 0 && Double.parseDouble(mhr.getMmPurQty()) > 0) {
							savePrjMhrVo.setDepStartDt(mem.getDepStartDt()+"01");
							startFlag = 1;
						}
						
						//TODO : 종료일 계산.
//						if(startFlag == 1 && endFlag == 0 && Integer.parseInt(mhr.getMmPurQty()) = 0) {
//							
//						}
						
						//TODO : 프로젝트공수월내역 insert or update or delete (실투입이 줄어들면 프로젝트공수월내역은 삭제?)
					}

					saveList.add(savePrjMhrVo);
				}
			}
		}
		
		
		cntSaveMc += tbPrjMhrLstMapper.TB_PRJ_MHR_LST_IL001(saveList);
		
		return cntSaveMc;
	}
}
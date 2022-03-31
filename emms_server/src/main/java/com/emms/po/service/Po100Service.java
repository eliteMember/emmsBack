package com.emms.po.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emms.cmmn.SessionVO;
import com.emms.mapper.TB_PRJ_MST_Mapper;
import com.emms.vo.TB_PRJ_MST_VO;

@Service("po100Service")
public class Po100Service {
	
	@Autowired
	TB_PRJ_MST_Mapper tbPrjMstMapper;
	
	@Transactional
	public Map<String, Object> prjBaseInfoInsert( HttpServletRequest request, Po100VO paramVO ) {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		SessionVO sessionVO = (SessionVO) session.getAttribute("sessionVO");
		
		TB_PRJ_MST_VO tbPrjMstVo = new TB_PRJ_MST_VO();
		tbPrjMstVo.setPrjNum        (paramVO.getPrjNum()    	);
		tbPrjMstVo.setPrjNm         (paramVO.getPrjNm()     	);
		tbPrjMstVo.setPrjDivCd      (paramVO.getPrjDivCd()  	);
		tbPrjMstVo.setPrjStsCd      (paramVO.getPrjStsCd()  	);
		tbPrjMstVo.setPrjNom        (paramVO.getPrjNom()    	);
		tbPrjMstVo.setPrjPlcNm      (paramVO.getPrjPlcNm()  	);
		tbPrjMstVo.setPrjRefCmt     (paramVO.getPrjRefCmt() 	);
		tbPrjMstVo.setTimNum        (paramVO.getTimNum()    	);
		//tbPrjMstVo.setDscPer        (paramVO.getDscPer()    	);
		//tbPrjMstVo.setEstAmt        (paramVO.getEstAmt()    	);
		tbPrjMstVo.setPmtMtdCd      ("00"  	);
		tbPrjMstVo.setDelYn         ("N"     	);
		//tbPrjMstVo.setCrtDtm        (paramVO.getCrtDtm()    	);
		tbPrjMstVo.setCrtUsrNum     (sessionVO.getLoginVO().getUsrNum() 	);
		//tbPrjMstVo.setMdfDtm        (paramVO.getMdfDtm()    	);
		tbPrjMstVo.setMdfUsrNum     (sessionVO.getLoginVO().getUsrNum() 	);
		tbPrjMstVo.setPrjStartYm    (paramVO.getPrjStartYm()	);
		tbPrjMstVo.setPrjEndYm		(paramVO.getPrjEndYm()		);
		
		int resultVal = tbPrjMstMapper.TB_PRJ_MST_EI001(tbPrjMstVo);
		
		
		System.out.println("============= resultPrjNum : "+tbPrjMstVo.getPrjNum());
		
		returnMap.put("result", true);
		returnMap.put("message", "성공~");
		
		
		return returnMap;
	}

}
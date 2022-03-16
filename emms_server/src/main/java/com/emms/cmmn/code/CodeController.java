package com.emms.cmmn.code;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emms.mapper.TB_CD_LST_Mapper;
import com.emms.vo.TB_CD_LST_VO;

@RestController
@RequestMapping("/api/code")
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	@GetMapping("/getCode")
	public HashMap<String, List<TB_CD_LST_VO>> getCodeList(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		
		HashMap<String, List<TB_CD_LST_VO>> result = new HashMap<String, List<TB_CD_LST_VO>>();
		
		List<TB_CD_LST_VO> lstParent = codeService.selectParent();
		
		for(int i=0; i<lstParent.size(); i++) {
			List<TB_CD_LST_VO> lstChild = codeService.selectChild(lstParent.get(i).getCdDivVal());
			result.put(lstParent.get(i).getCdDivVal(), lstChild);
		}
		
		//세선저장
		session.setAttribute("code", result);
		//리엑트로 데이터 전송
		return result;
	};
}

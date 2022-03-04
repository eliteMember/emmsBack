/**
 * 헤더에 노출되는 메뉴 컨트롤러
 * @author : 오태윤
 * @date   : 2022-03-03
 */
package com.emms.cmmn.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emms.mapper.TB_MNU_MST_Mapper;
import com.emms.vo.TB_MNU_MST_VO;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
	
	@Autowired
	TB_MNU_MST_Mapper mnuMstMapper;
	
	/**
	 * 메뉴목록 조회
	 * @author : 오태윤
	 * @date   : 2022-03-03
	 * @return : HashMap<List<TB_MNU_MST_VO>>
	 */
	@SuppressWarnings("null")
	@GetMapping("/getList")
	public HashMap<String, List<TB_MNU_MST_VO>> searchMenuList() {
		//로그인한 계정을 입력받아 권한에 따른 메뉴 리턴 필요
		HashMap<String, List<TB_MNU_MST_VO>> result = new HashMap<String, List<TB_MNU_MST_VO>>();
		List<TB_MNU_MST_VO> lstChild = new ArrayList<TB_MNU_MST_VO>();
		
		HashMap<String, String> paramMap = new HashMap<String, String>();
		
		List<TB_MNU_MST_VO> lstParent = mnuMstMapper.TB_MNU_MST_PL001(paramMap);
		result.put("parent", lstParent);
		
		for(int i=0; i<lstParent.size(); i++) {
			paramMap.put("mnuNum", lstParent.get(i).getMnuNum());
			lstChild = mnuMstMapper.TB_MNU_MST_PL001(paramMap);
			result.put(lstParent.get(i).getMnuNum(), lstChild);
		}
		
		return result;
	}
}

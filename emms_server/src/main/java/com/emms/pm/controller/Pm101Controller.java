/**
 * 실투입공수관리 화면 관련 컨트롤러
 * @author : 오태윤
 * @date   : 2022-03-28
 */

package com.emms.pm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import com.emms.pm.service.MhrVo;
import com.emms.pm.service.Pm101Service;
import com.emms.pm.service.WrkMcVo;
import com.emms.vo.TB_PRJ_MST_VO;

@RestController
@RequestMapping("/api/pm101")
public class Pm101Controller {
	
	@Resource(name = "pm101Service")
	private Pm101Service pm101Service;
	
	/**
	 * 프로젝트 조회
	 * @author : 오태윤
	 * @date   : 2022-03-03
	 * @return : List<TB_PRJ_MST_VO>
	 * @throws Exception 
	 */
	@PostMapping(value = "/getPrjList")
	public ResponseEntity<List<TB_PRJ_MST_VO>> listPrjMst(HttpServletRequest request, @RequestBody HashMap<String,String> paramMap) throws Exception {
		
		List<TB_PRJ_MST_VO> result = new ArrayList<TB_PRJ_MST_VO>();
		result = pm101Service.listPrjMst(paramMap);
		
		return ResponseEntity.ok(result);	
	}
	
	/**
	 * 프로젝트 실투입공수 조회
	 * @author : 오태윤
	 * @date   : 2022-03-28
	 * @return : List<WrkMcVo>
	 * @throws Exception 
	 */
	@PostMapping(value = "/getMhrList")
	public ResponseEntity<List<WrkMcVo>> listRealMhr(HttpServletRequest request, @RequestBody HashMap<String,String> paramMap) throws Exception {
		
		List<WrkMcVo> result = new ArrayList<WrkMcVo>();
		result = pm101Service.listPrjMhr(paramMap.get("prjNum"));
		
		return ResponseEntity.ok(result);	
	}
	
	/**
	 * 프로젝트 실투입공수 조회
	 * @author : 오태윤
	 * @date   : 2022-03-28
	 * @return : List<WrkMcVo>
	 * @throws Exception 
	 */
	@PostMapping(value = "/getNewMhrList")
	public ResponseEntity<List<MhrVo>> listNewPrjMhr(HttpServletRequest request, @RequestBody HashMap<String,String> paramMap) throws Exception {
		
		List<MhrVo> result = pm101Service.listNewPrjMhr(paramMap.get("prjNum"));
		
		return ResponseEntity.ok(result);
		
	}
	
	/**
	 * 투입공수 저장
	 * @author : 오태윤
	 * @date   : 2022-04-26
	 * @return : List<WrkMcVo>
	 * @throws Exception 
	 */
	@PostMapping(value = "/saveMhr")
	public ResponseEntity<Integer> saveMhr(HttpServletRequest request
			, @RequestBody List<WrkMcVo> paramList, @RequestPayload String prjNum) throws Exception {
		
		Integer result = pm101Service.saveMhr(paramList, prjNum);
		
		return ResponseEntity.ok(result);
	}
}
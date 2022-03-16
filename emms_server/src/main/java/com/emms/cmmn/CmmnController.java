package com.emms.cmmn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emms.cmmn.service.CmmnService;
import com.emms.mapper.TB_TIM_MST_Mapper;
import com.emms.vo.TB_TIM_MST_VO;

@RestController
public class CmmnController {
	
	@Autowired
	private CmmnService cmmnService;
	
	/*
	 * interceptor 테스트용도
	 * */
	@GetMapping(value = "/api/cmmn/getSession")
	public ResponseEntity<SessionVO> getSession(
			HttpServletRequest request, 
			ModelMap model) throws Exception {
		
		HttpSession session = request.getSession();
		SessionVO sessionVO = null;
		if( session.getAttribute("sessionVO") == null ) {
			sessionVO = new SessionVO(); 
		}else {
			sessionVO = (SessionVO) session.getAttribute("sessionVO");
		}
		
		return ResponseEntity.ok(sessionVO);
	}
	
	
	/*
	 * interceptor 테스트용도
	 * */
	@GetMapping(value = "/api/getSession")
	public ResponseEntity<SessionVO> test(
			HttpServletRequest request, 
			ModelMap model) throws Exception {
		
		HttpSession session = request.getSession();
		SessionVO sessionVO = null;
		if( session.getAttribute("sessionVO") == null ) {
			sessionVO = new SessionVO(); 
		}else {
			sessionVO = (SessionVO) session.getAttribute("sessionVO");
		}
		
		return ResponseEntity.ok(sessionVO);
	}
	
	
	/*
	 * interceptor 테스트용도
	 * */
	@GetMapping(value = "/api/cmmn/listTeam")
	public ResponseEntity<Map<String, Object>> listTeam(
			@RequestParam TB_TIM_MST_VO paramVO, 
			HttpServletRequest request,
			
			ModelMap model) throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		List<TB_TIM_MST_VO> list = cmmnService.listTeam(paramVO);
		returnMap.put("list", list);
		
		return ResponseEntity.ok(returnMap);
	}
	
}
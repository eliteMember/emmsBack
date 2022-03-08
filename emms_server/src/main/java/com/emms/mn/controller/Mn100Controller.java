package com.emms.mn.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emms.cmmn.SessionVO;
import com.emms.mn.service.Mn100Service;
import com.emms.vo.TB_USR_MST_VO;

@RestController
public class Mn100Controller {
	
	@Resource(name = "mn100Service")
	private Mn100Service mn100Service;
	
	@PostMapping(value = "/api/login")
	public ResponseEntity<SessionVO> getSession(
			HttpServletRequest request,
			@RequestBody Map<String,String> paramMap,
			ModelMap model) throws Exception {
		
		TB_USR_MST_VO paramVO = new TB_USR_MST_VO();
		paramVO.setLoginId(paramMap.get("loginId"));
		paramVO.setPassNum(paramMap.get("password"));
		TB_USR_MST_VO resultVO = mn100Service.selectMember(paramVO);
		
		SessionVO sessionVO = new SessionVO();
		if( !ObjectUtils.isEmpty(resultVO) ) {
			sessionVO = new SessionVO(resultVO);
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionVO", sessionVO);
		}
		
		return ResponseEntity.ok(sessionVO);
		
	}
	
	@GetMapping(value = "/api/logout")
	public ResponseEntity<HttpStatus> getSession(
			HttpServletRequest request,
			ModelMap model) throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return ResponseEntity.ok(HttpStatus.OK);
		
	}

	
	
}
package com.emms.mn.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emms.cmmn.SessionVO;
import com.emms.mn.service.Mn100Service;
import com.emms.vo.TB_USR_MST_VO;

@RestController
public class Mn100Controller {
	
	@Resource(name = "mn100Service")
	private Mn100Service mn100Service;
	
	@GetMapping(value = "/api/login")
	public ResponseEntity<SessionVO> getSession(
			HttpServletRequest request,
			@RequestParam(required=true) String loginId,
			@RequestParam(required=true) String password,
			ModelMap model) throws Exception {
		
		TB_USR_MST_VO paramVO = new TB_USR_MST_VO();
		paramVO.setLoginId(loginId);
		paramVO.setPassNum(password);
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
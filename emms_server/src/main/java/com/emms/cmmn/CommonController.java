package com.emms.cmmn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
	
	@GetMapping(value = "/api/getSession")
	public ResponseEntity<SessionVO> adminMemberList(
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
	
	
}
package com.emms.api.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emms.api.member.service.ApiMemberService;
import com.emms.api.member.service.ApiMemberVO;
import com.emms.api.member.service.TestVO;

@RestController
public class ApiMemberController {

	@Resource(name = "apiMemberService")
	private ApiMemberService apiMemberService;

	@RequestMapping(value = "/api/member/list2.do", method = RequestMethod.GET)
	public ResponseEntity<TestVO> memberList2( 
			//@RequestBody ApiMemberVO paramVO,
			@RequestBody TestVO paramVO,
			HttpServletRequest request, 
			ModelMap model) throws Exception {
		try {
			//ApiMemberVO vo = apiMemberService.selectMember(paramVO);
			
			TestVO vo = apiMemberService.selectTest(paramVO);
			
			if(vo == null){ 
				return ResponseEntity.noContent().build();
			}
			
			System.out.println("============ success ============");
			return ResponseEntity.ok(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("============ error ============");
			return ResponseEntity.status(500).build();
		}

	}
	
	
}
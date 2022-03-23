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

import com.emms.pm.service.Pm101Service;
import com.emms.vo.TB_PRJ_MST_VO;

@RestController
@RequestMapping("/api/pm101")
public class Pm101Controller {
	
	@Resource(name = "pm101Service")
	private Pm101Service pm101Service;
	
	@PostMapping(value = "/getPrjList")
	public ResponseEntity<List<TB_PRJ_MST_VO>> listPrjMst(HttpServletRequest request, @RequestBody HashMap<String,String> paramMap) throws Exception {
		
		List<TB_PRJ_MST_VO> result = new ArrayList<TB_PRJ_MST_VO>();
		result = pm101Service.listPrjMst(paramMap);
		
		return ResponseEntity.ok(result);
		
	}
}
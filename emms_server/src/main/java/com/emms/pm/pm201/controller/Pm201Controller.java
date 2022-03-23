package com.emms.pm.pm201.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emms.me.service.Me100_TB_MEM_MST_VO;
import com.emms.pm.pm201.service.Pm201Service;

@RestController
public class Pm201Controller {
	
	@Resource(name = "pm201Service")
	private Pm201Service pm201Service;
	
	@PostMapping(value = "/api/prjTrtCstList")
	public ResponseEntity<Map<String,Object>> getMemList(
			HttpServletRequest request,
			@RequestBody Map<String,String> paramMap,
			ModelMap model) throws Exception {
		
		String data = paramMap.get("searchProject");
		
		Map<String,Object> returnData = new HashMap<String,Object>();
//		returnData.put("list", me100Service.selectMemList(paramVO));
		returnData.put("pjData", data);
		
		return ResponseEntity.ok(returnData);
		
	}
	
}
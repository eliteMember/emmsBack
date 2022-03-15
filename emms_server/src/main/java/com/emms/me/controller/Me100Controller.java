package com.emms.me.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emms.me.service.Me100Service;
import com.emms.vo.TB_MEM_MST_VO;

@RestController
public class Me100Controller {
	
	@Resource(name = "me100Service")
	private Me100Service me100Service;
	
	/**
	 * 인력관리 목록 조회
	 * @param request
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/api/memList")
	public ResponseEntity<Map<String,Object>> getMemList(
			HttpServletRequest request,
			@RequestBody Map<String,String> paramMap,
			ModelMap model) throws Exception {
		
		TB_MEM_MST_VO paramVO = new TB_MEM_MST_VO();
		paramVO.setMemName(paramMap.get("memName"));
		paramVO.setMemRnkCd(paramMap.get("memRnkCd"));
		
		Map<String,Object> list = new HashMap<String,Object>();
		list.put("list", me100Service.selectMemList(paramVO));
		
		return ResponseEntity.ok(list);
		
	}
	
	/**
	 * 인력관리 상세정보 조회
	 * @param request
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/api/memTargetData")
	public ResponseEntity<Map<String,Object>> getMemTargetData(
			HttpServletRequest request,
			@RequestBody Map<String,String> paramMap,
			ModelMap model) throws Exception {
		
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("value", me100Service.selectMemTargetData(paramMap.get("memNum")));
		
		return ResponseEntity.ok(data);
		
	}
	
}
package com.emms.me.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emms.cmmn.SessionVO;
import com.emms.me.service.Me100Service;
import com.emms.me.service.Me100_TB_MEM_MST_VO;

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
		
		Me100_TB_MEM_MST_VO paramVO = new Me100_TB_MEM_MST_VO();
		paramVO.setMemName(paramMap.get("memName"));
		paramVO.setMemRnkCd(paramMap.get("memRnkCd"));
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		returnData.put("list", me100Service.selectMemList(paramVO));
		
		return ResponseEntity.ok(returnData);
		
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
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		returnData.put("value", me100Service.selectMemTargetData(paramMap.get("memNum")));
		
		return ResponseEntity.ok(returnData);
		
	}
	
	/**
	 * 인력관리 인력 추가
	 * @param request
	 * @param paramVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/api/memAddData")
	public ResponseEntity<Map<String,Object>> memAddData(
			HttpServletRequest request,
			@RequestBody Me100_TB_MEM_MST_VO paramVO,
			ModelMap model) throws Exception {
		
		HttpSession session = request.getSession();
		System.out.println(session);
		SessionVO sessionVO = (SessionVO) session.getAttribute("sessionVO");
		
		if  ( null != session )  paramVO.setCrtUsrNum(sessionVO.getLoginVO().getUsrNum());
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		returnData.put("result", me100Service.insertMemData(paramVO));
		
		return ResponseEntity.ok(returnData);
		
	}
	
}
package com.emms.mn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emms.cmmn.SessionVO;
import com.emms.mapper.TB_USR_MST_Mapper;
import com.emms.mn.service.LoginVO;
import com.emms.mn.service.Mn400Service;
import com.emms.vo.TB_USR_MST_VO;

@RestController
@RequestMapping("/api/MN400")
public class Mn400Controller {
	
	@Autowired
	Mn400Service mn400Service;
	
	
	
	@PostMapping("/updateMember")
	public ResponseEntity<Map<String, Object>> updateMember (HttpServletRequest request,
	@RequestBody Map<String,String> paramMap) throws Exception{
		
		HttpSession session = request.getSession();
		String crtUsrNum = null;
		SessionVO sessionVO = (SessionVO) session.getAttribute("sessionVO");
		if  ( null != session ) { crtUsrNum = sessionVO.getLoginVO().getUsrNum();}
		
		String usrNum = paramMap.get("usrNum");
		String usrName = paramMap.get("usrName");
		String usrBirMd = paramMap.get("usrBirMd");
		String incCd = paramMap.get("incCd");
		String apoCd = paramMap.get("apoCd");
		String usrEmail = paramMap.get("usrEmail");
		String usrTelNum = paramMap.get("usrTelNum");
		String timNum = paramMap.get("timNum");
		HashMap<String, String> newdata = new HashMap<String,String>();
		newdata.put("usrNum", usrNum);
		newdata.put("usrName", usrName);
		newdata.put("usrBirMd", usrBirMd);
		newdata.put("incCd", incCd);
		newdata.put("apoCd", apoCd);
		newdata.put("usrEmail", usrEmail);
		newdata.put("usrTelNum", usrTelNum);
		newdata.put("timNum", timNum);
		newdata.put("masterNum", crtUsrNum);
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		if(usrNum == "") {
			returnData.put("result",mn400Service.insertUsrData(newdata));
		}else if(usrNum != "") {
			returnData.put("result",mn400Service.updateUsrData(newdata));
		}
		return ResponseEntity.ok(returnData);
	}
	
	@PostMapping("/resetPW")
	public HashMap<String, List<TB_USR_MST_VO>> resetPW (HttpServletRequest requst,@RequestBody Map<String,String> paramMap) throws Exception{
		
		String usrNum = paramMap.get("usrNum");
		String usrBirMd = "U2W" + paramMap.get("usrBirMd");
		HashMap<String, String> update = new HashMap<String, String>();
		update.put("usrNum", usrNum);
		update.put("usrBirMd", usrBirMd);
		mn400Service.updatePW(update);
		
		return null;
	}
	
	@PostMapping("/targetData")
	public ResponseEntity<Map<String,List<LoginVO>>> getMemTargetData(
			HttpServletRequest request,
			@RequestBody Map<String,String> paramMap,
			ModelMap model) throws Exception {
		Map<String,List<LoginVO>> returnData = new HashMap<String,List<LoginVO>>();
		returnData.put("value", mn400Service.targetData(paramMap.get("usrNum")));
		
		return ResponseEntity.ok(returnData);
		
	}
	
	
	@PostMapping("/searchName")
	public ResponseEntity<Map<String,List<LoginVO>>> getSearchName(
			HttpServletRequest request,
			@RequestBody Map<String,String> paramMap,
			ModelMap model) throws Exception {
		Map<String,List<LoginVO>> returnData = new HashMap<String,List<LoginVO>>();
		returnData.put("value", mn400Service.searchName(paramMap.get("usrName")));
		
		return ResponseEntity.ok(returnData);
		
	}
	
}

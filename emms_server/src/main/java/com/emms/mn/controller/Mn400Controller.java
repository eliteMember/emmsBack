package com.emms.mn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public HashMap<String, List<TB_USR_MST_VO>> updateMember (HttpServletRequest request,
	@RequestBody Map<String,String> paramMap) throws Exception{
		
		String id = paramMap.get("id");
		String column = paramMap.get("column");
		String value = paramMap.get("value");
		HashMap<String, String> update = new HashMap<String, String>();
		update.put("id", id);
		update.put("column", column);
		update.put("value", value);
		mn400Service.updateList(update);
		
		
		return null;
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
		System.out.println("여기왔음");
		Map<String,List<LoginVO>> returnData = new HashMap<String,List<LoginVO>>();
		returnData.put("value", mn400Service.targetData(paramMap.get("usrNum")));
		System.out.println(returnData);
		
		return ResponseEntity.ok(returnData);
		
	}
	
}

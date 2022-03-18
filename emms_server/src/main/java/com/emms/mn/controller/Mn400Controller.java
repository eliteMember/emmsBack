package com.emms.mn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emms.mapper.TB_USR_MST_Mapper;
import com.emms.mn.service.Mn400Service;
import com.emms.vo.TB_USR_MST_VO;

@RestController
@RequestMapping("/api/MN400")
public class Mn400Controller {
	
	@Autowired
	Mn400Service mn400Service;
	
	@GetMapping("/getList")
	public HashMap<String, List<TB_USR_MST_VO>> getList() throws Exception{
		
		HashMap<String, List<TB_USR_MST_VO>> result = new HashMap<String, List<TB_USR_MST_VO>>();
		
		List<TB_USR_MST_VO> mstParent = mn400Service.selectList();

		result.put("USR", mstParent);
		
		return result;
	}
	
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
		
		HashMap<String , List<TB_USR_MST_VO>> result = new HashMap<String, List<TB_USR_MST_VO>>();
		List<TB_USR_MST_VO> mstParent = mn400Service.selectList();

		result.put("USR", mstParent);
		
		return result;
	}
	
	@PostMapping("/resetPW")
	public String resetPW (HttpServletRequest requst,@RequestBody Map<String,String> paramMap) throws Exception{
		
		String usrNum = paramMap.get("usrNum");
		String usrBirMd = "U2W" + paramMap.get("usrBirMd");
		System.out.println(paramMap.get("usrNum"));
		System.out.println(paramMap.get("usrBirMd"));
		System.out.println(usrNum);
		System.out.println(usrBirMd);
		return null;
	}
}

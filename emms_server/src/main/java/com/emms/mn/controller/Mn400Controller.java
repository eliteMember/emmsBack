package com.emms.mn.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emms.mapper.TB_USR_MST_Mapper;
import com.emms.mn.service.Mn400Service;
import com.emms.vo.TB_USR_MST_VO;

@RestController
@RequestMapping("MN400/api/")
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
}

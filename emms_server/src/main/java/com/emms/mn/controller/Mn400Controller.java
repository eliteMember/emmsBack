package com.emms.mn.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emms.mapper.TB_USR_MST_Mapper;
import com.emms.vo.TB_USR_MST_VO;

@RestController
@RequestMapping("MN400/api/")
public class Mn400Controller {
	
	@Autowired
	TB_USR_MST_Mapper tb_usr_mst_mapper;
	
	@GetMapping("/getList")
	public HashMap<String, List<TB_USR_MST_VO>> getList(){
		
		HashMap<String, List<TB_USR_MST_VO>> result = new HashMap<String, List<TB_USR_MST_VO>>();
		
		List<TB_USR_MST_VO> mstParent = tb_usr_mst_mapper.TB_USR_MST_VL001();

		result.put("USR", mstParent);
		
		return result;
	}
}

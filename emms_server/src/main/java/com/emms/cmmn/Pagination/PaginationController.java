package com.emms.cmmn.Pagination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emms.mn.service.LoginVO;

@RestController
@RequestMapping("/api/pagination")
public class PaginationController {
	
	@Autowired
	PaginationService paginationService;
	
	@PostMapping("/MN400")
	public HashMap<String, Object> getList(HttpServletRequest request,
	@RequestBody Map<String,Object> paramMap) throws Exception{
		
//------처음 페이지에 뿌져줄 데이터 시작점과 보여주고 싶은 데이터갯수
		Integer PNo = (Integer) paramMap.get("PNo");
		Integer getCnt = (Integer) paramMap.get("getCnt");
		HashMap<String, Integer> update = new HashMap<String, Integer>();
		update.put("start", PNo);
		update.put("end", getCnt);
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<LoginVO> firstPage = paginationService.selectList(update);
		result.put("USR", firstPage);
//-----------------------------------------------------------------
//------두번째 페이지 여부, 두번째 페이지 데이터 적재
		update.clear();
		Integer startNo = getCnt * ((PNo+1) - 1) + 1;
		Integer endNo = startNo + getCnt - 1;
		update.put("start", startNo);
		update.put("end", endNo);
		List<LoginVO> nextPage = paginationService.selectList(update);
		if(nextPage.size() != 0) {
			result.put("nextYn", 'Y');
			result.put("nextUSR", nextPage);
			result.put("startNo", startNo);
			result.put("endNo", endNo);
		}else {
			result.put("nextYn", "N");
		}
		return result;
	}
	
//------세번째 이후의 페이징 요청
	@PostMapping("/MN400/nextPage")
	public HashMap<String, Object> nextList(HttpServletRequest request,
	@RequestBody Map<String,Object> paramMap) throws Exception{
		
		Integer startNo = (Integer) paramMap.get("startNo");
		Integer endNo = (Integer) paramMap.get("endNo");
		Integer getCnt = (Integer) paramMap.get("getCnt");
		HashMap<String, Integer> update = new HashMap<String, Integer>();
		update.put("start", (startNo + getCnt));
		update.put("end", ( endNo+getCnt) );
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<LoginVO> nextPage = paginationService.selectList(update);
		if(nextPage.size() != 0) {
			result.put("nextYn", 'Y');
			result.put("nextUSR", nextPage);
			result.put("startNo", (startNo+getCnt));
			result.put("endNo", (endNo+getCnt));
		}else {
			result.put("nextYn", "N");
		}
		return result;
	}
}

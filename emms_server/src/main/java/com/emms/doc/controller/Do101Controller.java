package com.emms.doc.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emms.doc.service.Do101Service;
import com.emms.doc.service.Do101_TB_REL_DOC_LST_VO;
import com.emms.vo.TB_REL_DOC_LST_VO;

// 해당 폴더명이 doc인 이유는 do라는 자바 명령어가 있어서 폴더명을 doc로 생성함
@RestController
@RequestMapping("/api/DO101")
public class Do101Controller {
	
	@Autowired
	Do101Service do101Service;
	
	@PostMapping("/searchList")
	public ResponseEntity<Map<String, Object>> searchList (HttpServletRequest request,
			@RequestBody Map<String,Object> paramMap) throws Exception{
		
		HashMap<String, Object> result = new HashMap<String, Object>();

		
		List<Do101_TB_REL_DOC_LST_VO> List = do101Service.searchList(paramMap);
		result.put("List", List);
		
		return ResponseEntity.ok(result);
		
	}
	
	 @PostMapping("/download")
	  public void download(HttpServletResponse response,HttpServletRequest request,
				@RequestBody Map<String,Object> paramMap) throws IOException {

	    String path = (String) paramMap.get("url");
	    String name = (String) paramMap.get("fileNm");
	    String fileExt = (String) paramMap.get("fileExt");
	    
	    byte[] fileByte = FileUtils.readFileToByteArray(new File(path));

	    response.setContentType("application/octet-stream");
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(name+"."+fileExt, "UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");

	    response.getOutputStream().write(fileByte);
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	  }
}

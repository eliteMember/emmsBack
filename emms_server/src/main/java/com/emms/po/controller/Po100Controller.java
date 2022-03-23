package com.emms.po.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.emms.po.service.Po100Service;
import com.emms.po.service.Po100VO;
import com.emms.vo.TB_REL_DOC_LST_VO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class Po100Controller {
	
	@Resource(name = "po100Service")
	private Po100Service po100Service;
	
	
	@PostMapping(value = "/api/po100/insert"
			//, consumes = {MediaType.APPLICATION_JSON_VALUE}
			//, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
	)
	public ResponseEntity<HttpStatus> getSession(
			HttpServletRequest request,
			//MultipartHttpServletRequest request,
			@RequestBody Po100VO paramVO, //파일을 업로드시에는 @RequestPart 사용해야함, MediaType 도 필수
			//@RequestPart Po100VO paramVO,
			//@RequestParam Po100VO paramVO,
			//@ModelAttribute Po100VO paramVO,
			//Po100VO paramVO,
			ModelMap model) throws Exception {
		
		String[] baseStrs = paramVO.getFiles().get(0).getFileBase64().split(",");
		String filePath = File.separator+"uploadTest"+File.separator;

		
		byte[] decodedBytes = Base64.getDecoder().decode(baseStrs[1]);
		File newFile = new File(filePath + paramVO.getFiles().get(0).getOrgFilNm());
		FileUtils.writeByteArrayToFile(newFile, decodedBytes);
        
		File getFile = new File(filePath + paramVO.getFiles().get(0).getOrgFilNm());
		if( getFile.exists() ) {
			System.out.println( getFile.length() );
		}
		
		return ResponseEntity.ok(HttpStatus.OK);
		
	}

	
	
}
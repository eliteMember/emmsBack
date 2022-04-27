/**
 * 회원가입 컨트롤러
 * @author : 임승재
 * @date   : 2022-03-10
 */
package com.emms.mn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
import com.emms.mn.service.Mn300Service;
import com.emms.vo.TB_CD_LST_VO;
import com.emms.vo.TB_TIM_MST_VO;

@RestController
@RequestMapping("/api/user")
public class Mn300Controller {
	
	@Autowired
	TB_USR_MST_Mapper tb_usr_mst_mapper;
	
	@Resource(name = "Mn300Service")
	private Mn300Service mn300Service;
	
	/**
	 * 회원정보 조회
	 * @author : 임승재
	 * @date   : 2022-04-26
	 * @return : String
	 */
	@PostMapping("/userInfo")
	public ResponseEntity<Map<String, Object>> userInfo (HttpServletRequest request,
			@RequestBody Map<String,String> paramMap) throws Exception{
		
		// 화면에서 회원번호 값 가져옴
		String userNum = paramMap.get("usrNum");
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		// 데이터에 회원번호 값 넣어주고
		data.put("usrNum", userNum);
		
		//DB에서 데이터 가져옴
		LoginVO userInfo = mn300Service.userInfo(data);
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		
		returnData.put("result", userInfo);
		
		return ResponseEntity.ok(returnData);
		
	}
	
	/**
	 * 기존비밀번호 체크
	 * @author : 임승재
	 * @date   : 2022-04-27
	 * @return : HashMap<List<TB_CD_LST_VO>>
	 */
	@PostMapping("/existPwChk")
	public ResponseEntity<Map<String, Object>> checkPwDuplicate(HttpServletRequest request,
			@RequestBody Map<String,String> paramMap) throws Exception{
		
		String loginId = paramMap.get("id");
		String loginPw = paramMap.get("existPw");
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		
		data.put("loginId", loginId);
		data.put("loginPw", loginPw);
		
		
		int chkPw = mn300Service.chkPw(data);
		
		returnData.put("chkPw", chkPw);
		
		return ResponseEntity.ok(returnData);
		
	}
	
	/**
	 * 팀 목록 조회
	 * @author : 임승재
	 * @date   : 2022-04-27
	 * @return : HashMap<List<TB_CD_LST_VO>>
	 */
	@PostMapping("/insertTeam")
	public ResponseEntity<Map<String, Object>> chkTeamDuplicate(HttpServletRequest request,
			@RequestBody Map<String,String> paramMap) throws Exception{
		
		String teamNm    	= paramMap.get("teamNm"	);		//팀명
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		
		data.put("teamNm", teamNm);
		
		
		TB_TIM_MST_VO checkTeamName = mn300Service.existTeamName(data);
		
		
		HashMap<String, String> newData = new HashMap<String,String>();
		
		if (teamNm != "") {
			// 팀명이 없다면
			if (checkTeamName == null) {
				// insert
				
				
				newData.put("teamNm", 	teamNm);
				
				returnData.put("result",mn300Service.insertTeam(newData));
				
			}
		}
	
		
		return ResponseEntity.ok(returnData);
		
	}
	
	/**
	 * 회원수정
	 * @author : 임승재
	 * @date   : 2022-04-27
	 * @return : String
	 */
	@PostMapping(value = "/updateMember")
	public ResponseEntity<Map<String, Object>> updateMember (
			HttpServletRequest request,
			@RequestBody Map<String,String> paramMap) throws Exception {
		// 화면에서 담긴 값 담아주기
		
		String num    = paramMap.get("num"	);		//유저번호
		String name   = paramMap.get("name"		);		//이름
		String id  = paramMap.get("id"	);		//생년월일
		String existPw = paramMap.get("existPw");		//전화번호
		String pw = paramMap.get("pw");		//전화번호
		String pwChk = paramMap.get("pwChk");		//전화번호
		String birMd   = paramMap.get("birMd"	);		//아이디
		String ctt1   = paramMap.get("ctt1"	);		//비밀번호
		String ctt2  = paramMap.get("ctt2"	);		//이메일
		String ctt3  = paramMap.get("ctt3"	);		//이메일
		String email1  = paramMap.get("email1"	);		//이메일
		String email2     = paramMap.get("email2"		);		//직위
		String incCd     = paramMap.get("incCd"		);		//직책
		String apoCd     = paramMap.get("apoCd"		);		//직책
		String teamNm     = paramMap.get("teamNm "	);		//팀명
		String ctt = ctt1 + "-" + ctt2 + "-" + ctt3;
		String email = email1 + "@" + email2;
		
		HashMap<String, String> newData = new HashMap<String,String>();
		
	
		
		
		newData.put("userNum", num);
		newData.put("userName", name);
		newData.put("userId", id);
		newData.put("userPw", pw);
		newData.put("userBirth", birMd);
		newData.put("usePhoneNum", ctt);
		newData.put("userEmail", email);
		newData.put("userIncCd", incCd);
		newData.put("userApoCd", apoCd);
		newData.put("userTimName", teamNm);
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		returnData.put("result",mn300Service.updateMember(newData));
		return ResponseEntity.ok(returnData);
	}
	
}
/**
 * 회원가입 컨트롤러
 * @author : 임승재
 * @date   : 2022-03-10
 */
package com.emms.mn.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emms.cmmn.SessionVO;
import com.emms.mapper.TB_USR_MST_Mapper;
import com.emms.mn.service.LoginVO;
import com.emms.mn.service.Mn200Service;
import com.emms.vo.TB_CD_LST_VO;
import com.emms.vo.TB_TIM_MST_VO;
import com.emms.vo.TB_USR_MST_VO;

@RestController
@RequestMapping("/api/join")
public class Mn200Controller {
	
	@Autowired
	TB_USR_MST_Mapper tb_usr_mst_mapper;
	
	@Resource(name = "Mn200Service")
	private Mn200Service mn200Service;
	
	/**
	 * 등록확인 버튼(가입여부)
	 * @author : 임승재
	 * @date   : 2022-04-04
	 * @return : String
	 */
	@PostMapping("/joinYnChk")
	public ResponseEntity<Map<String, Object>> joinYnChk (HttpServletRequest request,
			@RequestBody Map<String,String> paramMap) throws Exception{
		
		// 화면에서 이름과 생년월일 값 가져옴
		String userName = paramMap.get("usrName");
		String userBirth = paramMap.get("usrBirth");
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		// 데이터에 이름과 생년월일 값 넣어주고
		data.put("usrName", userName);
		data.put("usrBirth", userBirth);
		
		//DB에서 데이터 가져옴
		LoginVO userInfo = mn200Service.existUserInfo(data);
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		
		// 유저정보가 DB에 없다면 신규가입
		if (userInfo == null) {
		}
		// 유저정보가 DB에 있다면
		else {
			// 가입여부가 N이면
			if ("N".equals(userInfo.getJoinYn()) ) {
			}
			// 가입여부가 Y이면
			else {
			}
			
		}
		returnData.put("result", userInfo);
		
		return ResponseEntity.ok(returnData);
		
	}
	
	/**
	 * 아이디 목록 조회
	 * @author : 임승재
	 * @date   : 2022-03-16
	 * @return : HashMap<List<TB_CD_LST_VO>>
	 */
	@PostMapping("/loginIdChk")
	public ResponseEntity<Map<String, Object>> checkIdDuplicate(HttpServletRequest request,
			@RequestBody Map<String,String> paramMap) throws Exception{
		
		String loginId = paramMap.get("userId");
		String userNum = paramMap.get("userNum");
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		
		data.put("loginId", loginId);
		data.put("userNum", userNum);
		
		
		int checkId = mn200Service.selectChild(data);
		
		
		returnData.put("checkId", checkId);
		
		return ResponseEntity.ok(returnData);
		
	}
	
	/**
	 * 팀 목록 조회
	 * @author : 임승재
	 * @date   : 2022-03-16
	 * @return : HashMap<List<TB_CD_LST_VO>>
	 */
	@PostMapping("/insertTeam")
	public ResponseEntity<Map<String, Object>> chkTeamDuplicate(HttpServletRequest request,
			@RequestBody Map<String,String> paramMap) throws Exception{
		
		String timNm    	= paramMap.get("timNm"	);		//팀명
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		
		data.put("userTimName", timNm);
		
		System.out.println("userTimName : " + timNm);
		
		TB_TIM_MST_VO checkTeamName = mn200Service.existTeamName(data);
		
		
		HashMap<String, String> newData = new HashMap<String,String>();
		
		if (timNm != "") {
			// 팀명이 없다면
			if (checkTeamName == null) {
				// insert
				
				
				newData.put("userTimName", 	timNm);
				
				returnData.put("result",mn200Service.insertTeam(newData));
				
			}
		}
		
		return ResponseEntity.ok(returnData);
		
	}
	
	
	/**
	 * 직위 목록 조회
	 * @author : 임승재
	 * @date   : 2022-03-16
	 * @return : ResponseEntity<Map<String, Object>>
	 */
	@GetMapping("/listInc")
		
	public ResponseEntity<Map<String, Object>> listInc(
			TB_CD_LST_VO paramVO,
			HttpServletRequest request,
			ModelMap model) throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
      
		List<TB_CD_LST_VO> list = mn200Service.listInc(paramVO);

		returnMap.put("list", list);
		
		return ResponseEntity.ok(returnMap);

	}
	
	/**
	 * 직책 목록 조회
	 * @author : 임승재
	 * @date   : 2022-03-11
	 * @return : ResponseEntity<Map<String, Object>>
	 */
	@GetMapping("/listApo")
	
	public ResponseEntity<Map<String, Object>> listApo(
			TB_CD_LST_VO paramVO,
			HttpServletRequest request,
			ModelMap model) throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
      
		List<TB_CD_LST_VO> list = mn200Service.listApo(paramVO);

		returnMap.put("list", list);
		
		return ResponseEntity.ok(returnMap);

	}
	
	/**
	 * 회원가입(신규회원)
	 * @author : 임승재
	 * @date   : 2022-03-11
	 * @return : String
	 */
	@PostMapping(value = "/insertMember")
	public ResponseEntity<Map<String, Object>> insertMember (
			HttpServletRequest request,
			@RequestBody Map<String,String> paramMap) throws Exception {
		// 화면에서 담긴 값 담아주기
		
		String usrName   	= paramMap.get("userName"		);		//이름
		String usrBirMd  	= paramMap.get("userBirth"		);		//생년월일
		String usrTelNum1 	= paramMap.get("usePhoneNum1"	);		//전화번호
		String usrTelNum2 	= paramMap.get("usePhoneNum2"	);		//전화번호
		String usrTelNum3	= paramMap.get("usePhoneNum3"	);		//전화번호
		String loginId   	= paramMap.get("userId"		);		//아이디
		String passNum   	= paramMap.get("userPw"		);		//비밀번호
		String usrEmail1  	= paramMap.get("userEmail1"	);		//이메일
		String usrEmail2  	= paramMap.get("userEmail2"	);		//이메일
		String incCd     	= paramMap.get("userIncCd"		);		//직위
		String apoCd     	= paramMap.get("userApoCd"		);		//직책
		String timNum    	= paramMap.get("userTimName"	);		//팀명
		String usrTelNum 	= usrTelNum1 + "-" + usrTelNum2 + "-" + usrTelNum3;
		String usrEmail 	= usrEmail1 + "@" + usrEmail2;
		
		HashMap<String, String> newData = new HashMap<String,String>();
		
		
		newData.put("userName", 	usrName);
		newData.put("userBirth", 	usrBirMd);
		newData.put("usePhoneNum",	usrTelNum);
		newData.put("userId", 		loginId);
		newData.put("userPw", 		passNum);
		newData.put("userEmail", 	usrEmail);
		newData.put("userIncCd", 	incCd);
		newData.put("userApoCd", 	apoCd);
		newData.put("userTimName", 	timNum);
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		returnData.put("result",mn200Service.insertMember(newData));
		return ResponseEntity.ok(returnData);
		
	}
	
	/**
	 * 회원가입(기존회원)
	 * @author : 임승재
	 * @date   : 2022-03-11
	 * @return : String
	 */
	@PostMapping(value = "/updateMember")
	public ResponseEntity<Map<String, Object>> updateMember (
			HttpServletRequest request,
			@RequestBody Map<String,String> paramMap) throws Exception {
		// 화면에서 담긴 값 담아주기
		
		String usrNum    = paramMap.get("userNum"	);		//유저번호
		String usrName   = paramMap.get("userName"		);		//이름
		String usrBirMd  = paramMap.get("userBirth"	);		//생년월일
		String usrTelNum1 = paramMap.get("usePhoneNum1");		//전화번호
		String usrTelNum2 = paramMap.get("usePhoneNum2");		//전화번호
		String usrTelNum3 = paramMap.get("usePhoneNum3");		//전화번호
		String loginId   = paramMap.get("userId"	);		//아이디
		String passNum   = paramMap.get("userPw"	);		//비밀번호
		String usrEmail1  = paramMap.get("userEmail1"	);		//이메일
		String usrEmail2  = paramMap.get("userEmail2"	);		//이메일
		String incCd     = paramMap.get("userIncCd"		);		//직위
		String apoCd     = paramMap.get("userApoCd"		);		//직책
		String timNum    = paramMap.get("userTimName"	);		//팀명
		String usrTelNum = usrTelNum1 + "-" + usrTelNum2 + "-" + usrTelNum3;
		String usrEmail = usrEmail1 + "@" + usrEmail2;
		
		HashMap<String, String> newData = new HashMap<String,String>();
		
		
		newData.put("userNum", usrNum);
		newData.put("userName", usrName);
		newData.put("userBirth", usrBirMd);
		newData.put("usePhoneNum", usrTelNum);
		newData.put("userId", loginId);
		newData.put("userPw", passNum);
		newData.put("userEmail", usrEmail);
		newData.put("userIncCd", incCd);
		newData.put("userApoCd", apoCd);
		newData.put("userTimName", timNum);
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		returnData.put("result",mn200Service.updateMember(newData));
		return ResponseEntity.ok(returnData);
		
	}
}
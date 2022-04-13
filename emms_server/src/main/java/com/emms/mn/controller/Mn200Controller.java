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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emms.mapper.TB_USR_MST_Mapper;
import com.emms.mn.service.Mn200Service;
import com.emms.vo.TB_CD_LST_VO;
import com.emms.vo.TB_USR_MST_VO;

@RestController
@RequestMapping("/api/join")
public class Mn200Controller {
	
	@Autowired
	TB_USR_MST_Mapper tb_usr_mst_mapper;
	
	@Resource(name = "Mn200Service")
	private Mn200Service mn200Service;
	
	/**
	 * 등록확인 버튼(이름)
	 * @author : 임승재
	 * @date   : 2022-04-04
	 * @return : String
	 */
	@PostMapping("/nameChk")
	public ResponseEntity<Map<String, Object>> updateMember (HttpServletRequest request,
			@RequestBody Map<String,String> paramMap) throws Exception{
		
//		HttpSession session = request.getSession();
//		System.out.println(session);
//		SessionVO sessionVO = (SessionVO) session.getAttribute("sessionVO");
		
		String userName = paramMap.get("usrName");
		String userBirth = paramMap.get("usrBirth");
		
		System.out.println("userName : " + userName);
		System.out.println("userBirth : " + userBirth);
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		data.put("usrName", userName);
		data.put("usrBirth", userBirth);
		
		System.out.println("data : " + data);
		
		Map<String,Object> returnData = new HashMap<String,Object>();
		
		returnData.put("result", mn200Service.nmBirChkData(data));
		
		System.out.println("returnData : " + returnData);
		
		return ResponseEntity.ok(returnData);
		
//		Map<String, Object> returnMap = new HashMap<String, Object>();
//		
//		List<TB_USR_MST_VO> list = mn100_1Service.listName(paramVO);
//		System.out.println("11111111");
//		System.out.println(list);
//		returnMap.put("list", list);
//		
//		return ResponseEntity.ok(returnMap);
	}
	
	
	/**
	 * 회원가입
	 * @author : 임승재
	 * @date   : 2022-03-11
	 * @return : String
	 */
	@PostMapping(value = "/register")
	public ResponseEntity<String> insertMember (
			HttpServletRequest request,
			@RequestBody Map<String,String> paramMap,
			ModelMap model ) throws Exception {
		// 화면에서 담긴 값 담아주기
		TB_USR_MST_VO paramVO = new TB_USR_MST_VO();
		
		paramVO.setLoginId   ( 	paramMap.get("loginId"	));		//아이디
		paramVO.setPassNum   (	paramMap.get("password"	));		//비밀번호
		paramVO.setUsrName   (	paramMap.get("name"		));		//이름
		paramVO.setUsrBirMd  (	paramMap.get("usrBirth"	));		//생년월일
		paramVO.setUsrEmail  (	paramMap.get("usrEmail"	));		//이메일
		paramVO.setUsrTelNum (	paramMap.get("usrTelNum"));		//전화번호
		paramVO.setUsrAdr    (	paramMap.get("usrAdr"	));		//주소
		paramVO.setIncCd     (	paramMap.get("incCd"	));		//직위
		paramVO.setApoCd     (	paramMap.get("apoCd"	));		//직책
		paramVO.setTimNum    (	paramMap.get("timName"	));		//팀명
		
		System.out.println("-------------------------------");
		System.out.println("loginId : " + paramMap.get("loginId"));
		System.out.println("password : " + paramMap.get("password"));
		System.out.println("name : " + paramMap.get("name"));
		System.out.println("usrBirth : " + paramMap.get("usrBirth"));
		System.out.println("usrEmail : " + paramMap.get("usrEmail"));
		System.out.println("usrTelNum : " + paramMap.get("usrTelNum"));
		System.out.println("usrAdr : " + paramMap.get("usrAdr"));
		System.out.println("incCd : " + paramMap.get("incCd"));
		System.out.println("apoCd : " + paramMap.get("apoCd"));
		System.out.println("timName : " + paramMap.get("timName"));
		
		System.out.println("join 진입");
		try {
			System.out.println("join server 성공");
			mn200Service.insertMember(paramVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("join server 실패");
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("true", HttpStatus.OK);
		
	}

	/**
	 * 아이디 목록 조회
	 * @author : 임승재
	 * @date   : 2022-03-16
	 * @return : HashMap<List<TB_CD_LST_VO>>
	 */
	@GetMapping("/getIdList")
	public HashMap<String, List<TB_USR_MST_VO>> checkIdDuplicate(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		HashMap<String, List<TB_USR_MST_VO>> result = new HashMap<String, List<TB_USR_MST_VO>>();
		
		List<TB_USR_MST_VO> lstParent = mn200Service.selectParent();
		System.out.println("==================================================");
		System.out.println(lstParent);
		
		for (int i=0; i<lstParent.size(); i++) {
			List<TB_USR_MST_VO> lstChild = mn200Service.selectChild(lstParent.get(i).getLoginId());
			TB_USR_MST_VO lst = lstChild.get(10);
			System.out.println("#########################################");
			System.out.println(lstChild); 
			System.out.println(lst); 
			result.put(lstParent.get(i).getLoginId(), lstChild);
		}
		
		return result;
		
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
		
		System.out.println("resultINC : "+returnMap);
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
		
		System.out.println("resultAPO : "+returnMap);
		return ResponseEntity.ok(returnMap);

	}
	
	
}
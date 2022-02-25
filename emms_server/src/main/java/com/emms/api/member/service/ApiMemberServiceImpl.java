package com.emms.api.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("apiMemberService")
public class ApiMemberServiceImpl implements ApiMemberService {

	@Autowired
	private ApiMemberMapper apiMemberMapper;

	@Override
	public ApiMemberVO selectMember(ApiMemberVO vo) throws Exception {

		ApiMemberVO memberVO = apiMemberMapper.getMember(vo);

		return memberVO;
	}

	@Override
	public TestVO selectTest(TestVO vo) throws Exception {
		
		return apiMemberMapper.getTest(vo);
	}

}
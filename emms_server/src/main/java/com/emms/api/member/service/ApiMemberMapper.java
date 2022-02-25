
package com.emms.api.member.service;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApiMemberMapper {
	
	ApiMemberVO getMember(ApiMemberVO vo);
	
	TestVO getTest(TestVO vo);
	
}

package com.oht.firsts.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oht.firsts.mapper.MemberMapper;
import com.oht.firsts.vo.Member;

@Repository
public class MemberDAO {

	@Autowired
	private MemberMapper memberMapper;
	
	public Member loginMember(Member member) {
		return memberMapper.loginMember(member);
	}

}

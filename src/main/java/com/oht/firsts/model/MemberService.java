package com.oht.firsts.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oht.firsts.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	public Member loginMember(Member member) {
		return memberDao.loginMember(member);
	}

}

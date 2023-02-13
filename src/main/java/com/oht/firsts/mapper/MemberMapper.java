package com.oht.firsts.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.oht.firsts.vo.Member;

@Mapper
public interface MemberMapper {
	public Member loginMember(Member member);
}

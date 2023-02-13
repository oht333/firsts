package com.oht.firsts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oht.firsts.model.MemberService;
import com.oht.firsts.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/loginPage")
	public String loginPage() {
		System.out.println("로그인 페이지 들어옴");
		return "/login";
	}
	
	@PostMapping("/login")
	public String loginMember(Member member, ModelAndView mv, HttpServletRequest request, HttpSession session) {	
		
		Member loginUser = memberService.loginMember(member);
		
		if(loginUser!=null && member.getMemPwd().equals(loginUser.getMemPwd())) {
			// member.getMemPwd : 내가 입력한 아이디 비밀번호, loginUser.getMemPwd() : 기존 테이블에 있었던 칼럼값
//			mv.setViewName("index");
			System.out.println("ID PASSWORD 동일");
			session.setAttribute("loginUser", loginUser);
			return "redirect:/list";	
			
			
		}else {
			return "/error";
		}
	}
}

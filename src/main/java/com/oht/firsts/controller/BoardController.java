package com.oht.firsts.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oht.firsts.model.BoardService;
//import com.oht.firsts.model.MemberService;
import com.oht.firsts.vo.Board;
import com.oht.firsts.vo.Member;

import jakarta.servlet.http.HttpSession;


@Controller
public class BoardController {

	
	//DI - 생성자에 의한 종속객체 주입
	@Autowired
	private BoardService boardService;
	
//	@Autowired
//	private MemberService memberService;
	
//	@GetMapping("/delete")
//	public String boardDelete() {
//		System.out.println("삭제 페이지 들어옴");
//		return "/boardDelete";
//	}
	
	@GetMapping("/list") //url주소 끝자리에 /list를 붙여서 이동
	public ModelAndView boardList(ModelAndView mv) {
		ArrayList<Board> list = boardService.boardList();
		mv.addObject("list", list);
		mv.setViewName("boardList"); //boardList.html로 페이지를 셋팅
		return mv;
	}		
	
	
	@GetMapping("/detailBoard")
	public ModelAndView detailBoard(Member member,Board board, ModelAndView mv) {
		
		
		Board detailBoard = boardService.detailBoard(board);
		
		System.out.println(detailBoard);
		
		mv.addObject("detailBoard", detailBoard);
		mv.setViewName("boardDetail");
		
		System.out.println(mv);
		
		return mv;
		
	}	
//	
//	@GetMapping("/write")
//	public String write_get() {
//		return "writeBoard";
//	}
//
//	@PostMapping("/writeBoard")
//	public String writeBoard(Board board, HttpSession session, ModelAndView mv) {
//		
//		Member m = (Member) session.getAttribute("userNo");
//		board.setMemId(m.getMemId());
//		
//		return "redirect:/list";
//	}
	
//	@GetMapping("updateBoardPage")
//	public String updateBoardPage(Board board, ModelAndView mv) {
//		
//		
//		Board detailBoard = boardService.detailBoard(board);
//		System.out.println(detailBoard);
////		mv.addObject("detailBoard", detailBoard);
////		mv.setViewName("boardUpdateView");
//		
////		int result = commonService.updateBoard(board);
//		
//		return "redirect:/";
//	}	
}

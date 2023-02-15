package com.oht.firsts.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	@GetMapping("/list") //url주소 끝자리에 /list를 붙여서 이동
	public ModelAndView boardList(ModelAndView mv) {
		
		ArrayList<Board> list = boardService.boardList();
		
		mv.addObject("list", list);  //받아온 list값을 list key에 설정. 나중에 html문서에서 출력하고 싶은게 있으면 ${list.title} 이렇게 기재하면 됨
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
	
	@GetMapping("/write")	//w.html에서 '글쓰기'칸(writeBoard.html로 링크되어 있는것)을 <a href="/write">로 연결시킴
	public String write() {
		System.out.println("들어옴");
		return "writeBoard";
	}

	@PostMapping("/writeBoard") /*값을 받아올 html 파일 매핑*/
	public String writeBoard(Board board, HttpSession session, ModelAndView mv, Model model) {
		
		Member m = (Member) session.getAttribute("loginUser");
		board.setMemId(m.getMemId());
		
		int bd = boardService.writeBoard(board);
		
		model.addAttribute("message", "글 작성이 완료되었습니다.");
		model.addAttribute("searchUrl", "/list");
		
//		return "redirect:/list";
		return "message";
	}
	
	@GetMapping("/deleteBoard") 
	public String deleteBoard(Board board, Model model) { 
		boardService.deleteBoard(board); 

		model.addAttribute("message", "글 삭제가 완료되었습니다.");
		model.addAttribute("searchUrl", "/list");
		
		return "message";
	}
	
	@GetMapping("/updateBoardPage") 
	public ModelAndView updateBoardPage(Board board, ModelAndView mv) { 
		Board detailBoard = boardService.detailBoard(board);
		mv.addObject("detailBoard", detailBoard);
		mv.setViewName("/boardEdit");
		 
		return mv; 
	}
		  
		  
	@PostMapping("/editBoard") 
	public String editBoard(Board board, ModelAndView mv, Model model) { 
		System.out.println(board);
		  
		int res = boardService.editBoard(board);
		System.out.println(res);
		
		model.addAttribute("message", "글 수정이 완료되었습니다.");
		model.addAttribute("searchUrl", "/list");
		
		return "message";
	}	
}

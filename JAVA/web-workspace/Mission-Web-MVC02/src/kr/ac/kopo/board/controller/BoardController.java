package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.framework.annotation.RequestMapping;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.framework.ModelAndView;

public class BoardController {

	BoardService service;
	
	
	// /board/list.do 요청시 실행할 메소드
	@RequestMapping(value = "/board/list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("게시판 조회 서비스");

		ServletContext sc = request.getServletContext(); // 서블렛이 값을 공유하기 위해 만들어진 클래스
		
		service = (BoardService)sc.getAttribute("boardService");
		// VO, DAO 등을 먼저 만들어놓고 만들어진 객체를 필요할때마다 빼다씀
		
		
		List<BoardVO> boardList = service.listAll();

		ModelAndView mav = new ModelAndView();
		mav.setView("/board/list.jsp");
		mav.addAttribute("list", boardList);
		return mav;
	}

	// /board/detail.do 요청시 실행할 메소드
	@RequestMapping(value = "/board/detail.do")
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView("/board/detail.jsp");
		return mav;
	}

	@RequestMapping(value = "/board/writeForm.do")
	public ModelAndView writeForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView("/board/writeForm.jsp");
		return mav;
	}

	@RequestMapping(value = "/board/write.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		mav.setView("/board/write.jsp");
		return mav;
	}

}

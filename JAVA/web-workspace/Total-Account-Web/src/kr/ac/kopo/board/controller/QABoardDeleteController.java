package kr.ac.kopo.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.BoardDAO;
import kr.ac.kopo.controller.Controller;

public class QABoardDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
	 	int no = Integer.parseInt(request.getParameter("no"));
	 	
	 	System.out.println(no);
	 	BoardDAO board = new BoardDAO();
	  	
		board.delete(no);
		
		return "redirect:/qaBoardList.do";
	}

}

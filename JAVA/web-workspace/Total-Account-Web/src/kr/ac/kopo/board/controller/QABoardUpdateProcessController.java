package kr.ac.kopo.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import kr.ac.kopo.board.BoardDAO;
import kr.ac.kopo.board.BoardVO;
import kr.ac.kopo.controller.Controller;

public class QABoardUpdateProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		
		board.setNo(no);
		board.setTitle(title);
		board.setContent(content);
		
		dao.update(board);
		
		return "redirect:/qaBoardList.do";
	}

}

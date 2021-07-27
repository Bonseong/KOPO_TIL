package kr.ac.kopo.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.BoardDAO;
import kr.ac.kopo.board.BoardVO;
import kr.ac.kopo.controller.Controller;

public class QABoardReplyController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNo = Integer.parseInt(request.getParameter("no"));

		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.viewDetail(boardNo);

		request.setAttribute("board", board);
		
		return "/board/qaBoardReply.jsp";
	}

}

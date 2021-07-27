package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.BoardDAO;
import kr.ac.kopo.board.BoardVO;
import kr.ac.kopo.controller.Controller;

public class QABoardListController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAll();
		
	
		request.setAttribute("list", list);
		
		return "/board/qaBoardList.jsp";
	}
}

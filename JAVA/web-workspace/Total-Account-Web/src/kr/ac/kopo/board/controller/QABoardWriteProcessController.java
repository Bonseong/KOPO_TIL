package kr.ac.kopo.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.BoardDAO;
import kr.ac.kopo.board.BoardVO;
import kr.ac.kopo.controller.Controller;

public class QABoardWriteProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		BoardDAO dao = new BoardDAO();

		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);

		System.out.println(board);
		dao.insert(board);
		return "redirect:/qaBoardList.do";
	}

}

package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.BoardDAO;
import kr.ac.kopo.board.BoardVO;

public class BoardDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 5, 6. DB에 대한 처리
		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		
		// 7. 처리를 받아 requestScope에 공유객체 등록
		request.setAttribute("board", board);
		
		// 8. 다시 FrontControllerScope에 jsp 리턴, FCS에서 해당하는 jsp로 갈수 있도록 함
		return "/board/detail.jsp";
	}

}

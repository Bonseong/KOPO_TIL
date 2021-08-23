package kr.ac.kopo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

// Board에 대한 url을 전체적으로 관리하는 컨트롤러
@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	// /board 를 처리할때
	// service -> DAO를 통해 boardList를 받아오면서
	// modelandview jsp가 설정된 경로에서 board/list를 찾아서 사용자에게 보여줌
	// 최종적으로 list.jsp와 boardList 데이터를 결합한 형태의 페이지가 완성
	
	@RequestMapping("/board")
	public ModelAndView selectAll() {
		List<BoardVO> boardList = service.selectAllBoard();

		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list", boardList);

		return mav;
	}

	// http://localhost:9999/Mission-Spring/board/detail?no=23
	@RequestMapping("/board/detail")
	public void selectByNo(@RequestParam("no") int no) {

		System.out.println("no : " + no);
	}

	// http://localhost:9999/Mission-Spring/board/12
	// http://localhost:9999/Mission-Spring/board/8

	
	// board/no 의 형태
	// 
	@RequestMapping("/board/{no}") // 어떠한 변수가 들어올거라는 뜻
	public ModelAndView selectByNo2(@PathVariable("no") int no) { // path속의 변수 -> no를 받아 넘겨줌, 여러개도 가능
		System.out.println(no);
		
		BoardVO board = service.selectOneBoard(no);
		System.out.println(board);
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board", board);

		
		return mav;
	}

}

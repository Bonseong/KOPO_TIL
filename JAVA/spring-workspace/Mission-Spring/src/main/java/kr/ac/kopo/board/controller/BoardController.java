package kr.ac.kopo.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

// Board에 대한 url을 전체적으로 관리하는 컨트롤러
@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	@Autowired
	private ReplyService replyService;

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

	// 같은 URI지만 GET/POST에 따라 하는 행위가 다름
	// Spring 4.3이후 @GetMapping @PostMapping

	// @RequestMapping(value="/board/write", method=RequestMethod.GET) // GET 방식 :
	// writeForm 자체
	@GetMapping("/board/write")
	public String writeForm(Model model) {
		BoardVO board = new BoardVO();
		board.setTitle("이것은 제목이야");
		model.addAttribute("boardVO", board); // 공유영역 등록
		return "board/write";
	}

	// @RequestMapping(value="/board/write", method=RequestMethod.POST) // POST 방식 :
	// write을 하는 행위
	@PostMapping("/board/write")
	public String write(@Valid BoardVO board, Errors error) { // Errors를 상속받은 BindingResult도 있음 (@Valid, Errors는 붙어있어야함)
		// BoardVO를 mapping 시켜주지 않아도 spring이 알아서 mapping
		// @Valid : @NotEmpty annotaion 체크
		System.out.println("post /board/write");
		System.out.println(board);
		// System.out.println(error.hasErrors()); // return : True / false

		if (error.hasErrors()) {
			System.out.println("오류발생");
			return "board/write";
		}

		return "redirect:/board";
	}

	@RequestMapping("/board/{no}/replyInsert")
	public void replyInsert(@PathVariable("no") int no) {
		
	}
	
	@RequestMapping("/board/{no}/replyList")
	public ModelAndView replyList(@PathVariable("no") int no) throws Exception{
		List<ReplyVO> replyList = replyService.selectReply(no);
		
		ModelAndView mav = new ModelAndView("board/replyList");
		mav.addObject("replyList", replyList);

		return mav;
		
		
	}
	
	@RequestMapping("/board/{no}/replyListJson")
	@ResponseBody
	public List<ReplyVO> replyListJson(@PathVariable("no") int no) throws Exception {

		List<ReplyVO> replyList = replyService.selectReply(no);
		System.out.println(replyList);
		return replyList;

	}

}

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

@Controller
public class ReplyController {


	@Autowired
	private ReplyService replyService;
	
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

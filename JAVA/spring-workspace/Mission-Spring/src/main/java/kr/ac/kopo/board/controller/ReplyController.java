package kr.ac.kopo.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

@Controller
public class ReplyController {


	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/board/{no}/replyList")
	public ModelAndView replyList(@PathVariable("no") int no) throws Exception{
		List<ReplyVO> replyList = replyService.selectReply(no);
		
		ModelAndView mav = new ModelAndView("board/replyList");
		mav.addObject("replyList", replyList);
		System.out.println(no);
		return mav;
		
		
	}
	
	
	@PostMapping("/board/{no}/writeReply")
	@ResponseBody // 단순문자열 리턴
	public void write(@PathVariable("no") int no, @Valid ReplyVO reply, Errors error) { 

		if (error.hasErrors()) {
			System.out.println("오류발생");
		
		}

		reply.setBoardNo(no);
		
		replyService.writeReply(reply);
		System.out.println(reply);
		
	}
	
}

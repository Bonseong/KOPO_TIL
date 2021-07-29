package kr.ac.kopo.login.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import kr.ac.kopo.board.framework.annotation.Controller;
import kr.ac.kopo.board.framework.annotation.RequestMapping;
import kr.ac.kopo.framework.ModelAndView;

@Controller 
public class LoginController {
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServlet response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView("/login/login.jsp");
		return mav;
	}

	@RequestMapping("/loginProcess.do")
	public ModelAndView loginProcess(HttpServletRequest request, HttpServlet response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView("/login/loginProcess.jsp");
		System.out.println("로그인프로세스진입");
		return mav;
	}

	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServlet response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView("/login/logout.jsp");
		return mav;
	}
}

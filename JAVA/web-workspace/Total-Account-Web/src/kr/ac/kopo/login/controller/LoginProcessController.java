package kr.ac.kopo.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.login.LoginDAO;
import kr.ac.kopo.login.LoginVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(id);;
		loginVO.setPassword(password);
		
		LoginDAO dao = new LoginDAO();
		LoginVO userVO = dao.login(loginVO);
		
		String msg = "";
		String url = "";
		
		if(userVO == null) {
			msg = "아이디 또는 패스워드를 잘못 입력하셨습니다.";
			url = "redirect:/login.do";
			HttpSession session = request.getSession();
			session.setAttribute("msg", msg);
		}else {
			url = "redirect:/";
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			System.out.println(userVO);
		}
		
		
		
		return url;
	}

}

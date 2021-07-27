package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.login.LoginDAO;
import kr.ac.kopo.login.LoginVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id       = request.getParameter("id");
		String password = request.getParameter("password");
		LoginVO loginVO = new LoginVO();
		loginVO.setId(id);
		loginVO.setPassword(password);
		
		LoginDAO dao = new LoginDAO();
		LoginVO userVO = dao.login(loginVO);
		
		String msg = "";
		String url = "";
		if(userVO == null) {
			// 로그인 실패
			msg = "아이디 또는 패스워드를 잘못입력하셨습니다";
			url = request.getContextPath() + "/login.do";
		} else {
			// 로그인 성공
			msg = "로그인을 성공하였습니다";
			url = request.getContextPath();
			
			// 세션 등록
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			System.out.println(userVO);
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/login/loginProcess.jsp";
	}

}












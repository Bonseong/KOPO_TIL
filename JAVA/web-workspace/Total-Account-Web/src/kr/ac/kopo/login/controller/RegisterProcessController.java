package kr.ac.kopo.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.login.LoginDAO;
import kr.ac.kopo.login.LoginVO;

public class RegisterProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String rrn = request.getParameter("rrn");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String post = request.getParameter("post");
		String basicAddr = request.getParameter("basicAddr");
		String detailAddr = request.getParameter("detailAddr");

		String[] email_arr = email.split("@");
		String[] phone_arr = phone.split("-");

		LoginVO loginVO = new LoginVO();

		loginVO.setId(id);
		loginVO.setName(name);
		loginVO.setPassword(password);
		loginVO.setEmail(email_arr[0]);
		loginVO.setEmail_domain(email_arr[1]);
		loginVO.setRrn(rrn);
		loginVO.setTel1(phone_arr[0]);
		loginVO.setTel2(phone_arr[1]);
		loginVO.setTel3(phone_arr[2]);
		loginVO.setPost(post);
		loginVO.setBasic_addr(basicAddr);
		loginVO.setDetail_addr(detailAddr);

		LoginDAO dao = new LoginDAO();
		LoginVO userVO = dao.register(loginVO);

		String msg = "";
		String url = "";
		if (userVO == null) {
			
			msg = "아이디가 올바르지 않습니다";
			url = "redirect:/register.do";
			HttpSession session = request.getSession();
			session.setAttribute("msg", msg);
		} else {
			url = "redirect:/";
			HttpSession session = request.getSession();
			session.setAttribute("userName", userVO.getName());
		}

		return url;
	}

}

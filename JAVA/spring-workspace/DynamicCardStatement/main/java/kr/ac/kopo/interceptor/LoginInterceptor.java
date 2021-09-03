package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.member.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServlet response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		MemberVO loginVO = (MemberVO) session.getAttribute("loginVO");

		if (loginVO == null) {
			// 목적지 경로 기억시키기
			String uri = request.getRequestURI();
			uri = uri.substring(request.getContextPath().length());
			// 세션에 저장
			session.setAttribute("dest", uri);
			return false;
		}

		return true;
	}

}
package kr.ac.kopo.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() : 최초 한번만 실행되는 메소드입니다.");

	}
	

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException /* 파일 입출력에 대한 간접처리 */ {
		System.out.println("service() : 실제 작업이 실행되는 메소드입니다.");
		System.out.println("사용자가 요청할 때마다 호출되는 메소드입니다.");

	}
}

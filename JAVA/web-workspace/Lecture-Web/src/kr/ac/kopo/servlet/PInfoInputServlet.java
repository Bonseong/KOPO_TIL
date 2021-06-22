package kr.ac.kopo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PInfoInputServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String[] mail = request.getParameterValues("mail");
		String job = request.getParameter("job");

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인 정보 입력</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인 정보 출력</h2>");
		out.println("이름 : " + name + "<br>");
		out.println("아이디 : " + id + "<br>");
		out.println("암호 : " + pw + "<br>");
		out.println("성별 : " + gender + "<br>");

		
		out.println("공지메일 : " + (Arrays.asList(mail).contains("notice") ? "받음" : "받지않음") + "<br>");
		out.println("광고메일 : " + (Arrays.asList(mail).contains("ad") ? "받음" : "받지않음") + "<br>");
		out.println("배송 확인 메일 : " + (Arrays.asList(mail).contains("delivery") ? "받음" : "받지않음") + "<br>");

		out.println("직업 : " + job + "<br>");
		out.println("============================================<br>");
		out.println("</body>");
		out.println("</html>");

		out.flush();
		out.close();
	}

}

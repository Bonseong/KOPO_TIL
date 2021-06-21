package kr.ac.kopo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MethodServlet extends HttpServlet {

	// GET http://localhost:9999/Lecture-Web/methods?id=aaa
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id"); // method id가 던져주는 값
		String method = request.getMethod();
		StringBuffer url = request.getRequestURL(); /* URL : 프로토콜 포함 */
		String uri = request.getRequestURI();

		/*
		 * // 서버 출력 System.out.println("id : " + id); System.out.println("method : " +
		 * method); System.out.println("url : " + url.toString());
		 * System.out.println("uri : " + uri);
		 */

		// client에게 응답 (outputstream이나 writer 필요!)

		response.setContentType("text/html; charset=utf-8"); // 받아올 데이터에 대한 형식
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>메소드 호출방식</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("	</body>");
		out.println("===============================<br>");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;요 청 결 과<br>");
		out.println("===============================<br>");
		out.println("파라미터(id) : " + id + "<br>");
		out.println("요청방식 : " + method + "<br>");
		out.println("요청uri : " + uri + "<br>");
		out.println("===============================<br>");

		out.println("</html>");

		out.flush(); // flush : FileWriter 내부 버퍼의 내용을 파일에 write
		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); // POST는 태그가 body쪽으로 가기 때문에, body 쪽에 대한 인코딩이 반드시 필요함!
		String method = request.getMethod(); // GET OR POST
		String uri = request.getRequestURI();

		String id = request.getParameter("id");

		// System.out.println("method : " + method);
		// System.out.println("uri : " + uri);

		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>메소드 호출방식 - POST</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("============================================<br>");
		out.println("&nbsp;&nbsp;&nbsp;출 력 결 과<br>");
		out.println("============================================<br>");
		out.println("요청 URI : " + uri + "<br>");
		out.println("요청 메소드 : " + method + "<br>");
		out.println("파라미터(id) : " + id + "<br>");
		out.println("============================================<br>");
		out.println("</body>");

		out.println("</html>");

		out.flush();
		out.close();

	}

}

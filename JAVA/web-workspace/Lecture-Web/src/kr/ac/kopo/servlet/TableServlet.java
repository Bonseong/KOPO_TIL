package kr.ac.kopo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:9999/Lecture-Web/servlet/table?row=4&col=3 요청시

@WebServlet("/servlet/tableExam")
// annotation을 이용한 주소 지정
public class TableServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int row = request.getParameter("row") != "" ? Integer.parseInt(request.getParameter("row")) : 5;
		int col = request.getParameter("col") != "" ? Integer.parseInt(request.getParameter("col")) : 5;

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(row + ", " + col + "size의 테이블 출력");

		out.println("<html>");
		out.println("	<head>");
		out.println("<style>");
		out.println("td { padding : 0 10px }");
		out.println("</style>");
		out.println("		<title>table</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("<table border = '1'>");

		for (int i = 0; i < row; i++) {
			out.println("<tr>");
			for (int j = 0; j < col; j++) {
				out.println("<td>cell(" + i + ", " + j + ") </td>");
			}
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("	</body>");

		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}

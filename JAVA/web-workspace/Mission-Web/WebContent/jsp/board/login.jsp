<%@page import="java.sql.ResultSet"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");

Connection conn = new ConnectionFactory().getConnection();

StringBuilder sql = new StringBuilder();

sql.append(" SELECT NAME FROM T_MEMBER WHERE ID = ? AND PASSWORD = ? ");

PreparedStatement pstmt = conn.prepareStatement(sql.toString());

pstmt.setString(1, id);
pstmt.setString(2, pw);

ResultSet rs = pstmt.executeQuery();


Boolean bool = false;

while (rs.next()) {
	bool = true;
}
%>

<%
if (bool) {
%>
<script>
	alert("로그인에 성공했습니다.")
	location.href = "list.jsp"
</script>
<%
} else {
%>
<script>
	alert("로그인에 실패했습니다.")
	location.href = "loginForm.jsp"
</script>
<%
}
JDBCClose.close(conn, pstmt);
%>



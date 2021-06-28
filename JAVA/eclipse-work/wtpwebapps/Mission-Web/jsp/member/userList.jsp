<%@page import="java.sql.ResultSet"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	
	Connection conn = new ConnectionFactory().getConnection();
	
	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT ID, NAME FROM T_MEMBER ");
	
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	
	pstmt.executeUpdate();
	
	ResultSet rs = pstmt.executeQuery();
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
	$('#main').click(function() {
		location.href = "loginForm.jsp"
		
	})
})
</script>
</head>
<body>
	<div align="center">
		<hr width="80%">
		<h2>회원 목록</h2>
		<hr width="80%">
		<table border="1" style="width: 50%">
			<tr>
				<th width="7%">아이디</th>
				<th width="16%">이름</th>
			</tr>
			<%
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
			%>
			<tr>

				<td><a href ="checkID.jsp?id=<%=id%>"><%=id%></a></td>
				<td><%=name%></td>
	
			</tr>
			<%
			}
			%>
		</table>
		<br>
		<button id="main">메인</button>
	</div>
</body>
</html>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%
Connection conn = new ConnectionFactory().getConnection();
StringBuilder sql = new StringBuilder();

sql.append(" SELECT NO, TITLE, WRITER, TO_CHAR(REG_DATE, 'YYYY-MM-DD') AS REG_DATE ");
sql.append(" FROM T_BOARD ");
sql.append(" ORDER BY NO DESC ");

PreparedStatement pstmt = conn.prepareStatement(sql.toString());

ResultSet rs = pstmt.executeQuery();

JDBCClose.close(conn, pstmt);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('#addBtn').click(function() {
			location.href = "writeForm.jsp"
			/* location 객체 필요 */
		})
	})
</script>

</head>
<body>
	<div align="center">
		<hr width="80%">
		<h2>게시판 목록</h2>
		<hr width="80%">
		<table border="1" style="width: 80%">
			<tr>
				<th width="7%">번호</th>
				<th>제목</th>
				<th width="16%">작성자</th>
				<th width="20%">등록일</th>
			</tr>
			<%
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
			%>
			<tr>
				<td><%=no%></td>
				<td><a href="detail.jsp?no=<%=no%>"><%=title%></a></td>
				<td><%=rs.getString("writer")%></td>
				<td><%=rs.getString("reg_date")%></td>
			</tr>
			<%
			}
			%>
		</table>
		<br>
		<button id="addBtn">새글등록</button>
	</div>
</body>
</html>

<%
JDBCClose.close(conn, pstmt);
%>
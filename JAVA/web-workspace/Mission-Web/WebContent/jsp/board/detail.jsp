<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--
	http://localhost:9999/Mission-Web/jsp/board/detail.jsp?no=2
--%>

<%
// 게시물 번호 추출
int boardNo = Integer.parseInt(request.getParameter("no"));

// 데이터베이스 t_board에서 해당 게시물 조회
Connection conn = new ConnectionFactory().getConnection();
StringBuilder sql = new StringBuilder();

sql.append(" SELECT NO, TITLE, WRITER, CONTENT, VIEW_CNT ");
sql.append(" , TO_CHAR(REG_DATE, 'YYYY-MM-DD') AS REG_DATE ");
sql.append(" FROM T_BOARD ");
sql.append(" WHERE NO = ? ");

PreparedStatement pstmt = conn.prepareStatement(sql.toString());

pstmt.setInt(1, boardNo);
ResultSet rs = pstmt.executeQuery();

rs.next();
JDBCClose.close(conn, pstmt);

int no 			= rs.getInt("NO");
String title 	= rs.getString("title");
String writer 	= rs.getString("writer");
String content 	= rs.getString("content");
int viewCnt 	= rs.getInt("view_cnt");
String regdate 	= rs.getString("reg_date");

BoardVO board = new BoardVO(no, title, writer, content, viewCnt, regdate);

pageContext.setAttribute("board", board); /* BoardVO 객체 자체를 등록 */


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>

$(document).ready(function() {
	$('#goListBtn').click(function() {
		location.href = "list.jsp"
	})
})

</script>
</head>
<body>
	<div align="center">
		<hr width="80%">
		<h2>게시판 상세</h2>
		<hr width="80%">
		<br>
		<table border="1">
			<tr>
				<th width="25%">번호</th>
				<td>${ board.no }</td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td>${ board.title }</td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td>${ board.content }</td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td>${ board.viewCnt }</td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td>${ board.regdate }</td>
			</tr>
		</table>
		<br> <input type="button" value="목록" id="goListBtn">




	</div>
</body>
</html>
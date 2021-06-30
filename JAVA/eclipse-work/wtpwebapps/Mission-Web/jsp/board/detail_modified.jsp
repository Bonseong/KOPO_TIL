<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%--
	http://localhost:9999/Mission-Web/jsp/board/detail.jsp?no=2
 --%>    
<%
	// 1. 게시물번호 추출
	int boardNo = Integer.parseInt(request.getParameter("no"));

	// 2. 데이터베이스 t_board테이블에서 해당 게시물 조회
	Connection conn = new ConnectionFactory().getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append("select no, title, writer, content, view_cnt ");
	sql.append("     , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
	sql.append("  from t_board ");
	sql.append(" where no = ? ");
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	pstmt.setInt(1, boardNo);
	ResultSet rs = pstmt.executeQuery();
	
	rs.next();
	int no 			= rs.getInt("no");
	String title 	= rs.getString("title");
	String writer	= rs.getString("writer");
	String content	= rs.getString("content");
	int viewCnt 	= rs.getInt("view_cnt");
	String regDate	= rs.getString("reg_date");
	
	JDBCClose.close(conn, pstmt);
	
	BoardVO board = new BoardVO(no, title, writer, content, viewCnt, regDate);
	
	pageContext.setAttribute("board", board);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css" />
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css" />
<script>
	function clickBtn(type) {
		switch(type) {
		case 'U' : 
			location.href = 'updateForm.jsp?no=${ param.no }'
			break
		case 'D' : 
			break
		case 'L' :
			location.href = "list.jsp"
			break
		}
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
		<hr width="80%">
		<h2>게시판 상세</h2>
		<hr width="80%">
		<br>
		<table border="1" style="width: 80%">
			<tr>
				<th width="25%">번호</th>
				<td><c:out value="${ board.no }"/></td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td><c:out value="${ board.title }" /></td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td>${ board.writer }</td>
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
				<td>${ board.regDate }</td>
			</tr>
		</table>
		<br>
		<button onclick="clickBtn('U')">수정</button>
		<button onclick="clickBtn('D')">삭제</button>
		<button onclick="clickBtn('L')">목록</button>
	</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>
























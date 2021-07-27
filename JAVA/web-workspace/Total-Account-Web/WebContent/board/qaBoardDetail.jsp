<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="kr.ac.kopo.board.BoardVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세진저축은행</title>
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/layout.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/board.css" /> --%>
<script>
	function clickBtn(type) {
		switch(type) {
		case 'U' : 
			location.href = '${pageContext.request.contextPath}/qaBoardUpdate.do?no=${ param.no }'
			break
		case 'D' :
			location.href = "${pageContext.request.contextPath}/qaBoardDelete.do?no=${ param.no }"
			break
		case 'R' :
			location.href = "${pageContext.request.contextPath}/qaBoardReply.do?no=${ param.no }&title=${param.title}"
			break
		case 'L' :
			location.href = "${pageContext.request.contextPath}/qaBoardList.do"
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
		<table border="1" style="width: 80%" class="table table-bordered">
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
		<button onclick="clickBtn('R')">답글</button>
		<button onclick="clickBtn('L')">목록</button>
	</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>























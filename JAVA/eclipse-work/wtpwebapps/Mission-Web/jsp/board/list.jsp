<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Connection conn = new ConnectionFactory().getConnection();
StringBuilder sql = new StringBuilder();
sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
sql.append("  from t_board ");
sql.append(" order by no desc ");
PreparedStatement pstmt = conn.prepareStatement(sql.toString());
ResultSet rs = pstmt.executeQuery();

List<BoardVO> list = new ArrayList<>();

while (rs.next()) {
	int no = rs.getInt("no");
	String title = rs.getString("title");
	String writer = rs.getString("writer");
	String regDate = rs.getString("reg_date");

	BoardVO board = new BoardVO();
	board.setNo(no);
	board.setTitle(title);
	board.setWriter(writer);
	board.setRegDate(regDate);

	list.add(board);
}

JDBCClose.close(conn, pstmt);

pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"></link>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"></link>
<script src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('#addBtn').click(function() {
			location.href = "writeForm.jsp"
		})
	})
	
	function doAction(no){
		<c:choose>
			<c:when test="${not empty userVO}">
				location.href="detail.jsp?no=" + no
			</c:when>
			<c:otherwise>
				if(confirm("로그인이 필요한 서비스입니다\n로그인페이지로 이동하시겠습니까?"))
					location.href="/Mission-Web/jsp/login/login.jsp"
			</c:otherwise>
		</c:choose>
		
		/* 
			해석이 JSP가 먼저기 때문에 스크립트를 사용할 수 있음 
			(자바스크립트 -> 웹브라우저)
			서블릿 코드로 전송될 때, when이나 otherwise 둘중 하나의 코드만 전송됨
		*/
		
	}
	
	
/* 	$(document).ready(function() {
		$('#logoutBtn').click(function() {
			alert("로그아웃 되었습니다.")
			location.href = "/Mission-Web/jsp/login/login.jsp"
		})
	}) */
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
			<hr width="80%">
			<h2>게시판 목록</h2>
			<hr width="80%">
			<br>
			<table border="1" style="width: 80%" id="list">
				<tr>
					<th width="7%">번호</th>
					<th>제목</th>
					<th width="16%">작성자</th>
					<th width="20%">등록일</th>
				</tr>
				<c:forEach items="${ list }" var="board" varStatus="loop">
					<tr <c:if test="${loop.index mod 2 ne 0}" > class="odd"</c:if>>
						<td>${ board.no }</td>
						<td><a href="javascript:doAction(${ board.no })"> <!-- JS 문법을 사용, 게시물번호를 파라미터로서 넘김 -->
								<c:out value="${board.title }" />
						</a> <%-- <a onclick="doAction()">
								<c:out value="${board.title }"/> // 링크가 잡히지 않음, href=#을 사용하면 링크는 잡히지면, url에 #이 포함된
							</a> --%> <%-- <a href="detail.jsp?no=${ board.no }"> <c:out
										value="${ board.title }" />
							</a> --%></td>
						<td>${ board.writer }</td>
						<td>${ board.regDate }</td>
					</tr>
				</c:forEach>
			</table>
			<br>

			<c:if test="${ not empty userVO }">
				<button id="addBtn">새글등록</button>
			</c:if>

			<!-- <button id="logoutBtn">로그아웃</button> -->
		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp"%>
	</footer>
</body>
</html>
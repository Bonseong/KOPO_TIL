<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/layout.css"></link>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/board.css"></link>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('#addBtn').click(function() {
			location.href = "${pageContext.request.contextPath}/qaBoardWrite.do"
		})
	})

	function doAction(no) {
		<c:choose>
		<c:when test="${not empty userVO}">
		location.href = "detail.jsp?no=" + no + "&type=list" /* 조회수 증가가 list를 타고 들어온 경우만 증가 */
		</c:when>
		<c:otherwise>
		if (confirm("로그인이 필요한 서비스입니다\n로그인페이지로 이동하시겠습니까?"))
			location.href = "/Total-Account-Web/login/login.jsp"
		</c:otherwise>
		</c:choose>
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center" style="margin-top: 200px;">
			<hr width="80%">
			<h2>게시판 목록</h2>
			<hr width="80%">
			<br>
			<table border="1" style="width: 80%" id="list" class="table table-bordered">
				<tr>
					<th width="7%">번호</th>
					<th>제목</th>
					<th width="16%">작성자</th>
					<th width="20%">등록일</th>
				</tr>
				<c:forEach items="${ list }" var="board" varStatus="loop">
					<tr <c:if test="${loop.index mod 2 ne 0}" > class="odd"</c:if>>
						<td>${ board.no }</td>
						<td><a
							href="<%=request.getContextPath()%>/qaBoardDetail.do?no=${board.no}">
								<c:out value="${ board.title }" />
						</a></td>
						<td>${ board.writer }</td>
						<td>${ board.regDate }</td>
					</tr>
				</c:forEach>
			</table>
			<br>

			<c:if test="${ not empty userVO }">
				<button id="addBtn">새글등록</button>
			</c:if>

		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp"%>
	</footer>
</body>
</html>
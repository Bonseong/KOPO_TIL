<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세진저축은행</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"></link>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"></link>
<script type="text/javascript"
	src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>

<script>
	if ("{userVO}" = "") {
		location.href = "/Total-Account-Web/login/login.jsp"

	}
</script>
<script>
	$(document).ready(function() {
		$('#goListBtn').click(function() {
			location.href = "qaBoardList.do"
		})
	})
</script>
</head>

<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
			<hr width="80%">
			<h2>게시물 수정</h2>
			<hr width="80%">
			<br>
			<form action="<%=request.getContextPath()%>/qaBoardUpdateProcess.do"
				method="post" name="updateForm" role="form">
				<input type="hidden" name="no" value="${board.no}">
				<table border="1" style="width: 80%" class="table table-bordered">
					<tr>
						<th width="25%">제목</th>
						<td><input type="text" size="60" name="title"
							value="${ board.title }" required></td>
					</tr>
					<tr>
						<th width="25%">작성자</th>
						<td><c:out value="${ userVO.id }" /></td>
						<!-- <input type="text" size="60" name=" { userVO.id }" readonly> -->
					</tr>
					<tr>
						<th width="25%">내용</th>
						<td><textarea rows="10" cols="150" name="content" required><c:out
									value="${ board.content }"  /></textarea></td>
					</tr>
				</table>
				<br> <input type="submit" value="수정"> <input
					type="button" value="목록" id="goListBtn">
			</form>
		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp"%>
	</footer>
</body>
</html>

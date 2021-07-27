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

<script>
	function clickBtn(type) {
		switch(type) {
		
		case 'L' :
			location.href = "${pageContext.request.contextPath}/openBankDetail.do"
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
		<h2>계좌 상세정보</h2>
		<hr width="80%">
		<br>
		<table border="1" style="width: 40%" class="table table-bordered">
			<tr>
				<th width="25%">아이디</th>
				<td>${ obVO.id }</td>
			</tr>
			<tr>
				<th width="25%">은행명</th>
				<td>${ obVO.openBankName }</td>
			</tr>
			<tr>
				<th width="25%">계좌번호</th>
				<td>${ obVO.openAccNo }</td>
			</tr>
			<tr>
				<th width="25%">잔액</th>
				<td>${ obVO.balance }</td>
			</tr>
			
		</table>
		<br>
		<button onclick="clickBtn('L')">계좌목록</button>
	</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>
























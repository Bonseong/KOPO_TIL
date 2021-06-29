<%@page import="java.sql.ResultSet"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>


<script>
	$(document).ready(function() {

		$("#main").click(function() {
			location.href = "/Mission-Web/index.jsp"

		})

	})
</script>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"></link>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"></link>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
			<hr width="80%"></hr>
			<h2>회 원 가 입</h2>
			<hr width="80%"></hr>
			<br>

			<form action="register.jsp" method="post">
				<table border="1" style="width: 50%">
					<tr>
						<th width="30%">아이디 :</th>
						<td><input type="text" name="id" id="id">
							<button type="button" id="checkDuplicated"
								onclick="button_click()">중복체크</button></td>
					</tr>
					<tr>
						<th width="30%">이름 :</th>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<th width="30%">비밀번호 :</th>
						<td><input type="text" name="pw"></td>
					</tr>
					<tr>
						<th width="30%">비밀번호 확인 :</th>
						<td><input type="text" name="pw_check"></td>
					</tr>
					<tr>
						<th width="30%">이메일 :</th>
						<td><input type="text" name="email">@<input
							type="text" name="emailDetail"></td>
					</tr>
					<tr>
						<th width="30%">전화번호 :</th>
						<td><input type="text" name="tel1" size="4">-<input
							type="text" name="tel2" size="4">-<input type="text"
							name="tel3" size="4"></td>
					</tr>
					<tr>
						<th width="30%">우편번호 :</th>
						<td><input type="text" name="post"></td>
					</tr>
					<tr>
						<th width="30%">주소 :</th>
						<td><input type="text" name="addrBasic"></td>
					</tr>
					<tr>
						<th width="30%">상세주소 :</th>
						<td><input type="text" name="addrDetail"></td>
					</tr>

				</table>
				<div align="center">
					<input type="submit" value="등록"> <input type="button"
						value="메인" id="main">
				</div>

			</form>
		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp"%>
	</footer>
</body>
</html>
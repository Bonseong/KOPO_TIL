<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script type="text/javascript"
	src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$("#main").click(function() {
			
			
			
			
			
		})

		$("#checkDuplicated").click(function() {
			alert("aa")
		})
	})
</script>
</head>
<body>
	<div align="center">
		<hr width="80%"></hr>
		<h2>회 원 가 입</h2>
		<hr width="80%"></hr>
		<br>

		<form action="register.jsp" method="post">
			<table border="1" style="width: 50%">
				<tr>
					<th width="30%">아이디 :</th>
					<td><input type="text" name="id" id = "id">
						<button type = "button" id="checkDuplicated">중복체크</button></td>
				</tr>
				<tr>
					<th width="30%">이름 :</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th width="30%">패스워드 :</th>
					<td><input type="text" name="pw"></td>
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
</body>
</html>
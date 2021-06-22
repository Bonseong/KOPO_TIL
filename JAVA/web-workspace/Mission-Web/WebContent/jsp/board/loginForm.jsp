<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$("#register").click(function(){
			location.href="registerForm.jsp"
		})
	})
	
	$(document).ready(function(){
		$("#checkID").click(function(){
			location.href="checkIDForm.jsp"
		})
	})
	
	$(document).ready(function(){
		$("#userList").click(function(){
			location.href="userList.jsp"
		})
	})
</script>
</head>
<body>
	<div align="center">
		<hr width="80%"></hr>
		<h2>로 그 인</h2>
		<hr width="80%"></hr>
		
		<form action="login.jsp" method = "post">
		아 이 디 : <input type="text" name = "id"><br>
		패스워드 : <input type="text" name = "pw"><br>
		
		<input type="submit" value = "로그인">
		<input type="button" value = "회원가입" id = "register">
		<input type="button" value = "ID체크" id = "checkID">
		<input type="button" value = "유저리스트" id = "userList">
		</form>
	</div>
	
</body>
</html>
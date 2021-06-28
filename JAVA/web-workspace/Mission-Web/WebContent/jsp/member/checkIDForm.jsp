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
		$("#cancle").click(function(){
			location.href="loginForm.jsp"
		})
	})
</script>
</head>
<body>
	<div align="center">
		<hr width="80%"></hr>
		<h2>아이디 체크</h2>
		<hr width="80%"></hr>
		
		<form action="checkID.jsp" method = "get">
		아 이 디 : <input type="text" name = "id"><br>
		<br>
		
		<input type="submit" value = "확인">
		<input type="button" value = "취소" id = "cancle">
		
		</form>
	</div>
</body>
</html>
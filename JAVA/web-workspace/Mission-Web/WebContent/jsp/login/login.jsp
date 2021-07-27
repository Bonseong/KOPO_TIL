<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"></link>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"></link>
<script src="/Mission-Web/resources/js/myJS.js"></script>
<script>
	
	function checkForm() {

		let f = document.loginForm
		
		if(isNull(f.id, '아이디를 입력하세요')){
			return false
		}
		
		if(isNull(f.password, '패스워드를 입력하세요')){
			return false
		}
		
		

		/* 같은 함수 -> 모듈화로 간단하게 처리
		if(f.id.value == ''){
			alert('아이디를 입력하세요')
			f.id.focus()
			return false
		}
		
		if(f.password.value == ''){
			alert('패스워드를 입력하세요')
			f.password.focus()
			return false
		}
		return true
		 */
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
			<hr>
			<h2>로그인</h2>
			<hr>
			<br>

			<form action="loginProcess.jsp" method="post" name="loginForm"
				onsubmit="return checkForm()">
				<table>
					<tr>
						<th>ID</th>
						<td><input type="email" name="id" value="ADMIN" required></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password" value="ADMIN" required></td>
					</tr>
				</table>
				<br> <input type="submit" value="로그인">
			</form>
		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp"%>
	</footer>
</body>
</html>
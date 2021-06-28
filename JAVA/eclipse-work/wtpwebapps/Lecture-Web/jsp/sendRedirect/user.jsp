<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- requestScope로 공유했을 경우 --%>
	<%-- <h2>${id}님 환영합니다</h2>  --%>
	<%-- <h2>${requestScope.id}님 환영합니다</h2> --%>
	
	<!-- forward로 공유했을 경우 -->
	<h2>${param.id}님 환영합니다</h2>
	
	<!-- 이미 request로 값이 공유되고 있음 -->
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1 ~ 10 사이의 정수 출력</h2>
	<%
	for (int i = 1; i <= 10; i++) { /* 자바코드로 작성해도 서블릿 코드로 변경됨 */
		out.write(i + "<br>"); /* out을 선언하지 않았더라도, 기본객체에 선언되어 있음 */
	}
	%>
</body>
</html>
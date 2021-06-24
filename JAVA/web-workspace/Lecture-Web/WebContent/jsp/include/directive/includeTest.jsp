<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	msg : <%= msg %><br>
	<h2>인클루드 전</h2>
	<%@ include file="one.jsp"%>
	<!--
	one.jsp가 들어감
	공통된 코드는 전체 태그를 가지고 있을 필요가 없음
	-> 자기 원래 코드만 가지고 있으면 됨
	-->
	
	<h2>인클루드 후</h2>
</body>
</html>
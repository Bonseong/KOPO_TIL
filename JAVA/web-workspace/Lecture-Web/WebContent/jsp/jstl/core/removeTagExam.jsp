<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1값을 가지는 변수 cnt를 공유영역에 등록(page)<br>
	
	<c:set var ="cnt" value="1"/>
	공유영역에 등록된 변수 cnt 출력<br>
	<!-- 공유영역에 등록되었으므로 el 사용 가능 -->
	
	cnt : ${cnt}<br>
	
	cnt 변수에 1을 더한 후 cnt 값을 출력<br>
	<c:set var ="cnt" value="${cnt+1}" scope = "request"/> <!-- el 사용 -->
	cnt : ${cnt}<br> <!-- request영역을 호출한 것이 아니기 때문에 1 -->
	cnt : ${requestScope.cnt}<br> <!-- EL 공유영역 내 requestScope -->
	
	request cnt : ${requestScope.cnt}<br>
	
</body>
</html>

<!--
----------------------------------------------------
JSP공유영역			EL공유영역			JSTL공유영역
----------------------------------------------------
pageContex			pageScope			page
request				requestScope		request
session				sessionScope		session
application			applicationScope	application
----------------------------------------------------

-->


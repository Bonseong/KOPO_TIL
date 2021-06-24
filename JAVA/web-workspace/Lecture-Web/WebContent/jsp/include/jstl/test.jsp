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
	<%-- <jsp:include page="http://www.daum.net"/> --%>
	<!-- 외부 링크는 jsp:include만으로는 가져올 수 없음 / 로컬의 객체가 아니기 때문 -->
	<c:import url="https://www.daum.net"/>
</body>
</html>


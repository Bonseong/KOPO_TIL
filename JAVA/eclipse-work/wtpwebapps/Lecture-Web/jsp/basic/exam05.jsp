<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Enumeration<String> headerNames = request.getHeaderNames();  //내장변수, enumarion 객체
		while(headerNames.hasMoreElements()){
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
	%>
		<%= headerName %> : <%=headerValue %><br> <!-- 접속 환경에 대한 상세 정보 (PC인지 모바일인지 등) -->
		
	<%
			
		}
	%>
</body>
</html>
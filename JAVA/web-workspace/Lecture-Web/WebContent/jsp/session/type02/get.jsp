<%@page import="kr.ac.kopo.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberVO member = (MemberVO)session.getAttribute("member");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% if(member!=null){ %>
		설정된 세션 ID : <%= member.getId() %><br>
		설정된 세션 PASSWORD : <%= member.getPassword() %><br>
	
	<%
		} else{
	%>
		설정된 세션정보가 없습니다.
	<%
		}
	%>
	
	<hr>
	<c:choose>
		<c:when test="${ not empty member }">
			설정된 세션 ID : <%= member.getId() %><br>
			설정된 세션 PASSWORD : <%= member.getPassword() %><br>
		</c:when>
		<c:otherwise>
			설정된 세션 정보가 없습니다.
		</c:otherwise>
	</c:choose>
	<hr>
	설정된 세션 ID : ${ sessionScope.member.id }<br> 
	설정된 세션 PASSWORD : ${ sessionScope.member.password }<br>
	<hr>
	<a href="remove.jsp">세션 삭제</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과화면</h2>
	<c:if test="${param.id eq 'admin'}">
		<%
			response.sendRedirect("admin.jsp");
		%> <!-- 서블릿 문법이기 때문에 script가 필요함 -->
	</c:if>
	<c:if test="${ param.id ne 'admin' }">
		<c:set var="id" value="${param.id }" scope = "request"/>
		<%
			response.sendRedirect("user.jsp?id="+request.getParameter("id"));
		/* 두번째로 요청받은 페이지에서 파라미터를 받지 못하므로, 직접 파라미터를 넘겨주어야 함 */
		/* request.getParameter를 통해 파라미터를 받고, 다시 넘겨줌 */
		%>
	</c:if>
</body>
</html>
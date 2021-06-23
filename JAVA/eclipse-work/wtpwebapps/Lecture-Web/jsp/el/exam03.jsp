<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		
	 --%>
	 
	 <%
	 
	 	// 객체등록 : 공유영역명.setAttribute(이름, 값)
		// 객제조회 : 공유영역명.getAttribute(이름)
		// 공유영역 4가지 : pageContext, request, session, application
	 	
		pageContext.setAttribute("msg", "pageContext영역에 등록"); // 등록
		String message = (String)pageContext.getAttribute("msg"); // 조회
		
		// request영역에 id라는 이름으로 hong값을 등록
	
		request.setAttribute("id", "hong");
		request.setAttribute("msg", "request영역에 등록");
		
	 %>
	 
	empty msg : ${ empty msg }<br>
	msg : <%= message %><br>
	
	msg : <%= pageContext.getAttribute("msg") %><br>
	el msg : ${ msg }<br>
	request msg : ${ requestScope.msg } <br>
	id : ${ id }<br>
	
	<%--
		el공유영역 4가지 : pageScope requestScope sessionScope applicationScope
	--%>
		
</body>
</html>
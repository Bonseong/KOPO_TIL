<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>    
<%
	request.setAttribute("id", "hong");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	msg : <%= msg %><br>
	id : ${ id }<br>
	phone : ${phone}<br> <%--아직 인클루드를 실행하지 않았기 때문에 phone이 없음 --%>
	<h2>인클루드전</h2>
	<strong>파라미터 미설정</strong>
	<jsp:include page="one.jsp" />
	<!-- one.jsp 요청, 요청시 includeTest.jsp의 out을 one.jsp에게 보냄 -->
	<!-- 하지만, 파라미터를 넘겨주지 않았기 때문에 값이 empty가 리턴됨 -->
	phone : ${phone}<br>
	
	<strong>파라미터 설정</strong>
	
	<jsp:include page="one.jsp">
		<jsp:param name = "name" value = "hong gil dong"/>
		<jsp:param name = "age" value = "30"/>
	</jsp:include>
	<!-- 파라미터를 설정하는 경우, 시작태그와 종료태그를 따로 설정해야함
	name = hong gil dong 이라는 파라미터를 가지고 one.jsp를 실행함
	종료 후 변수 소멸 -->
	
	<h2>인클루드후</h2>
</body>
</html>
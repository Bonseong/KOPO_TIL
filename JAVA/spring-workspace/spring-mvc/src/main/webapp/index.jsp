<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath() %>/hello/hello.do">hello</a><br>
	<a href="<%= request.getContextPath() %>/method/method.do">method</a><br>
	<a href="<%= request.getContextPath() %>/form/joinForm.do">form</a><br>
	<a href="<%= request.getContextPath() %>/ajax/resBody.do">문자열 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/resBody.json">json 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/resVOBody.json">json vo 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/resStringListBody.json">json list(문자열) 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/resVOListBody.json">json list(vo) 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/restBody.do">rest 문자열 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/restBody.json">rest json 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/restVOBody.json">rest json vo 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/restStringListBody.json">rest json list(문자열) 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/restVOListBody.json">rest json list(vo) 응답</a><br>
	<a href="<%= request.getContextPath() %>/file/uploadForm.do">파일업로드</a><br>
	
	
	
</body>
</html>
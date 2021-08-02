<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=request.getContextPath() %>/hello/hello.do">hello</a><br>
	<a href="<%=request.getContextPath() %>/method/method.do">method</a><br>
	<a href="<%=request.getContextPath() %>/form/joinForm.do">form</a><br>
	<hr>
	<a href="<%=request.getContextPath() %>/ajax/resBody.do">문자열 응답</a><br>
	<a href="<%=request.getContextPath() %>/ajax/resBody.json">json응답</a><br>
	<a href="<%=request.getContextPath() %>/ajax/resVOBody.json">json VO응답</a><br>
	<a href="<%=request.getContextPath() %>/ajax/resStringListBody.json">json list(문자열) 응답</a><br>
	<a href="<%=request.getContextPath() %>/ajax/resVOListBody.json">json list(vo) 응답</a><br>
	<hr>
	<a href="<%=request.getContextPath() %>/ajax/restBody.do">문자열 응답</a><br>
	<a href="<%=request.getContextPath() %>/ajax/restBody.json">json응답</a><br>
	<a href="<%=request.getContextPath() %>/ajax/restVOBody.json">json VO응답</a><br>
	<a href="<%=request.getContextPath() %>/ajax/restStringListBody.json">json list(문자열) 응답</a><br>
	<a href="<%=request.getContextPath() %>/ajax/restVOListBody.json">json list(vo) 응답</a><br>
	<hr>
	<a href="<%=request.getContextPath() %>/file/uploadForm.do">파일업로드</a><br>
</body>
</html>
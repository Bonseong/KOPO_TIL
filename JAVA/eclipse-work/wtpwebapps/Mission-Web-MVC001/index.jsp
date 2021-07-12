<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 재사용을 위해 아래처럼 사용 -->
	<!-- <a href = "/Mission-Web-MVC001/board/list.do">게시판</a><hr>
	<a href = "/Mission-Web-MVC001/board/writeForm.do">글등록</a><hr> -->
	
	
	<a href = "<%=request.getContextPath() %>/board/list.do">게시판</a><hr>
	<a href = "<%=request.getContextPath() %>/board/writeForm.do">글등록</a><hr>
	
	
</body>
</html>
<%@page import="kr.ac.kopo.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
	BoardVO board = new BoardVO();
	board.setNo(1);
	board.setTitle("test");
	
	// pageContext영역 등록 => 이름 : boardVo, 값 : 생성된 BoardVO객체
	pageContext.setAttribute("boardVO", board);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	no : <%= board.getNo() %><br>
	no : <%= ((BoardVO)pageContext.getAttribute("boardVO")).getNo() %><br>
	title : <%= board.getTitle() %><br>
	title : <%= ((BoardVO)pageContext.getAttribute("boardVO")).getTitle() %> <br>
	
	el no : ${ boardVO.no }<br> <!-- getNo()와 같은 역할 -->
	el title : ${ boardVO.title }<br> <!-- getTitle()와 같은 역할 -->
	el title : ${ boardVO['title'] }<br>
	
	<!--  el aaa : ${ boardVO.aaa }<br> -->
	<!-- 자바빈즈는 getter를 호출하지만, getAaa는 없기 때문에 500에러 -->
	

</body>
</html>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.ac.kopo.board.BoardVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 1. 자바빈즈 + 콜렉션
	BoardVO board = new BoardVO();
	board.setTitle("성공");
	
	List<BoardVO> boardList = new ArrayList<BoardVO>();
	boardList.add(board);
	
	pageContext.setAttribute("boardList", boardList);
	
	// 2. 자바빈즈 + 배열
	
	BoardVO board2 = new BoardVO();
	board2.setTitle("성공");
	BoardVO[] boardList2 = new BoardVO[]{board2};
	
	pageContext.setAttribute("boardList2", boardList2);
	
	// 3. Map + 배열
	
	Map<String, String> board3 = new HashMap<>();
	board3.put("title", "성공");
	
	Map[] boardList3 = {board3};
	
	pageContext.setAttribute("boardList3", boardList3);
	
	// 4. Map + 콜렉션
	Map<String, String> board4 = new HashMap<>();
	board4.put("title", "성공");
	List<Map<String, String>> boardList4 = new ArrayList<>();
	boardList4.add(board4);
	
	
	pageContext.setAttribute("boardList4", boardList4);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	성공/실패? - 1 ${ boardList[0].title } <br>
	성공/실패? - 2 ${ boardList2[0].title } <br>
	성공/실패? - 3 ${ boardList3[0].title } <br>
	성공/실패? - 4 ${ boardList4[0].title } <br>
	
</body>
</html>
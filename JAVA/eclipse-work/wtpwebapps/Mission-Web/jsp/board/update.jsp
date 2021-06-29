<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDAO dao = new BoardDAO();
	BoardVO board = new BoardVO();
	
	board.setNo(no);
	board.setTitle(title);
	board.setContent(content);
	
	dao.update(board);
%>

<script>
	alert("수정이 완료되었습니다.")
	location.href="list.jsp"
</script>
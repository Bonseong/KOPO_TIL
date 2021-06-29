<%@page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
 	int no = Integer.parseInt(request.getParameter("no"));
 	
 	BoardDAO board = new BoardDAO();
  	
	board.delete(no);
 %>
<script>
	alert("삭제가 완료되었습니다.")
	location.href = "list.jsp"
</script>
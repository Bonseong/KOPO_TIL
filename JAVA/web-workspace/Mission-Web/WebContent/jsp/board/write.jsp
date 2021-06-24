<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%--
	작업순서
	1. 파라미터(제목, 작성자, 내용) 추출
	2. 추출된 데이터를 DB(t_board)에 삽입
	3. 목록페이지 이동
 --%>

<%
 	request.setCharacterEncoding("utf-8");
 
 	String title = request.getParameter("title");
 	String writer = request.getParameter("writer");
 	String content = request.getParameter("content");
 	
 	Connection conn = new ConnectionFactory().getConnection();
 	
 	StringBuilder sql = new StringBuilder();
 	
 	sql.append(" INSERT INTO T_BOARD(NO, TITLE, WRITER, CONTENT) " );
 	sql.append(" VALUES(SEQ_T_BOARD_NO.NEXTVAL, ?, ?, ? )");
 	
 	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
 	
 	pstmt.setString(1, title);
 	pstmt.setString(2, writer);
 	pstmt.setString(3, content);
 	
 	pstmt.executeUpdate();
 	
 	JDBCClose.close(conn, pstmt);
 	
 	
 %>
<script>
	alert("새글 등록이 완료되었습니다.")
	location.href = "list.jsp"
</script>
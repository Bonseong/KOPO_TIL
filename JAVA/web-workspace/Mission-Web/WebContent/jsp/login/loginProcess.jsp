<%@page import="kr.ac.kopo.member.vo.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 화면에 출력할 부분이 없음! -->

<!--
	작업순서
	1. login.jsp에서 날라오는 파라미터 추출(id, password)
	2. 추출된 ID, PASSWORD에 맞는 회원의 존재 여부 판단(DB, t_member)
	3. 로그인 성공시 세션에 회원정보를 등록
	4. 존재여부에 따른 페이지를 이동(로그인 성공 : index.jsp, 로그인 실패 : login.jsp)
	
-->


<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String password = request.getParameter("password");

Connection conn = new ConnectionFactory().getConnection();

StringBuilder sql = new StringBuilder();

sql.append(" SELECT NAME FROM T_MEMBER WHERE ID = ? AND PASSWORD = ? ");

PreparedStatement pstmt = conn.prepareStatement(sql.toString());

pstmt.setString(1, id);
pstmt.setString(2, password);

ResultSet rs = pstmt.executeQuery();

if (rs.next()) {
	MemberVO member = new MemberVO();
	member.setId(id);
	member.setPassword(password);

	session.setAttribute("member", member);	
	
	response.sendRedirect("/Mission-Web/index.jsp");
} else {
	response.sendRedirect("/Mission-Web/jsp/login/login.jsp");
}
JDBCClose.close(conn, pstmt);
%>

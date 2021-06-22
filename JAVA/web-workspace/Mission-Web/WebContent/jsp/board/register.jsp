<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.SQLIntegrityConstraintViolationException"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	try{
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	String emailDetail = request.getParameter("emailDetail");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String post = request.getParameter("post");
	String addrBasic = request.getParameter("addrBasic");
	String addrDetail = request.getParameter("addrDetail");

	
	
	Connection conn = new ConnectionFactory().getConnection();

	StringBuilder sql = new StringBuilder();

	sql.append(
			" INSERT INTO T_MEMBER(ID, NAME, PASSWORD, EMAIL_ID, EMAIL_DOMAIN, TEL1, TEL2, TEL3, POST, BASIC_ADDR, DETAIL_ADDR) ");
	sql.append(" values(?,?,?,?,?,?,?,?,?,?,?) ");

	PreparedStatement pstmt = conn.prepareStatement(sql.toString());

	pstmt.setString(1, id);
	pstmt.setString(2, name);
	pstmt.setString(3, pw);
	pstmt.setString(4, email);
	pstmt.setString(5, emailDetail);
	pstmt.setString(6, tel1);
	pstmt.setString(7, tel2);
	pstmt.setString(8, tel3);
	pstmt.setString(9, post);
	pstmt.setString(10, addrBasic);
	pstmt.setString(11, addrDetail);

	pstmt.executeUpdate();

	JDBCClose.close(conn, pstmt);
	
	%>
<script>
	alert("회원가입이 완료되었습니다.")
	location.href = "loginForm.jsp"
	</script>

<%
	
	}catch(SQLIntegrityConstraintViolationException e){
		%><script>
		alert("중복된 아이디입니다.")
		location.href = "registerForm.jsp"
		</script>
<%
	}catch(SQLException e){
		%><script>
		alert('입력된 값이 올바르지 않습니다.')
		location.href = "registerForm.jsp"
		</script>
		<%
	}
	%>



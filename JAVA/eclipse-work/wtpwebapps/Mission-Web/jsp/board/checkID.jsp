<%@page import="java.sql.ResultSet"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	
	Connection conn = new ConnectionFactory().getConnection();
	
	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT ID, NAME, EMAIL_ID, EMAIL_DOMAIN, TEL1, TEL2, TEL3, POST, BASIC_ADDR, DETAIL_ADDR FROM T_MEMBER ");
	sql.append(" WHERE ID = ? ");
	
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	
	pstmt.setString(1, id);
	pstmt.executeUpdate();
	
	ResultSet rs = pstmt.executeQuery();
	

	
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>

<script>
<%

String name = null;
String emailID = null;
String tel = null;
String post = null;
String addr = null;

if(rs.next()){
	name = rs.getString("NAME");
	emailID = rs.getString("EMAIL_ID")+"@"+rs.getString("EMAIL_DOMAIN");
	tel = rs.getString("TEL1")+"-"+rs.getString("TEL2")+"-"+rs.getString("TEL3");
	post = rs.getString("POST");
	addr = rs.getString("BASIC_ADDR")+" " + rs.getString("DETAIL_ADDR"); 
}else{
	%>
	alert("아이디가 존재하지 않습니다.")
	location.href = "loginForm.jsp"
	<%
	
}


%>

</script>
<script>
	$(document).ready(function(){
		$("#main").click(function(){
			location.href="loginForm.jsp"
		})
	})
</script>
</head>
<body>
	<div align="center">
		<hr width="80%"></hr>
		<h2>상 세 정 보</h2>
		<hr width="80%"></hr>

		<table border="1" style="width: 80%">


			<tr>
				<th style="width: 30%">아이디</th>
				<td><%=id %></td>
			</tr>
			<tr>
				<th style="width: 30%">이름</th>
				<td><%=name %></td>
			</tr>
			<tr>
				<th style="width: 30%">이메일</th>
				<td><%=emailID %></td>
			</tr>
			<tr>
				<th style="width: 30%">전화번호</th>
				<td><%=tel %></td>
			</tr>
			<tr>
				<th style="width: 30%">우편번호</th>
				<td><%=post %></td>
			</tr>
			<tr>
				<th style="width: 30%">주소</th>
				<td><%=addr %></td>
			</tr>

		</table>
		<input type="button" value = "메인" id = "main">
	</div>
</body>
</html>
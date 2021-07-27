<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.login.LoginDAO;"%>

<%
String id = request.getParameter("id");

LoginDAO dao = new LoginDAO();

boolean re = dao.checkId(id); //DAO클래스를 통해 아이디 중복 검사한 값을 받아온다.
if (!re) {
%>
사용 가능합니다. //요 텍스트를 데이터로 전달한다.
<%
} else {
%>
이미 존재합니다.
<%
}
%>


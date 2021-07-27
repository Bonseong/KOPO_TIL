<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("POST"))
		request.setCharacterEncoding("utf-8"); // POST에 대한 인코딩
%>
name = ${ param.name }
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>empTable</title>
  
  </head>
  <body>
  	<div></div>
  			<c:forEach var="data" items="${data}">
  			<table>
  				<tr>
  					<td>${data.deptno}</td>
  					<td>${data.ename}</a></td>
  					<td>${data.job}</a></td>
  					<td>${data.mgr}</td>
  					<td>${data.sal}</td>
  					<td>${data.deptno}</td>
  				</tr>
  			</table>
  			</c:forEach>
  			
  </body>
  </html>
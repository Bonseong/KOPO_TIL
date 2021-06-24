<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<%
	String[] names = {"홍길동","강길동", "윤길동", "박길동"};
	pageContext.setAttribute("names", names);
	pageContext.setAttribute("lastValue", names[names.length-1]);
	
	pageContext.setAttribute("namesLength", names.length);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1~10사이의 정수 출력</h2>
	<c:forEach var="i" begin="1" end="10">
		${i} <br>
		<!-- i변수를 등록했다가, 사용 후 삭제 -->
	</c:forEach>

	년도선택 :
	<select>
		<option>2000</option>
		<option>2001</option>
		<option>2002</option>
	</select>
	<br>
	<select>
		<c:forEach var="year" begin="1940" end="2021" step="5">
			<option>${year}</option>
		</c:forEach>
	</select>
	<br>

	<c:forEach var="name" items="${names}">
		${name}<br>
	</c:forEach>


	<c:set var="lastValue" value = "${lastValue }"/>
	
	<c:forEach var="name" items="${names}">
		<c:choose>
			<c:when test="${name eq lastValue }">
				${name}
			</c:when>
			<c:otherwise>
				${name},
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<br>
	<hr>

	<c:forEach begin="0" end="${namesLength-1 }" var="i">
		<c:if test="${i ne 0 }">
		,
		</c:if>
		${ names[i] }	
	</c:forEach>
	<br><hr>
		<c:set var="cnt" value="0" />
	<c:forEach items="${ names }" var="name">
		<c:if test="${ cnt != 0 }">
		,
		</c:if>
		${ name }
		<c:set var="cnt" value="${ cnt+1 }" />
	</c:forEach>
	<hr>
	
	<c:forEach items="${names}" var="name" varStatus="loop">
		${loop.first} : ${loop.index} : ${loop.count} : ${loop.last}<br>
	</c:forEach>
	<hr>
	
	
	<c:forEach items="${names}" var = "name" varStatus="loop">
		<%-- 		
		<c:if test="${loop.index ne 0 }">
		<c:if test="${loop.count ne 1 }"> --%>
		<c:if test="${ not loop.first }">
			,
		</c:if>
		${ name }
	</c:forEach>
	
	
	<hr>
	"hello world" 문자열 길이 : ${fn:length("hello world")}<br>
	
	배열의 요소개수 : ${ fn:length(names) }<br>
	
</body>
</html>
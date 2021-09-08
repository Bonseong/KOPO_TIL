<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>jQuery UI Slider</title>
<body>

<c:set var="tempname" value=""/>
<c:forEach items="${requestScope.notice}" var="notice" varStatus="status">
	<c:if test="${notice.categoryKor ne tempname }">
		<h6><c:out value="${ notice.categoryKor }" /></h6><br>
	</c:if>
	<c:out value="${ notice.notice }" /><br>
	<c:set var="tempname" value="${notice.categoryKor}"/>

</c:forEach>

	<%-- <c:forEach items="${requestScope.notice}" var="notice" varStatus="status">
		<c:choose>
			<c:when test="${ status.index eq 0 }">
				<h6><c:out value="${ notice.categoryKor }" /></h6><br>
				<c:out value="${ notice.notice }" />
			</c:when>
			<c:when test="${ status.index ne 0 }">
				<c:if  test="${notice[status.index- 1].categoryKor ne notice.categoryKor} ">
					<h6><c:out value="${ notice.categoryKor }" /></h6><br>
				</c:if>
					<c:out value="${ notice.notice }" />
				
				
				
			</c:when>
			
			
		</c:choose>
		<c:out value="${loop.index}" /><br>
		<c:out value="${ notice.categoryKor }" /> <br><c:out value="${ notice.notice }" /><hr> 


	</c:forEach> --%>

</body>
</html>



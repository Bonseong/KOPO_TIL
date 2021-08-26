<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/layout.css" />
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/board.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<script>
	$(document).ready(function(){
	    
		replyList();
		
		$('#replyButton').click(function(){
	       	writeReply();
			replyList();
	    })   
	    
	    
	    function writeReply(){
			$.ajax({
			  'async' : false,
	          'type' : 'post',
	          'url' : '${pageContext.request.contextPath}/board/${board.no}/writeReply',
	          'data' :{
	        	  
	        	writer:$("#writer").val(),
	        	content:$("#content").val()
	        	  
	          } ,
	          'error' : function(){
	             console.log('에러')
	          },
	          'success' : function(data){
	        	  
	                  
                  $("#content").val("")
                  $("#writer").val("")
	              
		             
	          }
	       })
		}
	    
	    function replyList(){
	       $.ajax({
	          'type' : 'get',
	          'url' : '${pageContext.request.contextPath}/board/${board.no}/replyList',
	          'success' : function(data){
	             $('#replyList').html(data)
	             
	          }, 'error' : function(){
	             
	          }
	       })
		}
		
		
	 })
 


</script>



<script>
	function clickBtn(type) {
		switch (type) {
		case 'U':
			location.href = 'updateForm.jsp?no=${ param.no }'
			break
		case 'D':
			break
		case 'L':
			location.href = "${pageContext.request.contextPath}/board"
			break
		}
	}
</script>
</head>
<body>
	<header>
		<%-- <jsp:include page="/jsp/include/topMenu.jsp" /> --%>
	</header>
	<section>
		<div align="center">
			<hr width="80%">
			<h2>게시판 상세</h2>
			<hr width="80%">
			<br>
			<table border="1" style="width: 80%">
				<tr>
					<th width="25%">번호</th>
					<td><c:out value="${ board.no }" /></td>
				</tr>
				<tr>
					<th width="25%">제목</th>
					<td><c:out value="${ board.title }" /></td>
				</tr>
				<tr>
					<th width="25%">작성자</th>
					<td>${ board.writer }</td>
				</tr>
				<tr>
					<th width="25%">내용</th>
					<td>${ board.content }</td>
				</tr>
				<tr>
					<th width="25%">조회수</th>
					<td>${ board.viewCnt }</td>
				</tr>
				<tr>
					<th width="25%">등록일</th>
					<td>${ board.regDate }</td>
				</tr>
			</table>
			<br>
			<button onclick="clickBtn('U')">수정</button>
			<button onclick="clickBtn('D')">삭제</button>
			<button onclick="clickBtn('L')">목록</button>
		</div>
		<hr>
		<table id="replyList">
		</table>



		<form method="post">
			작성자<input id="writer" type="text"><br>
			내용<input id="content" type="text">
		</form>
		<button id="replyButton">등록</button>

	</section>
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
</body>
</html>



<%@page import="kr.ac.kopo.board.vo.BoardFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	http://localhost:9999/Mission-Web/jsp/board/detail.jsp?no=2
 --%>
<%
	// 1. 게시물번호 추출
	int boardNo = Integer.parseInt(request.getParameter("no"));
	String type = request.getParameter("type");
	
	// 2-1. 데이터베이스 t_board테이블에서 해당 게시물 조회
	BoardDAO dao = new BoardDAO();
	
	BoardVO board = dao.viewDetail(boardNo);
	
	
	// 2-2 조회수 증가
	if(type!=null && type.equals("list")){
		dao.updateCnt(boardNo); 	
	}
	
	// 2-3 게시물 첨부파일 조회
	
	List<BoardFileVO> fileList = dao.selectFileByNo(boardNo); // 0개 ~ 2개 -> List
	
	pageContext.setAttribute("board",board);
	pageContext.setAttribute("fileList", fileList);

	pageContext.setAttribute("board", board);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"></link>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"></link>
<script src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>

	$(document).ready(function() {
		$('#listBtn').click(function() {
			location.href = "list.jsp"
		})
		

	})
	
	function deleteBoard(no){
		if(confirm("정말 삭제하시겠습니까?")){
			location.href="delete.jsp?no="+no
		}
	}
	
	function updateBoard(no){
		location.href="updateForm.jsp?no="+no
	}
	

	
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
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
			<tr>
				<th>첨부파일</th>
				<td>
					<c:forEach items="${ fileList }" var="file">
						<a download id = "downTag" href="/Mission-Web/upload/${ file.fileSaveName }"><c:out value="${ file.fileOriName }" /></a><button id="downloadFile">다운로드</button>
						(${ file.fileSize } bytes)
						<br>
					</c:forEach>
				</td>
			</tr>
			</table>
			<br>
			<c:if test="${userVO.id eq board.writer || userVO.type eq 'S'}">
				<button id="updateBtn" onclick="updateBoard('${ board.no }')">수정</button>
				<button id="deleteBtn" onclick="deleteBoard('${ board.no }')">삭제</button>
			</c:if>
			<button id="listBtn">목록</button>
		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp"%>
	</footer>
</body>
</html>


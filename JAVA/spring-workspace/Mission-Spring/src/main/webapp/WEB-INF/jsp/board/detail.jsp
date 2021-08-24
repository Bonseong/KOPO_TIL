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
    // Perform an asynchronous HTTP (Ajax) request.
    // 비동기 통신 Ajax를 Setting한다.
    $.ajaxSetup({
        type:"POST",
        async:true,
        dataType:"json",
        error:function(xhr) {
            console.log("error html = " + xhr.statusText);
        }
    });
    
   /*  $(function() {
        $("#commentWrite").on("click", function() {
            $.ajax({
                url:"/board/replyList",
                // data:{}에서는 EL을 ""로 감싸야 한다. 이외에는 그냥 사용한다.
                data:{
                    commentContent:$("#commentContent").val(),
                    articleNumber:"${article.articleNumber}"
                },
                beforeSend:function() {
                    console.log("시작 전...");
                },
                complete:function() {
                    console.log("완료 후...");
                },
                success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback
                    if(data.result == 1) {            // 쿼리 정상 완료, executeUpdate 결과
                        console.log("comment가 정상적으로 입력되었습니다.");
                        $("#commentContent").val("");
                        showHtml(data.comments, 1);
                    }
                }
            })
        });
    }); */
 
    function showHtml(data, commPageNum) {
        let html = "<table class='table table-striped table-bordered' style='margin-top: 10px;'><tbody>";
        $.each(data, function(index, item) {
            html += "<tr align='center'>";
            html += "<td>" + (index+1) + "</td>";
            html += "<td>" + item.id + "</td>";
            html += "<td align='left'>" + item.commentContent + "</td>";
            let presentDay = item.commentDate.substring(0, 10);
            html += "<td>" + presentDay + "</td>";
            html += "</tr>";
        });
        html += "</tbody></table>";
        commPageNum = parseInt(commPageNum);        // 정수로 변경
        // commentCount는 동기화되어 값을 받아오기 때문에, 댓글 insert에 즉각적으로 처리되지 못한다.
        if("${article.commentCount}" > commPageNum * 10) {
            nextPageNum = commPageNum + 1;
            html +="<input type='button' class='btn btn-default' onclick='getComment(nextPageNum, event)' value='다음 comment 보기'>";
        }
        
        $("#showComment").html(html);
        $("#commentContent").val("");
        $("#commentContent").focus();
    }
    
    function getComment(commPageNum, event) {
        $.ajax({
            url:"/board/{no}/replyList",
            data:{
                commPageNum:commPageNum*10,
                articleNumber:"${board.no}"
            },
            beforeSend:function() {
                console.log("읽어오기 시작 전...");
            },
            complete:function() {
                console.log("읽어오기 완료 후...");
            },
            success:function(data) {
                console.log("comment를 정상적으로 조회하였습니다.");
                showHtml(data, commPageNum);
                
                let position = $("#showComment table tr:last").position();
                $('html, body').animate({scrollTop : position.top}, 400);        // 두 번째 param은 스크롤 이동하는 시간
            }
        })
    }
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
		<div class="input-group" role="group" aria-label="..."
			style="margin-top: 10px; width: 100%;">
			<textarea class="form-control" rows="3" id="commentContent"
				placeholder="댓글을 입력하세요." style="width: 100%;"></textarea>
			<div class="btn-group btn-group-sm" role="group" aria-label="...">
				<c:if test="${id == null}">
					<input type="button" class="btn btn-default" value="댓글 쓰기"
						disabled="disabled">
				</c:if>
				<c:if test="${id != null}">
					<input type="button" class="btn btn-default" value="댓글 쓰기"
						id="commentWrite">
				</c:if>
				<input type="button" class="btn btn-default"
					value="댓글 읽기(${article.commentCount})"
					onclick="getComment(1, event)" id="commentRead">
			</div>
		</div>

		<!-- Comment 태그 추가 -->
		<div class="input-group" role="group" aria-label="..."
			style="margin-top: 10px; width: 100%;">
			<div id="showComment" style="text-align: center;"></div>
		</div>






	</section>
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
</body>
</html>
























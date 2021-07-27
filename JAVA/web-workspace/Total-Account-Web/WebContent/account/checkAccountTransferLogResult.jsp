<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세진저축은행</title>
<link rel="stylesheet" href="resources/assets/css/table.css" />
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function page(){ 
	$('table.paginated').each(function() {
	var pagesu = 10;  //페이지 번호 갯수
	var currentPage = 0;
	var numPerPage = 10;  //목록의 수
	var $table = $(this);    
	var pagination = $("#pagination");

	//length로 원래 리스트의 전체길이구함
	var numRows = $table.find('tbody tr').length;

	//Math.ceil를 이용하여 반올림
	var numPages = Math.ceil(numRows / numPerPage);

	//리스트가 없으면 종료
	if (numPages==0) return;

	//pager라는 클래스의 div엘리먼트 작성
	var $pager = $('<div class="pager"></div>');
	var nowp = currentPage;
	var endp = nowp+10;

	//페이지를 클릭하면 다시 셋팅
	$table.bind('repaginate', function() {

		//기본적으로 모두 감춘다, 현재페이지+1 곱하기 현재페이지까지 보여준다
	$table.find('tbody tr').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
	$("#pagination").html("");

	if (numPages > 1) {     // 한페이지 이상이면
	if (currentPage < 5 && numPages-currentPage >= 5) {   // 현재 5p 이하이면
	nowp = 0;     // 1부터 
	endp = pagesu;    // 10까지
	}else{
	nowp = currentPage -5;  // 6넘어가면 2부터 찍고
	endp = nowp+pagesu;   // 10까지
	pi = 1;
	}
	if (numPages < endp) {   // 10페이지가 안되면
	endp = numPages;   // 마지막페이지를 갯수 만큼
	nowp = numPages-pagesu;  // 시작페이지를   갯수 -10
	}
	if (nowp < 1) {     // 시작이 음수 or 0 이면
	nowp = 0;     // 1페이지부터 시작
	}
	}else{       // 한페이지 이하이면
	nowp = 0;      // 한번만 페이징 생성
	endp = numPages;
	}


	// [처음]
	$('<span class="pageNum first"> 처음 </span>').css("cursor","pointer").bind('click', {newPage: page},function(event) {
	currentPage = 0;   
	$table.trigger('repaginate');  
	$($(".pageNum")[2]).addClass('active').siblings().removeClass('active');
	}).appendTo(pagination).addClass('clickable');

	// [이전]
	$('<span class="pageNum back"> 이전 </span>').css("cursor","pointer").bind('click', {newPage: page},function(event) {
	if(currentPage == 0) return; 

	currentPage = currentPage-1;
	$table.trigger('repaginate'); 
	$($(".pageNum")[(currentPage-nowp)+2]).addClass('active').siblings().removeClass('active');
	}).appendTo(pagination).addClass('clickable');

	// [1,2,3,4,5,6,7,8]
	for (var page = nowp ; page < endp; page++) {
	$('<span class="pageNum"></span>').text(page + 1 + " ").css("cursor","pointer").bind('click', {newPage: page}, function(event) {
	currentPage = event.data['newPage'];
	$table.trigger('repaginate');
	$($(".pageNum")[(currentPage-nowp)+2]).addClass('active').siblings().removeClass('active');
	}).appendTo(pagination).addClass('clickable');
	} 

	// [다음]
	$('<span class="pageNum next"> 다음 </span>').css("cursor","pointer").bind('click', {newPage: page},function(event) {
	if(currentPage == numPages-1) return;

	currentPage = currentPage+1;
	$table.trigger('repaginate'); 
	$($(".pageNum")[(currentPage-nowp)+2]).addClass('active').siblings().removeClass('active');
	}).appendTo(pagination).addClass('clickable');

	// [끝]
	$('<span class="pageNum last"> 끝 </span>').css("cursor","pointer").bind('click', {newPage: page},function(event) {
	currentPage = numPages-1;
	$table.trigger('repaginate');
	$($(".pageNum")[endp-nowp+1]).addClass('active').siblings().removeClass('active');
	}).appendTo(pagination).addClass('clickable');
	$($(".pageNum")[2]).addClass('active');
	});

	$pager.insertAfter($table).find('span.pageNum:first').next().next().addClass('active');   
	$pager.appendTo(pagination);
	$table.trigger('repaginate');
	});
	}

	$(function(){
	// table pagination
	page();
	});
</script>

<script>
		
	function clickBtn(type) {
		switch(type) {
		
		case 'L' :
			location.href = "${pageContext.request.contextPath}/checkAccountTransferLog.do"
			break
		}
	}


</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center" style="margin-top: 200px;">
			<hr width="80%">
			<h2>거래 내역</h2>
			<hr width="80%">
			<br>

			<table border="1" style="width: 80%; margin-top: 0px]" id="list"
				class="table table-bordered tbList paginated">
				<tr>
					<th width="20%" class="th-center">거래일시</th>
					<th width="10%" class="th-center">보낸 은행명</th>
					<th width="15%" class="th-center">보낸 계좌번호</th>
					<th width="10%" class="th-center">이체 전 잔액</th>
					<th width="10%" class="th-center">이체액</th>
					<th width="10%" class="th-center">이체 후 잔액</th>
					<th width="10%" class="th-center">받는 은행명</th>
					<th width="15%" class="th-center">받는 계좌번호</th>
				</tr>
			</table>
			
			<table border="1" style="width: 80%; margin-top: 0px]" id="list"
				class="table table-bordered tbList paginated">
				
				<c:forEach items="${ logList }" var="logList" varStatus="loop">
					<tr <c:if test="${loop.index mod 2 ne 0}" > class="odd"</c:if>>
						<td width="20%" class="td-center">${ logList.logDate }</td>
						<td width="10%" class="td-center">${ logList.sendingBankName }</td>
						<td width="15%" class="td-center">${ logList.sendingAccNO }</td>
						<td width="10%" class="td-center">${ logList.beforeBalance }</td>
						<td width="10%" class="td-center">${ logList.remittance }</td>
						<td width="10%" class="td-center">${ logList.afterBalance }</td>
						<td width="10%" class="td-center">${ logList.receivingBankName }</td>
						<td width="15%" class="td-center">${ logList.receivingAccNO }</td>
					</tr>
				</c:forEach>
			</table>

			<div class="btnContent">
				<div class="pagination" id="pagination">페이지 영역</div>
			</div>
			<br>


			<button onclick="clickBtn('L')">계좌목록</button>

		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp"%>
	</footer>
</body>
</html>
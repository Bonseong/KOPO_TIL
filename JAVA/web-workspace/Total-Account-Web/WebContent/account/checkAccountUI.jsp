<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.login.LoginVO"%>
<%@page import="kr.ac.kopo.account.AccountDAO"%>
<%@page import="kr.ac.kopo.account.AccountVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>세진저축은행</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						$('#btn-accountDetail')
								.click(
										function() {
											location.href = "${pageContext.request.contextPath}/checkAccountDetail.do"
										})

						$('#btn-transferLog')
								.click(
										function() {
											location.href = "${pageContext.request.contextPath}/checkTransferLog.do"
										})
					})
</script>
<link rel="stylesheet"
	href="/Total-Account-Web/resources/assets/css/form.css"></link>


<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div class="container">
			<div id="signupbox"
				class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">계좌조회</div>


					</div>
					<div class="panel-body">
						<form id="checkAccountform" method="post" class="form-horizontal"
							role="form">
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-accountDetail" type="button"
									class="btn btn-info"
									onclick="location.href='/Total-Account-Web/checkAccountDetail.do';">
									<i class="icon-hand-right"></i>계좌상세정보
								</button>
							</div>
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-accountDetail" type="button"
									class="btn btn-info"
									onclick="location.href='/Total-Account-Web/checkAccountTransferLog.do';">
									<i class="icon-hand-right"></i>계좌이체기록
								</button>
							</div>

						</form>
					</div>
				</div>


			</div>
		</div>
	</section>
	<footer>
		<jsp:include page="/jsp/include/bottom.jsp" />
	</footer>
</body>
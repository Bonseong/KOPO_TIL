<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.login.LoginVO"%>
<%@page import="kr.ac.kopo.account.AccountDAO"%>
<%@page import="kr.ac.kopo.account.AccountVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


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
						<div class="panel-title">계좌수정</div>


					</div>
					<div class="panel-body">
						<form id="openAccountform" method="post" class="form-horizontal"
							role="form">
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-signup" type="button" class="btn btn-info"
									onclick="location.href='/Total-Account-Web/modifyAccountPassword.do';">
									<i class="icon-hand-right"></i> 비밀번호수정
								</button>
							</div>
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-signup" type="button" class="btn btn-info"
									onclick="location.href='/Total-Account-Web/modifyAccountNickname.do';">
									<i class="icon-hand-right"></i> 계좌약칭수정
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
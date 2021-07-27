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
						<div class="panel-title">오픈뱅킹</div>
					</div>
					<div class="panel-body" style=text-align:center;>
						<form id="openBankingform" method="post" class="form-horizontal"
							role="form">
							<button id="btn-signup" type="button" class="btn btn-info"
								onclick="location.href='/Total-Account-Web/openBankTerms.do';">
								<i class="icon-hand-right"></i>계좌등록
							</button>
							<button id="btn-signup" type="button" class="btn btn-info"
								onclick="location.href='/Total-Account-Web/openBankDetail.do';">
								<i class="icon-hand-right"></i>계좌조회
							</button>
							<button id="btn-signup" type="button" class="btn btn-info"
								onclick="location.href='/Total-Account-Web/openBankDelete.do';">
								<i class="icon-hand-right"></i>등록해지
							</button>
							<button id="btn-signup" type="button" class="btn btn-info"
								onclick="location.href='/Total-Account-Web/openBankTransfer.do';">
								<i class="icon-hand-right"></i>계좌이체
							</button>

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
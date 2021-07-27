<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Home page style-->
<meta charset="utf-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="favicon.ico">

<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">


<link rel="stylesheet" href="resources/assets/css/slick/slick.css">
<link rel="stylesheet" href="resources/assets/css/slick/slick-theme.css">
<link rel="stylesheet" href="resources/assets/css/animate.css">
<link rel="stylesheet" href="resources/assets/css/iconfont.css">
<link rel="stylesheet" href="resources/assets/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/assets/css/bootstrap.css">
<link rel="stylesheet" href="resources/assets/css/magnific-popup.css">
<link rel="stylesheet" href="resources/assets/css/bootsnav.css">

<link rel="stylesheet" href="resources/assets/css/style.css">
<link rel="stylesheet" href="resources/assets/css/responsive.css" />

<script
	src="resources/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<!-- JS includes -->

<script src="resources/assets/js/vendor/jquery-1.11.2.min.js"></script>
<script src="resources/assets/js/vendor/bootstrap.min.js"></script>

<script src="resources/assets/js/owl.carousel.min.js"></script>
<script src="resources/assets/js/jquery.magnific-popup.js"></script>
<script src="resources/assets/js/jquery.easing.1.3.js"></script>
<script src="resources/assets/css/slick/slick.js"></script>
<script src="resources/assets/css/slick/slick.min.js"></script>
<script src="resources/assets/js/jquery.collapse.js"></script>
<script src="resources/assets/js/bootsnav.js"></script>

<script src="resources/assets/js/plugins.js"></script>
<script src="resources/assets/js/main.js"></script>

<script
	src="resources/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<!-- JS includes -->

<script src="resources/assets/js/vendor/jquery-1.11.2.min.js"></script>
<script src="resources/assets/js/vendor/bootstrap.min.js"></script>

<script src="resources/assets/js/owl.carousel.min.js"></script>
<script src="resources/assets/js/jquery.magnific-popup.js"></script>
<script src="resources/assets/js/jquery.easing.1.3.js"></script>
<script src="resources/assets/css/slick/slick.js"></script>
<script src="resources/assets/css/slick/slick.min.js"></script>
<script src="resources/assets/js/jquery.collapse.js"></script>
<script src="resources/assets/js/bootsnav.js"></script>

<script src="resources/assets/js/plugins.js"></script>
<script src="resources/assets/js/main.js"></script>


<nav class="navbar navbar-default bootsnav navbar-fixed">
	<div class="navbar-top bg-grey fix">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="navbar-callus text-left sm-text-center">
						<ul class="list-inline">
							<li><a href=""><i class="fa fa-phone"></i> Call us : 010
									4773 9853</a></li>
							<li><a href=""><i class="fa fa-envelope-o"></i> Contact
									us : 9bonseong@naver.com</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-6">
					<div class="navbar-socail text-right sm-text-center">
						<ul class="list-inline">
							<li><a href="">저축은행소개</a></li>

							<li><a
								href="https://www.youtube.com/channel/UCq49mJiquZk6Bzcug3aALtw"
								target='_blank'>세진개발</a></li>
							<li><a href="">세진은행</a></li>

							<c:choose>
								<c:when test="${ empty userVO }">
									<li><a href="<%=request.getContextPath()%>/register.do">회원가입</a></li>
									<li><a href="<%=request.getContextPath()%>/login.do">로그인</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="<%=request.getContextPath()%>/logout.do">로그아웃</a></li>
									<li><strong>${ userVO.name }</strong>님</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="container">


		<!-- Start Header Navigation -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navbar-menu">
				<i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand" href="<%=request.getContextPath()%>"> <img
				class="logo" src="resources/assets/images/logo2.png" alt="">
			</a>
		</div>

		<!-- End Header Navigation -->

		<!-- navbar menu -->
		<div class="collapse navbar-collapse" id="navbar-menu">
			<ul class="nav navbar-nav navbar-right">

				<c:choose>
					<c:when test="${ not empty userVO }">
						<li><a href="<%=request.getContextPath()%>/openAccount.do">계좌생성</a></li>
						<li><a href="<%=request.getContextPath()%>/modifyAccountUI.do">계좌수정</a></li>
						<li><a href="<%=request.getContextPath()%>/deleteAccount.do">계좌삭제</a></li>
						<li><a href="<%=request.getContextPath()%>/transfer.do">계좌이체</a></li>
						<li><a href="<%=request.getContextPath()%>/checkAccountUI.do">계좌조회</a></li>
						<li><a href="<%=request.getContextPath()%>/openBankUI.do">오픈뱅킹</a></li>
						<li><a href="<%=request.getContextPath()%>/qaBoardList.do">문의사항</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="<%=request.getContextPath()%>/login.do">계좌생성</a></li>
						<li><a href="<%=request.getContextPath()%>/login.do">계좌수정</a></li>
						<li><a href="<%=request.getContextPath()%>/login.do">계좌삭제</a></li>
						<li><a href="<%=request.getContextPath()%>/login.do">계좌이체</a></li>
						<li><a href="<%=request.getContextPath()%>/login.do">계좌조회</a></li>
						<li><a href="<%=request.getContextPath()%>/login.do">오픈뱅킹</a></li>
						<li><a href="<%=request.getContextPath()%>/login.do">문의사항</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>

</nav>

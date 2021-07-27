<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>세진저축은행</title>
<link
	href='https://fonts.googleapis.com/css?family=Lato:300,400|Montserrat:700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="/Total-Account-Web/resources/assets/css/form.css"></link>
<style>
@import
	url(//cdnjs.cloudflare.com/ajax/libs/normalize/3.0.1/normalize.min.css)
	;

@import
	url(//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css)
	;
</style>
<link rel="stylesheet"
	href="https://2-22-4-dot-lead-pages.appspot.com/static/lp918/min/default_thank_you.css">
<script
	src="https://2-22-4-dot-lead-pages.appspot.com/static/lp918/min/jquery-1.9.1.min.js"></script>
<script
	src="https://2-22-4-dot-lead-pages.appspot.com/static/lp918/min/html5shiv.js"></script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<div class="site-header" id="header">
		<h3 class="site-header__title" data-lead-id="site-header-title">환영합니다!</h3>
	</div>


	<div class="main-content">

		<p class="main-content__body" data-lead-id="main-content-body">
			<strong>세진저축은행</strong>의 새 가족이 되신걸 환영합니다<br>가장 빠르게 부자가 되는 <strong>세진저축은행</strong>의
			서비스를 만나보세요!
		</p>
	</div>

	<div class="col-md-12 control">
		<div>

			<h3 class="bottom-text">
				<a href="<%=request.getContextPath()%>/">메인으로</a>
			</h3>
		</div>
	</div>

	<footer>
		<jsp:include page="/jsp/include/bottom.jsp" />
	</footer>

</body>
</html>
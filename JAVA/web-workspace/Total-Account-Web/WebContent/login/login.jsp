<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>세진저축은행</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet"
	href="/Total-Account-Web/resources/assets/css/form.css"></link>

<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>

	<div class="container">
		<div id="loginbox"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">로그인</div>
					<div class="panel-heading-small">
						<a href="#">Forgot password?</a>
					</div>
				</div>

				<div class="panel-body">

					<form action="<%=request.getContextPath()%>/loginProcess.do"
						method="post" id="loginform" class="form-horizontal" role="form">

						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-id"
								type="text" class="form-control" name="id" value="test"
								placeholder="ID">
						</div>

						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="password"
								value="test" placeholder="PASSWORD">
						</div>


						<div class="input-group-checkbox">
							<div class="checkbox">
								<label> <input id="login-remember" type="checkbox"
									name="remember" value="1"> Remember me
								</label>
							</div>
						</div>


						<div class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">
								<input type="submit" value="로그인" id="btn-login"
									class="btn btn-success"> <a id="btn-fblogin" href="#"
									class="btn btn-primary">카카오 로그인</a>

							</div>
						</div>


						<div class="form-group">
							<div class="col-md-12 control">
								<div>
									<a href="<%=request.getContextPath()%>/register.do"
										onClick="$('#loginbox').hide(); $('#signupbox').show()">
										회원가입 </a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
	<header>
		<jsp:include page="/jsp/include/bottom.jsp" />
	</header>
</body>
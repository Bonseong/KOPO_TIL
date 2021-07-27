<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<div class="panel-title">회원가입</div>

						<div class='panel-heading-small'>
							<a id="signinlink" href="<%=request.getContextPath()%>/login.do"
								onclick="$('#signupbox').hide(); $('#loginbox').show()">로그인</a>
						</div>
					</div>
					<div class="panel-body">
						<form id="signupform"
							action="<%=request.getContextPath()%>/registerProcess.do"
							method="post" class="form-horizontal" role="form">


							<div class="form-group">
								<label for="id" class="col-md-3 control-label">ID</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="id"
										placeholder="ID" required>
								</div>
							</div>

							<div class="form-group">
								<label for="name" class="col-md-3 control-label">이름</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="name"
										placeholder="Name" required>
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-md-3 control-label">비밀번호</label>
								<div class="col-md-9">
									<input type="password" class="form-control" name="password"
										placeholder="Password" required>
								</div>
							</div>
							<div class="form-group">
								<label for="rrn" class="col-md-3 control-label">주민등록번호</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="rrn"
										placeholder="Resident Registration Number" required>
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-md-3 control-label">이메일</label>
								<div class="col-md-9">
									<input type="email" class="form-control" name="email"
										placeholder="Email" required>
								</div>
							</div>

							<div class="form-group">
								<label for="phone" class="col-md-3 control-label">휴대전화</label>
								<div class="col-md-9">
									<input type="text" pattern="(010)-\d{3,4}-\d{4}"
										title="010-0000-0000 형태로 작성하세요." class="form-control"
										name="phone" placeholder="Password">
								</div>
							</div>
							<div class="form-group">
								<label for="post" class="col-md-3 control-label">우편번호</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="post"
										placeholder="Post" required>
								</div>
							</div>
							<div class="form-group">
								<label for="basic_addr" class="col-md-3 control-label">주소</label>
								<div class="col-md-9">
									<select class="form-control" name="basicAddr" required>
										<option value="서울특별시">서울특별시</option>
										<option value="부산광역시">부산광역시</option>
										<option value="인천광역시">인천광역시</option>
										<option value="대구광역시">대구광역시</option>
										<option value="울산광역시">울산광역시</option>
										<option value="광주광역시">광주광역시</option>
										<option value="대전광역시">대전광역시</option>
										<option value="세종특별자치시">세종특별자치시</option>
										<option value="경기도">경기도</option>
										<option value="충청북도">충청북도</option>
										<option value="충청남도">충청남도</option>
										<option value="강원도">강원도</option>
										<option value="전라북도">전라북도</option>
										<option value="전라남도">전라남도</option>
										<option value="경상북도">경상북도</option>
										<option value="경상남도">경상남도</option>
										<option value="제주특별자치도">제주특별자치도</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="detail_addr" class="col-md-3 control-label">상세주소</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="detailAddr"
										placeholder="Detail Address" required>
								</div>
							</div>



							<div class="form-group">
								<!-- Button -->
								<div class="col-md-offset-3 col-md-9">
									<button id="btn-signup" type="submit" class="btn btn-info">
										<i class="icon-hand-right"></i> 회원가입
									</button>
									<span class="btn-side-text">또는</span>
								</div>
							</div>

							<div class="form-group-bottom">

								<div class="col-md-offset-3 col-md-9">
									<button id="btn-fbsignup" type="button" class="btn btn-primary">
										<i class="icon-facebook"></i> 카카오 로그인
									</button>
								</div>

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
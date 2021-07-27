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
<title>세진저축은행</title>
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
						<div class="panel-title">오픈뱅킹 계좌등록 - 계좌 선택</div>


					</div>
					<div class="panel-body">
						<form id="openBankEnrollSelect"
							action="<%=request.getContextPath()%>/openBankEnrollSelectProcess.do"
							method="post" class="form-horizontal" role="form">
							<div class="form-group">
								<label for="name" class="col-md-3 control-label">이름</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="name"
										value="${ userVO.name }" readonly>
								</div>
							</div>
							<div class="form-group">
								<label for="name" class="col-md-3 control-label">아이디</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="id"
										value="${ userVO.id }" readonly>
								</div>
							</div>
						
							<div class="form-group">
								<label for="accNo" class="col-md-3 control-label">타행<br>계좌번호</label>

								<div class="col-md-9">
									<select class="form-control" name="openAcc" required>
										<c:forEach items="${ accList }" var="accList" varStatus="loop">
											<option value="${ accList.openAccList }" />
											<c:out value="${ accList.openAccList }" />
										</c:forEach>
									</select>
								</div>

							</div>
							

							<div class="form-group">
								<!-- Button -->
								<div class="col-md-offset-3 col-md-9">
									<button id="btn-signup" type="submit" class="btn btn-info">
										<i class="icon-hand-right"></i>확인
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
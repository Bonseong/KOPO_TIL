<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Job Board</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<script>

	// Load the Visualization API and the corechart package.
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});

	// Set a callback to run when the Google Visualization API is loaded.
	google.charts.setOnLoadCallback(drawChart);

	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	
	function drawChart() {

		// Create the data table.
		var data = new google.visualization.DataTable();
		data.addColumn('string', '성별');
		data.addColumn('number', '가입 비율');
		data.addRows([ [ 'Mushrooms', 3 ], [ 'Onions', 1 ], [ 'Olives', 1 ],
				[ 'Zucchini', 1 ], [ 'Pepperoni', 2 ] ]);

		// Set chart options
		var options = {
			'title' : '${ card.cardName }' + '가입 성비',
			'width' : 400,
			'height' : 300,
			'tooltip' : {text : 'percentage'}
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>

</head>

<body>
	<header>
		<jsp:include page="../include/topMenu.jsp" />
	</header>

	<!-- bradcam_area  -->
	<div class="bradcam_area bradcam_bg_1">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="bradcam_text">
						<h3>
							<c:out value="${ card.cardName }" />
						</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/ bradcam_area  -->

	<div class="job_details_area">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="job_details_header">
						<div class="single_jobs white-bg d-flex justify-content-between">
							<div class="jobs_left d-flex align-items-center">
								<div class="thumb" style="width: 150px; padding: 0">
									<img style="width: 148px; height: 80px;"
										src="${ pageContext.request.contextPath }/resources/img/card/<c:out
														value="${ card.cardCode }" />.png"
										alt="" />
								</div>
								<div class="jobs_conetent">
									<h4 style="margin-bottom: 15px">
										<c:out value="${ card.cardName }" />
									</h4>
									<div class="links_locat d-flex align-items-center">
										<div class="location">
											<p>
												<i class="fa fa-map-marker"></i>
												<c:choose>
													<c:when test="${ card.cardType eq 'CREDIT' }">신용카드</c:when>
													<c:when test="${ card.cardType eq 'CHECK' }">체크카드</c:when>
												</c:choose>
											</p>
										</div>
										<div class="location">
											<p>
												<i class="fa fa-clock-o"></i> 연회비
												<c:out value="${ card.annualFee }" />
												원
											</p>
										</div>
									</div>
								</div>
							</div>
							<div class="jobs_right"></div>
						</div>
					</div>
					<div class="descript_wrap white-bg">
						<!-- <div class="single_wrap">
							<h4>Job description</h4>
							<p>There are many variations of passages of Lorem Ipsum
								available, but the majority have suffered alteration in some
								form, by injected humour, or randomised words which don't look
								even slightly believable. If you are going to use a passage of
								Lorem Ipsum, you need to be sure there isn't anything
								embarrassing.</p>
							<p>Variations of passages of lorem Ipsum available, but the
								majority have suffered alteration in some form, by injected
								humour, or randomised words which don't look even slightly
								believable. If you are going to use a passage of Lorem Ipsum,
								you need to be sure there isn't anything embarrassing.</p>
						</div> -->

						<div class="single_wrap">
							<c:set var="tempname" value="" />
							<c:forEach items="${requestScope.notice}" var="notice"
								varStatus="status">
								<c:if test="${notice.categoryKor ne tempname }">
									<h4>
										<c:out value="${ notice.categoryKor }" />
									</h4>
								</c:if>
								<ul style="margin-bottom: 10px;">
									<li style="margin-bottom: 5px;"><c:out
											value="${ notice.notice }" /></li>
								</ul>
								<c:set var="tempname" value="${notice.categoryKor}" />

							</c:forEach>



						</div>

						<div class="single_wrap">
							<h4>여기는 그래프를 그릴거야</h4>
							<ul>
								<li>The applicants should have experience in the following
									areas.</li>
								<li>Have sound knowledge of commercial activities.</li>
								<li>Leadership, analytical, and problem-solving abilities.</li>
								<li>Should have vast knowledge in IAS/ IFRS, Company Act,
									Income Tax, VAT.</li>
							</ul>

						</div>
						<div class="single_wrap">
							<h4>여기는 혜택을 정리할거야</h4>
							<div id="chart_div"></div>
						</div>
					</div>

				</div>
				<div class="col-lg-4">
					<div class="job_sumary">
						<div class="summery_header">
							<h3>카드 정보</h3>
						</div>
						<div class="job_content">
							<ul>
								<li>카드 종류 : <span><c:choose>
											<c:when test="${ card.cardType eq 'CREDIT' }">신용카드</c:when>
											<c:when test="${ card.cardType eq 'CHECK' }">체크카드</c:when>
										</c:choose></span></li>
								<li>연회비 : <span><c:out value="${ card.annualFee }" />
										원</span></li>
								<li>발급대상 : <span><c:choose>
											<c:when test="${ card.cardType eq 'CREDIT' }">전 고객</c:when>
											<c:when test="${ card.cardType eq 'CHECK' }">비교통 - 만 14세 이상 / 후불교통 - 만 18세 이상</c:when>
										</c:choose></span></li>
								<li>발급 신청 : <span>하나카드 홈페이지</span></li>
							</ul>
						</div>
					</div>
					<div class="mt-10">
						<div class="col-lg-12">
							<div class="single_field">
								<div class="reset_btn">
									<a
										href="https://www.hanacard.co.kr/OPIB0040000M.web?schID=ncd&mID=OPIB0040000M"><button
											type="button" class="boxed-btn3 w-100" id="enrollCard">카드
											신청</button></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<jsp:include page="../include/bottom.jsp" />
	</footer>
</body>


</html>
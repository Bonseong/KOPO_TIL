<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Job Board</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script>
	$(function() {
		$("#slider-range-max").slider({
			range : "max",
			min : 1,
			max : 10,
			value : 2,
			slide : function(event, ui) {
				$("#amount").val(ui.value);
			}
		});
		$("#amount").val($("#slider-range-max").slider("value"));

		$("#slider-range").slider({
			range : true,
			min : 0,
			max : 500,
			step : 5,
			values : [ 75, 300 ],
			slide : function(event, ui) {
				$("#amount2").val("$" + ui.values[0] + " - $" + ui.values[1]);
			}
		});
		$("#amount2").val(
				"$" + $("#slider-range").slider("values", 0) + " - $"
						+ $("#slider-range").slider("values", 1));

		$("#slider").slider({
			value : 10,
			min : 0,
			max : 100,
			step : 10,
			slide : function(event, ui) {
				$("#amount3").val("$" + ui.value);
			}
		});
		$("#amount3").val("$" + $("#slider").slider("value"));
	});
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
						<h3>나만의 카드</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/ bradcam_area  -->

	<!-- job_listing_area_start  -->
	<div class="job_listing_area plus_padding">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="job_filter white-bg">
						<div class="form_inner white-bg">
							<h3>Filter</h3>
							<form action="#">
								<div class="row">
									<div class="col-lg-12">
										<div class="single_field">
											<input type="text" placeholder="카드 이름 입력">
										</div>
									</div>
									<div class="col-lg-12">
										<div class="single_field">
											<select class="wide">
												<option data-display="카드 종류">카드 종류</option>
												<option value="CREDIT">신용카드</option>
												<option value="CHECK">체크카드</option>
											</select>
										</div>
									</div>
									<div class="col-lg-12">
										<div class="single_field">
											<select class="wide">
												<option data-display="Category">Category</option>
												<option value="1">Category 1</option>
												<option value="2">Category 2</option>
											</select>
										</div>
									</div>
									<div class="col-lg-12">
										<div class="single_field">
											<select class="wide">
												<option data-display="Experience">Experience</option>
												<option value="1">Experience 1</option>
												<option value="2">Experience 2</option>
											</select>
										</div>
									</div>
									<div class="col-lg-12">
										<div class="single_field">
											<select class="wide">
												<option data-display="Job type">Job type</option>
												<option value="1">full time 1</option>
												<option value="2">part time 2</option>
											</select>
										</div>
									</div>
									<div class="col-lg-12">
										<div class="single_field">
											<select class="wide">
												<option data-display="Qualification">Qualification</option>
												<option value="1">Qualification 1</option>
												<option value="2">Qualification 2</option>
											</select>
										</div>
									</div>
									<div class="col-lg-12">
										<div class="single_field">
											<select class="wide">
												<option data-display="Gender">Gender</option>
												<option value="1">male</option>
												<option value="2">female</option>
											</select>
										</div>
									</div>
								</div>
								<div class="range_wrap">
								
									<div id="slider-range-max"></div>

									<p>
										<input type="text" id="amount2" readonly
											style="border: 0; color: #f6931f; font-weight: bold;">
									</p>
									
									<label for="amount">Price range:</label>
									<div id="slider-range"></div>
									<p>
										<input type="text" id="amount" readonly
											style="border: 0; color: #7A838B; font-size: 14px; font-weight: 400;">
									</p>
								</div>
							</form>
						</div>


						<div class="reset_btn">
							<button class="boxed-btn3 w-100" type="submit">Reset</button>
						</div>


					</div>
				</div>
				<div class="col-lg-9">
					<div class="recent_joblist_wrap">
						<div class="recent_joblist white-bg ">
							<div class="row align-items-center">
								<div class="col-md-6">
									<h4>Job Listing</h4>
								</div>
								<div class="col-md-6">
									<div class="serch_cat d-flex justify-content-end">
										<select>
											<option data-display="Most Recent">혜택이 많은 순</option>
											<option value="1">최다 선택순</option>
											<option value="2">연령별</option>
											<option value="4">Designer</option>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="job_lists m-0">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="single_jobs white-bg d-flex justify-content-between">
									<div class="jobs_left d-flex align-items-center">
										<div class="thumb">
											<img src="img/svg_icon/1.svg" alt="">
										</div>
										<div class="jobs_conetent">
											<a href="job_details.html"><h4>Software Engineer</h4></a>
											<div class="links_locat d-flex align-items-center">
												<div class="location">
													<p>
														<i class="fa fa-map-marker"></i> California, USA
													</p>
												</div>
												<div class="location">
													<p>
														<i class="fa fa-clock-o"></i> Part-time
													</p>
												</div>
											</div>
										</div>
									</div>
									<div class="jobs_right">
										<div class="apply_now">
											<a class="heart_mark" href="#"> <i class="fa fa-heart"></i>
											</a> <a href="job_details.html" class="boxed-btn3">Apply Now</a>
										</div>
										<div class="date">
											<p>Date line: 31 Jan 2020</p>
										</div>
									</div>
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-lg-12">
								<div class="pagination_wrap">
									<ul>
										<li><a href="#"> <i class="ti-angle-left"></i>
										</a></li>
										<li><a href="#"><span>01</span></a></li>
										<li><a href="#"><span>02</span></a></li>
										<li><a href="#"> <i class="ti-angle-right"></i>
										</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- job_listing_area_end  -->

	<!-- footer start -->
	<footer class="footer">
		<div class="footer_top">
			<div class="container">
				<div class="row">
					<div class="col-xl-3 col-md-6 col-lg-3">
						<div class="footer_widget wow fadeInUp" data-wow-duration="1s"
							data-wow-delay=".3s">
							<div class="footer_logo">
								<a href="#"> <img src="img/logo.png" alt="">
								</a>
							</div>
							<p>
								finloan@support.com <br> +10 873 672 6782 <br> 600/D,
								Green road, NewYork
							</p>
							<div class="socail_links">
								<ul>
									<li><a href="#"> <i class="ti-facebook"></i>
									</a></li>
									<li><a href="#"> <i class="fa fa-google-plus"></i>
									</a></li>
									<li><a href="#"> <i class="fa fa-twitter"></i>
									</a></li>
									<li><a href="#"> <i class="fa fa-instagram"></i>
									</a></li>
								</ul>
							</div>

						</div>
					</div>
					<div class="col-xl-2 col-md-6 col-lg-2">
						<div class="footer_widget wow fadeInUp" data-wow-duration="1.1s"
							data-wow-delay=".4s">
							<h3 class="footer_title">Company</h3>
							<ul>
								<li><a href="#">About </a></li>
								<li><a href="#"> Pricing</a></li>
								<li><a href="#">Carrier Tips</a></li>
								<li><a href="#">FAQ</a></li>
							</ul>

						</div>
					</div>
					<div class="col-xl-3 col-md-6 col-lg-3">
						<div class="footer_widget wow fadeInUp" data-wow-duration="1.2s"
							data-wow-delay=".5s">
							<h3 class="footer_title">Category</h3>
							<ul>
								<li><a href="#">Design & Art</a></li>
								<li><a href="#">Engineering</a></li>
								<li><a href="#">Sales & Marketing</a></li>
								<li><a href="#">Finance</a></li>
							</ul>
						</div>
					</div>
					<div class="col-xl-4 col-md-6 col-lg-4">
						<div class="footer_widget wow fadeInUp" data-wow-duration="1.3s"
							data-wow-delay=".6s">
							<h3 class="footer_title">Subscribe</h3>
							<form action="#" class="newsletter_form">
								<input type="text" placeholder="Enter your mail">
								<button type="submit">Subscribe</button>
							</form>
							<p class="newsletter_text">Esteem spirit temper too say
								adieus who direct esteem esteems luckily.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="copy-right_text wow fadeInUp" data-wow-duration="1.4s"
			data-wow-delay=".3s">
			<div class="container">
				<div class="footer_border"></div>
				<div class="row">
					<div class="col-xl-12">
						<p class="copy_right text-center">
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with <i
								class="fa fa-heart-o" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!--/ footer end  -->

	<!-- link that opens popup -->


	<script>
		$(function() {
			$("#slider-range").slider(
					{
						range : true,
						min : 0,
						max : 24600,
						values : [ 750, 24600 ],
						slide : function(event, ui) {
							$("#amount").val(
									"$" + ui.values[0] + " - $" + ui.values[1]
											+ "/ Year");
						}
					});

			$("#amount")
					.val(
							"$" + $("#slider-range").slider("values", 0)
									+ " - $"
									+ $("#slider-range").slider("values", 1)
									+ "/ Year");
		});
	</script>
</body>

</html>
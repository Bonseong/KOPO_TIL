<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Job Board</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">


<script>
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href = "${pageContext.request.contextPath}/cardlist?nowPage=${paging.nowPage}&cntPerPage="
				+ sel;
	}
</script>
</head>

<body>
	<header>
		<jsp:include page="../include/topMenu.jsp" />
	</header>
	<!-- header-end -->

	<!-- bradcam_area  -->
	<div class="bradcam_area bradcam_bg_1">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="bradcam_text">
						<h3>실시간 카드 내역서</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/ bradcam_area  -->


	<!--================Blog Area =================-->
	<section class="blog_area section-padding">
		<div class="container">

			<div class="row">
				<div class="col-lg-8 mb-5 mb-lg-0">
					<div class="blog_left_sidebar">
						<div class="section-top-border">
							<div class="recent_joblist white-bg ">
								<div class="row align-items-center">
									<div class="col-md-6">
										<h4>하나카드 카드목록</h4>
									</div>
									<div class="col-md-6">
										<div class="serch_cat d-flex justify-content-end">

											<select id="cntPerPage" name="sel" onchange="selChange()">
												<option value="5"
													<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5개씩
													보기</option>
												<option value="10"
													<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10개씩
													보기</option>
												<option value="15"
													<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15개씩
													보기</option>
												<option value="20"
													<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20개씩
													보기</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<h3 class="mb-30">최근 거래 내역</h3>
							<table border="1" id="list"
								class="table table-bordered paginated">
								<tr>
									<th width="30%" class="th-center">일시</th>
									<th width="15%" class="th-center">카테고리</th>
									<th width="40%" class="th-center">항목</th>
									<th width="15%" class="th-center">금액</th>

								</tr>
								<c:forEach items="${requestScope.history }" var="history"
									varStatus="loop">
									<tr>
										<td><c:out value="${ history.historyDate }" /></td>
										<td><c:out value="${ history.category }" /></td>
										<td><c:out value="${ history.store }" /></td>
										<td><c:out value="${ history.amount }" /></td>
									</tr>
								</c:forEach>
							</table>

						</div>

						<article class="blog_item">
							<div class="blog_item_img">
								<img class="card-img rounded-0" src="img/blog/single_blog_2.png"
									alt=""> <a href="#" class="blog_item_date">
									<h3>15</h3>
									<p>Jan</p>
								</a>
							</div>

							<div class="blog_details">
								<a class="d-inline-block" href="single-blog.html">
									<h2>Google inks pact for new 35-storey office</h2>
								</a>
								<p>That dominion stars lights dominion divide years for
									fourth have don't stars is that he earth it first without
									heaven in place seed it second morning saying.</p>
								<ul class="blog-info-link">
									<li><a href="#"><i class="fa fa-user"></i> Travel,
											Lifestyle</a></li>
									<li><a href="#"><i class="fa fa-comments"></i> 03
											Comments</a></li>
								</ul>
							</div>
						</article>

						<article class="blog_item">
							<div class="blog_item_img">
								<img class="card-img rounded-0" src="img/blog/single_blog_3.png"
									alt=""> <a href="#" class="blog_item_date">
									<h3>15</h3>
									<p>Jan</p>
								</a>
							</div>

							<div class="blog_details">
								<a class="d-inline-block" href="single-blog.html">
									<h2>Google inks pact for new 35-storey office</h2>
								</a>
								<p>That dominion stars lights dominion divide years for
									fourth have don't stars is that he earth it first without
									heaven in place seed it second morning saying.</p>
								<ul class="blog-info-link">
									<li><a href="#"><i class="fa fa-user"></i> Travel,
											Lifestyle</a></li>
									<li><a href="#"><i class="fa fa-comments"></i> 03
											Comments</a></li>
								</ul>
							</div>
						</article>

						<article class="blog_item">
							<div class="blog_item_img">
								<img class="card-img rounded-0" src="img/blog/single_blog_4.png"
									alt=""> <a href="#" class="blog_item_date">
									<h3>15</h3>
									<p>Jan</p>
								</a>
							</div>

							<div class="blog_details">
								<a class="d-inline-block" href="single-blog.html">
									<h2>Google inks pact for new 35-storey office</h2>
								</a>
								<p>That dominion stars lights dominion divide years for
									fourth have don't stars is that he earth it first without
									heaven in place seed it second morning saying.</p>
								<ul class="blog-info-link">
									<li><a href="#"><i class="fa fa-user"></i> Travel,
											Lifestyle</a></li>
									<li><a href="#"><i class="fa fa-comments"></i> 03
											Comments</a></li>
								</ul>
							</div>
						</article>

						<article class="blog_item">
							<div class="blog_item_img">
								<img class="card-img rounded-0" src="img/blog/single_blog_5.png"
									alt=""> <a href="#" class="blog_item_date">
									<h3>15</h3>
									<p>Jan</p>
								</a>
							</div>

							<div class="blog_details">
								<a class="d-inline-block" href="single-blog.html">
									<h2>Google inks pact for new 35-storey office</h2>
								</a>
								<p>That dominion stars lights dominion divide years for
									fourth have don't stars is that he earth it first without
									heaven in place seed it second morning saying.</p>
								<ul class="blog-info-link">
									<li><a href="#"><i class="fa fa-user"></i> Travel,
											Lifestyle</a></li>
									<li><a href="#"><i class="fa fa-comments"></i> 03
											Comments</a></li>
								</ul>
							</div>
						</article>

						<nav class="blog-pagination justify-content-center d-flex">
							<ul class="pagination">
								<li class="page-item"><a href="#" class="page-link"
									aria-label="Previous"> <i class="ti-angle-left"></i>
								</a></li>
								<li class="page-item"><a href="#" class="page-link">1</a></li>
								<li class="page-item active"><a href="#" class="page-link">2</a>
								</li>
								<li class="page-item"><a href="#" class="page-link"
									aria-label="Next"> <i class="ti-angle-right"></i>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget search_widget">
							<form action="#">
								<div class="form-group">
									<div class="input-group mb-3">
										<input type="text" class="form-control"
											placeholder='Search Keyword' onfocus="this.placeholder = ''"
											onblur="this.placeholder = 'Search Keyword'">
										<div class="input-group-append">
											<button class="btn" type="button">
												<i class="ti-search"></i>
											</button>
										</div>
									</div>
								</div>
								<button
									class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
									type="submit">Search</button>
							</form>
						</aside>

						<aside class="single_sidebar_widget post_category_widget">
							<h4 class="widget_title">Category</h4>
							<ul class="list cat-list">
								<li><a href="#" class="d-flex">
										<p>Resaurant food</p>
										<p>(37)</p>
								</a></li>
								<li><a href="#" class="d-flex">
										<p>Travel news</p>
										<p>(10)</p>
								</a></li>
								<li><a href="#" class="d-flex">
										<p>Modern technology</p>
										<p>(03)</p>
								</a></li>
								<li><a href="#" class="d-flex">
										<p>Product</p>
										<p>(11)</p>
								</a></li>
								<li><a href="#" class="d-flex">
										<p>Inspiration</p>
										<p>21</p>
								</a></li>
								<li><a href="#" class="d-flex">
										<p>Health Care (21)</p>
										<p>09</p>
								</a></li>
							</ul>
						</aside>

						<aside class="single_sidebar_widget popular_post_widget">
							<h3 class="widget_title">Recent Post</h3>
							<div class="media post_item">
								<img src="img/post/post_1.png" alt="post">
								<div class="media-body">
									<a href="single-blog.html">
										<h3>From life was you fish...</h3>
									</a>
									<p>January 12, 2019</p>
								</div>
							</div>
							<div class="media post_item">
								<img src="img/post/post_2.png" alt="post">
								<div class="media-body">
									<a href="single-blog.html">
										<h3>The Amazing Hubble</h3>
									</a>
									<p>02 Hours ago</p>
								</div>
							</div>
							<div class="media post_item">
								<img src="img/post/post_3.png" alt="post">
								<div class="media-body">
									<a href="single-blog.html">
										<h3>Astronomy Or Astrology</h3>
									</a>
									<p>03 Hours ago</p>
								</div>
							</div>
							<div class="media post_item">
								<img src="img/post/post_4.png" alt="post">
								<div class="media-body">
									<a href="single-blog.html">
										<h3>Asteroids telescope</h3>
									</a>
									<p>01 Hours ago</p>
								</div>
							</div>
						</aside>
						<aside class="single_sidebar_widget tag_cloud_widget">
							<h4 class="widget_title">Tag Clouds</h4>
							<ul class="list">
								<li><a href="#">project</a></li>
								<li><a href="#">love</a></li>
								<li><a href="#">technology</a></li>
								<li><a href="#">travel</a></li>
								<li><a href="#">restaurant</a></li>
								<li><a href="#">life style</a></li>
								<li><a href="#">design</a></li>
								<li><a href="#">illustration</a></li>
							</ul>
						</aside>


						<aside class="single_sidebar_widget instagram_feeds">
							<h4 class="widget_title">Instagram Feeds</h4>
							<ul class="instagram_row flex-wrap">
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_5.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_6.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_7.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_8.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_9.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_10.png" alt="">
								</a></li>
							</ul>
						</aside>


						<aside class="single_sidebar_widget newsletter_widget">
							<h4 class="widget_title">Newsletter</h4>

							<form action="#">
								<div class="form-group">
									<input type="email" class="form-control"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter email'"
										placeholder='Enter email' required>
								</div>
								<button
									class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
									type="submit">Subscribe</button>
							</form>
						</aside>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================Blog Area =================-->

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



	<script>
		$('#datepicker').datepicker({
			iconsLibrary : 'fontawesome',
			icons : {
				rightIcon : '<span class="fa fa-caret-down"></span>'
			}
		});
		$('#datepicker2').datepicker({
			iconsLibrary : 'fontawesome',
			icons : {
				rightIcon : '<span class="fa fa-caret-down"></span>'
			}

		});
	</script>
</body>
</html>
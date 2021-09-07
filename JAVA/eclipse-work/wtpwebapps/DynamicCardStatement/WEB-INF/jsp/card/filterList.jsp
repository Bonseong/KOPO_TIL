<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<div class="job_lists m-0">
	<div class="row">


		<table class="paginated">
			<c:forEach items="${requestScope.cardFilterList }" var="cardFilterList"
				varStatus="loop">
				<tr>
					<td>
						<div class="col-lg-12 col-md-12">
							<div class="single_jobs white-bg d-flex justify-content-between"
								style="width: 827px">
								<div class="jobs_left d-flex align-items-center">
									<div class="thumb" style="width: 150px; padding: 0">
										<img style="width: 148px; height: 80px;"
											src="${ pageContext.request.contextPath }/resources/img/card/<c:out
														value="${ cardFilterList.cardCode }" />.png"
											alt="" />
									</div>
									<div class="jobs_conetent">
										<c:choose>
											<c:when test="${fn:length(cardFilterList.cardName) gt 20}">
												<h5>
													<a href="detail/${ cardFilterList.cardCode }"> <c:out
															value="${ cardFilterList.cardName }" />
													</a>
												</h5>
											</c:when>
											<c:otherwise>
												<h4>
													<a href="detail/${ cardFilterList.cardCode }"> <c:out
															value="${ cardFilterList.cardName }" />
													</a>
												</h4>
											</c:otherwise>
										</c:choose>

										<div class="links_locat d-flex align-items-center">
											<div class="location">
												<p>
													<i class="fa fa-map-marker"></i>
													<c:choose>
														<c:when test="${ cardFilterList.cardType eq 'CREDIT' }">신용카드</c:when>
														<c:when test="${ cardFilterList.cardType eq 'CHECK' }">체크카드</c:when>
													</c:choose>
												</p>
											</div>
											<div class="location">
												<p>
													<i class="fa fa-clock-o"></i> 연회비
													<c:out value="${ cardFilterList.annualFee }" />
													원
												</p>
											</div>
										</div>
									</div>
								</div>
								<div class="jobs_right">
									<div class="apply_now">
										<a class="heart_mark" href="detail/${ cardFilterList.cardCode }"> <i class="fa fa-heart"></i>
										</a> <a href="job_details.html" class="boxed-btn3">상세 혜택</a>
									</div>
									<div class="date">
										<p>n명의 선택을 받은 카드!</p>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>


			</c:forEach>
		</table>



	</div>



</div><%-- 
<div style="display: block; text-align: center;">
	<c:if test="${paging.startPage != 1 }">
		<a
			href="${pageContext.request.contextPath}/cardlist?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
	</c:if>
	<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
		var="p">
		<c:choose>
			<c:when test="${p == paging.nowPage }">
				<b>${p }</b>
			</c:when>
			<c:when test="${p != paging.nowPage }">
				<a
					href="${pageContext.request.contextPath}/cardlist?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
			</c:when>
		</c:choose>
	</c:forEach>
	<c:if test="${paging.endPage != paging.lastPage}">
		<a
			href="${pageContext.request.contextPath}/cardlist?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
	</c:if>
</div>
 --%>
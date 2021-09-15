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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/custom/modal.css">

<script>
	$(document)
			.ready(
					function() {
						$('#modalBtn').click(function() {
							$('.index_modal').css('display', 'block')
							$('body').css("overflow", "hidden");
						})
						//모달 다시 숨기기
						$('.index_modal_cancel').click(function() {
							$('.index_modal').css('display', 'none')
							$('body').css("overflow", "scroll");
						})
						temp = []
						amount_temp = []
						$("input[class=form-check-input]").each(function(idx) {
							var value = $(this).val();
							temp.push("#" + value + "_slider-range");
							amount_temp.push("#" + value + "_amount");
						})
						for (var i = 0; i < temp.length; i++) {
							eval('$(function(){$(temp['
									+ i
									+ ']).slider({range:true,min:0,step:1,max:50,values:[0,50],slide:function(event,ui){$(amount_temp['
									+ i
									+ ']).val(ui.values[0]+" % - "+ui.values[1]+" %")}});$(amount_temp['
									+ i + ']).val($(temp[' + i
									+ ']).slider("values",0)+" % - "+$(temp['
									+ i + ']).slider("values",1)+" %")});')
						}
						$('#searchBtn').click(function() {
							getCardList();
						})
						function getCardList() {
							let benefitInputList = [];
							$("input[class=form-check-input]:checked").each(
									function(idx) {
										var value = $(this).val();
										benefitInputList.push(value);
									})
							console.log("benefitInputList : "
									+ benefitInputList)
							var json_data = {}
							json_data['cardName'] = $("#cardName").val();
							json_data['cardType'] = $("#cardType").val();
							json_data['annualFeeType'] = $("#annualFeeType")
									.val()
							json_data['annualFeeRange'] = $("#amount").val()
							console.log(json_data)
							for (var i = 0; i < benefitInputList.length; i++) {
								json_data[benefitInputList[i]] = document
										.getElementById(benefitInputList[i]
												+ "_amount").value
								console.log(json_data)
							}
							$
									.ajax({
										'type' : 'post',
										'contentType' : "application/json; charset=utf-8",
										'url' : '${pageContext.request.contextPath}/cardlist/filterList',
										'data' : JSON.stringify(json_data),
										'success' : function(data) {
											$('#cardListDiv').empty()
											$('#cardListDiv').html(data)
											console.log("석세스")
										},
										'error' : function() {
											console.log("실패")
										}
									})
						}
					})
	function annualFeeChange(e) {
		var div = document.getElementById('annualFeeRangeDiv');
		if ($("#annualFeeType").val() == 'Y') {
			div.style.display = 'block';
		} else {
			div.style.display = 'none';
		}
	}
	function getBenefitList() {
		let allBenefitList = [];
		let benefitInputList = [];
		$("input[class=form-check-input]").each(function(idx) {
			var value = $(this).val();
			allBenefitList.push(value);
		})
		$("input[class=form-check-input]:checked").each(function(idx) {
			var value = $(this).val();
			benefitInputList.push(value);
		})
		for (i = 0; i < benefitInputList.length; i++) {
			allBenefitList = allBenefitList.filter(function(item) {
				return item !== benefitInputList[i];
			});
		}
		for (i = 0; i < benefitInputList.length; i++) {
			document.getElementById(benefitInputList[i]).style.display = 'block'
		}
		for (i = 0; i < allBenefitList.length; i++) {
			document.getElementById(allBenefitList[i]).style.display = 'none'
		}
	}
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href = "${pageContext.request.contextPath}/cardlist?nowPage=${paging.nowPage}&cntPerPage="
				+ sel;
	}
</script>
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
						<form name="benefitInputForm">
							<div class="form_inner white-bg">
								<h3>카드 검색 필터</h3>
								<div class="row">
									<div class="col-lg-12">
										<div class="single_field">
											<input type="text" id="cardName" name="cardName"
												placeholder="카드 이름 입력">
										</div>
									</div>
									<div class="col-lg-12">
										<div class="single_field">

											<select class="wide" id="cardType" name="cardType">
												<option value="" data-display="카드 종류 선택">카드 종류 선택</option>
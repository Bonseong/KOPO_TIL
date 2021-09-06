<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>jQuery UI Slider</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script>
$(document).ready(function() {
	let temp = [ 1, 2, 3 ]
	for (var i = 0; i < temp.lenth; i++) {

		$(function() {
			$("#slider-range"+i)
					.slider(
							{
								range : true,
								min : 0,
								max : 500,
								step : 5,
								values : [ 75, 300 ],
								slide : function(event, ui) {
									$("#amount"+i).val(
											"$" + ui.values[0] + " - $"
													+ ui.values[1]);
								}
							});

			$("#amount"+i).val(
					"$"
							+ $("#slider-range"+i)
									.slider("values", 0)
							+ " - $"
							+ $("#slider-range"+i)
									.slider("values", 1));

		});
	}

}
</script>
</head>

<body>


	<p>
		<input type="text" id="amount" readonly
			style="border: 0; color: #f6931f; font-weight: bold;">
	</p>
	<div id="slider-range"></div>
	<p>
		<input type="text" id="amount1" readonly
			style="border: 0; color: #f6931f; font-weight: bold;">
	</p>
	<div id="slider-range1"></div>
	<p>
	<p>
		<input type="text" id="amount2" readonly
			style="border: 0; color: #f6931f; font-weight: bold;">
	</p>
	<div id="slider-range2"></div>
	<p>
		<input type="text" id="amount3" readonly
			style="border: 0; color: #f6931f; font-weight: bold;">
	</p>
	<div id="slider-range3"></div>


</body>
<script type="text/javascript">
	let temp = [ 1, 2, 3 ]
	$(function() {
		$("#slider-range").slider(
				{
					range : true,
					min : 0,
					step : 1000,
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

	for (var i = 0; i < temp.lenth; i++) {

		$(function() {
			$("#slider-range"+i)
					.slider(
							{
								range : true,
								min : 0,
								max : 500,
								step : 5,
								values : [ 75, 300 ],
								slide : function(event, ui) {
									$("#amount"+i).val(
											"$" + ui.values[0] + " - $"
													+ ui.values[1]);
								}
							});

			$("#amount"+i).val(
					"$"
							+ $("#slider-range"+i)
									.slider("values", 0)
							+ " - $"
							+ $("#slider-range"+i)
									.slider("values", 1));

		});
	}
</script>
</html>



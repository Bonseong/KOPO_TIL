<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<head>
<meta charset="utf-8">
<title>jQuery UI Slider</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
	var ctx = document.getElementById("myChart").getContext('2d');
	var myChart = new Chart(
			ctx,
			{
				type : 'pie',
				data : {
					labels : [ 'confirmed', 'pending' ],
					datasets : [ {
						data : [ 67, 33 ],
						backgroundColor : [ 'rgba(41, 121, 255, 1)',
								'rgba(38, 198, 218, 1)',
								'rgba(138, 178, 248, 1)',
								'rgba(255, 100, 200, 1)',
								'rgba(116, 96, 238, 1)',
								'rgba(215, 119, 74, 1)',
								'rgba(173, 92, 210, 1)',
								'rgba(255, 159, 64, 1)',
								'rgba(247, 247, 247, 1)',
								'rgba(227, 247, 227, 1)', ],
					} ]
				},
				options : {
					responsive : true,
					maintainAspectRatio : false,
					cutoutPercentage : 80,
					tooltips : {
						callbacks : {
							label : function(tooltipItem, data) {
								return data['labels'][tooltipItem['index']]
										+ ': '
										+ data['datasets'][0]['data'][tooltipItem['index']]
										+ '%';
							}
						}
					}
				}
			});
</script>
</head>

<body>
	<!--Div that will hold the pie chart-->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/gh/emn178/chartjs-plugin-labels/src/chartjs-plugin-labels.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.min.js"></script>
	<canvas id="myChart"></canvas>
</body>
</html>



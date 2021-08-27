<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Filter</title>
<script type="text/javascript"
	src="https://public.tableau.com/javascripts/api/tableau-2.min.js"></script>
<script type="text/javascript">
        var viz;
        function initViz() {
            var containerDiv = document.getElementById("vizContainer"),
                url = "https://prod-apnortheast-a.online.tableau.com/t/kubonseongwebsite/views/210810_3/1?:showAppBanner=false&:display_count=n&:showVizHome=n&:origin=viz_share_link",
                options = {
                    
                    hideTabs: true
                };

            viz = new tableau.Viz(containerDiv, url, options);
            
            
            
        }

    
    </script>
</head>

<body onload="initViz();">
	<div id="vizContainer" style="width: 800px; height: 700px;"></div>

</body>

</html>
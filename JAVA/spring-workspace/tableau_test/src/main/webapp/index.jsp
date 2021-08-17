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
                url = "https://public.tableau.com/views/2_16284906518100/1?:language=ko-KR&publish=yes&:display_count=n&:origin=viz_share_link",
                options = {
                    "NAME": '구본성',
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
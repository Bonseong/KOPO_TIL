<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	let httpRequest = null
	function getXMLHttpRequest() {
		let httpRequest = null;
		if (window.XMLHttpRequest)
			httpRequest = new XMLHttpRequest()
		else if (window.ActiveXObject)
			httpRequest = new ActiveXObject("Microsoft.XMLHTTP")
		return httpRequest
	}

	function sendProcess(method, param) {
		httpRequest = getXMLHttpRequest()
		httpRequest.onreadystatechange = callbackFunction
		let msg = "================================\n"

		msg += "/Lecture-Web/exam02/param2.jsp?name=" + param + "\n"
		debugTrace(msg)

		let url = 'param2.jsp'
		param = encodeURIComponent(param)
		let args = 'name = ' + param

		if (method == 'GET') {
			httpRequest.open(method, url + '?' + args, true)
			httpRequest.send(null)
		} else if (method == 'POST') { // form태그를 사용할때만 POST로 날아감, 나머지는 GET
			httpRequest.open(method, url, true)
			httpRequest.setRequestHeader('Content-type',
					'application/x-www-form-urlencoded')
			httpRequest.send(args) // 파라미터

		}

	}

	function callbackFunction() {
		let msg = ''
		switch (httpRequest.readyState) {
		case 1:
			msg += 'Loading...\n'
			break
		case 2:
			msg += 'Loaded...\n'
			break
		case 3:
			msg += 'Interactive...\n'
			break
		case 4:
			msg += 'Completed...\n'
			if (httpRequest.status == 200) {
				msg += '웹서버에서 정상적으로 수행..\n'
				msg += '실행결과 : ' + httpRequest.responseText + '\n'
			} else {
				msg += '웹서버에서 오류 발생...\n'
				msg += '오류코드 : ' + httpRequest.status + '\n'
			}

			msg += "================================\n"
			break
		}

		debugTrace(msg)

	}

	function debugTrace(msg) {
		let debug = document.getElementById("debug")
		debug.value += msg
	}
</script>
</head>
<body>
	<form method="get" action=""
		enctype="application/x-www-form-urlencoded">
		<!-- content의 타입 설정 (form을 쓰는 경우만 POST) -->
	</form>
	<textarea rows="10" cols="80" id="debug"></textarea>
	<br>
	<button onclick="sendProcess('GET', 'hong gil-dong')">영문인자호출</button>
	<button onclick="sendProcess('GET', '홍길동')">한글인자호출</button>
	<button onclick="sendProcess('POST', 'hong gil-dong')">POST영문인자호출</button>
	<button onclick="sendProcess('POST', '홍길동')">POST한글인자호출</button>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="httpRequest.js"></script>
<script src="/Lecture-Web/jquery/js/jquery-3.6.0.min.js"></script>
<script>
	function clickBtn() {
		sendProcess('GET', 'sample.jsp', null, callback)
	}

	function callback() {
		let msg = ''
		if (httpRequest.readystate == 4) {
			if (httpRequest.satus == 200) {
				
				// 개발자도구에서 확인해보기
				/* httpRequest.responseXML.getElementsByTagName('member')[0].getElementsByTagName("id") */
				
				
				let xmlDoc = httpRequest.responseXML
				let memberList = $(xmlDoc).find('member')
				msg += '회원수 : ' + memberList.length + '명\n'

				memberList.each(function){
					let id = $(this).find('id').text()
					let name = $(this).find('name').text()
					msg += id + "("+name+")\n"
				}

				debugTrace(msg)
				
			}
		}
	}

	function debugTrace(msg) {
		let debug = document.getElementById("debug")
		debug.value += msg
	}
</script>
</head>
<body>
	<h2>JSON DATA 예제</h2>

	<textarea rows="10" cols="80" id="debug"></textarea>
	<br>
	<button type="button" onclick="clickBtn()">서버에 자료요청</button>
</body>
</html>
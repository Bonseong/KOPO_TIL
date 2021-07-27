<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src = "httpRequest.js">
</script>
<script>
	function clickBtn(){
		/* httpRequest = getXMLHttpRequest()
		alert(httpRequest) */
		
		let name = document.inputForm.name.value
		let age = document.inputForm.age.value
		let addr = document.inputForm.addr.value
		
		// 비동기 통신
		// 1 단계
		/* sendProcess('GET', 'sample.jsp', "name=홍길동&age=24&addr=서울시 서초구", callback) */

		// method, url, 파라미터, 콜백함수(서버가 올바르게 작동했을 때 내 화면에 바뀌게 해주는 함수) 는 사용자마다 달라질 수 있음
		
		// 2단계
		/* let params = 'name=' + name + '&age=' + age + '&addr=' + addr
		sendProcess('GET', 'sample.jsp', params, callback) */
		
		// 3단계
		let params = {name : '김미미', age : 25, addr : '서울시 강남구'}
		sendProcess('GET', 'sample.jsp', params, callback)
		
	}
	
	function callback() {
		let msg = ''
		switch(httpRequest.readyState) {
		case 1 :
			msg += 'Loading...\n'
			break
		case 2 : 
			msg += 'Loaded...\n'
			break
		case 3 : 
			msg += 'Interactive...\n'
			break
		case 4 :
			msg += 'Completed...\n'
			if(httpRequest.status == 200) {
				msg += '웹서버에서 정상적으로 수행..\n'
				msg += '실행결과 : ' + httpRequest.responseText + '\n'
			} else {
				msg += '웹서버에서 오류발생...\n'
				msg += '오류코드 : ' + httpRequest.status + '\n'
			}
			msg += "===========================================================================\n"
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
	<h2>XMLHTTPRequest 모듈을 이용한 예제</h2>
	<form name = "inputForm">
	<textarea rows="10" cols="80" id="debug"></textarea><br>
	이름 : <input type="text" name="name"><br>
	나이 : <input type="text" name="age"><br>
	주소 : <input type="text" name="addr"><br>
	<button type="button" onclick="clickBtn()">서버에 자료 요청</button>
	</form>
</body>
</html>
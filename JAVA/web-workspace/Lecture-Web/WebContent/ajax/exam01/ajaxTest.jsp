<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#msgView {
	border: 1px solid red;
	height: 200px;
	width: 500px;
	margin-bottom: 20px;
}
</style>

<script>
	let httpRequest = null

	function requestMsg() {
		// 1단계 : XMLHttpRequest객체 생성
		if (window.XMLHttpRequest)
			httpRequest = new XMLHttpRequest()
		else if (window.ActiveXObject)
			// explore버전때문에 해주는거임. 최소한의 안전장치
			httpRequest = new ActiveXObject("Microsoft.XMLHTTP")
		else
			httpRequest = null

			// 2단계 : Callback함수 설정( 서버요청이 바뀔때마다 호출되는 함수 )
			/*
			   httpRequest.onreadystatechage = function(){
			   
			   }아래와 같은 뜻
			 */
		httpRequest.onreadystatechange = responseMsg

		// 3단계 : 서버에 비동기 요청
		httpRequest.open('GET', 'hello.jsp', true) // 비동기방식 true
		httpRequest.send(null)

	}

	function responseMsg() {
		if (httpRequest.readyState == 4) {
			// 모든 데이터 전송완료(응답완료 4) 했고 결과가 올바르다면(200) responseText한다.
			if (httpRequest.status == 200) {

				let msgView = document.getElementById("msgView");
				msgView.innerHTML = httpRequest.responseText // +=는 계속 추가됨

			}

		}

	}
</script>

</head>
<body>
	<h2>서버에서 받은 메시지</h2>
	<div id="msgView"></div>
	<input type="button" value="서버에서 자료 요청" onclick="requestMsg()">

</body>
</html>
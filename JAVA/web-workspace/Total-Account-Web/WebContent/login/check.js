function idcheck() {
	var param = "id=" + encodeURIComponent(document.add.id.value);
	sendRequest("./join/idc1.jsp", param, idResult, "post");

}
function idResult() {
	if (httpRequest.readyState == 4) { //데이터를 전부 받은 상태. 완전한 데이터 이용 가능
		if (httpRequest.status == 200) {  //요청 성공
			var result = document.getElementById("resid");
			result.innerHTML = httpRequest.responseText;
		}
	}
}
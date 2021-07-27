/**
 * Ajax통신과 관련된 함수의 집합
 */

let httpRequest = null

function getXMLHttpRequest() {
	let httpRequest = null;
	if (window.XMLHttpRequest)
		httpRequest = new XMLHttpRequest()
	else if (window.ActiveXObject)
		httpRequest = new ActiveXObject("Microsoft.XMLHTTP")

	return httpRequest
}

function sendProcess(method, url, params, callback) {
	httpRequest = getXMLHttpRequest()
	httpRequest.onreadystatechange = callback

	let httpMethod = method
	if (httpMethod != 'GET' && httpMethod != 'POST')
		httpMethod = 'GET'

	let httpParams = ''
	if (params != null && params != '') {

		if (typeof (params) == 'string') {
			//name=홍길동&age=24
			paramArr = params.split('&')
			for (let param of paramArr) {
				pdata = param.split('=')
				if (httpParams != '')
					httpParams += '&'
				httpParams += pdata[0] + '=' + encodeURIComponent(pdata[1])
			}
		} else {

			// {name:'홍길동', age: 24} ==> name=홍길동&age=24
			for (let key in params) {
				//console.log(key, params[key])
				if (httpParams != '')
					httpParams += '&'
				httpParams += key + '=' + encodeURIComponent(params[key])
			}
		}

	}

	let httpUrl = url
	if (httpMethod == 'GET' && httpParams != '')
		httpUrl = url + '?' + httpParams

	//	console.log(httpMethod, httpUrl, httpParams)				

	httpRequest.open(httpMethod, httpUrl, true)
	if (httpMethod == 'GET')
		httpRequest.send(null)
	else if (httpMethod == 'POST') {
		httpRequest.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
		httpRequest.send(httpParams)
	}
}



























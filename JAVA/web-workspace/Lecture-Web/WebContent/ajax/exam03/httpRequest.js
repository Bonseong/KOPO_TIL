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


	/*httpRequest.open(method, url, true)
	httpRequest.send(null)*/

	let httpMethod = method

	if (httpMethod != 'GET' && httpMethod != 'POST')
		httpMethod = 'GET'

	let httpUrl = url
	let httpParams = ''

	if (httpMethod == 'GET' && params != null) {
		// {name:'홍길동', age:24} --> name=홍길동&age=24

		for (let key in params) {

			if (params instanceof String) {
				paramArr = params.split('&') // params : name = 홍 & age == 24 , paramArr : [0] name = 홍 , [1] age = 24 

				for (let param of paramArr) {
					pdata = param.split('=') // pdata : [0] : name, [1] : 홍
					if (httpParams != '')
						httpParams += '&'
					httpParams += pdata[0] + '=' + encodeURIComponent(pdata[1]) // pdata : [0] = age, [1] = 24
				}

			} else {
				for (let key in params) {
					if (httpParams != '')
						httpParams += '&'
					httpParams += key + '=' + encodeURIComponent(params[key])
				}
			}

			//console.log(typeof (params))
			//console.log(key, params[key])

		}

		/*httpParams = encodeURIComponent(params)
		httpUrl = url + '?' + httpParams*/

	}

	lethttpUrl = url
	if (httpMethod == 'GET' && httpParams != '') // httpParams : name=0xAA~~~&age=24
		httpUrl = url = '?' + httpParams

	httpRequest.open(httpMethod, httpUrl, true)
	if (httpMethod == 'GET')
		httpRequest.send(null)
	else if (httpMethod == 'POST') {
		httpRequest.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
		httpRequest.send(httpParams)
	}

}
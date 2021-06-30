<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전송된 정보 출력</h2>
	
	<%
		InputStreamReader isr = new InputStreamReader(request.getInputStream(), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		while(true){
			String data = br.readLine();
			if(data == null) break;
			out.println(data + "<br>");
		} /* 텍스트는 잘 날라갈수 있어도, 다른 파일들은 제대로 불러오지 못함 */
	%>
	<!-- 서버와 클라이언트가 같은 언어로 작성되어있지 않을수도 있기 때문에,
	바이트스트림을 주로 사용 -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		http://localhost:9999/Lecture-Web/jsp/el/exam02.jsp?id=aaa&name=bbb&hobby=music&hobby=movie
		요청했을 때의 id, name 값을 추출
		
	 --%>
	 
	 <%
	 	String id = request.getParameter("id");
	 	String[] hobbies = request.getParameterValues("hobby"); // 항목어 잆으면 null -> error
	 	if(hobbies == null){
	 		hobbies = new String[]{"파라미터 없음"};
	 	}
	 %>
	 
	 id : <%=id %><br>
	 id : <%= request.getParameter("id") %><br>
	 el id : ${ param.id }<br> <!-- id가 가지고 있는 parameter 추출 -->
	 
	 <br>
	 name : <%= request.getParameter("name") %><br>
	 el name : ${ param.name }<br> <!-- 없으면 null 이 아닌 blank -->
	 <br>
	 hobby : <%=hobbies[0] %><br>
	 el hobby : ${ paramValues.hobby[0] }, ${ paramValues.hobby[1] } <br>
	 <!-- 없으면 empty, 길이 0-->
	 
</body>
</html>
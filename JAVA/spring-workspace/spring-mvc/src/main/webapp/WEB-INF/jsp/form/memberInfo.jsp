<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보</h2>
	<!-- @ModelAttribute("member") MemberVO member -> member, 공유영역에 올리지 않았다면 -> memberVO -->
	ID : ${ member.id }<br>
	PASSWORD : ${ member.password }<br>
	NAME : ${ member.name }
</body>
</html>
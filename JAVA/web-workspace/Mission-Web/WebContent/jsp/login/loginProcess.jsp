<%@page import="kr.ac.kopo.login.vo.LoginVO"%>
<%@page import="kr.ac.kopo.login.dao.LoginDAO"%>
<%@page import="kr.ac.kopo.member.vo.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 화면에 출력할 부분이 없음! -->

<!--
	작업순서
	1. login.jsp에서 날라오는 파라미터 추출(id, password)
	2. 추출된 ID, PASSWORD에 맞는 회원의 존재 여부 판단(DB, t_member)
	3. 로그인 성공시 세션에 회원정보를 등록
	4. 존재여부에 따른 페이지를 이동(로그인 성공 : index.jsp, 로그인 실패 : login.jsp)
	
-->


<%
request.setCharacterEncoding("utf-8");

// 파라미터 추출
String id = request.getParameter("id");
String password = request.getParameter("password");

// 객체생성 및 초기화
LoginVO loginVO = new LoginVO();

loginVO.setId(id);
loginVO.setPassword(password); 

// DB에서 로그인 수행
LoginDAO dao = new LoginDAO();
LoginVO userVO = dao.login(loginVO); // 로그인에 성공했을시, 유저에 대한 정보 저장

/*
	userVO null이면 로그인 실패
	userVO null아니면 로그인 성공
*/

/* =
Connection conn = new ConnectionFactory().getConnection();

StringBuilder sql = new StringBuilder();

sql.append(" SELECT NAME FROM T_MEMBER WHERE ID = ? AND PASSWORD = ? ");

PreparedStatement pstmt = conn.prepareStatement(sql.toString());

pstmt.setString(1, id);
pstmt.setString(2, password);

ResultSet rs = pstmt.executeQuery();

if (rs.next()) {
	MemberVO member = new MemberVO();
	member.setId(id);
	member.setPassword(password);

	session.setAttribute("member", member);	
	
	response.sendRedirect("/Mission-Web/index.jsp");
} else {
	response.sendRedirect("/Mission-Web/jsp/login/login.jsp");
}
JDBCClose.close(conn, pstmt);
======= DAO로 보내버림 ======
*/

String msg = null;
String url = null;

if (userVO == null) {
	msg = "아이디 또는 패스워드를 잘못 입력하셨습니다.";
	url = "/Mission-Web/jsp/login/login.jsp";
} else {
	msg = userVO.getName() + "님 환영합니다.";
	url = "/Mission-Web/index.jsp";
	// url = "/Mission-Web/index.jsp";
	// include, forward, xml은 최상위 디렉토리 이후부터가 경로
	// 외외는 localhost:9999/ 이후
	
	session.setAttribute("userVO", userVO);
}

pageContext.setAttribute("msg", msg);
pageContext.setAttribute("url", url);

/*
EL과 자바코드가 먼저 해석되기 때문에 우선 msg를 공유영역에 등록하고
다음 스크립트가 실행될 수 있도록 한다!
자바와 자바스크립트를 혼용하지 말기
*/
%>


<script>
	alert( '${msg}')
	location.href = "${url}"
</script>


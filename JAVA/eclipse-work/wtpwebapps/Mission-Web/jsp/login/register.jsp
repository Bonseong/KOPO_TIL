<%@page import="kr.ac.kopo.member.dao.MemberDAO"%>
<%@page import="kr.ac.kopo.member.vo.MemberVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.SQLIntegrityConstraintViolationException"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	String emailDetail = request.getParameter("emailDetail");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String post = request.getParameter("post");
	String addrBasic = request.getParameter("addrBasic");
	String addrDetail = request.getParameter("addrDetail");

	MemberVO member = new MemberVO();
	
	member.setId(id);
	member.setName(name);
	member.setPassword(pw);
	member.setEmail(email);
	member.setEmail_domain(emailDetail);
	member.setTel1(tel1);
	member.setTel2(tel2);
	member.setTel3(tel3);
	member.setPost(post);
	member.setBasic_addr(addrBasic);
	member.setDetail_addr(addrDetail);
	
	MemberDAO dao = new MemberDAO();
	
	dao.register(member);
	
	
	
	
	%>

<script>
	alert("회원가입이 완료되었습니다.")
	location.href = "/Mission-Web/index.jsp"
</script>


<%-- <%
	
	}catch(SQLIntegrityConstraintViolationException e){
		%><script>
		alert("중복된 아이디입니다.")
		location.href = "registerForm.jsp"
		</script>
<%
	}catch(SQLException e){
		%><script>
		alert('입력된 값이 올바르지 않습니다.')
		location.href = "registerForm.jsp"
		</script>
		<%
	}
	%>


 --%>
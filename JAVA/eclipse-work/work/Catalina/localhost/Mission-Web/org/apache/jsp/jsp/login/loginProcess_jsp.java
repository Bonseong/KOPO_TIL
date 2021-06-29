/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.46
 * Generated at: 2021-06-29 01:14:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.ac.kopo.login.vo.LoginVO;
import kr.ac.kopo.login.dao.LoginDAO;
import kr.ac.kopo.member.vo.MemberVO;
import java.sql.ResultSet;
import kr.ac.kopo.util.JDBCClose;
import java.sql.PreparedStatement;
import java.sql.Connection;
import kr.ac.kopo.util.ConnectionFactory;

public final class loginProcess_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("kr.ac.kopo.util.ConnectionFactory");
    _jspx_imports_classes.add("kr.ac.kopo.member.vo.MemberVO");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("kr.ac.kopo.login.vo.LoginVO");
    _jspx_imports_classes.add("kr.ac.kopo.login.dao.LoginDAO");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("kr.ac.kopo.util.JDBCClose");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 화면에 출력할 부분이 없음! -->\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("	작업순서\r\n");
      out.write("	1. login.jsp에서 날라오는 파라미터 추출(id, password)\r\n");
      out.write("	2. 추출된 ID, PASSWORD에 맞는 회원의 존재 여부 판단(DB, t_member)\r\n");
      out.write("	3. 로그인 성공시 세션에 회원정보를 등록\r\n");
      out.write("	4. 존재여부에 따른 페이지를 이동(로그인 성공 : index.jsp, 로그인 실패 : login.jsp)\r\n");
      out.write("	\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("	alert( '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("')\r\n");
      out.write("	location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

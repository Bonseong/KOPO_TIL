package kr.ac.kopo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class dbconn
 */
//db
@WebServlet("/dbconn")
public class dbconn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<EMP> empList = new ArrayList<EMP>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@//192.168.119.111:1521/oracle19";
			String id = "linux_scott";
			String pw = "1234";
			try {
				con = DriverManager.getConnection(url, id, pw);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		
		try {
			String sql = "select * from emp";

			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();

			String empno = "";
			String ename= "";
			String job= "";
			String mgr= "";
			String sal= "";
			String deptno= "";
			
			while (rs.next()) {
				
				EMP emp = new EMP();
				
				empno = Integer.toString(rs.getInt("EMPNO"));
				ename = rs.getString("ENAME");
				job = rs.getString("JOB");
				mgr = Integer.toString(rs.getInt("MGR"));
				sal = Integer.toString(rs.getInt("SAL"));
				deptno = Integer.toString(rs.getInt("DEPTNO"));
					
				emp.setDeptno(deptno);
				emp.setEname(ename);
				emp.setJob(job);
				emp.setMgr(mgr);
				emp.setSal(sal);
				emp.setDeptno(deptno);
				
				empList.add(emp);
				System.out.println(empList.toString());
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("data", empList);
        /*뿌리 경로가 webapp이므로 webapp을 기준으로 경로를 작성을 한다.*/
		request.getRequestDispatcher("/empList.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
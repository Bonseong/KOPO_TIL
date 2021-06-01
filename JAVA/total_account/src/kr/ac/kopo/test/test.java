package kr.ac.kopo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.User_InfoVO;

public class test {
	public static void main(String[] args) {

		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT ACC_NO, ACC_PW FROM ACCOUNT ");
			sql.append(" WHERE ACC_NO = ? AND ACC_PW = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, "111-222-333");
			pstmt.setString(2, "1234");

			ResultSet rs = pstmt.executeQuery();
			
			
			System.out.println(rs.next());
			
	} catch(Exception e) {
		System.out.println("예외");
		e.printStackTrace();
	}
	}
	
}

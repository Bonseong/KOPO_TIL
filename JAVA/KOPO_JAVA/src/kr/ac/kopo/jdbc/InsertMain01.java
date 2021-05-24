package kr.ac.kopo.jdbc;

/*
 	JDBC 작업 순서
 	1. 드라이버 로딩
 	2. DB 접속 후 연결객체 얻기
 	3. SQL문 실행할 객체 얻기
 	4. SQL문 실행
 	5. DB접속 해제
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMain01 {
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null; // finally 구문에서 사용하기 위해

		try {
			// 1단계 : 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공...");

			// 2단계 : DB 연결 후 Connection 객체 얻기
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";

			conn = DriverManager.getConnection(url, user, password);

			System.out.println("conn : " + conn);

			// 3단계 : SQL 실행객체 얻기
			stmt = conn.createStatement(); // statement 객체 리턴
			String sql = "INSERT INTO T_TEST(ID, NAME) "; // 쿼리를 만들때는 습관적으로 공백
			sql += " VALUES('hong', '홍길동') "; // 쿼리에는 세미콜론을 붙이지 않음

			// 4단계 : SQL문 실행 및 결과 얻기
			int cnt = stmt.executeUpdate(sql);
			System.out.println("총 " + cnt + "개 행 삽입");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5단계 : DB접속 해제
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					stmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

		}
	}
}

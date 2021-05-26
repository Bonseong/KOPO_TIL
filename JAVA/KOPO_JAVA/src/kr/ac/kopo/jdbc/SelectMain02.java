package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class SelectMain02 {
	public static void main(String[] args) {
		Connection conn = null; // Connection과 Statement는 모두 AutoCloseable를 상속받고 있기 때문에 JDK 1.7의 try를 사용할 수 있음
		PreparedStatement pstmt = null;

		try {
			// 1, 2단게
//			ConnectionFactory factory = new ConnectionFactory();
//			conn = factory.getConnection();

			conn = new ConnectionFactory().getConnection(); // 1회용 사용, ConnectionFactory의 인스턴스 주소를 알고있는 객체가 없음

			// 3단계
			String sql = "SELECT * FROM T_TEST ";
			pstmt = conn.prepareStatement(sql);

			// 4단계
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { // 리턴타입 : boolean, rs.next가 false일때까지
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println("id : " + id + ", name : " + name);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5단계
			JDBCClose.close(conn, pstmt);

		}
	}
}

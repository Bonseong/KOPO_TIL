package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;

class Test implements AutoCloseable {

	@Override
	public void close() throws Exception {
	}
}

public class SelectMain03 {
	public static void main(String[] args) {
		String sql = "SELECT * FROM T_TEST"; // string 클래스는 AutoCloseable를 상속받지 않았기 때문에 try문 밖으로 빠져나가야함

		// 1.7버전의 try (finally에서 자원해제가 필요없고, AutoCloseable를 사용함)
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println("id : " + id + ", name : " + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


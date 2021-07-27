package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCClose {
	public static void close(Connection conn, Statement pstmt) { // PreparedStatement는 Statement를 상속받고 있기 때문
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				pstmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
}

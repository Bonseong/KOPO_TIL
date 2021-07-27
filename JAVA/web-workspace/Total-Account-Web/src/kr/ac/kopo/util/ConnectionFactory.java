package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;

// DB 접속 후 연결객체를 알려주는 역할
public class ConnectionFactory {
	public Connection getConnection() {
		Connection conn = null;
		try {
			// 1단계
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2단계
			String url = "jdbc:oracle:thin:@192.168.217.202:1521/KOPODA";
			String user = "DA2103";
			String password = "da03";

			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

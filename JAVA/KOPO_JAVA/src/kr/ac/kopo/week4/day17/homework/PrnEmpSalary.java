package kr.ac.kopo.week4.day17.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PrnEmpSalary {
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.217.57:1522:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);

			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT J.JOB_TITLE, ROUND(AVG(E.SALARY),-2) AS AVG_SAL FROM EMPLOYEES E, JOBS J ");
			sql.append(" WHERE J.JOB_ID = E.JOB_ID AND E.SALARY >= ? ");
			sql.append(" GROUP BY J.JOB_TITLE ORDER BY AVG_SAL DESC ");

			pstmt = conn.prepareStatement(sql.toString());

			System.out.print("급여를 입력하시오 : ");
			int inputSal = sc.nextInt();
			pstmt.setInt(1, inputSal);

			ResultSet rs = pstmt.executeQuery();

			int cnt = 0;

			while (rs.next()) {

				String job_title = rs.getString("job_title");
				int avg_sal = rs.getInt("avg_sal");

				System.out.println("[" + job_title + "] " + avg_sal);
				cnt++;
			}
			System.out.println("총 [" + cnt + "]명이 검색되었습니다.");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
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
}

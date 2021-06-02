package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.BankVO;

public class BankDAODB {
	public BankDAODB() {
	}

	public boolean checkLastDay(String session) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT MIN(TRUNC(SYSDATE - ACC_CREATING_DATE)) AS LAST_DAY FROM ACCOUNT ");
			sql.append(" WHERE USER_NO = (SELECT USER_NO FROM USER_INFO WHERE ID = ? ) ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, session);

			ResultSet rs = pstmt.executeQuery();

			int last_day=0;
			while(rs.next()) {
				last_day = rs.getInt("LAST_DAY");
			}
			
			if (last_day>30) {
				return true; // 30일 초과
			}else {
				return false; // 30일 이하
			}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return false;
		
		
		
	}
	
	
	public String enrollAccount(BankVO newBank, String session, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			// checkDuplicated 가 true 면 다시 해야함
		
			String newAcc = makeRandomAccNo(newBank);
			while(checkDuplicated(newAcc)) {
				 newAcc = makeRandomAccNo(newBank);
			}
			
			System.out.println(newAcc);
			System.out.println(newBank.getBankName());
			System.out.println(session);
			System.out.println(pw);
			
			
			sql.append(" INSERT INTO ACCOUNT VALUES ( ");
			sql.append(" ACC_NO.NEXTVAL, ");
			sql.append(" (SELECT BANK_CODE FROM BANK WHERE BANK_NAME = ?) , ");
			sql.append(" (SELECT USER_NO FROM USER_INFO WHERE ID = ? ) , ");
			sql.append(" ( ? ), ");
			sql.append(" 0 , ");
			sql.append(" ? , ");
			sql.append(" null, ");
			sql.append(" SYSDATE)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newBank.getBankName());
			pstmt.setString(2, session);
			pstmt.setString(3, newAcc);
			pstmt.setString(4, pw);

			pstmt.executeUpdate();

			return newAcc;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return null;

	}

	public String makeRandomAccNo(BankVO newBank) {
		Random random = new Random();
		StringBuilder sql = new StringBuilder();

		String bankname = newBank.getBankName();
		if (bankname.equals("HANA")) {
			sql.append("111");
		}
		if (bankname.equals("SHINHAN")) {
			sql.append("222");
		}
		if (bankname.equals("KB")) {
			sql.append("333");
		}
		if (bankname.equals("WOORI")) {
			sql.append("444");
		}

		sql.append('-');

		for (int i = 0; i < 3; i++) {
			sql.append(random.nextInt(9));
		}
		sql.append('-');

		for (int i = 0; i < 3; i++) {
			sql.append(random.nextInt(9));
		}
		return (sql.toString());
	}

	public boolean checkDuplicated(String acc) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT ACC_NO FROM ACCOUNT WHERE ACC_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, acc);

			ResultSet rs = pstmt.executeQuery();

			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return false;
	}
}

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
	public String enrollAccount(BankVO newBank, String session, String pw) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			conn.setAutoCommit(false);
			
			// checkDuplicated 가 true 면 다시 해야함

			String newAcc = makeRandomAccNo(newBank);
			while (checkDuplicated(newAcc)) {
				newAcc = makeRandomAccNo(newBank);
			}



			sql.append(" INSERT INTO ACCOUNT VALUES ( ");
			sql.append(" ACC_NO.NEXTVAL, ");
			sql.append(" (SELECT BANK_CODE FROM BANK WHERE BANK_NAME = ?) , ");
			sql.append(" (SELECT USER_NO FROM USER_INFO WHERE ID = ? ) , ");
			sql.append(" ( ? ), ");
			sql.append(" 1000 , ");
			sql.append(" ? , ");
			sql.append(" null, ");
			sql.append(" SYSDATE, 'ACTIVE')");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newBank.getBankName());
			pstmt.setString(2, session);
			pstmt.setString(3, newAcc);
			pstmt.setString(4, pw);

			pstmt.executeUpdate();

			conn.commit();
			return newAcc;

		} catch (Exception e) {
			conn.rollback();
			System.out.println("알수없는 오류입니다. (계좌 생성 관련)");
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return null;

	}
	public boolean checkLastDay(String session) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			
			sql.append(" SELECT NVL(MIN(TRUNC(SYSDATE - ACC_CREATING_DATE)),0) AS LAST_DAY FROM ACCOUNT ");
			sql.append(" WHERE USER_NO = (SELECT USER_NO FROM USER_INFO WHERE ID = ? ) ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, session);

			ResultSet rs = pstmt.executeQuery();

			int last_day = 0;
			while (rs.next()) {
				last_day = rs.getInt("LAST_DAY");
			}
			
			

			if (last_day > 30) {
				return true; // 30일 초과
			} else {
				return false; // 30일 이하
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return false;

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
	
	public void searchByBank(BankVO newBank, String session) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT B.BANK_NAME, A.ACC_NO, A.BALANCE FROM ACCOUNT A, BANK B ");
			sql.append(" WHERE A.BANK_CODE = B.BANK_CODE AND ACC_ISACTIVE = 'ACTIVE' ");
			sql.append(" AND A.USER_NO = (SELECT USER_NO FROM USER_INFO WHERE ID = ? ) ");
			sql.append(" AND BANK_NAME = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, session);
			pstmt.setString(2, newBank.getBankName());

			ResultSet rs = pstmt.executeQuery();

			if (rs.isBeforeFirst()) {
				System.out.println("은행명\t계좌번호\t잔액");
			} else {
				System.out.println("계좌가 존재하지 않습니다.");
				System.out.println("다시 확인해주세요.");
			}

			while (rs.next()) {
				System.out.println(
						rs.getString("BANK_NAME") + "\t" + rs.getString("ACC_NO") + "\t" + rs.getString("BALANCE"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
	
	
}

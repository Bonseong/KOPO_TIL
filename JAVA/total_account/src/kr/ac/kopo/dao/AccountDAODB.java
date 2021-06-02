package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.AccountVO;

public class AccountDAODB {

	public AccountDAODB() {
	}

	public boolean checkAccount(AccountVO newAcc, String session) throws Exception { // 계좌 조회
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT ACC_NO FROM ACCOUNT ");
			sql.append(" WHERE (SELECT USER_NO FROM USER_INFO WHERE ID= ? ) = USER_NO ");
			sql.append(" AND ACC_NO = ? AND ACC_PW = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, session);
			pstmt.setString(2, newAcc.getAccNo());
			pstmt.setString(3, newAcc.getAccPw());

			ResultSet rs = pstmt.executeQuery();

			return rs.next(); // 계좌 존재

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return false; // 알수없는 에러

	}

	public boolean checkAccount(String acc) throws Exception { // 계좌 조회
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT ACC_NO FROM ACCOUNT ");
			sql.append(" WHERE ACC_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, acc);

			ResultSet rs = pstmt.executeQuery();

			return rs.next(); // 계좌 존재

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return false; // 알수없는 에러

	}

	public int deposit(String newAcc, int depositAmount) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" UPDATE ACCOUNT SET BALANCE = BALANCE + ? WHERE ACC_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, depositAmount);
			pstmt.setString(2, newAcc);

			int chk = pstmt.executeUpdate();
			

			return chk;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return 0;
	}

	public int checkBalance(AccountVO newAcc) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT BALANCE FROM ACCOUNT WHERE ACC_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newAcc.getAccNo());

			ResultSet rs = pstmt.executeQuery();

			int balance = 0;

			while (rs.next()) {
				balance = rs.getInt("BALANCE");
			}

			return balance;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return 0;
	}

	public int withdraw(String newAcc, int withdrawAmount) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE ACC_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, withdrawAmount);
			pstmt.setString(2, newAcc);

			int chk = pstmt.executeUpdate();

			return chk;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return 0;
	}

	public int transfer(String newAcc, String acc, int transferAmount) {
		deposit(acc, transferAmount);
		withdraw(newAcc, transferAmount);

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" INSERT INTO TRANSFER_LOG VALUES (LOG_NO.NEXTVAL, SYSDATE, ");
			sql.append(" (SELECT ACC_ID FROM ACCOUNT WHERE ACC_NO = ?), ");
			sql.append(" (SELECT ACC_ID FROM ACCOUNT WHERE ACC_NO = ?), ");
			sql.append(" ?) ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newAcc);
			pstmt.setString(2, acc);
			pstmt.setInt(3, transferAmount);

			int chk = pstmt.executeUpdate();

			return chk;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return 0;

	}

}

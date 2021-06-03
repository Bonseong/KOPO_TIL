package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.User_InfoVO;

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
			sql.append(" AND ACC_NO = ? AND ACC_PW = ? AND ACC_ISACTIVE = 'ACTIVE'");

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
		return false;

	}

	public boolean checkAccount(String acc) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT ACC_NO FROM ACCOUNT ");
			sql.append(" WHERE ACC_NO = ? AND ACC_ISACTIVE = 'ACTIVE'");

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

	public int deposit(String newAcc, int depositAmount) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();

			sql.append(" UPDATE ACCOUNT SET BALANCE = BALANCE + ? WHERE ACC_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, depositAmount);
			pstmt.setString(2, newAcc);

			int chk = pstmt.executeUpdate();

			if (chk == 1) {
				conn.commit();
			}

			return chk;

		} catch (Exception e) {
			conn.rollback();
			System.out.println("알수없는 오류입니다. (입금관련)");
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return 0;
	}

	public int checkBalance(AccountVO newAcc) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT BALANCE FROM ACCOUNT WHERE ACC_NO = ? AND ACC_ISACTIVE = 'ACTIVE' ");

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

	public int withdraw(String newAcc, int withdrawAmount) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();

			sql.append(" UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE ACC_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, withdrawAmount);
			pstmt.setString(2, newAcc);

			int chk = pstmt.executeUpdate();

			if (chk == 1) {
				conn.commit();
			}

			return chk;

		} catch (Exception e) {
			conn.rollback();
			System.out.println("알수없는 오류입니다. (출금관련)");
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return 0;
	}

	public int transfer(String newAcc, String acc, int transferAmount) throws Exception {
		deposit(acc, transferAmount);
		withdraw(newAcc, transferAmount);

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);
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
			conn.commit();
			
			return chk;

		} catch (Exception e) {
			conn.rollback();
			System.out.println("알수없는 오류입니다. (이체관련)");
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return 0;

	}

	public void searchTransferLog(AccountVO newAcc, String session) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(
					" SELECT TO_CHAR(T.LOG_DATE, 'yyyy-mm-dd HH24:MI:SS') AS LOG_DATE, U.USER_NAME AS SENDING_USER_NAME, A.ACC_NO AS SENDING_ACC_NO, U2.USER_NAME AS RECEIVING_USER_NAME, A2.ACC_NO AS RECEIVING_ACC_NO, T.REMITTANCE FROM ACCOUNT A, ACCOUNT A2, TRANSFER_LOG T, USER_INFO U, USER_INFO U2 ");
			sql.append(" WHERE A.ACC_ID = T.SENDING_ACC_ID AND A2.ACC_ID = T.RECEIVING_ACC_ID ");
			sql.append(" AND A.USER_NO = U.USER_NO AND A2.USER_NO = U2.USER_NO ");
			sql.append(" AND (A. ACC_NO = ? or A2.ACC_NO = ?) ");
			sql.append(" ORDER BY LOG_DATE ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newAcc.getAccNo());
			pstmt.setString(2, newAcc.getAccNo());

			ResultSet rs = pstmt.executeQuery();

			System.out.println("거래일자\t\t보내는사람\t보내는계좌\t받는사람\t받는계좌\t송금액");
			while (rs.next()) {

				System.out.println(rs.getString("LOG_DATE") + "\t" + rs.getString("SENDING_USER_NAME") + "\t\t"
						+ rs.getString("SENDING_ACC_NO") + "\t" + rs.getString("RECEIVING_USER_NAME") + "\t\t"
						+ rs.getString("RECEIVING_ACC_NO") + "\t" + rs.getString("REMITTANCE"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

	}

	public boolean searchOne(User_InfoVO newUser, AccountVO newAcc) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT B.BANK_NAME, U.USER_NAME, A.ACC_NO, A.BALANCE, A.ACC_NICKNAME, TO_CHAR(A.ACC_CREATING_DATE, 'yyyy-mm-dd') AS ACC_CREATING_DATE ");
			sql.append(" FROM ACCOUNT A, BANK B, USER_INFO U ");
			sql.append(" WHERE A.ACC_ISACTIVE = 'ACTIVE' AND A.BANK_CODE = B.BANK_CODE AND A.USER_NO = U.USER_NO ");
			sql.append(" AND U.ID = ? AND A.ACC_PW = ? AND A.ACC_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newUser.getId());
			pstmt.setString(2, newAcc.getAccPw());
			pstmt.setString(3, newAcc.getAccNo());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("은행명 : " + rs.getString("BANK_NAME") + "\n고객명 : " + rs.getString("USER_NAME")
						+ "\n계좌번호 : " + rs.getString("ACC_NO") + "\n잔액 : " + rs.getInt("BALANCE") + "\n계좌별칭 : "
						+ rs.getString("ACC_NICKNAME") + "\n계좌생성일자 : " + rs.getString("ACC_CREATING_DATE"));
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return false;

	}

	public void searchAll(User_InfoVO newUser) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT B.BANK_NAME, A.ACC_NO, A.BALANCE FROM ACCOUNT A, BANK B ");
			sql.append(" WHERE B.BANK_CODE = A.BANK_CODE AND ");
			sql.append(" USER_NO = (SELECT USER_NO FROM USER_INFO ");
			sql.append(" WHERE ID = ?) AND A.ACC_ISACTIVE = 'ACTIVE' ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newUser.getId());

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

	public void updatePassword(AccountVO newAcc) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();

			sql.append(" UPDATE ACCOUNT SET ACC_PW = ? WHERE ACC_NO = ? AND ACC_ISACTIVE = 'ACTIVE' ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newAcc.getAccPw());
			pstmt.setString(2, newAcc.getAccNo());

			int chk = pstmt.executeUpdate();

			if (chk == 1) {
				System.out.println("비밀번호가 변경되었습니다.");

			} else {
				System.out.println("변경에 실패했습니다.");
			}
			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			System.out.println("계좌 수정에 실패했습니다.");
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

	}

	public void updateNickname(AccountVO newAcc) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" UPDATE ACCOUNT SET ACC_NICKNAME = ? WHERE ACC_NO= ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newAcc.getAccNickname());
			pstmt.setString(2, newAcc.getAccNo());

			int chk = pstmt.executeUpdate();

			if (chk == 1) {
				System.out.println("별칭이 변경되었습니다.");

			} else {
				System.out.println("변경에 실패했습니다.");
			}

			conn.commit();

		} catch (Exception e) {
			System.out.println("계좌 수정에 실패했습니다.");
			conn.rollback();
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

	}

	public void deleteAccount(AccountVO newAcc) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();

			sql.append(" UPDATE ACCOUNT SET ACC_ISACTIVE = 'INACTIVE' WHERE ACC_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newAcc.getAccNo());

			int chk = pstmt.executeUpdate();

			if (chk == 1) {

				conn.commit();
			} else {
				System.out.println("변경에 실패했습니다.");
			}

		} catch (Exception e) {
			conn.rollback();
			System.out.println("계좌 삭제에 실패했습니다.");
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

	}

}

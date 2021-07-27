package kr.ac.kopo.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class AccountDAO {

	public String openAccount(AccountVO vo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			conn.setAutoCommit(false);

			// checkDuplicated 가 true 면 다시 해야함

			sql.append(" INSERT INTO T_ACCOUNT(ACC_NO, BANK_CODE, ID, BALANCE, ACC_PW, ACC_NICKNAME)");
			sql.append(" VALUES (?, ?, ?, ?, ?, ?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, vo.getAcc_no());
			pstmt.setString(2, vo.getBank_code());
			pstmt.setString(3, vo.getId());
			pstmt.setInt(4, vo.getBalance());
			pstmt.setString(5, vo.getPassword());
			pstmt.setString(6, vo.getNickname());

			conn.commit();

			return null;

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return null;

	}

	public boolean checkDuplicated(String acc) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT ACC_NO FROM T_ACCOUNT WHERE ACC_NO = ? ");

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

	public AccountVO selectOneAccount(AccountVO accVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		AccountVO acc = new AccountVO();
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(
					" SELECT A.ACC_NO, B.BANK_NAME, A.ID, A.BALANCE, A.ACC_NICKNAME, A.ACC_CREATING_DATE FROM T_ACCOUNT A, BANK_INFO B ");
			sql.append(" WHERE A.BANK_CODE = B.BANK_CODE AND A.ACC_NO= ? AND A.ID= ? AND A.ACC_PW= ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, accVO.getAcc_no());
			pstmt.setString(2, accVO.getId());
			pstmt.setString(3, accVO.getPassword());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				acc.setAcc_no(rs.getString("ACC_NO"));
				acc.setBank_name(rs.getString("BANK_NAME"));
				acc.setId(rs.getString("ID"));
				acc.setBalance(rs.getInt("BALANCE"));
				acc.setNickname(rs.getString("ACC_NICKNAME"));
				acc.setCreatingDate(rs.getString("ACC_CREATING_DATE"));
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return acc;
	}

	
	
	public List<AccountVO> selectAllAccount(String id) {
		List<AccountVO> list = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ACC_NO, BALANCE FROM T_ACCOUNT WHERE ID = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String accNo = rs.getString("ACC_NO");
				int balance = rs.getInt("BALANCE");

				AccountVO acc = new AccountVO();

				acc.setAcc_no(accNo);
				acc.setBalance(balance);

				list.add(acc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	/*
	 * public Map<String, Integer> selectAllAccountBalance(String id) {
	 * 
	 * Map<String, Integer> map = new HashMap<>();
	 * 
	 * StringBuilder sql = new StringBuilder();
	 * sql.append(" SELECT ACC_NO, BALANCE FROM T_ACCOUNT WHERE ID = ? ");
	 * 
	 * try (Connection conn = new ConnectionFactory().getConnection();
	 * PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	 * 
	 * ) { pstmt.setString(1, id); ResultSet rs = pstmt.executeQuery();
	 * 
	 * while (rs.next()) { String accNo = rs.getString("ACC_NO"); int balance =
	 * rs.getInt("BALANCE");
	 * 
	 * map.put(accNo, balance); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return map;
	 * 
	 * }
	 */

	public boolean checkPassword(AccountVO accVO) {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ACC_NO FROM T_ACCOUNT WHERE ACC_NO= ? AND ID= ? AND ACC_PW = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setString(1, accVO.getAcc_no());
			pstmt.setString(2, accVO.getId());
			pstmt.setString(3, accVO.getPassword());

			ResultSet rs = pstmt.executeQuery();

			boolean result = rs.next();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int checkBalance(AccountVO accVO) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT BALANCE FROM T_ACCOUNT WHERE ACC_NO= ? AND ID= ? AND ACC_PW = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setString(1, accVO.getAcc_no());
			pstmt.setString(2, accVO.getId());
			pstmt.setString(3, accVO.getPassword());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int balance = rs.getInt("BALANCE");
				return balance;
			} else {
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void modifyAccountPassword(AccountVO accVO) {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE T_ACCOUNT SET ACC_PW = ? WHERE ACC_NO= ? AND ID= ? ");

		;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			pstmt.setString(1, accVO.getPassword());
			pstmt.setString(2, accVO.getAcc_no());
			pstmt.setString(3, accVO.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modifyAccountNickname(AccountVO accVO) {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE T_ACCOUNT SET ACC_NICKNAME = ? WHERE ACC_NO= ? AND ID= ? ");

		;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			pstmt.setString(1, accVO.getNickname());
			pstmt.setString(2, accVO.getAcc_no());
			pstmt.setString(3, accVO.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAccount(AccountVO accVO) {

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE T_ACCOUNT WHERE ACC_NO = ? AND ID = ? AND ACC_PW = ? ");

		;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			pstmt.setString(1, accVO.getAcc_no());
			pstmt.setString(2, accVO.getId());
			pstmt.setString(3, accVO.getPassword());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

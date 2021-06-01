package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.service.TotalAccountSequence;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.User_InfoVO;

public class User_InfoDAODB {

	public User_InfoDAODB() {

	}

	public void login(User_InfoVO newUser) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT ID, PW FROM USER_INFO ");
			sql.append(" WHERE ID = ? AND PW = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newUser.getId());
			pstmt.setString(2, newUser.getPw());

			ResultSet rs = pstmt.executeQuery();

			if (!rs.next()) {
				newUser.setId(null);
				newUser.setPw(null);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

	public boolean idCheck(User_InfoVO newUser) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT ID FROM USER_INFO ");
			sql.append(" WHERE ID = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, newUser.getId());

			ResultSet rs = pstmt.executeQuery();

			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return true;

	}

	public void register(User_InfoVO newUser) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO USER_INFO VALUES(USER_NO.NEXTVAL, ?, ?, ?, ?) ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newUser.getId());
			pstmt.setString(2, newUser.getPw());
			pstmt.setString(3, newUser.getUserName());
			pstmt.setString(4, newUser.getMobileNo());

			int cnt = pstmt.executeUpdate();

			if (cnt == 1) {
				System.out.println("회원가입이 완료되었습니다.");
			} else {
				System.out.println("회원가입에 실패했습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

}

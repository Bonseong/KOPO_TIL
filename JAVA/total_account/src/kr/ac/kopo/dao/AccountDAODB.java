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

	public boolean AccountCheck(AccountVO newAcc) throws Exception { // 계좌 조회
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT ACC_NO, ACC_PW FROM ACCOUNT ");
			sql.append(" WHERE ACC_NO = ? AND ACC_PW = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newAcc.getAccNo());
			pstmt.setString(2, newAcc.getAccPw());


			
			ResultSet rs = pstmt.executeQuery();
			
			
			
			return rs.next(); // 계좌 존재

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return false; // 알수없는 에러

	}

}

package kr.ac.kopo.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.transfer.TransferVO;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class BankDAO {
	public List<BankVO> selectAllBank() {
		List<BankVO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT BANK_CODE, BANK_NAME FROM BANK_INFO ");

			pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int bankCode = rs.getInt("BANK_CODE");
				String bankName = rs.getString("BANK_NAME");

				BankVO bank = new BankVO();

				bank.setBank_code(bankCode);
				bank.setBank_name(bankName);

				list.add(bank);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return list;
	}
	
	
}

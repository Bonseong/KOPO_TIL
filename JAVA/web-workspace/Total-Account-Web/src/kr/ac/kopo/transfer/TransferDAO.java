package kr.ac.kopo.transfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.bank.BankVO;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class TransferDAO {
	public boolean transferSameBank(TransferVO trVO) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" BEGIN ");
			sql.append(" UPDATE T_ACCOUNT SET BALANCE = BALANCE - ? WHERE ACC_NO = ?; "); // 보내는 계좌
			sql.append(" UPDATE T_ACCOUNT SET BALANCE = BALANCE + ? WHERE ACC_NO = ?; "); // 받는 계좌
			sql.append(
					" INSERT INTO TRANSFER_LOG(SENDING_BANK_NAME, SENDING_ACC_NO, BEFORE_BALANCE, REMITTANCE, AFTER_BALANCE, RECEIVING_BANK_NAME, RECEIVING_ACC_NO) ");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?); ");
			sql.append(" COMMIT; ");
			sql.append(" EXCEPTION ");
			sql.append(" WHEN OTHERS THEN ");
			sql.append(" ROLLBACK; ");
			sql.append(" END; ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, trVO.getRemittance());
			pstmt.setString(2, trVO.getSendingAccNO());
			pstmt.setInt(3, trVO.getRemittance());
			pstmt.setString(4, trVO.getReceivingAccNO());

			pstmt.setString(5, trVO.getSendingBankName());
			pstmt.setString(6, trVO.getSendingAccNO());
			pstmt.setInt(7, trVO.getBeforeBalance());
			pstmt.setInt(8, trVO.getRemittance());
			pstmt.setInt(9, trVO.getAfterBalance());
			pstmt.setString(10, trVO.getReceivingBankName());
			pstmt.setString(11, trVO.getReceivingAccNO());

			pstmt.executeQuery();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCClose.close(conn, pstmt);
		}

	}

	public TransferVO checkAccountOtherBank(BankVO bkVO, TransferVO trVO) {
		TransferVO ReceivingVO = new TransferVO();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT BANK_CODE, BALANCE, ACC_NO FROM T_ACCOUNT@");
		sql.append(bkVO.getBank_name_eng());
		sql.append(" WHERE ACC_NO = ? ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setString(1, trVO.getReceivingAccNO());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ReceivingVO.setBeforeBalance(rs.getInt("BALANCE"));
				ReceivingVO.setReceivingAccNO(rs.getString("ACC_NO"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ReceivingVO;

	}

	public void transferOtherBank(BankVO receivingBank, TransferVO receivingVO, TransferVO sendingVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" BEGIN ");
			sql.append(" UPDATE T_ACCOUNT SET BALANCE = BALANCE - ? WHERE ACC_NO = ?; "); // 보내는 계좌
			sql.append(" UPDATE T_ACCOUNT@");
			sql.append(receivingBank.getBank_name_eng());
			sql.append(" SET BALANCE = BALANCE + ? WHERE ACC_NO = ?; "); // 받는 계좌
			sql.append(
					" INSERT INTO TRANSFER_LOG(SENDING_BANK_NAME, SENDING_ACC_NO, BEFORE_BALANCE, REMITTANCE, AFTER_BALANCE, RECEIVING_BANK_NAME, RECEIVING_ACC_NO) ");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?); ");

			sql.append(" INSERT INTO TRANSFER_LOG@");
			sql.append(receivingBank.getBank_name_eng());
			sql.append(
					" (SENDING_BANK_NAME, SENDING_ACC_NO, BEFORE_BALANCE, REMITTANCE, AFTER_BALANCE, RECEIVING_BANK_NAME, RECEIVING_ACC_NO) ");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?); ");

			sql.append(" COMMIT; ");
			sql.append(" EXCEPTION ");
			sql.append(" WHEN OTHERS THEN ");
			sql.append(" ROLLBACK; ");
			sql.append(" END; ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, sendingVO.getRemittance());
			pstmt.setString(2, sendingVO.getSendingAccNO());

			pstmt.setInt(3, sendingVO.getRemittance());
			pstmt.setString(4, sendingVO.getReceivingAccNO());

			pstmt.setString(5, sendingVO.getSendingBankName());
			pstmt.setString(6, sendingVO.getSendingAccNO());
			pstmt.setInt(7, sendingVO.getBeforeBalance());
			pstmt.setInt(8, sendingVO.getRemittance());
			pstmt.setInt(9, sendingVO.getAfterBalance());
			pstmt.setString(10, sendingVO.getReceivingBankName());
			pstmt.setString(11, sendingVO.getReceivingAccNO());

			pstmt.setString(12, sendingVO.getSendingBankName());
			pstmt.setString(13, sendingVO.getReceivingAccNO());
			pstmt.setInt(14, receivingVO.getBeforeBalance());

			pstmt.setInt(15, receivingVO.getRemittance());
			pstmt.setInt(16, receivingVO.getAfterBalance());
			pstmt.setString(17, sendingVO.getReceivingBankName());
			pstmt.setString(18, sendingVO.getReceivingAccNO());

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

	}

	public BankVO getBankInfo(TransferVO trVO) {

		BankVO bank = new BankVO();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT BANK_CODE, BANK_NAME, BANK_NAME_ENG FROM BANK_INFO WHERE BANK_NAME = ? ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setString(1, trVO.getReceivingBankName());

			ResultSet rs = pstmt.executeQuery();

			rs.next();
			bank.setBank_code(rs.getInt("BANK_CODE"));
			bank.setBank_name(rs.getString("BANK_NAME"));
			bank.setBank_name_eng(rs.getString("BANK_NAME_ENG"));

		} catch (Exception e) {
			e.printStackTrace();

		}
		return bank;

	}

	public List<TransferVO> selectTransferLog(TransferVO trVO) {

		List<TransferVO> logList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(
				" SELECT TO_CHAR(LOG_DATE, 'yyyy-mm-dd HH24:MI:SS') AS LOG_DATE, SENDING_BANK_NAME, SENDING_ACC_NO, BEFORE_BALANCE, REMITTANCE, AFTER_BALANCE , RECEIVING_BANK_NAME, RECEIVING_ACC_NO FROM TRANSFER_LOG ");
		sql.append(" WHERE SENDING_ACC_NO = ? OR RECEIVING_ACC_NO = ? ORDER BY LOG_NO DESC ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			pstmt.setString(1, trVO.getSendingAccNO());
			pstmt.setString(2, trVO.getReceivingAccNO());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				TransferVO log = new TransferVO();

				log.setLogDate(rs.getString("LOG_DATE"));
				log.setSendingBankName(rs.getString("SENDING_BANK_NAME"));
				log.setSendingAccNO(rs.getString("SENDING_ACC_NO"));
				log.setBeforeBalance(rs.getInt("BEFORE_BALANCE"));
				log.setRemittance(rs.getInt("REMITTANCE"));
				log.setAfterBalance(rs.getInt("AFTER_BALANCE"));
				log.setReceivingBankName(rs.getString("RECEIVING_BANK_NAME"));
				log.setReceivingAccNO(rs.getString("RECEIVING_ACC_NO"));

				logList.add(log);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return logList;

	}
}

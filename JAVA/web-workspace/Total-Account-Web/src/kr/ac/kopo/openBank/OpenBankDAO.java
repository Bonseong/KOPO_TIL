package kr.ac.kopo.openBank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;

public class OpenBankDAO {
	public List<OpenBankVO> selectAllMyAcc(OpenBankVO vo) { // id pw가 input으로 들어가도 됨

		List<OpenBankVO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM ( SELECT 'MG구마을금고' AS OPEN_BANK_NAME, ACCOUNT_NUMBER AS OPEN_ACC_NO FROM MG_BANK@MG WHERE U_ID = (SELECT U_ID FROM BANK_USER@MG WHERE REGISTRATION_NUMBER = ? ) ");
sql.append( " UNION SELECT 'WC' AS OPEN_BANK_NAME, ACC_NUM AS OPEN_ACC_NO FROM WC_ACCOUNT@WC WHERE ID = (SELECT ID FROM WC_USER@WC WHERE SSN= ? )) ");

		try ( // auto closable 가능한 객체만 들어감
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, vo.getRrn());
			pstmt.setString(2, vo.getRrn());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				OpenBankVO openVO = new OpenBankVO();
				openVO.setOpenBankName(rs.getString("OPEN_BANK_NAME"));
				openVO.setOpenAccNo(rs.getString("OPEN_ACC_NO"));
				openVO.setId(vo.getId());
				openVO.setOpenAccList(rs.getString("OPEN_BANK_NAME") + " : " + rs.getString("OPEN_ACC_NO"));
				list.add(openVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list; //
	}

	public boolean checkOpenBankAcc(OpenBankVO OBvo) {
		boolean result = false;

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT OPEN_BANK_NAME, OPEN_ACC_NO, ID FROM T_OPENBANK_ACCOUNT ");
		sql.append(" WHERE OPEN_BANK_NAME =? AND OPEN_ACC_NO = ? ");

		try ( // auto closable 가능한 객체만 들어감
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, OBvo.getOpenBankName());
			pstmt.setString(2, OBvo.getOpenAccNo());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void enrollOpenBank(OpenBankVO OBvo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO T_OPENBANK_ACCOUNT(OPEN_BANK_NAME, OPEN_ACC_NO, ID) VALUES( ?, ?, ?) ");

		try ( // auto closable 가능한 객체만 들어감
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, OBvo.getOpenBankName());
			pstmt.setString(2, OBvo.getOpenAccNo());
			pstmt.setString(3, OBvo.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteOpenBank(OpenBankVO OBvo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM T_OPENBANK_ACCOUNT WHERE OPEN_ACC_NO = ? AND ID = ? ");

		try ( // auto closable 가능한 객체만 들어감
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, OBvo.getOpenAccNo());
			pstmt.setString(2, OBvo.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<OpenBankVO> selectAllOpenAcc(OpenBankVO OBvo) {
		List<OpenBankVO> openAcc = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT OPEN_BANK_NAME, OPEN_ACC_NO FROM T_OPENBANK_ACCOUNT WHERE ID= ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, OBvo.getId());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				OpenBankVO vo = new OpenBankVO();
				vo.setOpenBankName(rs.getString("OPEN_BANK_NAME"));
				vo.setOpenAccNo(rs.getString("OPEN_ACC_NO"));
				vo.setOpenAccList(rs.getString("OPEN_BANK_NAME") + " : " + rs.getString("OPEN_ACC_NO"));
				openAcc.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return openAcc;
	}

	public int getOpenBankBalance(OpenBankVO obVO) {

		StringBuilder sql = new StringBuilder();
		String bankname = obVO.getOpenBankName();
		int result = -1;
		if (bankname.equals("MG구마을금고")) {
			sql.append(
					" SELECT ACCOUNT_NUMBER AS ACC_NO, BALANCE AS BALANCE, ACCOUNT_NICKNAME AS ACC_NICKNAME FROM MG_BANK@MG WHERE ACCOUNT_NUMBER = ? ");

		} else if (bankname.equals("WC")) {
			sql.append(
					" SELECT ACC_NUM AS ACC_NO, ACC_BALANCE AS BALANCE, NICK AS ACC_NICKNAME FROM WC_ACCOUNT@WC WHERE ACC_NUM = ? ");
		} else if (bankname.equals("세진저축은행")) {
			sql.append(" SELECT ACC_NO, BALANCE FROM T_ACCOUNT WHERE ACC_NO = ? ");
		}

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, obVO.getOpenAccNo());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt("BALANCE");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean checkUserInfo(OpenBankVO obVO) {
		boolean result = false;

		StringBuilder sql = new StringBuilder();
		String bankname = obVO.getOpenBankName();
		if (bankname.equals("MG구마을금고")) {
			sql.append(" SELECT ACCOUNT_NUMBER AS ACC_NO FROM MG_BANK@MG B, BANK_USER@MG U ");
			sql.append(
					" WHERE B.U_ID = U.U_ID  AND U.REGISTRATION_NUMBER = ? AND ACCOUNT_NUMBER= ? AND ACCOUNT_PWD = ? ");

		} else if (bankname.equals("WC")) {
			sql.append(" SELECT A.ACC_NUM AS ACC_NO FROM WC_USER@WC U, WC_ACCOUNT@WC ");
			sql.append(" WHERE U.ID = A.ID AND SSN = ? AND ACC_NUM = ? AND ACC_PWD= ? ");

		}

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, obVO.getRrn());
			pstmt.setString(2, obVO.getOpenAccNo());
			pstmt.setString(3, obVO.getPassword());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public void transferOpenBank(OpenBankVO sendingVO, int remittance, OpenBankVO receivingVO) {

		System.out.println(sendingVO);
		System.out.println(remittance);
		System.out.println(receivingVO);
		String sql = "{call OPENBANK_TRANSFER(?, ?, ?, ?, ?, ?, ?)}";

		try (Connection conn = new ConnectionFactory().getConnection();
				CallableStatement cstmt = conn.prepareCall(sql);) {
			cstmt.setString(1, sendingVO.getOpenBankName());
			cstmt.setString(2, sendingVO.getOpenAccNo());
			cstmt.setInt(3, remittance);
			cstmt.setString(4, receivingVO.getOpenBankName());
			cstmt.setString(5, receivingVO.getOpenAccNo());
			cstmt.setInt(6, sendingVO.getBalance());
			cstmt.setInt(7, receivingVO.getBalance());

		
			
			int cnt = cstmt.executeUpdate();
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

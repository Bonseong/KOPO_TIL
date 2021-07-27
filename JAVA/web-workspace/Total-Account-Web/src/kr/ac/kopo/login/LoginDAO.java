package kr.ac.kopo.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;

public class LoginDAO {
	/**
	 * 사용자가 입력한 ID와 패스워드로 로그인 여부 판단
	 * 
	 * @return 해당 LoginVO
	 * @param loginVO 로그인시 입력한 id, password를 포함
	 */

	public LoginVO login(LoginVO loginVO) { // id pw가 input으로 들어가도 됨

		LoginVO userVO = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ID, NAME, TYPE FROM T_MEMBER WHERE ID = ? AND PASSWORD = ? ");

		try ( // auto closable 가능한 객체만 들어감
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				userVO = new LoginVO();
				userVO.setId(rs.getString("id"));
				userVO.setName(rs.getString("name"));
				userVO.setType(rs.getString("type"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userVO; // return null or LoginVO
	}

	public LoginVO register(LoginVO loginVO) {

		StringBuilder sql = new StringBuilder();
		sql.append(
				" INSERT INTO T_MEMBER(ID, NAME, PASSWORD, EMAIL_ID, EMAIL_DOMAIN, TEL1, TEL2, TEL3, POST, BASIC_ADDR, DETAIL_ADDR, RRN) ");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

		try ( // auto closable 가능한 객체만 들어감
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getName());
			pstmt.setString(3, loginVO.getPassword());
			pstmt.setString(4, loginVO.getEmail());
			pstmt.setString(5, loginVO.getEmail_domain());
			pstmt.setString(6, loginVO.getTel1());
			pstmt.setString(7, loginVO.getTel2());
			pstmt.setString(8, loginVO.getTel3());
			pstmt.setString(9, loginVO.getPost());
			pstmt.setString(10, loginVO.getBasic_addr());
			pstmt.setString(11, loginVO.getDetail_addr());
			pstmt.setString(12, loginVO.getRrn());

			int chk = pstmt.executeUpdate();

			if (chk == 1) {
				return loginVO;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null; // return null or LoginVO
	}

	public LoginVO checkUserInfo(LoginVO vo) {
		LoginVO userInfo = new LoginVO();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ID, NAME, RRN FROM T_MEMBER WHERE ID = ? AND PASSWORD = ? AND RRN = ? ");

		try ( // auto closable 가능한 객체만 들어감
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getRrn());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				userInfo = new LoginVO();
				userInfo.setId(rs.getString("ID"));
				userInfo.setName(rs.getString("NAME"));
				userInfo.setRrn(rs.getString("RRN"));

			
			}else{
				userInfo.setName("NoData");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
	public LoginVO checkOpenBankUserInfo(LoginVO vo) {
		LoginVO userInfo = new LoginVO();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ID, NAME, RRN FROM T_MEMBER WHERE ID = ? AND RRN = ? ");
		
		try ( // auto closable 가능한 객체만 들어감
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getRrn());
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userInfo = new LoginVO();
				userInfo.setId(rs.getString("ID"));
				userInfo.setName(rs.getString("NAME"));
				userInfo.setRrn(rs.getString("RRN"));
				
				
			}else{
				userInfo.setName("NoData");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}

}

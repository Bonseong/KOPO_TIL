package kr.ac.kopo.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.login.vo.LoginVO;
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
}

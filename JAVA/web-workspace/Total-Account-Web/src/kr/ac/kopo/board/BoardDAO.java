package kr.ac.kopo.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;

public class BoardDAO {

	public List<BoardVO> selectAll() {
		List<BoardVO> list = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT NO, UPPER_NO, TITLE, WRITER, CONTENT, VIEW_CNT, REG_DATE FROM T_BOARD START WITH UPPER_NO = 0 CONNECT BY PRIOR NO = UPPER_NO ORDER SIBLINGS BY NO DESC  ");
		

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");

				BoardVO board = new BoardVO();
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setRegDate(regDate);

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public BoardVO selectByNo(int boardNo) {

		BoardVO board = null;

		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, content, view_cnt ");
		sql.append("      , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_board ");
		sql.append(" where no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	public BoardVO viewDetail(int boardNo) {
		BoardVO board = new BoardVO();
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, content, view_cnt ");
		sql.append("     , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_board ");
		sql.append(" where no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, boardNo);

			ResultSet rs = pstmt.executeQuery();

			rs.next();
			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setViewCnt(rs.getInt("view_cnt"));
			board.setRegDate(rs.getString("reg_date"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;

	}

	public void insert(BoardVO board) {

		StringBuilder sql = new StringBuilder();

		sql.append(" INSERT INTO T_BOARD(TITLE, WRITER, CONTENT) ");
		sql.append(" VALUES(?, ?, ? )");

		try (Connection conn = new ConnectionFactory().getConnection();

				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void insertReply(BoardVO board) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO T_BOARD(UPPER_NO, TITLE, WRITER, CONTENT) ");
		sql.append(" VALUES(?, ?, ?, ? )");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setInt(1, board.getNo());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getContent());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(BoardVO board) {

		StringBuilder sql = new StringBuilder();

		sql.append(" UPDATE T_BOARD SET TITLE = ?, CONTENT = ?  WHERE NO = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(int no) {
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM T_BOARD WHERE NO = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();

		} catch (Exception e) {
		}

	}

	public void updateCnt(int boardNo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE T_BOARD SET VIEW_CNT = VIEW_CNT+1 WHERE NO = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();

		} catch (Exception e) {
		}
	}
}

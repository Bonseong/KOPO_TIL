package kr.ac.kopo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.board.vo.BoardFileVO;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.util.ConnectionFactory;

public class BoardDAO {
	// 시퀀스 추출
	public int selectNo() {
		int no = 0;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT SEQ_T_BOARD_NO.NEXTVAL FROM DUAL ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				no = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return no;
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

		sql.append(" INSERT INTO T_BOARD(NO, TITLE, WRITER, CONTENT) ");
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

	public List<BoardVO> selectAll() {
		List<BoardVO> list = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append(" select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_board ");
		sql.append(" order by no desc ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
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

	public void insertFile(BoardFileVO fileVO) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board_file(no, board_no, file_ori_name ");
		sql.append("     , file_save_name, file_size) ");
		sql.append(" values(seq_t_board_file_no.nextval, ?, ?, ?, ?) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setInt(loc++, fileVO.getBoardNo());
			pstmt.setString(loc++, fileVO.getFileOriName());
			pstmt.setString(loc++, fileVO.getFileSaveName());
			pstmt.setInt(loc++, fileVO.getFileSize());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardFileVO> selectFileByNo(int boardNo){
		List<BoardFileVO> fileList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT NO, FILE_ORI_NAME, FILE_SAVE_NAME, FILE_SIZE FROM T_BOARD_FILE WHERE BOARD_NO = ? ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setInt(1, boardNo);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setNo(rs.getInt("NO"));
				fileVO.setFileOriName(rs.getString("FILE_ORI_NAME"));
				fileVO.setFileSaveName(rs.getString("FILE_SAVE_NAME"));
				fileVO.setFileSize(rs.getInt("FILE_SIZE"));
				
				fileList.add(fileVO);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fileList;
		
	}

}

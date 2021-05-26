package kr.ac.kopo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.ac.kopo.dao.BoardDAODB;
import kr.ac.kopo.vo.BoardVO;

// 비즈니스 로직을 수행하기 위한 클래스
public class BoardService {
	//private BoardDAO dao;
	private BoardDAODB dao;
	// private static int boardNo = 1; // service 클래스에서 게시물 번호를 가지고 있을 필요가 없음
	
	
	public BoardService() {
		//dao = new BoardDAO(); // BoardDAO 객체는 단 한개만 존재해야 함!
		dao = new BoardDAODB();

	}

	public void 새글등록서비스(BoardVO newBoard) throws Exception {
		// 등록할 게시물 추출
		newBoard.setNo(BoardSequence.getNo());

		// 등록날짜 추출
		String pattern = "yyyy-MM-dd hh:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		newBoard.setRegDate(sdf.format(new Date()));

		dao.새글등록(newBoard);
	}
	
	public List<BoardVO> 전체게시글조회서비스() throws Exception{
		List<BoardVO> list = dao.전체게시글조회();
		return list;
	}
}

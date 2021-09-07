package kr.ac.kopo.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.MyConfig;

public class BoardDAO {
	private SqlSession session;

	public BoardDAO() {
		session = new MyConfig().getInstance();
	}

	public void work() {
		selectOne2();
		
		// selectWhere();
		// selectNos();
		// selectOne();
		// selectAll();
		// insert();
	}

	public void selectWhere() {
		// List<BoardVO> list = session.selectList("board.BoardDAO.selectWhere", "암온더");

		BoardVO vo = new BoardVO();
		vo.setTitle("");
		vo.setWriter("test");
		List<BoardVO> list = session.selectList("board.BoardDAO.selectWhere2", vo);

		for (BoardVO board : list) {
			System.out.println(board);
		}
	}

	public void selectNos() {
		/*
		 * BoardVO board = new BoardVO(); board.setNos(new int[] {1,2,3,4,6,7,9,100});
		 * 
		 * List<BoardVO> list = session.selectList("board.BoardDAO.selectNos", board);
		 */

		List<Integer> nos = new ArrayList<>();
		nos.add(1);
		nos.add(2);
		nos.add(3);
		nos.add(4);
		nos.add(5);

		List<BoardVO> list = session.selectList("board.BoardDAO.selectNos2", nos);
		for (BoardVO b : list) {
			System.out.println(b);
		}

	}

	public void selectOne() {
		BoardVO board = new BoardVO();
		board.setNo(1);
		// BoardVO result = session.selectOne("board.BoardDAO.selectOne", board); //
		// return : object
		// BoardVO result = session.selectOne("board.BoardDAO.selectOne2", 1); // 기본자료형
		BoardVO result = session.selectOne("board.BoardDAO.selectOne3", 1);
		System.out.println(result);
	}
	
	public void selectOne2() {
		BoardVO board = new BoardVO();
		board.setNo(1);
		
		Map<String, Object> map = session.selectOne("board.BoardDAO.selectOne4", board);
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
	}

	public void selectAll() {
//		List<BoardVO> list = session.selectList("board.BoardDAO.selectAll"); // return : list
		List<BoardVO> list = session.selectList("board.BoardDAO.selectAllMap");

		for (BoardVO board : list) {
			System.out.println(board);
		}
	}

	private void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("객체로 삽입...");
		board.setWriter("test");
		board.setContent("내용내용11");

		session.insert("board.BoardDAO.newBoard", board);

		session.commit();

		System.out.println("석세스");

	}
	
	private void insert2() {
		ArrayList <BoardVO> list = new ArrayList<>();
		BoardVO board1 = new BoardVO();
		board1.setTitle("암온더넥스트레블");
		board1.setWriter("글쓴이1");
		board1.setContent("절대적 룰을지켜");
		
		BoardVO board2 = new BoardVO();
		board2.setTitle("암온더넥스트레블");
		board2.setWriter("글쓴이1");
		board2.setContent("절대적 룰을지켜");
		
		BoardVO board3 = new BoardVO();
		board3.setTitle("암온더넥스트레블");
		board3.setWriter("글쓴이1");
		board3.setContent("절대적 룰을지켜");
		list.add(board1);
		list.add(board2);
		list.add(board3);
		
		
	}
}

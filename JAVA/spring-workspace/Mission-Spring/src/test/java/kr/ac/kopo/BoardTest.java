package kr.ac.kopo;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.reply.vo.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })

public class BoardTest {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private BoardService boardService;	
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Ignore
	@Test
	public void 전체게시글조회Test() throws Exception{
		// List<BoardVO> list = sqlSessionTemplate.selectList("board.BoardDAO.selectAll");
		List<BoardVO> list = boardService.selectAllBoard();
		
		for(BoardVO board:list) {
			System.out.println(board);
		}
	}
	
	@Ignore
	@Test
	public void 게시글조회() throws Exception{
		
		
		BoardVO board = boardService.selectOneBoard(1);
		System.out.println(board);
	}
	
	
}

package kr.ac.kopo;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.reply.vo.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })
public class MybatisTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SqlSessionFactory sqlFactory;

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	@Ignore
	@Test
	public void 로그인테스트() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("user");
		member.setPassword("password");

		MemberVO userVO = sessionTemplate.selectOne("member.MemberDAO.login", member);
		System.out.println(userVO);
	}

	@Ignore // Ignore : 해당 단위테스트를 실행하지 않겟음
	@Test // 해당 메소드만 실행(테스트)
	public void DataSource생성테스트() throws Exception {
		// System.out.println("dataSource : " + dataSource); // 단위테스트 : 메인메소드없음

		assertNotNull(dataSource);
		// 올바르게 주입이 되었는지 알아보기
	}

	@Ignore
	@Test
	public void mybatis연동테스트() throws Exception {
		System.out.println("세진개발");
		// assertNotNull(sqlFactory);

		assertNotNull(sessionTemplate);

	}

	@Ignore
	@Test
	public void 전체게시글조회Test() throws Exception {
		List<BoardVO> list = sessionTemplate.selectList("board.BoardDAO.selectAll");

		for (BoardVO board : list) {
			System.out.println(board);
		}
	}

	@Ignore
	@Test
	public void 상세게시글조회Test() throws Exception {
		BoardVO board = sessionTemplate.selectOne("board.BoardDAO.selectByNo", 5);
		System.out.println(board);
	}

	@Test
	public void 댓글Test() throws Exception {

		List<ReplyVO> list = sessionTemplate.selectList("reply.ReplyDAO.selectReply", 1);

		for (ReplyVO reply : list) {
			System.out.println(reply);
		}
	}

}

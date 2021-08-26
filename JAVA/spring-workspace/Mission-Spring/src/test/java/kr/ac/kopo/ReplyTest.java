package kr.ac.kopo;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.reply.dao.ReplyDAO;
import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })

public class ReplyTest {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private ReplyService replyService;	
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Ignore
	@Test
	public void 댓글Test() throws Exception{
		List<ReplyVO> list = replyService.selectReply(1);
		
		for(ReplyVO reply:list) {
			System.out.println(reply);
		}
	}
	
	@Test
	public void 댓글쓰기test() throws Exception{
		ReplyVO reply = new ReplyVO();
		reply.setBoardNo(1);
		reply.setWriter("박종범");
		reply.setContent("종범은종범종범해");
		
		replyService.writeReply(reply);
		
	}
	

	
	
}

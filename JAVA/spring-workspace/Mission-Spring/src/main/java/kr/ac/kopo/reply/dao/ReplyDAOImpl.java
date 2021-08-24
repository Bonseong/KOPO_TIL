package kr.ac.kopo.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.reply.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	public List<ReplyVO> selectReply(int boardNo) {
		List<ReplyVO> list = sqlSessionTemplate.selectList("reply.ReplyDAO.selectReply", boardNo);
		return list;
	}
	
}

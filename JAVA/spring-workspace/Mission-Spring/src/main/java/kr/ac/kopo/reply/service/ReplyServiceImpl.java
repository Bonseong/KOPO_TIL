package kr.ac.kopo.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.reply.dao.ReplyDAO;
import kr.ac.kopo.reply.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyDAO replyDAO;
	
	public List<ReplyVO> selectReply(int boardNo) {
		List<ReplyVO> replyList = replyDAO.selectReply(boardNo);
		return replyList;
	}

	public void writeReply(ReplyVO reply) {
		replyDAO.writeReply(reply);
		
	}
	
	

}

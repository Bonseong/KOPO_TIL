package kr.ac.kopo.reply.dao;

import java.util.List;

import kr.ac.kopo.reply.vo.ReplyVO;

public interface ReplyDAO {
	List<ReplyVO> selectReply(int boardNo);
	void writeReply(ReplyVO reply);
}

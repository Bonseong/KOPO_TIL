package kr.ac.kopo.reply.service;

import kr.ac.kopo.reply.vo.ReplyVO;

import java.util.List;

import kr.ac.kopo.reply.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> selectReply(int boardNo);
}

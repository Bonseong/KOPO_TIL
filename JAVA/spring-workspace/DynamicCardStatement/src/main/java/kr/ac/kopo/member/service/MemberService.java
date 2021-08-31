package kr.ac.kopo.member.service;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberService {
	Boolean checkId(String id);
	
	MemberVO login(MemberVO member);
}

package kr.ac.kopo.card.service;

import java.util.List;
import java.util.Map;

import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardBenefitVO;
import kr.ac.kopo.card.vo.DemographyVO;
import kr.ac.kopo.card.vo.UserCardVO;
import kr.ac.kopo.util.PagingVO;

public interface CardService {

	List<UserCardVO> selectCardList(PagingVO vo);
	
	List<BenefitVO> selectBenefitList();
	
	List<CardBenefitVO> selectByFilter(Map<String, String> paramMap);
	
	int getLength();
	
	CardBenefitVO selectByNo(int no);
	
	List<BenefitVO> selectNotice(int no);
	
	DemographyVO selectStatByNo(int no);
	
	CardBenefitVO selectUserBenefit(int memberNo);
	
	
	
}

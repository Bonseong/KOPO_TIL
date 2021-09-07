package kr.ac.kopo.card.service;

import java.util.List;
import java.util.Map;

import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardBenefitVO;
import kr.ac.kopo.card.vo.UserCardVO;

public interface CardService {

	List<UserCardVO> selectCardList();
	
	List<BenefitVO> selectBenefitList();
	
	List<CardBenefitVO> selectByFilter(Map<String, String> paramMap);
	
	
}

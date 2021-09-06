package kr.ac.kopo.card.service;

import java.util.List;
import java.util.Map;

import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardVO;

public interface CardService {

	List<CardVO> selectCardList();
	
	List<BenefitVO> selectBenefitList();
	
	List<CardVO> selectByFilter(Map<String, String> paramMap);
}

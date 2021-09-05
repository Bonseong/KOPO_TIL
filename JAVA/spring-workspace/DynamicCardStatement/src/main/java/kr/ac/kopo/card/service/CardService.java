package kr.ac.kopo.card.service;

import java.util.List;

import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardVO;

public interface CardService {

	List<CardVO> selectCardList();
	
	List<BenefitVO> selectBenefitList();
}

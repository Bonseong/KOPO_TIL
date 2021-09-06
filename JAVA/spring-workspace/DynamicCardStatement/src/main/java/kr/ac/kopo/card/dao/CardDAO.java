package kr.ac.kopo.card.dao;

import java.util.List;
import java.util.Map;

import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardVO;

public interface CardDAO {
	
	List<BenefitVO> selectBenefitList();

	List<CardVO> selectByFilter(Map<String, String> paramMap);
}

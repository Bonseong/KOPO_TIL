package kr.ac.kopo.card.dao;

import java.util.List;

import kr.ac.kopo.card.vo.BenefitVO;

public interface CardDAO {
	
	List<BenefitVO> selectBenefitList();

}

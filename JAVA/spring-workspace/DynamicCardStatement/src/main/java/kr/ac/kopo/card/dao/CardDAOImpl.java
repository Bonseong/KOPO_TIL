package kr.ac.kopo.card.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardBenefitVO;
import kr.ac.kopo.card.vo.UserCardVO;

@Repository
public class CardDAOImpl implements CardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
		
	public List<UserCardVO> selectCardList() {
		List<UserCardVO> cardList = sqlSessionTemplate.selectList("card.CardDAO.selectAllCard");
		return cardList;
	}

	public List<BenefitVO> selectBenefitList() {
		List<BenefitVO> list = sqlSessionTemplate.selectList("card.CardDAO.selectBenefitList");
		return list;
	}

	@Override
	public List<CardBenefitVO> selectByFilter(Map<String, String> paramMap) {
		List<CardBenefitVO> cardList = sqlSessionTemplate.selectList("card.CardDAO.selectByFilter", paramMap);
		return cardList;
	}

}

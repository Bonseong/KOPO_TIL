package kr.ac.kopo.card.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardVO;

@Repository
public class CardDAOImpl implements CardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BenefitVO> selectBenefitList() {
		List<BenefitVO> list = sqlSessionTemplate.selectList("card.CardDAO.selectBenefitList");
		return list;
	}

	@Override
	public List<CardVO> selectByFilter(Map<String, String> paramMap) {
		List<CardVO> cardList = sqlSessionTemplate.selectList("card.CardDAO.selectByFilter", paramMap);
		System.out.println(cardList);
		return cardList;
	}

}

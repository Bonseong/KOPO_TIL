package kr.ac.kopo.card.dao;

import java.util.List;

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

}

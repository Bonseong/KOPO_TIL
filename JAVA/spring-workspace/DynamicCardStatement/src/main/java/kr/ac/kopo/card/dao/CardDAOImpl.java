package kr.ac.kopo.card.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardBenefitVO;
import kr.ac.kopo.card.vo.DemographyVO;
import kr.ac.kopo.card.vo.UserCardVO;
import kr.ac.kopo.util.PagingVO;

@Repository
public class CardDAOImpl implements CardDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<UserCardVO> selectCardList(PagingVO vo) {
		List<UserCardVO> cardList = sqlSessionTemplate.selectList("card.CardDAO.selectAllCard", vo);
		return cardList;
	}

	public List<BenefitVO> selectBenefitList() {
		List<BenefitVO> list = sqlSessionTemplate.selectList("card.CardDAO.selectBenefitList");
		return list;
	}

	public List<CardBenefitVO> selectByFilter(Map<String, String> paramMap) {
		List<CardBenefitVO> cardList = sqlSessionTemplate.selectList("card.CardDAO.selectByFilter", paramMap);
		return cardList;
	}

	public int getLength() {
		int totalLength = sqlSessionTemplate.selectOne("card.CardDAO.getLength");
		return totalLength;
	}

	public CardBenefitVO selectByNo(int no) {
		CardBenefitVO card = sqlSessionTemplate.selectOne("card.CardDAO.selectByNo", no);
		return card;
	}

	public List<BenefitVO> selectNotice(int no) {
		List<BenefitVO> notice = sqlSessionTemplate.selectList("card.CardDAO.selectNotice", no);
		return notice;
	}

	public List<DemographyVO> selectStatByNo(int no) {
		System.out.println("여기까지 오긴하니");
		System.out.println(no);
		List<DemographyVO> userStat = sqlSessionTemplate.selectList("card.CardDAO.selectStatByNo", no);

		return userStat;
	}

}

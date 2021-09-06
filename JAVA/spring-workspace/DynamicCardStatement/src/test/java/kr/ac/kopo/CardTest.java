package kr.ac.kopo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.card.dao.CardDAO;
import kr.ac.kopo.card.service.CardService;
import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardVO;
import kr.ac.kopo.card.vo.UserBenefitVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })

public class CardTest {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	private CardService cardService;

	@Autowired
	private CardDAO cardDAO;

	@Ignore
	@Test
	public void 카드리스트Test() throws Exception {
		List<BenefitVO> list = cardService.selectBenefitList();

		System.out.println(list);

	}
	
	@Ignore
	@Test
	public void 문자자르기Test() throws Exception{
	
		
		String temp2 = "0 % - 50 %";
		String[] bb = temp2.replace("%", "").replace(" ", "").split("-");
		
		
		
	}
	
	/*
	 * @Test
	 * 
	 * public void 카드핕터링Test() throws Exception {
	 * 
	 * List<UserBenefitVO> benefitList = new ArrayList<>();
	 * 
	 * UserBenefitVO vo = new UserBenefitVO(); vo.setParamName("cardName");
	 * vo.setParamValue("SK"); benefitList.add(vo);
	 * 
	 * UserBenefitVO vo2 = new UserBenefitVO(); vo2.setParamName("cardType");
	 * vo2.setParamValue("CHECK"); benefitList.add(vo2);
	 * 
	 * System.out.println(benefitList); List<CardVO> list =
	 * cardDAO.selectByFilter(benefitList);
	 * 
	 * System.out.println(list);
	 * 
	 * }
	 */
	



}

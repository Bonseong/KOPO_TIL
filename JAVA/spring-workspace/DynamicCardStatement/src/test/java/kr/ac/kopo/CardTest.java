package kr.ac.kopo;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })

public class CardTest {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	private CardService cardService;

	@Autowired
	private CardDAO carDAO;

	@Ignore
	@Test
	public void 카드리스트Test() throws Exception {
		List<BenefitVO> list = cardService.selectBenefitList();

		System.out.println(list);

	}



}

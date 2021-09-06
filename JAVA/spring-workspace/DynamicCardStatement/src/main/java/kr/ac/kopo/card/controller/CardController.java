package kr.ac.kopo.card.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.card.service.CardService;
import kr.ac.kopo.card.vo.BenefitVO;

@Controller
public class CardController {

	@Autowired
	private CardService cardService;

	@GetMapping("/cardlist")
	public ModelAndView cardList() {
		List<BenefitVO> benefitList = cardService.selectBenefitList();

		ModelAndView mav = new ModelAndView("card/cardlist");
		mav.addObject("benefitList", benefitList);

		// cardService.selectCardList();
		return mav;

	}

	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/cardlist") public Map<String, Object> cardListPost(@RequestBody
	 * Map<String, Object> param) { System.out.println(param);
	 * 
	 * List<BenefitVO> benefitList = cardService.selectBenefitList(); ModelAndView
	 * mav = new ModelAndView("card/cardlist"); mav.addObject("benefitList",
	 * benefitList);
	 * 
	 * return param; }
	 */

	

}
package kr.ac.kopo.card.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.card.service.CardService;
import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardBenefitVO;
import kr.ac.kopo.card.vo.DemographyVO;
import kr.ac.kopo.card.vo.UserCardVO;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.util.PagingVO;

@Controller
public class CardController {

	@Autowired
	private CardService cardService;

	@GetMapping("/cardlist")
	public ModelAndView cardList(PagingVO vo, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) {
		ModelAndView mav = new ModelAndView("card/cardlist");
		int total = cardService.getLength();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

		List<UserCardVO> cardList = cardService.selectCardList(vo);

		mav.addObject("paging", vo);
		mav.addObject("cardList", cardList);

		List<BenefitVO> benefitList = cardService.selectBenefitList();
		mav.addObject("benefitList", benefitList);
		return mav;

	}

	@ResponseBody
	@PostMapping("/cardlist")
	public List<CardBenefitVO> benefitSearch(@RequestBody Map<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("card/cardlist");

		List<CardBenefitVO> cardFilterList = cardService.selectByFilter(paramMap);
		mav.addObject("cardFilterList", cardFilterList);

		List<BenefitVO> benefitList = cardService.selectBenefitList();
		mav.addObject("benefitList", benefitList);

		return cardFilterList;
	}

	@PostMapping("/cardlist/filterList")
	public ModelAndView benefitFiltering(@RequestBody Map<String, String> paramMap) {

		ModelAndView mav = new ModelAndView("card/filterList");

		List<CardBenefitVO> cardFilterList = cardService.selectByFilter(paramMap);
		mav.addObject("cardFilterList", cardFilterList);
		List<BenefitVO> benefitList = cardService.selectBenefitList();
		mav.addObject("benefitList", benefitList);

		return mav;
	}

	@GetMapping("/detail/{no}")
	public ModelAndView detail(@PathVariable("no") int no, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("card/detail");

		List<BenefitVO> notice = cardService.selectNotice(no);
		mav.addObject("notice", notice); // 카드에 대한 공지

		DemographyVO userStat = cardService.selectStatByNo(no);
		mav.addObject("userStat", userStat); // 카드에 대한 인구통계학 정보

		MemberVO user = (MemberVO) session.getAttribute("userVO");

		List<CardBenefitVO> cardInfoList = cardService.selectCardAllInfo(no, user.getMemberNo());

		CardBenefitVO card = cardInfoList.get(0);
		mav.addObject("card", card);

		CardBenefitVO userConsumption = cardInfoList.get(1);
		mav.addObject("userConsumption", userConsumption);

		System.out.println(card);
		System.out.println(userConsumption);

		return mav;
	}

}
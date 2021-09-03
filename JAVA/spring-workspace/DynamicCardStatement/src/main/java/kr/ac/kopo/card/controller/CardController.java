package kr.ac.kopo.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ac.kopo.card.service.CardService;
import kr.ac.kopo.member.vo.MemberVO;

@Controller
public class CardController {

	@Autowired
	private CardService cardService;

	@GetMapping("/cardlist")
	public String register() {
		cardService.selectCardList();
		return "card/cardlist";

	}

}
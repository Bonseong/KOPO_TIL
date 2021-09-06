package kr.ac.kopo.card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.card.vo.CardVO;

@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardDAO cardDAO;
	
	
	public List<CardVO> selectCardList() {
		
		List<CardVO> cardList
		return null;
	}

}

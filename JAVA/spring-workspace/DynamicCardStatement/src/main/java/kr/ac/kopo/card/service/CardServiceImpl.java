package kr.ac.kopo.card.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.card.dao.CardDAO;
import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardVO;

@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardDAO cardDAO;
	
	public List<CardVO> selectCardList() {
		
		return null;
	}

	public List<BenefitVO> selectBenefitList() {
		List<BenefitVO> list = cardDAO.selectBenefitList();
		return list;
	}
	
	

}

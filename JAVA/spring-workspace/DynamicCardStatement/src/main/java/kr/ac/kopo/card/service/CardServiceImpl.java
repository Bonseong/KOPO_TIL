package kr.ac.kopo.card.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.card.dao.CardDAO;
import kr.ac.kopo.card.vo.BenefitVO;
import kr.ac.kopo.card.vo.CardVO;
import kr.ac.kopo.card.vo.UserBenefitVO;


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

	public List<CardVO> selectByFilter(Map<String, String> paramMap) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(String key : paramMap.keySet()) {
			if(key.equals("cardName")) {
				map.put("cardName", paramMap.get(key));
			}else if(key.equals("cardType")){
				map.put("cardType", paramMap.get(key));
			}else if(key.equals("annualFeeType")) {
				map.put("annualFeeType", paramMap.get(key));				
			}else if(key.equals("annualFeeRange")) {
				 
				String temp = paramMap.get(key);
				String[] min_max = temp.replace("원", "").split(" - ");
				
				String min_value = min_max[0];
				String max_value = min_max[1];
				
				map.put("annualFeeRange_min", min_value);
				map.put("annualFeeRange_max", max_value);
			}else {
				String temp = paramMap.get(key);
				String[] min_max = temp.replace("%", "").replace(" ", "").split("-");
				
				map.put(key+"_min", min_max[0]);
				map.put(key+"_max", min_max[1]);
			}
			
		}
		
		System.out.println(map);
		cardDAO.selectByFilter(map); 
		return null;
	}
	
	
	
	

}

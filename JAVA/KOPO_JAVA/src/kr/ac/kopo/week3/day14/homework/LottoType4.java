package kr.ac.kopo.week3.day14.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LottoType4 extends LottoUtil {

	@Override
	public void pickNumber() {
		// map의 key값은 중복이 허용되지 않기 때문에 유용하게 마치 set처럼 사용할 수 있다.
		System.out.println("set을 이용한 방법");
		Random r = new Random();

		int num = 0;

		Map<String, String> lotto_map = new HashMap<String, String>();

		while (true) {
			num = r.nextInt(45) + 1;
			lotto_map.put(String.valueOf(num), ""); // value값은 의미없으니 공백으로

			if (lotto_map.size() == 6)
				break;
		}

		Set<String> keys = lotto_map.keySet();
		
		
		for (String lottoNum : keys) {
			System.out.print(lottoNum+" ");
		}

	}
}

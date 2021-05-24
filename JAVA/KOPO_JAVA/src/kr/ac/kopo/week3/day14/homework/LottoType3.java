package kr.ac.kopo.week3.day14.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LottoType3 extends LottoUtil {
	@Override
	public void pickNumber() {
		
		Random r = new Random();
		System.out.println("list를 이용한 방법");
		
		List<Integer> lotto_list = new ArrayList<>();
		lotto_list.add(3);
		int num = 0;
		while (lotto_list.size() < 6) {
			num = r.nextInt(45) + 1;
			if (!lotto_list.contains(num)) {
				lotto_list.add(num);
			}

		}
		Object[] arr = lotto_list.toArray(); // 리스트를 배열 형태로 리턴
		System.out.println(Arrays.toString(arr));

	}
}

package kr.ac.kopo.week3.day14.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoType1 extends LottoUtil {

	@Override
	public void pickNumber() {
		System.out.println("set을 이용한 방법");
		Random r = new Random();

		Set<Integer> lotto_set = new TreeSet<>();

		while (true) {
			lotto_set.add(r.nextInt(45) + 1);
			if (lotto_set.size() == 6) {
				break;
			}
		}

		Object[] arr = lotto_set.toArray();
		System.out.println(Arrays.toString(arr));

	}
}

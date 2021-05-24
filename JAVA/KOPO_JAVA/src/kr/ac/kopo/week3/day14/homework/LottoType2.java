package kr.ac.kopo.week3.day14.homework;

import java.util.Arrays;
import java.util.Random;

public class LottoType2 extends LottoUtil {
	@Override
	public void pickNumber() {

		System.out.println("array를 이용한 방법");
		Random r = new Random();

		boolean duplication_check = false; // 기본적으로 중복이 아닌 상황
		int lotto_arr[] = new int[6];

		for (int i = 0; i < 6; i++) {
			while (true) {
				lotto_arr[i] = r.nextInt(45) + 1;

				for (int j = 0; j < i; j++) {
					if (lotto_arr[j] == lotto_arr[i]) {
						duplication_check = true; // 뽑은 수가 이전 인덱스와 비교하여 중복인 상황, for문을 중지하고 다시 수를 뽑는다.
						break;
					} else {
						duplication_check = false;
					}
				}
				if (!duplication_check) {
					break; // 중복이 아니라면 다음 인덱스로 넘어간다
				}
			}

		}

		System.out.println(Arrays.toString(lotto_arr));

	}
}

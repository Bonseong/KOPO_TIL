package kr.ac.kopo.week3.day14.homework;

import java.util.Scanner;

public abstract class LottoUtil {
	public abstract void pickNumber(); // 각 알고리즘으로 시행

	public void inputGames() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇번 진행하시겠습니까?");
		int inputCount = sc.nextInt();

		while (inputCount > 0) {
			pickNumber();
			inputCount--;
		}

	}
}

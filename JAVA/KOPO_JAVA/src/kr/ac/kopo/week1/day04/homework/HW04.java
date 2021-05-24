package kr.ac.kopo.week1.day04.homework;

import java.util.Scanner;

public class HW04 {

	public static void main(String[] args) {
		System.out.println("정수를 입력하시오.");
		Scanner sc = new Scanner(System.in);
		int num4_1 = sc.nextInt();

		for (int i = 2; i < num4_1; i++) {
			if (num4_1 % i == 0) {
				System.out.println(num4_1 + "은 소수가 아닙니다.");
				break;
			} else {
				System.out.println(num4_1 + "은 소수입니다.");
				break;
			}
		} // 이 경우, 2의 판별에서 문제가 생김

	}

}

/*
	본성씨.... 이렇게 코드를 작성하면 int i = 1 일때 if문 조건 만족하면서 반복문 빠져나오지 않아요?
	어떻게 해도 1회만 반복문을 수행할 거 같은데요.... 한번 확인해보세요 ㅠ__
*/
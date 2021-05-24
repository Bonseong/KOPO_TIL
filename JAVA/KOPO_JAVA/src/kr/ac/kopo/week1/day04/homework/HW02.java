package kr.ac.kopo.week1.day04.homework;

import java.util.Scanner;

public class HW02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Q2");

		System.out.print("첫번째 숫자를 입력하시오 : ");
		int num2_1 = sc.nextInt();
		System.out.print("두번째 숫자를 입력하시오 : ");
		int num2_2 = sc.nextInt();
		System.out.print("세번째 숫자를 입력하시오 : ");
		int num2_3 = sc.nextInt();
		System.out.print("네번째 숫자를 입력하시오 : ");
		int num2_4 = sc.nextInt();

		int max = (num2_1 > num2_2 && num2_1 > num2_3 && num2_1 > num2_4) ? num2_1
				: (num2_2 > num2_3 && num2_2 > num2_4 ? num2_2 : (num2_3 > num2_4 ? num2_3 : num2_4));
		System.out.println(max);

	}

}

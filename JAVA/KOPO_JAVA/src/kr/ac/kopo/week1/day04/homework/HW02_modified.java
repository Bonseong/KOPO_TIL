package kr.ac.kopo.week1.day04.homework;

import java.util.Random;

public class HW02_modified {

	public static void main(String[] args) {
		// 마치 토너먼트라고 생각하고 하면 편함.

		Random r = new Random();

		// 1~100사이의 정수를 4개 추출
		int num1 = r.nextInt(100) + 1; // (0~99) + 1 => (1~100)
		int num2 = r.nextInt(100) + 1;
		int num3 = r.nextInt(100) + 1;
		int num4 = r.nextInt(100) + 1;
		System.out.println(num1 + " " + num2 + " " + num3 + " " + num4);

		/*
		 * for을 통한 입력을 받는 방법또한 존재
		 * 단 최댓/최솟값에 대한 초기화 필요
		 */
		
		int max = num1 > num2 ? num1 : num2;
		if (max < num3) {
			max = num3;
		}
		if (max < num4) {
			max = num4;
		}

		System.out.println("가장 큰수 : " + max);
		
		
		/*
		int max1 = num1 > num2 ? num1 : num2;
		int max2 = num3;
		if (num4 > num3) {
			max2 = num4;
		}
		
		System.out.println("가장 큰수 : " + (max1 > max2 ? max1 : max2));
		*/
	}

}

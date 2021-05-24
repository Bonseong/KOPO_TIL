package kr.ac.kopo.week1.day04.homework;

import java.util.Scanner;

public class HW01_modified {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 3개 입력하세요 : ");
		int num = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();

		System.out.println(num + ", " + num2 + ", " + num3);

		/*
		 * 경우의 수
		 * num > num2 > num3 
		 * num > num3 > num2
		 * num2 > num > num3
		 * num2 > num3 > num
		 * num3 > num > num2
		 * num3 > num2 > num
		 */

		int min = num, max = num2; //
		if (num > num2) {
			min = num2;
			max = num;
		}

		if (num3 > max) {
			System.out.println(num3 + ">" + max + ">" + min);
		} else if (num3 > min) {
			System.out.println(max + ">" + num3 + ">" + min);
		} else {
			System.out.println(max + ">" + min + ">" + num3);
		}

	}
}

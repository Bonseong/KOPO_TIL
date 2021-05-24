package kr.ac.kopo.week1.day04.homework;

import java.util.Scanner;

public class HW04_modified {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();

		// 정수의 약수갯수 구하기 (소수는 약수가 1과 자기 자신 : 2개
		// or 1과 자기 자신의 정수를 제외한 약수 갯수 구하기 (소수는 약수 0개)
		// 정수의 약수가 될 수 있는 후보군 : 1 ~ 정수

		int i = 2;
		while(i <= num-1 && num % i != 0) {
			i++; // i가 num일때 탈출
		}
		
		if(i == num) {
			System.out.println(num + " : 소수입니다.");
		}else {
			System.out.println(num + " : 소수가 아닙니다.");
		}
		
		
		
		/*
		boolean bool = true; // 소수라고 가정함
		for(int i = 2; i<=num/2; i++) {
			if(num % i == 0) {
				bool = false;
				break;
			}
		}
		
		if(bool) {
			System.out.println(num + " : 소수입니다.");
		}else {
			System.out.println(num + " : 소수가 아닙니다.");
		
		}
		// count에 대한 값은 관심없고, 0 또는 1이상인지의 여부만 궁금함 -> boolean 타입이 유리
		*/
		
		/*
		int count = 0;
		for (int i = 2; i <= num/2; i++) {
			if (num % i == 0) {
				count++;
				break; // 만약 소수가 아니라고 판별나면, 굳이 끝까지 할 필요가 없음.
			}
		}
		*/


		
		/*
		int count = 0;
		for (int i = 2; i <= num/2; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		

		if (count == 0) {
			System.out.println(num + " : 소수입니다.");
		} else {
			System.out.println(num + " : 소수가 아닙니다.");
		}
		*/
	}

}

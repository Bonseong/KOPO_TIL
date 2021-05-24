package kr.ac.kopo.week1.day02.homework;

import java.util.Scanner;

public class day2_q4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 굳이 두번 사용할 필요는 없음
		
		System.out.println("첫번째 정수를 입력하시오.");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수를 입력하시오.");
		int num2 = sc.nextInt();
		
		if (num2!=0 && num1%num2==0) {
			System.out.println("판단 결과 : " + true);
		}else{
			System.out.println("판단 결과 : " + false);
		}
		
		System.out.println("----------");
		
		
		boolean result = num2 <= 0 ? false : (num1%num2==0) ? true : false;
		System.out.println("판단 결과 : " + result);
	}

}

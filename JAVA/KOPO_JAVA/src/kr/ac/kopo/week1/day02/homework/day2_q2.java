package kr.ac.kopo.week1.day02.homework;

import java.util.Scanner;

public class day2_q2 {

	public static void main(String[] args) {
		//final double pi = 3.141592; // pi는 상수변수, 따라서 대문자로 변경해야함! pi->PI
		
		final double PI = 3.141592;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름을 입력하시오 : ");
		int r = sc.nextInt();
		System.out.println("반지름은 " + r + "입니다.");
		
		System.out.printf("반지름이 " + r + "일때 원둘레는 " + "%.3f"+ " 이고, 원넓이는 " + "%.3f" + "입니다." , 2*(double)r*PI,(double)r*(double)r*PI);
		// 소수점 셋째자리까지 표기
		
		
	}

}

/*
	과제하느라 고생하셨습니다.
	일단 final로 변수를 상수화시키는 경우 명명규칙에 의해 pi변수명을 PI로 쓰는 것이 권고됩니다.
	원둘레나 원넓이 계산시 2 * int * double 은 묵시적 형변환에 의해서 형변환 키워드를 생략하실 수 있습니다.
	수고하셨습니다 ^^
*/

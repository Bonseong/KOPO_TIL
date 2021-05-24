package kr.ac.kopo.week1.day02;

import java.util.Scanner;

/* 좋아하는 계절을 입력 : spring
 * 봄은 3월 ~ 5월까지입니다.
 */

public class SwitchMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("좋아하는 계절을 입력 : ");
		String season = sc.nextLine();
		
		System.out.println(season);
		
		/*
		if(season.equals("spring")) {
			System.out.println("봄은 3월 ~ 5월까지입니다.");
		}else if (season.equals("summer")) {
			System.out.println("여름은 6월 ~ 8월까지입니다.");
		}
		*/
		// 객체참조형은 동등비교를 할 수 없음! (season=="spring") -> 틀림
		
		switch(season) {
		case "SPRING":
		case "spring":
		case "봄": // 문자열 비교에 대해 Switch가 조금더 수월함 (단 JDK 7버전 이상)
			System.out.println("봄은 3월 ~ 5월까지입니다.");
			break;
		case "summer":
			System.out.println("여름은 6월 ~ 8월까지입니다.");
			break;
		default:
			System.out.println("error");
		}
	}
	
	
}

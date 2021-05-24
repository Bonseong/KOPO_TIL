package kr.ac.kopo.week2.day07;

import java.util.Scanner;

public class GugudanMain {

	public static void main(String[] args) {

		Gugudan gu = new Gugudan();

		
		int dan = gu.getDan("2- 9 사이의 정수 입력 : ");

		/*
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		sc.nextLine();
		*/

		gu.print(dan); // 리턴타입은 없음 (void)

		gu.print(); // 메소드 오버로딩

		int startDan = gu.getDan("시작단을 입력 : ");
		int endDan = gu.getDan("종료단을 입력 : ");
		

		gu.print(startDan, endDan);

	}

}

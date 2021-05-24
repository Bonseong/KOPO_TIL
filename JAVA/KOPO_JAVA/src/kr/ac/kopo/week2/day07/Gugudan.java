package kr.ac.kopo.week2.day07;

import java.util.Scanner;

/*
 * 
 * 구구단에 관련된 기능을 가지는 기능 클래스ㅡ
 * */
public class Gugudan {
	
	Scanner sc = new Scanner(System.in); // 메모리의 효율성을 위해 스캐너를 멤버변수로 선언함
	
	void print(int dan) {
		System.out.println("*** " + dan + "단 " + " ***");
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}
		System.out.println();

	}

	void print() {
		
		print(2,9);
		// 같은 내 클래스를 참조하여 2~9단 출력
		
		/*
		print(2); // 같은 클래스 내에 다른 객체이지만 호출 가능.
		// this.print(2); // this 생략 가능

		for (int dan = 2; dan <= 9; dan++) {
			print(dan);
		}
		*/

		/*
		 * 
		 * for (int dan = 2; dan <= 9; dan++) { System.out.println("*** " + dan +
		 * "단 ***"); for (int i = 1; i <= 9; i++) { System.out.println(dan + " * " + i +
		 * " = " + dan * i); } System.out.println(); }
		 * 
		 */

	}
	
	/**
	 * 
	 * @param sDan 시작 단
	 * @param eDan 종료 단
	 */
	void print(int sDan, int eDan) {
		for(int dan = sDan; dan<=eDan; dan++) {
			print(dan);
		}


	}

	int getDan() {
		int dan = sc.nextInt();
		sc.nextLine();
		return dan;
		
	}
	
	int getDan(String msg) {
		System.out.print(msg);
		int dan = sc.nextInt();
		sc.nextLine();
		return dan;
	}


}

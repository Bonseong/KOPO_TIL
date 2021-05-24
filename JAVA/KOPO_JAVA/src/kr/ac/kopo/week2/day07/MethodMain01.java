package kr.ac.kopo.week2.day07;

/*
 * **********
 * hello
 * **********
 * hi
 * **********
 * good-bye
 * **********
 * 
 */

public class MethodMain01 {

	
	/**
	 * 임의의 문자를 반복하여 출력하는 기능
	 * @param chr 출력할 문자
	 * @param cnt 문자의 개수
	 */
	
	static int printStar(char chr, int cnt) {
		// 피호출자 메소드이자 println을 호출하는 호출자 메소드
		// 매개변수, 파라미터
		// int i = 10; // 메소드 내 변수는 메소드가 돌아갈 때는 존재하지만, 메소드가 끝나면 소멸함.

		for (int i = 0; i < cnt; i++) {
			System.out.print(chr);
		}
		System.out.println();

		return 10;
	}
	// 반환형은 반드시 들어가야 함
	// void : 잘 모르면 void, 없다, 다른 값을 반환값으로 주기 위해 void가 아닌, 문자형을 넣어줌
	// 반환값과 매개변수를 통해 서로 공유
	// 반환값 : 피호출자가 호출자에게 대화 시도를 위한 통로
	// 매개변수 : 호출자가 피호출자에게 대화 시도를 위한 통로

	public static void main(String[] args) { // 호출자 메소드

//		for (int i =0; i<4; i++) {
//			System.out.println("**********");
//			
//		} // 반복되지 않는 문장이 나올경우 사용하기 까다로움

		// System.out.println("**********"); // 이거보다 메소드를 사용하는 것이 수정이나 관리에 더욱 용이함

		int i = 4; // prinstar의 i와는 독립적

		int data = printStar('*', 10);
		// printStar('*', 10); // printstar 정의부로 이동
		System.out.println("hello");
		printStar('#', 20);
		System.out.println("hi");
		printStar('!', 1);
		System.out.println("goodbye");
		printStar('-', 5);
		printStar('W',20);

	}

}

/*
 * 모듈의 관점에서 메소드는 정~~~~~~말 중요
 */

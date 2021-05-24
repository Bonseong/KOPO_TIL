package kr.ac.kopo.week2.day07;

import java.util.Scanner;

public class KeyboardTestMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // System : 클래스, in : 멤버변수(괄호가 없기 때문에)
	
		System.out.print("정수 입력 : ");
		
//		int num = sc.nextInt();
//		sc.nextLine(); // 정수 입력 후, 반드시 다음줄로 바꿔주기 (버퍼의 문제 해결)
		
//		String data = sc.nextLine();
//		int num = Integer.parseInt(data);
		
		int num = Integer.parseInt(sc.nextLine()); // 숫자를 문자로 입력받아 다시 정수로 변환
		
		System.out.print("문자열을 입력 : ");
		String str = sc.nextLine();
		
		System.out.println("str : " + str + ", num : " + num);
		
		/*
		System.out.print("첫번째 정수 : ");
		int num = sc.nextInt();
		System.out.print("두번째 정수 : ");
		int num2 = sc.nextInt();
		
		System.out.println("num : " + num + ", num2 : " + num2);
		// 처음에 나오는 글자가 공백이면 무시함.
		// 만약 문자라면 InputMismatchException 발생
	
		 */

	}

}

package kr.ac.kopo.week1.day02;

import java.util.Scanner;

/*
 * 정수를 입력하세요 : 12
 * 12의 짝수유무 : true
 * 
 * 정수를 입력하세요 : 5
 * 5의 짝수유무 : false
 * 
 * 단, 0이나 음수인 경우는 false라 출력
 */

public class OperationMain3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 키보드를 통한 입력
		// 에러메시지 클릭하면 자동 임포트가 가능함! (ctrl shift o)
		
		// 정수를 입력하세요 : 문장을 출력
		System.out.print("정수를 입력하세요 : ");
		
		// 키보드로 정수를 입력
		int num = sc.nextInt(); // SW는 지속적으로 실행되고 있음
		
		// 결과 출력
		boolean result = (num > 0 && num % 2 == 0); // 논리 연산
		System.out.println(num + "의 짝수 여부 : " + result);
		
		
		

	}

}

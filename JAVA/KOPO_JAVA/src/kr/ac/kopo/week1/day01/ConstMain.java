package kr.ac.kopo.week1.day01;

/*
 * 상수
 * 1. 정수형 상수 : 10, 20, -678
 * 2. 실수형 상수 : 1.2, 3.451
 * 3. 문자형 상수 : '3', 'A', 'm', '가'
 * 4. 문자열 상수 : "abc", "A"
 * 5. 논리형 상수 " True, False
 */


public class ConstMain {
	public static void main(String[] args) {
		System.out.println('A'+10);
		System.out.println('A'+'B'); // A, B를 유니코드로 변환
		System.out.printf("%c%c\n", 'A', 'B');
		
		final boolean BOOL = true; // bool 변수에 대한 고정, 명명 규칙에 의해 대문자로 작성
		// bool = false; -> final 때문에 에러
		System.out.println(BOOL);
			
	}
}

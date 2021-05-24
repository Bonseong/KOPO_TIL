package kr.ac.kopo.week1.day02;

public class ConstMain02 {
	public static void main (String[] args) {
		char ch='A';
		//ch=65;
		//ch='\u0041'; // 유니코드 문자 (16진수 형태로 출력, 표현해야 함)
		System.out.println("문자 : " + ch); // ch가 문자열로 출력됨 (ch의 타입에 맞추어)
		System.out.println(ch);
		System.out.println((int)ch);
		
		
		/*
		 * ch에 해당하는 유니코드를 찍고 싶다면
		 */
		int code = ch;
		System.out.println(code);
	}
}

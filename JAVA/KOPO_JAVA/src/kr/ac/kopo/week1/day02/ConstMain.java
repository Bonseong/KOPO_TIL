package kr.ac.kopo.week1.day02;

public class ConstMain {

	public static void main(String[] args) {
		System.out.println(10+20);
		System.out.println('A'+20); // 데이터 타입이 다름 -> 더 큰 타입을 따르게 되어 있음
		System.out.println(/*(int)*/'A'+20); // 묵시적 형변환
		System.out.println(12.3+/*(double)*/45);
		
		System.out.println((int)12.3+45); // 명시적 형변환 (높은 타입 -> 낮은 타입)
		
		double num = /* double */12;
		int num2 = (int)12.34; // 반드시 써주어야 함!

	}

}

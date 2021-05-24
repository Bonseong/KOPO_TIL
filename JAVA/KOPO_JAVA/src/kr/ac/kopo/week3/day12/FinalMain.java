package kr.ac.kopo.week3.day12;

import java.util.Random;

/*final*/ class Super{
	private /*final*/ int MAX = 100;
	
	public /*final*/ void info() {
		System.out.println("Super클래스에서 정의된 메소드...");
		MAX = 50; // 값 변경 금지

	}
}

class Sub extends Super{ // 상속 금지
	@Override
	public void info() { //override 금지
		System.out.println("Sub클래스에서 재정의된 메소드");
	}
}

class MyRandom extends Random{

	/**
	 * bound가 10일때 1 ~ 10사이의 난수 추출
	 * @param bound 난수 범위
	 * @return 1 ~ bound 사이의 난수
	 */
	
	@Override
	public int nextInt(int bound) {
		return super.nextInt(bound)+1;
	}
	
}

/*
class MyString extends String{
}
*/
//String 클래스는 final 클래스이므로 상속할 수 없음

public class FinalMain {
	public static void main(String[] args) {
		/*
		 * 1~100 사이의 난수를 발생시켜 출력하는 코드를 작성
		 */
		
		Random r = new MyRandom();
		int random = r.nextInt(3);
		
		System.out.println("추출된 정수 : " + random);
	}
}

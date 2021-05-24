package kr.ac.kopo.week2.day06;

// 실행클래스 : 프로그램을 실행하는 클래스
public class CarMain {

	public static void main(String[] args) {
		
		Car c = new Car();
		// heap영역에 자동차 생성, Car c : car를 가리키는 참조변수
		
		Car c2 = new Car();
		
		
		
		c.name = "소나타";
		c.price = 3200;
		c.company = "현대";
		
		
		
		c2.name = "K5";
		c2.price = 3000;
		c2.company = "기아";
		
		// c,c2는 단지 참조변수
		// c = c2 // shallow copy, 실제 가지고 있는 객체를 잊어버림, 객체에 대한 접근 불가
		
		System.out.println("모델명 : " + c.name + ", 가격 : " + c.price + "만원, 제조사 : " + c.company);
		System.out.println("모델명 : " + c2.name + ", 가격 : " + c2.price + "만원, 제조사 : " + c2.company);
		

		
		// tip : 블럭잡고 ctrl space 하면 sysout을 바로 고를 수 있음
	}

}

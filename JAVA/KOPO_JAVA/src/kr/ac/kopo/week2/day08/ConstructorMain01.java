package kr.ac.kopo.week2.day08;

class Car{
	Car(){
		System.out.println("Car() 생성자 호출");
	}
	
	Car(String s) {
		System.out.println("Car(String) 생성자 호출");
	}

	Car(int i, String s){
		System.out.println("Car(int, String) 생성자 호출");
	}
	
	void Car() { 
		System.out.println("일반 메소드 Car() 호출...");
	}
	
	/* <에러>
	 * 빨간 줄 : 문법 오류
	 * 노란 줄 : 경고 (Warning)
	 */

}

public class ConstructorMain01 {
	public static void main(String[] args) {
		Car2 c = new Car2();
		Car2 c2 = new Car2("소나타");
		Car2 c3 = new Car2(1000, "모닝");
		
		c.Car();
	}
}

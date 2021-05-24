package kr.ac.kopo.week2.day10;
class One{
	One(){
		System.out.println("One 생성자 호출...");
	}
}

class Two extends One{ //Two 클래스가 One 클래스를 상속받음
	Two(){
		super();
		System.out.println("Two 생성자 호출...");
	}
}

class Three extends Two{
	Three(){
		System.out.println("Three 생성자 호출...");
	}
}

// 자바는 항상 부모-자식 관계만 상속관계가 형성 (단일 상속)

public class ExtendsMain {

	public static void main(String[] args) {
		new Three(); // Three -> Two -> One
		
		

	}

}

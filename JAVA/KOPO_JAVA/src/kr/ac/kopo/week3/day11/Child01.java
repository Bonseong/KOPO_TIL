package kr.ac.kopo.week3.day11;

public class Child01 extends Parent {
	String name = "자식01";

	public void study() {
		System.out.println("나는 공부를 합니다");
	}

	public void sleep() {
		System.out.println("나는 잡니다");
	}

	@Override
	public void info() {
		System.out.println("Child01 클래스에서 재정의된 메소드...");

	}
}

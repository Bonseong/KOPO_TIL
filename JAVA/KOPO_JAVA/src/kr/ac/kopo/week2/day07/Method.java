package kr.ac.kopo.week2.day07;

public class Method {
	void call() {
		System.out.println("call() 메소드 호출...");
	}

	void call(int i) {
		System.out.println("call(int) 메소드 호출...");
	}

	// 클래스에서는 메소드와 파리마터만이 구분할 수 있음

	void call(double d) {
		System.out.println("call(double) 메소드 호출...");
	}
	
	void call(String s) {
		System.out.println("call(String) 메소드 호출...");
	}
	
	
	void call (String s,boolean b) {
		System.out.println("call(String, bollean) 메소드 호출");
	}
	
	void call (boolean b, String s) {
		System.out.println("call(boolean, String) 메소드 호출...");
	}
	/*
	void call(char c) {
		System.out.println("call(char) 메소드 호출...");
	}
	*/
}

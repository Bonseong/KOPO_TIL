package kr.ac.kopo.week2.day07;

/*
 * 메소드 오버로딩(Overloading)
 * : 같은 클래스내에 동명의 메소드이면서 매개변수의 개수 또는 타입이 다른 것
 */

public class MethodMain02 {
	public static void main(String[] args) {

		Method m = new Method();
		m.call();
		m.call(1);
		m.call(12.34);
		m.call("hello");
		m.call('A'); // 만약 char에 대한 정의가 없다면 묵시적 형변환 (int 출력)
		m.call("hello", true);
		m.call(true, "hello");

	}

}
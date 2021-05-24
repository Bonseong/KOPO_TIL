package kr.ac.kopo.week2.day08;

public class ConstructorMain02 {
	public static void main(String[] args) {
		Member m = new Member();
		Member m2 = new Member("홍길동");
		Member m3 = new Member("강길동", 20);
		Member m4 = new Member("박길동", 33,"AB");
		
		m.info(); // 초깃값을 디폴트가 아닌 값도 할 수 있음;
		m2.info();
		m3.info();
		m4.info();
		
	}
}

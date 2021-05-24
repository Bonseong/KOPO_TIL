package kr.ac.kopo.week3.day12.inter02;

public class UserMain {
	public static void main(String[] args) {
		TV tv = new SamsungTV(); // tv가 가리키는 객체가 무엇이든 간에 메소드 실행은 전혀 문제가 없음 -> 다형성

		tv.mute();
		tv.soundUp();
		tv.mute();
		tv.soundUp();

		tv.mute();
		tv.soundDown();

		tv.mute();
		tv.copyright();
		System.out.println("========================");

	}
}

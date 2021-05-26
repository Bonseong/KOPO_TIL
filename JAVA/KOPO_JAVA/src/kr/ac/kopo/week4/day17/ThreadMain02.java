package kr.ac.kopo.week4.day17;

/*
 	Thread 구성 2가지
 	1. Thread 클래스 상속 구현
 	2. Runnable 인터페이스를 상속
 */

class ExtendThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + 1 + "번째 인형 눈 붙이기...");
		}
	}
}

class ImplementThread implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + 1 + "번째 인형 코 만들기...");
		}
	}
}

public class ThreadMain02 {
	public static void main(String[] args) {
		ExtendThread et = new ExtendThread();

		ImplementThread it = new ImplementThread();
		Thread t = new Thread(it); // runnable를 생성자로 받는 객체를 생성해야 함

		System.out.println("감독을 시작합니다."); // 메인 자체가 쓰레드이기 때문에 가장 먼저 시작한다는 보장이 없음

		et.start();
		t.start();

		try {
			et.join(100); // 시간을 써주게 되면 해당 시간을 기다리고 BLOCK을 빠져나옴
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		for (int i = 0; i < 100; i++) {
//			System.out.println(i + 1 + "번째 감독중..."); // 쓰레드 3개 사용 (메인 자체가 쓰레드이기 때문)
//		}

		System.out.println("감독을 종료합니다.");

	}
}

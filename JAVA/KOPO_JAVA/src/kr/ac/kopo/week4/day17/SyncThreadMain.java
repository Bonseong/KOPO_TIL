package kr.ac.kopo.week4.day17;

class Sync {
	public void a() { // 같은 자원을 공유하지만, 하나의 작업이 끝날때까지는 다른 작업이 수행되지 않음
		for (int i = 0; i < 10; i++) {
			System.out.print('a');
		}
	}

	public void b() {
		for (int i = 0; i < 10; i++) {
			System.out.print('b');
		}
	}

	public void c() {
		for (int i = 0; i < 10; i++) {
			System.out.print('c');
		}
	}

	public void d() { // 동기화 블럭, 345는 반드시 함께 실행됨
		System.out.println(1);
		System.out.println(2);
		synchronized (this) {
			System.out.println(3);
			System.out.println(4);
			System.out.println(5);
		}

		System.out.println(6);
	}
}

class SyncThread extends Thread {
	private Sync sync;
	private int type;

	public SyncThread(Sync sync, int type) {
		this.sync = sync;
		this.type = type;
	}

	@Override
	public void run() {
		switch (type) {
		case 1:
			sync.a();
			break;
		case 2:
			sync.b();
			break;
		case 3:
			sync.c();
			break;
		}
	}
}

public class SyncThreadMain {

	public static void main(String[] args) {
		Sync sync = new Sync();
		SyncThread st = new SyncThread(sync, 1);
		SyncThread st2 = new SyncThread(sync, 2);
		SyncThread st3 = new SyncThread(sync, 3); // 하나의 인스턴스 객체를 3개의 쓰레드가 공유함

		st.start();
		st2.start();
		st3.start();
	}
}

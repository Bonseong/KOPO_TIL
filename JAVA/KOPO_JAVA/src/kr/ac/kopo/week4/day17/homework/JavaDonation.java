package kr.ac.kopo.week4.day17.homework;

import java.util.Random;

class Sync {

	public static int total_money = 0;
	Random rand = new Random();

	public void a() {
		int money_dontaion = 0;
		for (int i = 0; i < 10; i++) {
			int money = (rand.nextInt(10) + 1) * 1000;
			System.out.println("1번 콜센터에서 " + money + "원 보내주셨습니다.");
			money_dontaion += money;
		}
		total_money += money_dontaion;
		System.out.println("** 1번 콜센터에서 총 " + money_dontaion + "원 모금되었습니다. **");
	}

	public void b() {
		int money_dontaion = 0;
		for (int i = 0; i < 10; i++) {
			int money = (rand.nextInt(10) + 1) * 1000;
			System.out.println("2번 콜센터에서 " + money + "원 보내주셨습니다.");
			money_dontaion += money;
		}
		total_money += money_dontaion;
		System.out.println("** 2번 콜센터에서 총 " + money_dontaion + "원 모금되었습니다. **");
	}

	public void c() {
		int money_dontaion = 0;
		for (int i = 0; i < 10; i++) {
			int money = (rand.nextInt(10) + 1) * 1000;
			System.out.println("3번 콜센터에서 " + money + "원 보내주셨습니다.");
			money_dontaion += money;
		}
		total_money += money_dontaion;
		System.out.println("** 3번 콜센터에서 총 " + money_dontaion + "원 모금되었습니다. **");
	}

	public void d() {
		int money_dontaion = 0;
		for (int i = 0; i < 10; i++) {
			int money = (rand.nextInt(10) + 1) * 1000;
			System.out.println("4번 콜센터에서 " + money + "원 보내주셨습니다.");
			money_dontaion += money;
		}
		total_money += money_dontaion;
		System.out.println("** 4번 콜센터에서 총 " + money_dontaion + "원 모금되었습니다. **");

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
		case 4:
			sync.d();
			break;
		}
	}
}

public class JavaDonation {

	public static void main(String[] args) {

		Sync sync = new Sync();
		SyncThread st = new SyncThread(sync, 1);
		SyncThread st2 = new SyncThread(sync, 2);
		SyncThread st3 = new SyncThread(sync, 3); // 하나의 인스턴스 객체를 3개의 쓰레드가 공유함
		SyncThread st4 = new SyncThread(sync, 4); // 하나의 인스턴스 객체를 3개의 쓰레드가 공유함

		st.start();
		st2.start();
		st3.start();
		st4.start();

		try {
			st.join();
			st2.join();
			st3.join();
			st4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("============================");
			System.out.println("총 " + Sync.total_money + "원 모금되었습니다.");
			System.out.println("============================");
		}

	}
}
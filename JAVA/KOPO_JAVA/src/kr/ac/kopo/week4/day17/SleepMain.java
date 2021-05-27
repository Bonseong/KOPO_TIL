package kr.ac.kopo.week4.day17;

import java.util.Date;

class TimeThread extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println("현재 시간 : " + new Date().toLocaleString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}

public class SleepMain {

	public static void main(String[] args) {

		TimeThread tt = new TimeThread();
		tt.start();

		while (true) {
			System.out.println("go!!!!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		/*
		 * System.out.println("Thread가 2초동안 잠이 들겠습니다"); try { Thread.sleep(2000); }
		 * catch (Exception e) { e.printStackTrace(); }
		 * System.out.println("Thread가 깨어났습니다");
		 */
	}
}
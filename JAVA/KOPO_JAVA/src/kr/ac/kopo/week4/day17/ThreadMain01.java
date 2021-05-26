package kr.ac.kopo.week4.day17;

class AAA extends Thread {

	@Override
	public void run() {
		while (true)
			System.out.println("go!!!!");
	}

}

class BBB extends Thread {

	@Override
	public void run() {
		while (true)
			System.out.println("\t\tstop!!!!");
	}
}

public class ThreadMain01 {
	public static void main(String[] args) {
		AAA ta = new AAA();
		BBB tb = new BBB();
		
		ta.start(); // run을 실행하는 것이 아닌, start를 실행해야 함
		tb.start();
	}
}

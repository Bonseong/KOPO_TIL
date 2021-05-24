package kr.ac.kopo.week3.day11.abs02;

public abstract class HPPrinter extends Printer {

}

class HPLaserPrinter extends HPPrinter {
	@Override
	public void print() {
		System.out.println("HP 레이저프린터에서 출력중...");
	}
}

class HPInkjetPrinter extends HPPrinter {
	@Override
	public void print() {
		System.out.println("HP 잉크젯프린터에서 출력중...");
	}
}
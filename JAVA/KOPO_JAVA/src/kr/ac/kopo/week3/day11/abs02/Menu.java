package kr.ac.kopo.week3.day11.abs02;

import java.util.Scanner;

public class Menu {
	public int selectMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("LV2프린터를 선택하세요(1. LG    2. 삼성    3. HP) =>");
		int no = sc.nextInt();
		sc.nextLine();

		return no;
	}

	public void choice() {
		int type = selectMenu();
		print(type);

	}

	public void print(int no) {
		Printer p = null; // 원래는 Printer p = new Printer(); 이 와야하지만, 객체형변환이 일어나면서 문법적으로 문제가 없음

		switch (no) {
		case 1:
			p = new LGPrinter();
			break;
		case 2:
			p = new SamsungPrinter();
			break;
		case 3:
			// p = new HPInkjetPrinter(); // 변화에 둔감함 어떤 코드가 들어와도 추상클래스로서 구현 가능
			p = new HPLaserPrinter();
			break;
		}
		
		if(p != null) {
			p.print();
		}
		else {
			System.out.println("잘못 선택하셨습니다.");
		}
		
		/*
		switch (no) {
		case 1:
			LGPrinter lg = new LGPrinter();
			lg.print();
			break;
		case 2:
			SamsungPrinter sam = new SamsungPrinter();
			sam.print();
			break;
		case 3:
			HPPrinter hp = new HPPrinter();
			hp.print();
			break;
		}
		*/
	}
}

package kr.ac.kopo.week2.day07.homework_modified;

import java.util.Scanner;

public class IcecreamMarket {
	Icecream[] iceArr; // 멤버변수를 Icemarket이 기억
	Scanner sc = new Scanner(System.in); // 스캐너를 이용해 정수를 받는 것, 문자를 받는 것 각각 하나씩 만듬

	int inputInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	String inputString(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;

	}

	void doSomething() {
		// 손님 아이스크림 구매
		buy();

		// 구매정보 출력
		info();
	}

	void buy() {
		int count = inputInt("아이스크림 몇개 구입할래? : ");
		iceArr = new Icecream[count];

		for (int i = 0; i < iceArr.length; i++) {
			System.out.println("*** " + (i + 1) + "번째 아이스크림 구매정보 입력 ***");
			String name = inputString("아이스크림 : ");
			int price = inputInt("아이스크림 가격 : ");

			iceArr[i] = new Icecream(); // 객체 생성

			iceArr[i].set(name, price); // 아이스크림 배열에 입력한 값들을 넣어라, set메소드는 Icecream 클래스에 있어야 함
		}

	}

	void info() {
		System.out.println(" < 총 " + iceArr.length + "개 구매정보 출력>");
		System.out.println("번호\t아이스크림명\t아이스크림가격");
		int no = 1;
		for (Icecream ice : iceArr) {
			System.out.println(no++ + "\t" + ice.getName() + "\t\t" + ice.getPrice());
		}

		// 자신의 멤버변수를 바꾸는 순간 다 바꿔줘야 함. -> 멤버변수로 통신하기 보다 메소드로 통신하는 것이 더 좋음

	}

	/*
	 * 입력은 어디서 받을 것인가
	 */
}

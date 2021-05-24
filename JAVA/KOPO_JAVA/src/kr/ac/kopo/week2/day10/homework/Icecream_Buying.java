package kr.ac.kopo.week2.day10.homework;

import java.util.Scanner;

public class Icecream_Buying extends Icecream_Info {

	Scanner sc = new Scanner(System.in);

	private static int cnt; // 총 고객
	private static int total_price; // 총 금액
	private static int total_cnt; // 총 아이스크림 구매 갯수

	Icecream_Info[] iceArr;

	String name;
	int price;

	void buying() {

		while (true) {
			int num = inputInt("몇 개의 아이스크림을 구매하시겠습니까?");
			cnt++; // 구매 횟수 체크
			total_cnt += num;
			iceArr = new Icecream_Info[num];

			for (int i = 0; i < num; i++) {
				System.out.println((i + 1) + "번 아이스크림의 정보");
				String name = inputString("아이스크림 이름 : ");
				int price = inputInt("아이스크림 가격 : ");

				iceArr[i] = new Icecream_Info();
				iceArr[i].set(name, price);

				total_price += price;

			}
			String temp = inputString("계속 구매하시겠습니까? y/n : ");

			if (temp.equals("n")) {
				break;
			}

		}

	}

	public void printtotal() {
		System.out.println("총" + cnt + "명의 고객이 아이스크림을 구매했습니다.");
		System.out.println("총" + total_cnt + "개의 아이스크림을 판매했습니다.");
		System.out.println("총" + total_price + "원의 아이스크림을 판매했습니다.");
	}

	public int inputInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	public String inputString(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
}

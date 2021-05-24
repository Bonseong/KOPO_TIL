package kr.ac.kopo.week2.day07.homework;

import java.util.Scanner;

public class Icecream_main {
	static Icecream[] icearr;

	public static void input() {

		Scanner sc = new Scanner(System.in);

		System.out.println("몇개의 아이스크림을 구매하시겠습니까?");
		int num = sc.nextInt();
		sc.nextLine();
		icearr = new Icecream[num];

		for (int i = 0; i < num; i++) {
			System.out.println((i + 1) + "번째 아이스크림의 정보");
			System.out.println("아이스크림 명 : ");
			String name = sc.nextLine();
			System.out.println("아이스크림 가격 : ");
			int price = sc.nextInt();
			sc.nextLine();
			icearr[i] = new Icecream(name, price);
		}

	}

	public static void print() {

		int sum = 0;

		System.out.println("총 " + icearr.length + "개의 아이스크림 구매정보");
		System.out.println("번호\t이름\t가격");
		for (int i = 0; i < icearr.length; i++) {
			System.out.print((i + 1) + "\t" + icearr[i].toString());
			sum += icearr[i].price;
			System.out.println();

		}

		System.out.println(sum);
	}

	public static void main(String[] args) {
		input();
		print();

	}

}

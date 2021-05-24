package kr.ac.kopo.week2.day06.homework;

import java.util.Scanner;

public class Icecream_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 개의 아이스크림을 구입하시겠습니까?");
		int cnt = sc.nextInt();
		int sum = 0;

		Icecream_info[] icearr = new Icecream_info[cnt];
		for (int i = 0; i < cnt; i++) {

			icearr[i] = new Icecream_info();
			System.out.println((i + 1) + "번째 아이스크림의 정보");
			System.out.println("아이스크림 명 : ");
			icearr[i].name = sc.next();
			System.out.println("아이스크림 가격 : ");
			icearr[i].price = sc.nextInt();
			sum += icearr[i].price;

		}

		System.out.println("총 " + cnt + "개의 아이스크림 구매정보");
		System.out.println("번호\t이름\t가격");
		for (int i = 0; i < icearr.length; i++) {
			System.out.print((i + 1) + "\t" + icearr[i].name + "\t" + icearr[i].price);
			System.out.println();
		}
		System.out.println("총합 : " + sum);

	}

}

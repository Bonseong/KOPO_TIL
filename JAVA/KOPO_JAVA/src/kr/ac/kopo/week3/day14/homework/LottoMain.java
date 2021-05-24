package kr.ac.kopo.week3.day14.homework;

import java.util.Scanner;

/*
 * main : switch문을 통해 알고리즘 선택
 * case1
 * case2
 * case3
 * case4
 * 
 */
public class LottoMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("번호를 기입하세요.");
		System.out.println("1. set을 이용한 방법");
		System.out.println("2. array을 이용한 방법");
		System.out.println("3. list를 이용한 방법");
		System.out.println("4. map을 이용한 방법");

		int num = sc.nextInt();
		sc.nextLine();

		switch (num) {
		case 1:
			LottoType1 l1 = new LottoType1();
			l1.pickNumber();
			break;
		case 2:
			LottoType2 l2 = new LottoType2();
			l2.pickNumber();
			break;
		case 3:
			LottoType3 l3 = new LottoType3();
			l3.pickNumber();
			break;
		case 4:
			LottoType4 l4 = new LottoType4();
			l4.pickNumber();
			break;

		}

	}
}

package kr.ac.kopo.week2.day07.homework;

import java.util.Scanner;

public class Caculator_main {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째 정수 입력 : ");
		cal.num1 = sc.nextInt();
		sc.nextLine();

		System.out.print("두번째 정수 입력 : ");
		cal.num2 = sc.nextInt();
		sc.nextLine();

		cal.sum();
		cal.sub();
		cal.mul();
		cal.div();

		System.out.println();

		System.out.println(cal.num1 + " : " + cal.prime_check(cal.num1));
		System.out.println(cal.num2 + " : " + cal.prime_check(cal.num2));

	}

}

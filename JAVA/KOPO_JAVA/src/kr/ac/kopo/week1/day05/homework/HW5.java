package kr.ac.kopo.week1.day05.homework;

import java.util.Scanner;

public class HW5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (num % 2 == 0) {
			num--;
		}

		int startCol = 1;

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= (num + 1) / 2; j++) {
				if (j <= startCol) {
					System.out.print('*');
				}

			}
			System.out.println();
			if (i < (num + 1) / 2) {
				startCol++;
			} else {
				startCol--;
			}
		}

		System.out.println();
		System.out.println("----------");
		System.out.println();

		int space = 0;
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= (num + 1) / 2; j++) {
				if (j <= space || j >= num + 1 - space) {
					System.out.print('-');
				} else {
					System.out.print('*');
				}
			}
			System.out.println();
			if (i < (num + 1) / 2) {
				space++;
			} else {
				space--;
			}
		}

		System.out.println();
		System.out.println("----------");
		System.out.println();

		int space2 = 8;

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				if (j <= space2) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}

			}
			System.out.println();

			space2--;

		}

	}

}

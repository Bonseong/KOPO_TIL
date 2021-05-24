package kr.ac.kopo.week1.day05.homework;

import java.util.Scanner;
import java.util.Random;

public class HW6 {
	public static void main(String[] args) {

		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		int max = 100;
		int min = 1;
		int ans = r.nextInt(100) + 1;
		int count = 4;

		while (true) {
			System.out.println(count + "번의 기회가 남았습니다.");
			System.out.println(min + " - " + max + " : ");
			int num = sc.nextInt();

			if (ans == num) {
				System.out.println("정답입니다!");
				break;
			} else if (ans > num) {
				System.out.println("틀렸습니다.");
				min = num;
			} else if (ans < num) {
				System.out.println("틀렸습니다.");
				max = num;
			}
			count--;

			if (count < 0) {

				System.out.println("아쉽습니다.");
				System.out.println("정답은 " + ans + "입니다.");
				break;

			}

		}

	}

}

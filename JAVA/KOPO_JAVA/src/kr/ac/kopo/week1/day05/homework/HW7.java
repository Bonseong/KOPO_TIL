package kr.ac.kopo.week1.day05.homework;

import java.util.Scanner;
import java.util.Random;

public class HW7 {
	public static void main(String[] args) {

		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		int max = 100;
		int min = 1;
		int count = 10; // 컴퓨터가 맞추는걸 보기위해서
		int check = 0;

		while (true) {
			System.out.println(count + "번의 기회가 남았습니다.");
			System.out.println(min + " - " + max + " : ");

			int ans = r.nextInt((max - min) + 1) + min;

			System.out.println(ans + "이 맞습니까? / 낮으면 : 0, 정답이면 : 1 , 높으면 : 2");
			check = sc.nextInt();

			if (check == 1) {
				System.out.println("정답입니다!");
				break;

			} else if (check == 0) { 
				max = ans;
			} else if (check == 2) { 
				min = ans;
			}

			count--;

			if (count < 0) {

				System.out.println("아쉽습니다.");

				break;

			}

		}

	}

}

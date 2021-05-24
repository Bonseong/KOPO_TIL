package kr.ac.kopo.week1.day04.homework;

public class HW03 {

	public static void main(String[] args) {
		System.out.println("Q3");

		int height = 0, days = 0;

		while (true) {
			height += 5;
			days += 1;
			if (height > 100) {
				System.out.println(days + "일차 " + height + " 탈출 성공!");
				break;
			} else {
				if (height < 50) {
					height -= 1;
				} else if (height >= 50) {
					height -= 2;
				}
				System.out.println(days + "일차 " + height);

			}

		}

	}

}

package kr.ac.kopo.week3.day13.homework;

import java.util.Scanner;
import java.util.Calendar;

/* class SelectNumber
 * class Print
 * main
 */
public class MakingCalendar {
	static String[] dayArr = new String[] { "일", "월", "화", "수", "목", "금", "토" };

	public static void SelectNumber() {
		int year = 0, month = 0;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("선택하세요 1. 특정년도 2. 특정월 3. 종료 =>");
			int select = sc.nextInt();
			sc.nextLine();
			if (select == 1) {
				System.out.println("년도를 입력하세요.");
				year = sc.nextInt();
				sc.nextLine();
				for (int i = 0; i < 12; i++) {
					CalenderPrint(year, i);
				}
				break;
			} else if (select == 2) {
				System.out.println("년도를 입력하세요.");
				year = sc.nextInt();
				sc.nextLine();
				System.out.println("월을 입력하세요.");
				month = sc.nextInt() - 1;
				sc.nextLine();
				CalenderPrint(year, month);
				break;
			} else if (select == 3) {
				break;
			} else {
				System.out.println("다시 입력하세요.");

			}

		}
	}

	public static void CalenderPrint(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, 1);

		System.out.println("\t\t   < " + year + "년 " + (month + 1) + "월 >");
		for (int i = 0; i < dayArr.length; i++) {
			System.out.print(dayArr[i] + "\t");
		}
		System.out.println();
		System.out.println("===================================================");

		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		for (int i = 1; i < startDay; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= maxDay; i++) {
			cal.set(Calendar.DATE, i);

			int week1 = cal.get(Calendar.WEEK_OF_MONTH);

			System.out.print(cal.get(Calendar.DATE) + "\t");
			cal.set(Calendar.DATE, i + 1);
			int week2 = cal.get(Calendar.WEEK_OF_MONTH);
			if (week1 != week2) {
				System.out.println();
			}
		}
		System.out.println();
		// 생각해보면 2차원 배열을 사용하면 행을 주차, 열을 요일로 인덱싱을 적절히하면
		// 정말 쉽게 할 수 있을거 같은데..??
	}

	public static void main(String[] args) {
		SelectNumber();
	}

}

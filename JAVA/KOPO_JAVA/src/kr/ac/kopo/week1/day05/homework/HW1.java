package kr.ac.kopo.week1.day05.homework;

import java.util.Scanner;
import java.util.Arrays;

public class HW1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr;
		arr = new int[5];

		int arr_index = 0;

		while (true) {
			System.out.println((arr_index + 1) + "번째 정수를 입력하시오.");
			arr[arr_index] = sc.nextInt();

			if (arr[arr_index] < 0 || arr[arr_index] > 99) {
				System.out.println("0-99사이의 정수만 입력하시오.");
				arr[arr_index] = 0;
				arr_index--;
			}

			arr_index++;

			if (arr_index == 5) {
				break;
			}

		}

		System.out.println("<PRINT>");
		for (int i = 0; i < 5; i++) {
			System.out.print(arr[i] + "\t");
		}

		System.out.println();
		System.out.println("<REVERSE>");
		for (int i = 0; i < 5; i++) {
			System.out.print((arr[i] % 10) * 10 + (arr[i] / 10) + "\t");
		}

	}

}

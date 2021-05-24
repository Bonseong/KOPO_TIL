package kr.ac.kopo.week1.day05.homework;

import java.util.Arrays;
import java.util.Scanner;

public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//미완
		int[] odd_arr, even_arr;
		System.out.println("홀수의 갯수 입력 : ");
		int odd_index = sc.nextInt();
		System.out.println("짝수의 갯수 입력 : ");
		int even_index = sc.nextInt();

		odd_arr = new int[odd_index];
		even_arr = new int[even_index];

		int odd_index_length = 0;
		int even_index_length = 0;

		while (true) {
			System.out.println((odd_index_length + even_index_length) + "번째 숫자를 입력하시오.");
			int temp = sc.nextInt();

			if (temp % 2 == 0 && even_index < even_index_length) {
				even_arr[even_index_length] = temp;
				even_index_length++;
			} else {
				System.out.println("다시 입력하시오.");
			}

			if (temp % 2 != 0 && odd_index < odd_index_length) {
				odd_arr[odd_index_length] = temp;
				odd_index_length++;
			} else {
				System.out.println("다시 입력하시오.");
			}

			if (odd_arr.length + even_arr.length == odd_index + even_index) {
				System.out.println("a : " + Arrays.toString(odd_arr));
				System.out.println("b : " + Arrays.toString(even_arr));
				break;

			}

		}

	}

}

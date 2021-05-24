package kr.ac.kopo.week1.day04.homework;

import java.util.Scanner;

public class HW06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			System.out.println((i + 1) + "번째 정수를 입력하시오 : ");
			arr[i] = sc.nextInt();

		}

		int even_sum = 0;
		int odd_sum = 0;

		int[] evenarr = new int[10];
		int[] oddarr = new int[10];

		int arrindex = 0;
		int evenindex = 0;
		int oddindex = 0;

		while (arrindex < 10) {

			if (arr[arrindex] % 2 == 0) {
				evenarr[evenindex] = arr[arrindex];
				even_sum += arr[arrindex];
				arrindex++;
				evenindex++;

			} else {
				oddarr[oddindex] = arr[arrindex];
				odd_sum += arr[arrindex];
				arrindex++;
				oddindex++;

			}

		}

//			System.out.println("홀수의 목록");
//			System.out.println(Arrays.toString(oddarr));
//			System.out.println("홀수의 합 : " + odd_sum);
//			System.out.println("짝수의 목록");
//			System.out.println(Arrays.toString(evenarr));
//			System.out.println("홀수의 합 : " + even_sum); 이럴 경우, 0값이 모두 출력됨

		System.out.println("짝수의 목록");
		for (int i = 0; i < 10; i++) {
			if (evenarr[i] == 0)
				break;
			System.out.print(evenarr[i] + " ");
		}
		System.out.println();
		System.out.println("짝수의 총합 : " + even_sum);

		System.out.println();

		System.out.println("홀수의 목록");
		for (int i = 0; i < 10; i++) {
			if (oddarr[i] == 0)
				break;
			System.out.print(oddarr[i] + " ");
		}
		System.out.println();
		System.out.println("홀수의 총합 : " + odd_sum);

	}

}

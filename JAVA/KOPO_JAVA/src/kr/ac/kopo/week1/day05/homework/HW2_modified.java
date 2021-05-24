package kr.ac.kopo.week1.day05.homework;

import java.util.Scanner;

public class HW2_modified {

	public static void main(String[] args) {

		/*
		 * 굳이 짝수 배열, 홀수 배열을 만들 필요가 없음
		 * 짝수면 0번지 부터, 홀수면 length-1 부터
		 */

		/*
		 * while문을 통해서도 할 수 있음
		 * 끝날 때 : evennum과 oddnum이 서로 크로스할때
		 */

		Scanner sc = new Scanner(System.in);

		System.out.print("짝수 몇개 입력 : ");
		int evennum = sc.nextInt();
		System.out.print("홀수 몇개 입력 : ");
		int oddnum = sc.nextInt();

		int[] nums = new int[evennum + oddnum];

		/*
		 * 짝수 : nums[0] ~ nums[evennum-1]
		 * 홀수 : nums[evennum] ~ nums[nums.length-1]
		 */

		int evenindex = 0, oddindex = nums.length - 1;

		for (int i = 0; i < nums.length; i++) {
			System.out.print("num " + (i + 1) + " : ");
			int num = sc.nextInt();

			if (num % 2 == 0 && evenindex < evennum) {
				nums[evenindex++] = num;

			} else if (num % 2 == 1 && oddindex >= evennum) { // else를 사용하면 안됨
				nums[oddindex--] = num;
			} else {
				i--;
			}

		}

		System.out.println(" < 총 " + nums.length + "개 정수 출력 > ");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}

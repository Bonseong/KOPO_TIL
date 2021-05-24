package kr.ac.kopo.week1.day05.homework;

public class HW4_modified {

	public static void main(String[] args) {

		int[] nums = new int[99]; // 2~100

		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 2;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] % nums[i] == 0) {
						nums[j] = 0;
					}
				}
			}
		}

		for (int i : nums) {
			if (i != 0) {
				System.out.print(i + " ");
			}

		}

	}
}
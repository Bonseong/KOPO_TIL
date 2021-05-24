package kr.ac.kopo.week2.day07.homework;

public class Calculator {
	int num1, num2;

	void sum() {
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
	}

	void sub() {
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
	}

	void mul() {
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
	}

	void div() {
		if (num2 != 0) {
			System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		} else {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}

	boolean prime_check(int num) {
		if (num < 2) {
			System.out.println(num + " : 2보다 작습니다.");
			return false;
		}

		int[] arr = new int[num + 1];
		for (int i = 2; i <= num; i++) {
			arr[i] = i;
		}

		for (int i = 2; i * i <= num; i += 1) {
			if (arr[i] != 0) {
				for (int j = i * i; j <= num; j += i) {
					arr[j] = 0;
				}
			}
		}

		return arr[num] == 0 ? false : true;

	}
}

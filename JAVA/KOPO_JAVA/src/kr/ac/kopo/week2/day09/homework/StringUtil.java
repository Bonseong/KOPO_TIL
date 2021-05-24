package kr.ac.kopo.week2.day09.homework;

import java.util.Scanner;

public class StringUtil {
	Scanner sc = new Scanner(System.in);

	char inputChar(String msg) {
		System.out.print(msg);
		char c = sc.next().charAt(0);
		return c;
	}

	int inputInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	String inputString(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}

	boolean isUpperChar(char c) {
		if ('A' <= c && c <= 'Z') {
			return true;
		} else {
			return false;
		}
	}

	boolean isLowerChar(char c) {
		if ('a' <= c && c <= 'z') {
			return true;
		} else {
			return false;
		}
	}

	int max(int i, int j) {
		if (i > j) {
			return i;
		} else if (i < j) {
			return j;
		} else {
			return i;
		}
	}

	int min(int i, int j) {
		if (i > j) {
			return j;
		} else if (i < j) {
			return i;
		} else {
			return i;
		}
	}

	String reverseString(String str) {
		String return_str = "";
		// char[] chars = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			return_str += str.charAt(str.length() - 1 - i);
			//chars[i++] = str.charAt(str.length() - 1 - i);
		}
		return return_str;
		//return String new chars;

	}

	String toUpperString(String str) {
		String upper_output = "";
		for (int i = 0; i < str.length(); i++) {
			int tmp = (int) str.charAt(i);
			if (97 <= tmp && tmp <= 122) {
				upper_output += (char) (tmp - 32);
			} else {
				upper_output += (char) tmp;
			}
		}
		return upper_output;

	}

	String toLowerString(String str) {
		String lower_output = "";
		for (int i = 0; i < str.length(); i++) {
			int tmp = (int) str.charAt(i);
			if (65 <= tmp && tmp <= 90) {
				lower_output += (char) (tmp + 32);
			} else {
				lower_output += (char) tmp;
			}
		}
		return lower_output;
	}

}

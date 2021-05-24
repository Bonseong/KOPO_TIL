package kr.ac.kopo.week2.day09.homework;

public class StringUtil_modified {
	public static void main(String[] args) {
		String str = "hello world";

		int length = str.length();
		char[] chars = new char[length];
		str.getChars(0, length, chars, 0);

		for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
		}
		
		System.out.println(chars);
	}
	/*
	 * charAt(0) <-> charAt(6) charAt(1) <-> charAt(5) charAt(2) <-> charAt(4)
	 * charAt(3) <-> charAt(5) charAt(4)
	 * 
	 * 문자열은 변경할 수 없으니, 배열로 선언
	 */
}

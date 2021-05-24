package kr.ac.kopo.week2.day09.homework;

public class StringUtilMain {

	public static void main(String[] args) {

		StringUtil s = new StringUtil();

		System.out.println("1. isUpperChar() : 대문자 체크");
		char c = s.inputChar("문자를 입력하시오 : ");
		System.out.println(s.isUpperChar(c));

		System.out.println("2. isLowerChar() : 소문자 체크");
		c = s.inputChar("문자를 입력하시오 : ");
		System.out.println(s.isLowerChar(c));

		System.out.println("3. max() : 큰 수 반환");
		int num1 = s.inputInt("첫번째 숫자를 입력하시오 : ");
		int num2 = s.inputInt("두번째 숫자를 입력하시오 : ");
		System.out.println(s.max(num1, num2));

		System.out.println("4. min() : 작은 수 반환");
		num1 = s.inputInt("첫번째 숫자를 입력하시오 : ");
		num2 = s.inputInt("두번째 숫자를 입력하시오 : ");
		System.out.println(s.min(num1, num2));

		System.out.println("5. reverseString() : 문자열 거꾸로 변경");
		String str = s.inputString("문자열을 입력하시오 : ");
		System.out.println(s.reverseString(str));

		System.out.println("6. toUpperString() : 대문자 변경");
		str = s.inputString("문자열을 입력하시오 : ");
		System.out.println(s.toUpperString(str));

		System.out.println("7. toLowerString() : 대문자 변경");
		str = s.inputString("문자열을 입력하시오 : ");
		System.out.println(s.toLowerString(str));
	}

}

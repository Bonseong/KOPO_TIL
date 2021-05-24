package kr.ac.kopo.week2.day09.homework;

public class CheckCharMain {
	public static void main(String[] args) {
		CheckChar c = new CheckChar();
		
		System.out.println("1번");
		String strData = c.inputString("문자열을 입력하시오 : ");
		char ch = c.inputChar("문자를 입력하시오 : ");
		System.out.println(c.checkChar(strData, ch));
		
		System.out.println("2번");
		String strData2 = c.inputString("문자열을 입력하시오 : ");
		char ch2 = c.inputChar("문자를 입력하시오 : ");
		System.out.println(c.removeChar(strData2, ch2));

		
	}
}

package kr.ac.kopo.week3.day12;

import java.util.Random;

public class ExceptionMain02 {
	public static void main(String[] args) {
		System.out.println("main start....");

		Random r = new Random();
		int num = r.nextInt(3); // 0~2
		System.out.println("num : " + num);

		String str = null;
		try {
			System.out.println("첫번째 문자 : " + str.charAt(0));
			System.out.println(10 / num);
		} catch (Exception e) { // 묵시적 형변환
			e.printStackTrace(); 
		}  finally {
			System.out.println("main end....");
		}
		

		/*
		try {
			System.out.println("첫번째 문자 : " + str.charAt(0));
			System.out.println(10 / num);
		} catch (ArithmeticException | NullPointerException e) {
			e.getStackTrace(); 
		}  finally {
			System.out.println("main end....");
		}
		*/
		/*
		try {
			System.out.println("첫번째 문자 : " + str.charAt(0));
			System.out.println(10 / num);
		} catch (ArithmeticException ae) {
			ae.getStackTrace(); // 프로그램은 끝까지 실행시키되, 예외에 대한 에러메시지 표시
			// System.out.println("이유 : " + ae.getMessage()); // 예외에 대한 이유
		} catch (NullPointerException ne) {
			System.out.println("NullPointerException 진입");
		} finally {
			System.out.println("main end....");
		}
		 */
	}
}
package kr.ac.kopo.week1.day02.homework;

import java.util.Scanner;

public class day2_q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("첫 번째 정수를 입력하시오. : ");
		int num1 = sc.nextInt();
		System.out.println("첫 번째 정수는 " + num1);
		System.out.println("두 번째 정수를 입력하시오. : ");
		int num2 = sc.nextInt();
		System.out.println("두 번째 정수는 " + num2);
		
		
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
		System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
		System.out.printf(num1+ " / " + num2 + " = " + "%.2f" +"\n", (double)num1/(double)num2);
		System.out.println(num1 + " % " + num2 + " = " + (num1%num2));

	}

}

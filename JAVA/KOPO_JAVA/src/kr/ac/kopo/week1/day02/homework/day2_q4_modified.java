package kr.ac.kopo.week1.day02.homework;

import java.util.Scanner;

public class day2_q4_modified {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.println(num1>0 && num1%num2==0); //참 거짓으로 표현할때만 조건연산자 필요
		

	}

}

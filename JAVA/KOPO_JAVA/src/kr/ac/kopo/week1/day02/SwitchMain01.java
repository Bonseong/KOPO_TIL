package kr.ac.kopo.week1.day02;

import java.util.Scanner;

/*
 * 1 - 3 사이의 정수 입력 : 1
 * ONE
 * 
 * 1 - 3 사이의 정수 입력 : 2
 * TWO
 * 
 * 1 - 3 사이의 정수 입력 : 3
 * THREE
 * 
 * 1 - 3 사이의 정수 입력 : 6
 * ERROR
 */

public class SwitchMain01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("1 - 3 사이의 정수 : ");
		
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		default: //디폴트는 케이스에 해당되지 않는 경우만 실행
			System.out.println("ERROR");
			break;
		}
		
		/* 코드 블럭후 alt + 위아래 : 이동
		 * ctrl + alt + 위아래 : 복사
		 */
		
		/*
		if (num==1) {
			System.out.println("ONE");
		}else if(num==2) {
			System.out.println("TWO");
		}else if(num==3) {
			System.out.println("THREE");
		}else {
			System.out.println("ERROR");
		}
		*/

	}

}

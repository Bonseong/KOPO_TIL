package kr.ac.kopo.week1.day02.homework;

import java.util.Scanner;

public class day2_q3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("물건값을 입력하시오.");
		int price = sc.nextInt();
		System.out.println("지불한 액수를 입력하시오.");
		int pay = sc.nextInt();
		
		
		int rest = pay - price;
		
		
		if (rest>=0) {
			int cheon = rest / 1000;
			int ohbaek = rest % 1000 / 500;
			int baek = rest % 1000 % 500 / 100;
			int ohsip = rest % 1000 % 500 % 100 / 50;
			int sip = rest % 1000 % 500 % 100 % 50 / 10;
			
			System.out.println("거스름돈 : " + rest+"원");
			System.out.println("1000원 : " + cheon+"개");
			System.out.println("500원 : " + ohbaek+"개");
			System.out.println("100원 : " + baek+"개");
			System.out.println("50원 : " + ohsip+"개");
			System.out.println("10원 : " + sip+"개");
		}else {
			System.out.println(-rest + "원이 모자랍니다.");
		}
		
		
		
		System.out.println("--------두번째방법--------");
		
		if (rest>=0) {
			int cheon = rest / 1000;
			int ohbaek = rest % 1000 / 500;
			int baek = rest % 1000 % 500 / 100;
			int ohsip = rest % 1000 % 500 % 100 / 50;
			int sip = rest % 1000 % 500 % 100 % 50 / 10;
			
			System.out.println("거스름돈 : " + rest+"원");
			System.out.print(cheon > 0 ? "1000원 : "+cheon+"개"+"\n" :  "");
			System.out.print(ohbaek > 0 ? "500원 : " + ohbaek+"개"+"\n" :  "");
			System.out.print(baek > 0 ? "100원 : " + baek+"개"+"\n" :  "");
			System.out.print(ohsip > 0 ? "50원 : " + ohsip+"개"+"\n" :  "");
			System.out.print(sip > 0 ? "10원 : " + sip+"개"+"\n" :  "");
			

		
		
		}else {
			System.out.println(-rest + "원이 모자랍니다.");
		}
		

	}

}

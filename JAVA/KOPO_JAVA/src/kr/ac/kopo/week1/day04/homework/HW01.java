package kr.ac.kopo.week1.day04.homework;

import java.util.Scanner;

public class HW01 {

	public static void main(String[] args) {
		System.out.println("Q1");
		Scanner sc = new Scanner(System.in);	
		
		System.out.print("첫번째 숫자를 입력하시오 : ");
        int num1_1 = sc.nextInt();
        System.out.print("두번째 숫자를 입력하시오 : ");
        int num1_2 = sc.nextInt();
        System.out.print("세번째 숫자를 입력하시오 : ");
        int num1_3 = sc.nextInt();
       
        int big = ((num1_1 > num1_2) && (num1_1>num1_3)) ? num1_1:(num1_2>num1_3?num1_2:num1_3);
        int small = ((num1_1 < num1_2) && (num1_1<num1_3)) ? num1_1:(num1_2<num1_3?num1_2:num1_3);
        
        //int mid = ((num1_1>small && num1_1<big))? num1_1:((num1_2>small&&num1_2<big))?num1_2:num1_3;
        
        int mid = (num1_1+num1_2+num1_3)-(big+small); // 두 수를 알고 있다면, 복잡한 계산식이 필요 없음
        
        System.out.println("가장 큰 수 : " + big);
        System.out.println("중간 수 : " + mid);
        System.out.println("가장 작은 수 : " + small);

	}

}

package kr.ac.kopo.week1.day02.homework;

import java.util.Scanner;

/*
 * 집에서 출발한 시간 08시 이전 : 걸어서
 * 					  08시 15분 이전 : 버스타고
 * 					  08시 15분 이후 : 택시타고
 * 
 * 집에서 출발한 시간 입력 (8시 5분은 805입력) : 756
 * 걸어서 융기원 온다
 */

public class ExamMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("집에서 출발한 시간 입력(8시 5분은 805입력) : ");
		int time = sc.nextInt();
		System.out.println(time);

	
		
		
		if (time<800) {
			System.out.println("걸어 온다.");
		} else if (time<815) {
			System.out.println("버스를 타고 온다");
		}else if (time>=815) { //else
			System.out.println("택시를 타고 온다");
		}
}
}

package kr.ac.kopo.week1.day01;

import java.lang.System;

public class HelloMain {
	public static void main(String[] args) { 
		java.util.List list;
		
		//System : 클래스명
		java.lang.System.out.println(10.0/3.0);
		System.out.printf("%.2f\n", 10.0/3.0);

		
		System.out.printf("[%15s]%d\n", "빼빼로", 1500);
		System.out.printf("[%15s]%d\n", "뻐다코코넛", 1500);
		System.out.printf("[%15s]%d\n", "초코로만든 홈런볼", 1500); // 
		
		System.out.printf("[%-15s]%d\n", "초코로만든 홈런볼", 1500); // - : 왼쪽 정렬
		
		System.out.printf("%-15s\t%6d\n", "빼빼로", 1500);
		System.out.printf("%-15s\t%6d\n", "뻐다코코넛", 1500);
		System.out.printf("%-15s\t%6d\n", "초코로만든 홈런볼", 1500); //
		
		
		System.out.println("빼빼로"+"\t"+1500);
		System.out.println("뻐다코코넛"+"\t"+2000); //tab : 일정한 위치이내 변경함
		System.out.println("초코로만든 홈런볼"+"\t"+2000); //일반적으로 tab의 크기는 8
		
		System.out.print(10+"\n"+20+"\n");
		System.out.printf("%d%c%d", 10, '\n', 20);
		
		
	}

}

/* 
 public : 접근 제한자, String : 배열
 
 출력메소드
 System.out.print()
 System.out.println() : 줄 바꿈
 System.out.printf() : 포맷에 따라 print (jdk 1.5)
 	%[간격][]알파벳 // []:옵션
 	%[전체자리수][.소수점이하자리수]f
 	정수 : %d
 	실수 : %f
 	문자 : %c
 	문자열 : %s
 	논리값 : %b
 	
 	
 */


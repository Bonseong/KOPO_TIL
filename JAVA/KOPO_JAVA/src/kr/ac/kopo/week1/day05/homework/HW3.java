package kr.ac.kopo.week1.day05.homework;

public class HW3 {

	public static void main(String[] args) {
		//미완
		
		int num = 100;
		int prime_index = 1;
 		int[] arr = new int[num + 1];
 		int[] prime_arr = new int[num + 1];
 		
 		
 		for (int i = 2; i<=100; i++) {
 			arr[i] = i;
 			System.out.println(arr[i]);
 		}
 		
 		prime_arr[0] = 2; // 초깃값 설정이 필요할듯 ..??
 		
 		for (int i=0; i<=arr.length; i++) {
 			for (int j=0; j<=prime_index; j++) {
 				if (i%prime_arr[j]!=0) {
 					prime_arr[prime_index]=i;
 					prime_index++;
 				}
 			}
 		}
 		
/*
	본성씨.... 배열의 인덱스는 0 ~ length-1까지이자나요
	i<=arr.length; 
	프로그램 실행하다보면 에러안나나요???
*/ 		
 		
 		
 		

		
//		for (int i = 0; i <= 100; i++) {
//			if (i % 2 == 0 && i != 2) {
//				arr[i] = i;
//			}
//		}
			
//			boolean isPrime = true;
//			for (int j = 2; j * j <= i; j++) {
//				if (i % j == 0) {
//					isPrime = false;
//					break;
//				}
//			}
//			if (isPrime)
//				arr[i] = 1;
//		}
		
//		for(int i=0;i<=100;i++) {
//			System.out.println(arr[i]);
//		}
		
	}
}

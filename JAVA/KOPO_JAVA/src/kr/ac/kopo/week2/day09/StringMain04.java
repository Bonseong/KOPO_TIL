package kr.ac.kopo.week2.day09;

import java.util.Arrays;

public class StringMain04 {

	public static void main(String[] args) {
		
		String str = "hello world";
		System.out.println("str : " + str);
		
		// 부분 문자열
		String subStr = str.substring(1, 5);
		System.out.println("substring(1,5) : [" + subStr + "]"); // 원본은 변하지 않음
		
		subStr = str.substring(3); // == str.substring(3, str.length());
		System.out.println("substring(3) : [" + subStr + "]"); // 3번 인덱스부터 자르기
		
		String str1 = "hello";
		String str2 = "!!!!";
	
		// 문자열 결합
//		str = str1 + str2;
		str = str1.concat(str2);
		
		System.out.println("concat(str1, str2) 결과 : " + str);
		
		
		// 문자열 치환
		str = "hello world";
		System.out.println("replace 전 : " + str);
		str = str.replace("l","rrrrrrr");
		System.out.println("replace 후 : " + str);
		
		// 공백 제거
		str = "         hello       ";
		System.out.println("trim() 전 [" + str + "] 길이 : " + str.length());
		str=str.trim();
		System.out.println("trim() 전 [" + str + "] 길이 : " + str.length());
		
		// 대소문자 반환
		str = "Hello World!!!";
		System.out.println("str : " + str);
		System.out.println("toLowerCase() : " + str.toLowerCase());
		System.out.println("toUpperCase() : " + str.toUpperCase());
		
		// 문자기준으로 문자열 나누기
		str = "홍길동전:허균:조선시대";
		String[] strArr = str.split(":");
		System.out.println(Arrays.toString(strArr));
		
		
		String ip = "192.168.5.203";
		String[] ipArr = ip.split("\\.");
		System.out.println(Arrays.toString(ipArr));
		
		// 형 변환
		
		int num = 123;
		//String strNum = num+"";
		String strNum = String.valueOf(num); // 문자열로 변환
		System.out.println(strNum+10);

		//boolean bool = String.valueOf(true); // 문자열로 바꿨기 때문에 에러
		System.out.println(String.valueOf(true) + false); // 앞이 문자열이기 때문에 덧셈 연산이 가능함

	}

}

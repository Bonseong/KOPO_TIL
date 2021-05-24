package kr.ac.kopo.week3.day15;

import java.util.ArrayList;
import java.util.List;


/* 
     기본자료형		Wrapper클래스
     boolean		Boolean
     char			Character
     byte			Byte
     short			Short
     int			Integer
     long			Long
     float			Float
     double			Double
 */

public class WrapperMain {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		int i = 123;
		Integer i2 = new Integer(123);
		Integer i3 = 123; // auto boxing (문법적으로는 원래 올바르지 않음, 래퍼클래스를 사용하는 경우 123을 참조 자료형 형태로 바꿈)
		int i4 = new Integer(123); // auto unboxing (i4는 원래 정수, 기본자료형인데 주소값을 가리키고 있음, 래퍼클래스인 경우 가능)
		
		System.out.println("i : " + i);
		System.out.println("i2 : " + i2);
		System.out.println("i3 : " + i3);
		System.out.println("i4 : " + i4);
		
		String str = "10234"; // 둘의 차이는 리턴값
		int num = Integer.parseInt(str);  // 리턴 값이 int (기본 자료형)
		int num2 = Integer.valueOf(str); // 리턴 값이 Integer (Wrapper Class)
		System.out.println(num + " " + num2); // auto unboxing 때문에 덧셈이 이루어짐
		

	}
}

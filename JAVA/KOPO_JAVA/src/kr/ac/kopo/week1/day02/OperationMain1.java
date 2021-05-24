package kr.ac.kopo.week1.day02;

public class OperationMain1 {

	public static void main(String[] args) {
		int num = 10;
		num = num + 1; // 산술연산자의 우선순위가 더 높음
		num += 1; // 복합대입연산자
		++num; // ++은 =이 없어도 자신의 값이 변경 됨, 속도는 더 빠름
		num++;
		System.out.println(num);

		num=5;
		System.out.println(++num); // 전위증감연산자
		num=5;
		System.out.println(num++); // 후위증감연산자
		
		num=1;
		System.out.println(++num + ++num); // 피해야 할 코드, 컴파일러에 따라 해석이 달라질 수 있음
		
		
		
 
	}

}

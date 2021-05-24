package kr.ac.kopo.week3.day13;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Dog {
	private String name;
	private int age;

	Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "name : " + name + ", age : " + age;
	}

}
 

public class DateMain {
	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		System.out.println("c : " + c);

		int year = c.get(Calendar.YEAR); // 상수변수 + public이므로 접근 가능
		int month = c.get(Calendar.MONTH) + 1; // 0~11
		//int date = c.get(Calendar.DATE);
		int date = c.get(Calendar.DAY_OF_MONTH);
		int day = c.get(Calendar.DAY_OF_WEEK); // 일(1) ~ 토(7)
		
		String[] dayArr = {"","일", "월", "화", "수", "목", "금", "토"};
		
		System.out.println(year + "년 " + month + "월 " + date + "일 " + dayArr[day]); 

		// 2021년 5월 5일 무슨요일
		c.set(2021, 5-1, 5);
		day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayArr[day]);
		
		// 5월의 마지막날이 몇일?
		int lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("5월은 " + lastday + "일로 구성되어있습니다.");
		
		// 2월의 마지막날이 몇일?
		c.set(c.MONTH, 2-1);
		lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("2월은 " + lastday + "일로 구성되어있습니다.");
		
		
		Date d = c.getTime();
		
		String pattern = "yyyy년 MM월 dd일 HH시 mm분 ss초(E)";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String data = sdf.format(new Date());
		System.out.println(data);
		
		data = sdf.format(d);
		System.out.println(data);
		
		/* Dog dog = new Dog("멍이", 3); System.out.println("dog : " + dog); // 출력하는 메소드에
		 * 대해서는 내부적으로 toString을 통해 주소값 출력 System.out.println("dog : " + dog.toString());
		 * dog.toString();
		
		// 오늘은 2021년 3월 24일입니다.
		Date d = new Date();
		System.out.println("d : " + d); // toString 메소드가 오버라이드 되어 있음 -> 자신의 객체를 확인할 수 있도록

		int year = d.getYear() + 1900; // deprecated
		int month = d.getMonth() + 1;
		int date = d.getDate();
		System.out.println("오늘은 " + year + "년 " + month + "월 " + date + "일 입니다.");
		*/
	}
}
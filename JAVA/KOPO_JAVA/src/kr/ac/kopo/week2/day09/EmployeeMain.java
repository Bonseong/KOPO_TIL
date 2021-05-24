package kr.ac.kopo.week2.day09;

public class EmployeeMain {

	public static void main(String[] args) {

		//System.out.println(Employee.totalEmployee + "명");
		Employee.printTotalEmployee(); // static이기 때문에 바로 접근 가능, 클래스명.메소드로 접근
		
		//int totalEmployee=0; // 사원클래스와 관련된 변수 -> 객체지향적인 프로그래밍이라고 할 수 없음
		
		
		Employee e = new Employee("홍길동", 3200, "사원");
		e.info();
		
		Employee e2 = new Employee("강길동", 4000, "주임");
		e2.info();
		Employee e3 = new Employee("윤길동", 3600, "사원");
		e3.info();
		
		System.out.println("첫번째 사원명 : " + e.getName());
		System.out.println("두번째 사원명 : " + e2.getName());
		
		e.setSalary(3800);
		e.info();
		
		
		
	}

}

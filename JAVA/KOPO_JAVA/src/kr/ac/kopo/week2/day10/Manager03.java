package kr.ac.kopo.week2.day10;

public class Manager03 extends Employee {

	Employee[] empList; // 관리사원 목록

	Manager03(int no, String name, int salary, String grade, Employee[] empList){
		super(no, name, salary, grade); // 초기화 작업을 부모에게 맡김
		this.empList = empList;
	}
	// Employee 부모생성자에 디폴트 생성자가 없기 때문에 에러
	
	@Override 	// 부모클래스의 메소드 재정의
				// annotation @ : 코드 주석, 에러까지 잡아주는 역할
				// annotation을 사용하여 재정의가 목적이라면 반드시 써야함.
	void info() { // 메소드 오버라이딩
		super.info();
		System.out.println("=======================================");
		System.out.println("\t\t관리사원 목록");
		System.out.println("=======================================");
		for(Employee e:empList) {
			e.info();
		}
		System.out.println("=======================================");
	}
}

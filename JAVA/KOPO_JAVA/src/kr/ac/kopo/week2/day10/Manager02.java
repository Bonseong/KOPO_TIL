package kr.ac.kopo.week2.day10;

public class Manager02 extends Employee {

	Employee[] empList; // 관리사원 목록

	Manager02(int no, String name, int salary, String grade, Employee[] empList){
		// super();
		this.no = no;
		this.name = name;
		this.salary = salary;System.out.println("=======================================");
		this.grade = grade;
		this.empList = empList;
		
		//manager02는 employee 클래스에 접근할 때 private 변수에 대해 받을 수 없음
	}
	// Employee 부모생성자에 디폴트 생성자가 없기 때문에 에러
	
	@Override 	// 부모클래스의 메소드 재정의
				// annotation @ : 코드 주석, 에러까지 잡아주는 역할
				// annotation을 사용하여 재정의가 목적이라면 반드시 써야함.
	void info() { // 메소드 오버라이딩
		super.info();
		System.out.println("사원번호 : " + no + ", 사원명 : " + name + ", 연봉 : " +salary + "만원, 직급 : " + grade);
		System.out.println("=======================================");
		System.out.println("\t관리사원 목록");
		System.out.println("=======================================");
		for(Employee e:empList) {
			e.info();
		}
		System.out.println("=======================================");
	}
}

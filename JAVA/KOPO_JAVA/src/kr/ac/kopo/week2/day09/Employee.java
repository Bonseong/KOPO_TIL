package kr.ac.kopo.week2.day09;

public class Employee {
	private String name;
	private int salary;
	private String grade;
	private static int totalEmployee; 
	// 생성자를 실행할 때마다 증가시킴
	// 절대 변하지 않는 값에 대해선 final 상수변수 이용
	// static변수는 반드시 클래스명.메소드명으로 접근함
	// 멤버변수와의 구별을 위해 클래스명을 (클래스.클래스) 명으로 정의함

	Employee() {
		++Employee.totalEmployee;
	}

	Employee(String name, int salary, String grade) {
		this.name = name;
		this.salary = salary;
		this.grade = grade;
		++Employee.totalEmployee;
	}

	void info() {
		System.out.println("name : " + this.name
				+ ", salary : " + this.salary
				+ ", grade: " + this.grade);
		Employee.printTotalEmployee();
	}
	
	static void printTotalEmployee() { 
		System.out.println("총 사원수 : " + Employee.totalEmployee + "명");
		// this를 사용할 수 없음
	}
	
	// getter method
	public String getName(){ //메소드는 접근제한자 public
		return this.name;
	}
	
	public int getSalary(){
		return this.salary;
	}
	
	// setter method
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
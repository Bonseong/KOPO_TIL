package kr.ac.kopo.week2.day10;

// 사원클래스
public class Employee {

	int no;
	String name;
	int salary;
	String grade;

	Employee() {
	}

	Employee(int no, String name, int salary, String grade) {
		this.no = no;
		this.name = name;
		this.salary = salary;
		this.grade = grade;
	}

	void info() {
		System.out.println("사원번호 : " + no + ", 사원명 : " + name + ", 연봉 : " + salary + ", 직급 : " + grade);
	}

}

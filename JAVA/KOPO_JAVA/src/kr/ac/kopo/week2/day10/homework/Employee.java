package kr.ac.kopo.week2.day10.homework;

class Employee {
	int no;
	String name;
	int salary;
	String grade;
	Employee() { // source - generate constructors from superclass
		super();

	}
	Employee(int no, String name, int salary, String grade) { // source - generate constructor using Fields
		super();
		this.no = no;
		this.name = name;
		this.salary = salary;
		this.grade = grade;
	}
}

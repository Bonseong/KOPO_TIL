package kr.ac.kopo.week2.day10.homework;

public class Manager extends Employee{
	Employee[] empList;

	public Manager(int no, String name, int salary, String grade, Employee[] empList) { // source - generate constructor using Fields
		super(no, name, salary, grade);
		this.empList = empList;
	}
	
	

}

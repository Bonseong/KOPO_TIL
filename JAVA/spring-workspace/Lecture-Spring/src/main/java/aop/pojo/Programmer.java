package aop.pojo;

public class Programmer implements Employee {

	public void work() {
		Action.gotoOffice();
		System.out.println("시스템 개발");
		Action.getoffOffice();

	}

}

package aop.pojo;

public class Manager implements Employee {

	public void work() {
		Action.gotoOffice(); // 공통부의 코드를 개발자가 넣어줘야함
		System.out.println("팀원들과 회의를 함");

	}

}

package aop.pojo;

// 공통의 행동을 모아놓은 클래스
public class Action { 
	public static void gotoOffice() {
		System.out.println("출근을 합니다");
	}
	
	public static void getoffOffice() {
		System.out.println("퇴근을 합니다");
	}
}

package kr.ac.kopo.ui.total;

import kr.ac.kopo.ui.BaseUI;

public class ExitUI extends BaseUI{

	@Override
	public void execute() throws Exception {

		System.out.println("====================================");
		System.out.println("\n   통합 계좌관리 프로그램을 종료합니다.\n");
		System.out.println("====================================");
		System.exit(0);
	}
		

}

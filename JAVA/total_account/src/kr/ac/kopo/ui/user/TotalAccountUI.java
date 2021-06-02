package kr.ac.kopo.ui.user;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.ui.ITotalAccountUI;
import kr.ac.kopo.ui.total.ExitUI;
import kr.ac.kopo.ui.total.LoginUI;
import kr.ac.kopo.ui.total.RegisterUI;

public class TotalAccountUI extends BaseUI {

 
	
	@Override
	public void execute() throws Exception {
		while(true) {
			ITotalAccountUI ui = null;
			try {
				int type = menu();
				switch(type) {
				case 1:
					ui = new LoginUI();
					break;
				case 2:
					ui = new RegisterUI();
					break;
				case 0:	
					ui = new ExitUI();
					break;
				}
				
				if(ui!=null) {
					ui.execute();
				}else {
					System.out.println("잘못 선택하셨습니다.");
				}
				
			} catch (Exception e) {
				System.out.println("TotalAccountUI Exception");
			}
		}
	}

	private int menu() {
		System.out.println("------------------------------------");
		System.out.println("\t통합계좌 관리 프로그램");
		System.out.println("------------------------------------");
		System.out.println("\t1. 로그인");
		System.out.println("\t2. 회원가입");
		System.out.println("\t0. 종료");
		System.out.println("------------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		return type;
	}

}

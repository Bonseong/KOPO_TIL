package kr.ac.kopo.ui.user;

import kr.ac.kopo.ui.ITotalAccountUI;
import kr.ac.kopo.ui.total.LogoutUI;

public class UserMainUI extends UserUI {
	
	

	@Override
	public void execute() throws Exception {
		while (true) {
			System.out.println(session+"님 환영합니다.");
			ITotalAccountUI ui = null;
			try {
				int type = userMenu();
				switch (type) {
				case 1:
					ui = new DepositUI();
					break;
				case 2:
					ui = new WithdrawUI();
					break;
				case 3:
					ui = new TransferUI();
					break;
				case 4:
					ui = new AccountManagerUI();
					break;
				case 5:
					ui = new LogoutUI();
					break;				
				}

				if (ui != null) {
					ui.execute();
				} else {
					System.out.println("잘못 선택하셨습니다.");
				}

			} catch (Exception e) {
				
			}
		}
	}

	private int userMenu() {
		System.out.println("------------------------------------");
		System.out.println("\t사용자 메뉴");
		System.out.println("------------------------------------");
		System.out.println("\t1. 입금");
		System.out.println("\t2. 출금");
		System.out.println("\t3. 계좌 이체");
		System.out.println("\t4. 계좌 관리");
		System.out.println("\t5. 로그 아웃");
		System.out.println("------------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		return type;
	}
}

package kr.ac.kopo.ui.user;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.ui.ITotalAccountUI;

public class AccountManagerUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		while(true) {
			ITotalAccountUI ui = null;
			try {
				int type = accountManagerMenu();
				switch(type) {
				case 1:
					ui = new EnrollUI();
					break;
				case 2:
					ui = new SearchOneUI();
					break;
				case 3:
					ui = new SearchAllUI();
					break;
				case 4:
					ui = new UpdateUI();
					break;
				case 5:
					ui = new DeleteUI();
					break;
				case 6:
					ui = new BackUI();
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

	private int accountManagerMenu() {
		System.out.println("------------------------------------");
		System.out.println("\t계좌 관리 메뉴");
		System.out.println("------------------------------------");
		System.out.println("\t1. 계좌 생성");
		System.out.println("\t2. 계좌 상세 조회");
		System.out.println("\t3. 전체 계좌 조회");
		System.out.println("\t4. 계좌 수정");
		System.out.println("\t5. 계좌 삭제");
		System.out.println("\t6. 뒤로 가기");
		System.out.println("------------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		return type;
	}

}
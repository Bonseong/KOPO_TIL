package kr.ac.kopo.ui.user;

import kr.ac.kopo.vo.BankVO;

public class SearchByBankUI extends UserUI {

	@Override
	public void execute() throws Exception {
		BankVO newBank = new BankVO();
		String bankname = null;
		
		System.out.println("은행별 계좌 조회 서비스입니다.");
		System.out.println("원하는 은행명을 입력해주세요 : ");
		
		int num = scanInt("1. 하나  2. 신한  3. KB  4. 우리 : ");
		boolean bool = true;
		switch (num) {
		case 1:
			bankname = "HANA";
			break;
		case 2:
			bankname = "SHINHAN";
			break;
		case 3:
			bankname = "KB";
			break;
		case 4:
			bankname = "WOORI";
			break;
		default:
			bool = false;
			System.out.println("다시 확인해주세요");
		}
		
		if(bool) {
			newBank.setBankName(bankname);
			BankService.searchByBankService(newBank, session);
		}
		
		
		
	}

}

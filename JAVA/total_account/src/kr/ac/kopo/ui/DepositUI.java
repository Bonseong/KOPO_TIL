package kr.ac.kopo.ui;

import kr.ac.kopo.vo.AccountVO;

public class DepositUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		AccountVO newAcc = new AccountVO();
		
		
		
		System.out.println("출금 서비스 입니다.");
		String accNo = scanStr("계좌번호를 입력해주세요 ( - 포함) : ");
		String accPw = scanStr("계좌 비밀번호를 입력해주세요 : ");
		
		newAcc.setAccNo(accNo);
		newAcc.setAccPw(accPw);
		
		
		
		
		boolean bool = AccountService.AccountCheckService(newAcc);
		
		System.out.println(bool);
		System.out.println("aaa");
		if (bool == true) {
			System.out.println("계좌존재");
		}else {
			System.out.println("계좌가 존재하지 않음");
		}
		
		
	}
	
}

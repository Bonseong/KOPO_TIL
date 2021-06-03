package kr.ac.kopo.ui.user;

import kr.ac.kopo.vo.AccountVO;

public class DeleteUI extends UserUI{
	@Override
	public void execute() throws Exception {
		AccountVO newAcc = new AccountVO();
		System.out.println("계좌 삭제 서비스 입니다.");
		System.out.println("계좌는 잔액이 없는 계좌만 삭제할 수 있습니다.");
		
		String accNo = scanStr("계좌번호를 입력해주세요 ( - 포함) : ");
		String accPw = scanStr("계좌 비밀번호를 입력해주세요 : ");

		newAcc.setAccNo(accNo);
		newAcc.setAccPw(accPw);

		boolean chk = AccountService.AccountCheckService(newAcc, session);
		
		if (chk == true) {
			System.out.println("해당 계좌가 존재합니다");
			int balance = AccountService.BalanceCheckService(newAcc);
			if (balance==0) {
				AccountService.deleteAccountService(newAcc);
				System.out.println("계좌를 삭제했습니다.");
			} else {
				System.out.println("잔액이 있어 삭제할 수 없습니다.");
			}

		} else {
			System.out.println("해당 계좌가 존재하지 않습니다.");
		}
		
	}
}

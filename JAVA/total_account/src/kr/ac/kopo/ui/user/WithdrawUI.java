package kr.ac.kopo.ui.user;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.AccountVO;

public class WithdrawUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		AccountVO newAcc = new AccountVO();

		System.out.println("출금 서비스 입니다.");
		String accNo = scanStr("계좌번호를 입력해주세요 ( - 포함) : ");
		String accPw = scanStr("계좌 비밀번호를 입력해주세요 : ");

		newAcc.setAccNo(accNo);
		newAcc.setAccPw(accPw);

		boolean chk = AccountService.AccountCheckService(newAcc, session);

		if (chk == true) {
			System.out.println("해당 계좌가 존재합니다");

			int depositAmount = scanInt("얼마나 출금하시겠습니까?");
			int balance = AccountService.BalanceCheckService(newAcc);

			if (depositAmount > balance) {
				System.out.println("잔액이 부족합니다");
			} else {
				int chk_2 = AccountService.withdrawService(newAcc, depositAmount);

				if (chk_2 == 1) {
					System.out.println("출금이 완료되었습니다.");
				}

			}

		} else {
			System.out.println("계좌가 존재하지 않습니다.");
		}

	}

}

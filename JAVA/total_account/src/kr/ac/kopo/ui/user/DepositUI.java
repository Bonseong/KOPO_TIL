package kr.ac.kopo.ui.user;

import kr.ac.kopo.vo.AccountVO;

public class DepositUI extends UserUI {

	@Override
	public void execute() throws Exception {

		AccountVO newAcc = new AccountVO();

		System.out.println("입금 서비스 입니다.");
		String accNo = scanStr("계좌번호를 입력해주세요 ( - 포함 ) : ");
		String accPw = scanStr("계좌 비밀번호를 입력해주세요 : ");

		newAcc.setAccNo(accNo);
		newAcc.setAccPw(accPw);

		boolean bool = AccountService.AccountCheckService(newAcc, session);

		if (bool == true) {
			System.out.println("해당 계좌가 존재합니다");
			int depositAmount = scanInt("얼마나 입금하시겠습니까? : ");
			if (depositAmount > 0) {

				int chk = AccountService.depositService(newAcc, depositAmount);
				if (chk == 1) {
					System.out.println("입금이 완료되었습니다.");
				}
			}else {
				System.out.println("입력하신 값이 올바르지 않습니다.");
			}

		} else {
			System.out.println("계좌가 존재하지 않습니다.");
		}

	}

}

package kr.ac.kopo.ui.user;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.AccountVO;

public class TransferUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		AccountVO newAcc = new AccountVO();

		System.out.println("계좌이체 서비스 입니다.");

		String accNo = scanStr("계좌번호를 입력해주세요 ( - 포함) : ");
		String accPw = scanStr("계좌 비밀번호를 입력해주세요 : ");

		newAcc.setAccNo(accNo);
		newAcc.setAccPw(accPw);

		boolean bool = AccountService.AccountCheckService(newAcc, session);

		if (bool) {
			System.out.println("해당 계좌가 존재합니다");
			String acc = scanStr("이체할 계좌번호를 입력해주세요 ( - 포함) : ");

			boolean bool_2 = AccountService.AccountCheckService(acc);

			if (!newAcc.getAccNo().equals(acc)) { // 동일한 계좌 입력했는지
				if (bool_2) {
					int transferAmount = scanInt("얼마나 이체하시겠습니까? : ");
					int balance = AccountService.BalanceCheckService(newAcc);

					if (balance > 0 && transferAmount < balance) {
						int chk = AccountService.transferService(newAcc, acc, transferAmount);
						if (chk == 1) {
							System.out.println("이체에 성공했습니다.");
						} else {
							System.out.println("이체에 실패했습니다.");
						}
					} else { // 잔액이 부족할 경우
						System.out.println("잔액이 부족합니다");
					}
				} else {
					System.out.println("상대 계좌가 존재하지 않습니다.");
				}
			} else {
				System.out.println("동일한 계좌에는 이체하실 수 없습니다.");
			}
		} else {
			System.out.println("본인 소유의 계좌가 존재하지 않습니다.");
		}

	}
}

package kr.ac.kopo.ui.user;

import kr.ac.kopo.vo.AccountVO;

public class UpdateUI extends UserUI {
	@Override
	public void execute() throws Exception {

		AccountVO newAcc = new AccountVO();


		System.out.println("계좌 수정 서비스 입니다.");
		System.out.println("변경하실 정보를 선택해주세요");
		int num = scanInt("1. 계좌비밀번호  2. 계좌별칭 : ");

		switch (num) {
		case 1:
			
			if (checkIdPw()) {
				String new_pw = scanStr("변경할 비밀번호를 입력해주세요 : ");
				
				if (new_pw.equals(scanStr("비밀번호를 다시 입력해주세요 : "))) {
					{
						newAcc.setAccPw(new_pw);
						AccountService.updatePasswordService(newAcc);
					}
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}

			}else {
				System.out.println("입력하신 정보가 올바르지 않습니다.");
			}
			break;
		case 2:
			if(checkIdPw()) {
				String new_nickname = scanStr("변경할 별칭을 입력하세요 : ");
				newAcc.setAccNickname(new_nickname);
				AccountService.updateNicknameService(newAcc);
			} else {
				System.out.println("입력하신 정보가 올바르지 않습니다.");
			}
			break;
			
		
		}
	}
	
	public boolean checkIdPw() throws Exception {
		AccountVO newAcc = new AccountVO();

		String acc = scanStr("비밀번호를 변경할 계좌번호를 입력해주세요 : ");
		String pw = scanStr("비밀번호를 입력해주세요 : ");
		newAcc.setAccNo(acc);
		newAcc.setAccPw(pw);
		boolean bool = AccountService.AccountCheckService(newAcc, session);
		return bool;
		
	}
}

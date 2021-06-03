package kr.ac.kopo.ui.user;

import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.User_InfoVO;

public class SearchOneUI extends UserUI {
	@Override
	public void execute() throws Exception {

		User_InfoVO newUser = new User_InfoVO();
		AccountVO newAcc = new AccountVO();

		System.out.println("계좌 상세 조회 서비스입니다.");
		String acc = scanStr("계좌 번호를 입력해주세요 : ");
		String pw = scanStr("비밀번호를 입력해주세요 : ");

		newUser.setId(session);
		newAcc.setAccPw(pw);
		newAcc.setAccNo(acc);

		boolean bool = AccountService.searchOneService(newUser, newAcc);

		if(!bool) {
			System.out.println("입력하신 본인 소유 계좌가 존재하지 않습니다.");
		}
	}
}

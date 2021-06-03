package kr.ac.kopo.ui.user;

import kr.ac.kopo.vo.AccountVO;

public class SearchTransferLogUI extends UserUI{

	@Override
	public void execute() throws Exception {
		AccountVO newAcc = new AccountVO();
		
		System.out.println("거래 내역 조회 서비스입니다.");
		String acc = scanStr("계좌 번호를 입력해주세요 : ");
		String pw = scanStr("비밀번호를 입력해주세요 : ");
		
		
		newAcc.setAccNo(acc);
		newAcc.setAccPw(pw);
		
		boolean bool = AccountService.AccountCheckService(newAcc, session);
		
		if(bool) {
			AccountService.searchTransferLogService(newAcc, session);
		}else {
			System.out.println("입력하신 본인 소유 계좌가 존재하지 않습니다.");
		}
	}
	
}

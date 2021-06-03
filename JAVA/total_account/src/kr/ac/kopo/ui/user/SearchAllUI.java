package kr.ac.kopo.ui.user;

import kr.ac.kopo.vo.User_InfoVO;

public class SearchAllUI extends UserUI {
	@Override
	public void execute() throws Exception {
		
		User_InfoVO newUser = new User_InfoVO();
		System.out.println("전체 계좌 조회 서비스입니다.");

		newUser.setId(session);

		AccountService.searchAllService(newUser);

	}
}

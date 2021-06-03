package kr.ac.kopo.ui.total;

import kr.ac.kopo.ui.user.TotalAccountUI;

public class LogoutUI extends TotalUI{

	@Override
	public void execute() throws Exception {
		System.out.println("로그아웃 하였습니다.");
		TotalAccountUI TotalAccountUI = new TotalAccountUI();
		session = null;
		TotalAccountUI.execute();
	}

}

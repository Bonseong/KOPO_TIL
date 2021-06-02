package kr.ac.kopo.ui.user;

import kr.ac.kopo.ui.BaseUI;

public class BackUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		UserUI userui = new UserUI();
		userui.execute();
	}

}

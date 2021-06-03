package kr.ac.kopo.ui.user;

public class BackUI extends UserUI{

	@Override
	public void execute() throws Exception {
		UserMainUI userui = new UserMainUI();
		userui.execute();
	}

}

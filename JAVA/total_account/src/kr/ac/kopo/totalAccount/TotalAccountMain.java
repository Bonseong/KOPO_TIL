package kr.ac.kopo.totalAccount;

import kr.ac.kopo.ui.user.TotalAccountUI;

public class TotalAccountMain {
	public static void main(String[] args) {
		TotalAccountUI ui = new TotalAccountUI();
		try {
			ui.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

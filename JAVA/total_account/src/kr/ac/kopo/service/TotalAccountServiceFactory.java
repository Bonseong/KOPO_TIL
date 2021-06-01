package kr.ac.kopo.service;

public class TotalAccountServiceFactory {

	private static User_InfoService User_InfoService;

	public static User_InfoService getInstance() {
		if (User_InfoService == null)
			User_InfoService = new User_InfoService();
		return User_InfoService;

	}
}

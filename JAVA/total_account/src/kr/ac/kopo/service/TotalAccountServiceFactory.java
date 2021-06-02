package kr.ac.kopo.service;

public class TotalAccountServiceFactory {

	private static User_InfoService User_InfoService;
	private static AccountService AccountService;
	private static BankService BankService;
	private static TransferService TransferService;
	
	public static User_InfoService getInstance() {
		if (User_InfoService == null)
			User_InfoService = new User_InfoService();
		return User_InfoService;

	}
	
	public static AccountService getInstance2() {
		if (AccountService == null)
			AccountService = new AccountService();
		return AccountService;
	}
	
	public static BankService getInstance3() {
		if (BankService == null)
			BankService = new BankService();
		return BankService;

	}
	
	public static TransferService getInstance4() {
		if (TransferService == null)
			TransferService = new TransferService();
		return TransferService;
	}
}
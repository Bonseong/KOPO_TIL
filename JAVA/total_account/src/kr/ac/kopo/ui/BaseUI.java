package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.service.AccountService;
import kr.ac.kopo.service.BankService;
import kr.ac.kopo.service.TotalAccountServiceFactory;
import kr.ac.kopo.service.TransferService;
import kr.ac.kopo.service.User_InfoService;

public abstract class BaseUI implements ITotalAccountUI{
	private Scanner sc;
	protected User_InfoService User_InfoService;
	protected AccountService AccountService;
	protected BankService BankService;
	protected TransferService TransferService;
	
	public static String session = null;

	
	public BaseUI(){
		sc = new Scanner(System.in);
		
		
		User_InfoService = TotalAccountServiceFactory.getInstance();
		AccountService = TotalAccountServiceFactory.getInstance2();
		BankService = TotalAccountServiceFactory.getInstance3();
		TransferService =  TotalAccountServiceFactory.getInstance4();

		
		
	}
	
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
	
	protected int scanInt(String msg) {
		int num = Integer.parseInt(scanStr(msg));
		return num;
	}
	
	
}

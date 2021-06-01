package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.service.TotalAccountServiceFactory;
import kr.ac.kopo.service.User_InfoService;
import kr.ac.kopo.service.AccountService;

public abstract class BaseUI implements ITotalAccountUI{
	private Scanner sc;
	protected User_InfoService User_InfoService;
	protected AccountService AccountService;
	
	public BaseUI(){
		sc = new Scanner(System.in);
		User_InfoService = TotalAccountServiceFactory.getInstance();
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

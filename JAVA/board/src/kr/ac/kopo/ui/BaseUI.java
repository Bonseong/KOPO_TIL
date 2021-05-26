package kr.ac.kopo.ui;
// 키보드로 입력받는 공통의 메소드 구현
// 직접 execute 하지는 않음 -> 추상클래스로 구현
import java.util.Scanner;

import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.service.BoardServiceFactory;

public abstract class BaseUI implements IBoardUI{
	private Scanner sc;
	protected BoardService service;
	
	public BaseUI() {
		sc = new Scanner(System.in);
		//service = new BoardService(); // BoardService 객체는 단 한개만 존재해야함 -> static
		service = BoardServiceFactory.getInstance();
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

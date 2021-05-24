package kr.ac.kopo.week3.day13;

import java.util.Scanner;

/*
 * 등록할 ID를 입력하세요 : hello1234
 * ID는 최대 8글자만 가능합니다.
 * 
 * 등록할 ID를 입력하세요 : hello123
 * ID를 등록하였습니다.
 */

public class ExceptionMain06 {
	
	public static void register() throws CheckIDException {
		Scanner sc = new Scanner(System.in);
		System.out.print("등록할 ID를 입력하세요 : ");
		String id = sc.nextLine();
		
		if(id.length()>8)
			throw new CheckIDException("ID는 최대 8글자만 가능합니다."); // 예외가 발생했으니 던져라
		
		System.out.println("ID를 등록하였습니다");
	}
	
	public static void main(String[] args) {
		
		
		try {
			register();
		}catch(Exception e) {
			System.out.println(e.getMessage()); // 에러가 발생하지만, 어떤 에러인지는 알려주진 않음 -> 원래 에러가 아니기 때문에
		}
		
		
		
		/*
		if(id.length()>8) {
			System.out.println("ID는 최대 8글자만 가능합니다.");
		}else {
			System.out.println("ID를 등록하였습니다.");
		}
		*/
		
		
		
	}
}

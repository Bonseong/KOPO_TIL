package kr.ac.kopo.week3.day13.homework;

import java.util.Scanner;

public class LottoMain {

	public static void lottoNumber() throws LottoNumberException{
		Scanner sc = new Scanner(System.in);
		System.out.println("좋아하는 로또 번호를 입력하세요");
		int num = sc.nextInt();
		sc.nextLine();
		if (num < 1 || num > 45) {
			throw new LottoNumberException("1 - 45사이만 가능합니다. " + num + "은 올바르지 않습니다.");
	
		}System.out.println(num+"을 포함해서 로또번호를 추출하겠습니다.");
	}

	
	public static void main(String[] args) {
		try {
			lottoNumber();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

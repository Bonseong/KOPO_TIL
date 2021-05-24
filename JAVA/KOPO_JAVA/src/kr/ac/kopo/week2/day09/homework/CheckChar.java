package kr.ac.kopo.week2.day09.homework;

import java.util.Scanner;

public class CheckChar {
	Scanner sc = new Scanner(System.in);

	String inputString(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}

	char inputChar(String msg) {
		System.out.print(msg);
		char c = sc.next().charAt(0);
		return c;
	}

	public static int checkChar(String strData, char ch) {
		int cnt = 0;
		for (int i = 0; i < strData.length(); i++) {
			if (strData.charAt(i) == ch) {
				cnt++;

			}
		}
		return cnt;
	}

	
	public String removeChar(String oriStr, char delChar) {
		String txt = "";
		
		for (int i=0; i<oriStr.length(); i++) {
			if(oriStr.charAt(i)!=delChar) {
				txt+=oriStr.charAt(i);
			}
		}
		return txt;
		
	}


}

package kr.ac.kopo.test;

import java.util.Random;

import kr.ac.kopo.vo.BankVO;

public class test {
	public static void main(String[] args) {
		
		System.out.println(makeRandomAccNo(newBank));
	
		
		
		
		
	}
	
	public String makeRandomAccNo(BankVO newBank) {
		Random random = new Random();
		StringBuilder sql = new StringBuilder();

		String bankname = newBank.getBankName();
		if (bankname.equals("HANA")) {
			sql.append("111");
		}
		if (bankname.equals("SHINHAN")) {
			sql.append("222");
		}
		if (bankname.equals("KB")) {
			sql.append("333");
		}
		if (bankname.equals("WOORI")) {
			sql.append("444");
		}

		sql.append('-');

		for (int i = 0; i < 3; i++) {
			sql.append(random.nextInt(9));

		}

		sql.append('-');

		for (int i = 0; i < 3; i++) {
			sql.append(random.nextInt(9));
		}
		return (sql.toString());
	}
}

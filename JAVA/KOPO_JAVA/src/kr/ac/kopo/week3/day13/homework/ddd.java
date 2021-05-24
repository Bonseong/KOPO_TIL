package kr.ac.kopo.week3.day13.homework;

import java.util.Calendar;

public class ddd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();

		int year=2021, month=3;
		cal.set(year, month, 1);

		int i=30;
		cal.set(Calendar.DATE, i);
		System.out.print(cal.get(Calendar.DATE) + "\t");
		cal.set(Calendar.DATE, i + 1);
		System.out.print(cal.get(Calendar.DATE) + "\t");
	}

}

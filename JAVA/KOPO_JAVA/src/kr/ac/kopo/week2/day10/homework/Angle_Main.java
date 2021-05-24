package kr.ac.kopo.week2.day10.homework;

import java.util.Scanner;

public class Angle_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("도형을 선택하세요(1. 직사각형, 2. 정사각형, 3.삼각형, 4.원) : ");
		int num = sc.nextInt();
		sc.nextLine();

		Angle a = new Angle();

		switch (num) {
		case 1:
			a.quadrangle();
			break;
		case 2:
			a.square();
			break;
		case 3:
			a.triangle();
			break;
		case 4:
			a.circle();
			break;

		}

	}

}

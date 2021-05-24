package kr.ac.kopo.week3.day11.homework;

import java.util.Scanner;

public class Angle_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("도형을 선택하세요(1. 직사각형, 2. 정사각형, 3.삼각형, 4.원) : ");
		int num = sc.nextInt();
		sc.nextLine();

		switch (num) {
		case 1:
			Quadrangle q = new Quadrangle();
			q.print();
			break;
		case 2:
			Square s = new Square();
			s.print();
			break;
		case 3:
			Triangle t = new Triangle();
			t.print();
			break;
		case 4:
			Circle c = new Circle();
			c.print();
			break;

		}

	}

}

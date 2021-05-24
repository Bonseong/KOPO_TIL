package kr.ac.kopo.week2.day10.homework;

import java.util.Random;

public class Angle {

	Random r = new Random();
	int num1;
	int num2;

	public void quadrangle() {
		num1 = r.nextInt(9) + 2;
		num2 = r.nextInt(9) + 2;
		System.out.println("가로 " + num1 + ", 세로 " + num2 + "의 직사각형 면적은 " + (num1 * num2) + "입니다.");

	}

	public void square() { // 직사각형의 하나로 생각할수도 있음
		num1 = r.nextInt(9) + 2;
		System.out.println("가로 " + num1 + "의 정사각형 면적은 " + (num1 * num1) + "입니다.");

	}

	public void triangle() {
		num1 = r.nextInt(9) + 2;
		num2 = r.nextInt(9) + 2;
		System.out.println("가로 " + num1 + ", 높이 " + num2 + "의 삼각형 면적은 " + (num1 * num2) / 2 + "입니다.");
	}

	public void circle() {
		num1 = r.nextInt(9) + 2;
		System.out.printf("반지름 " + num1 + "의 원 면적은 " + "%.3f" + "입니다.", (num1 * num1) * Math.PI);

	}
}

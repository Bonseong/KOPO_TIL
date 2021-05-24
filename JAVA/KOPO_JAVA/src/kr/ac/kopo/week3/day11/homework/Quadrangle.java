package kr.ac.kopo.week3.day11.homework;

public class Quadrangle extends Length{

	@Override
	public void print() {
		int w = getWidth();
		int h = getHeight();
		System.out.println("가로 " + w + ", 세로 " + h + "의 직사각형 면적은 " + (w * h) + "입니다.");
		
	}
	
}

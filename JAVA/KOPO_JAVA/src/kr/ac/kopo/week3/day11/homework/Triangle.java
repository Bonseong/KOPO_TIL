package kr.ac.kopo.week3.day11.homework;

public class Triangle extends Length{

	@Override
	public void print() {
		int h = getHeight();
		int w = getWidth();
		System.out.println("가로 " + w + ", 높이 " + h + "의 삼각형 면적은 " + (w * h) / 2 + "입니다.");
	}

}

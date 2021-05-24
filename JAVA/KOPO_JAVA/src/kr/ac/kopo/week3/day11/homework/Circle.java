package kr.ac.kopo.week3.day11.homework;

public class Circle extends Length{

	@Override
	public void print() {
		int r = getHeight();
		System.out.printf("반지름 " + r + "의 원 면적은 " + "%.3f" + "입니다.", (r * r) * Math.PI);
		
	}

}



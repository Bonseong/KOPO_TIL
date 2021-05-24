package kr.ac.kopo.week3.day11.homework;

import java.util.Random;

public abstract class Length {
	private int height; // 높이
	private int width; // 너비

	public Length() {
		height = 0;
		width = 0;
	}
	
	public abstract void print(); // 모든 도형들은 반드시 print 메소드를 가져야 함
	
	// getter
	public int getHeight() {
		Random r = new Random();
		int num = r.nextInt(10) + 1;
		return num;
		
	}
	
	public int getWidth() {
		Random r = new Random();
		int num = r.nextInt(10) + 1;
		return num;
	}
	
}

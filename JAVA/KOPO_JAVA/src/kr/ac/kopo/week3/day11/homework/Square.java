package kr.ac.kopo.week3.day11.homework;

public class Square extends Length{

	@Override
	public void print() {
		int w = getWidth();
		System.out.println("가로 " + w + "의 정사각형 면적은 " + (w * w) + "입니다.");
		
	}

	/* 정사각형은 직사각형에 포함되기 때문에 상속의 관계로 봐야하나 싶었지만
	 * getWidth나 getHeight는 각각 w 값에 상관 없이 h값을 바꿀 수 있고, h 값에 상관 없이 w 값을 바꿀 수 있는 메서드이다.
	 * 정사각형은, w값에 상관 없이 h값을 마음대로 바꿀 수 없다.
	 * 따라서 상속의 관계라고 보기는 어렵다..??
	 */
}

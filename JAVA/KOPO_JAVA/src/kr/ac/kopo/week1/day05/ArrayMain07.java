package kr.ac.kopo.week1.day05;

public class ArrayMain07 {

	public static void main(String[] args) {
		int[] a = { 10, 20, 30, 40, 50 };
		// a배열의 모든 요소에 100을 더하자

		for (int num : a) {
			num += 100;
		}
		// 하지만, a배열 자체는 변하지 않음, num은 a의 배열 요소 중 하나를 빌려다 쓰는 것
		// 값 수정할시에, 사용하지 말자 (단순 읽기용) -> index 활용

		/*
		 * for (int i=0; i<a.length; i++) { a[i] = a[i]+100; }
		 * 
		 */

		for (int num : a) {
			System.out.println(num);
		}

	}

}

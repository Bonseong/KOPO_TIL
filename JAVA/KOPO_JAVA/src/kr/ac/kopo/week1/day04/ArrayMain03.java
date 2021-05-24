package kr.ac.kopo.week1.day04;

public class ArrayMain03 {
	public static void main(String[] args) {
		//int[][] arr = new int[2][4]; // 초기화를 위해 생성자 new가 필요
		int [][]arr = new int[2][]; // 1차원 배열에 대해 원소가 존재하지 않으므로, 에러
		arr[0] = new int[5];
		arr[1] = new int[3];

		System.out.println("arr : " + arr);
		System.out.println("arr.length : " + arr.length);

		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] : " + arr[i]); // 주소값 출력
			System.out.println("arr[" + i + "] : " + arr[i].length);
		}
	}
}

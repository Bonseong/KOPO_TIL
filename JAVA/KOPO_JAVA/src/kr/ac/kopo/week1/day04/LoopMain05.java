package kr.ac.kopo.week1.day04;

public class LoopMain05 {

	public static void main(String[] args) {
		loop01: for(int i =1; i<=3; i++) {
			for(int j = 1 ; j<=5; j++) {
				if(j==3) {
					break loop01; // 탈출조건
				}
				System.out.print(j);
			}
			System.out.println();
		}
		
	}

}

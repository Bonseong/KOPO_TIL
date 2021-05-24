package kr.ac.kopo.week1.day03;

/*
 * 1>
 * 	12345
 * 	23456
 * 	34567
 * 	45678
 * 	56789
 * 
 * 2>
 * 	56789
 * 	45678
 * 	34567
 * 	23456
 * 	12345
 * 
 * 3>
 * 	*****
 * 	****
 * 	***
 * 	**
 * 	*
 * 
 * 4>
 * *
 * **
 * ***
 * ****
 * *****
 * ****
 * ***
 * **
 * *
 * 
 * 5>
 * *****
 *  ****
 *   ***
 *    **
 *     *
 *    **
 *   ***
 *  ****
 * *****
 * 
 * 6>
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 * 
 * 7>
 * 
 *       *
 *      ***
 *     *****
 *    *******
 *   *********
 *    *******
 *     *****
 *      ***
 *       *
 *       
 * 8>
 * 	 *_______*
 *   **_____**
 *   ***___***
 *   ****_****
 *   *********
 *   ****_****
 *   ***___***
 *   **_____**
 *   *_______*
 *   
 *   
 * 
 */

public class ExamMain01 {

	public static void main(String[] args) {

		System.out.println("1번");
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < i + 4; j++) {
				System.out.print(j);
			}
			System.out.println("");

		}
		System.out.println("---------------------");

		System.out.println("2번");

		for (int i = 6; i > 1; i--) {
			for (int j = i - 1; j < i + 4; j++) {
				System.out.print(j);
			}
			System.out.println("");
		}
		System.out.println("---------------------");

		System.out.println("3번");

		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}

		System.out.println("---------------------");

		System.out.println("4번");

		for (int i = 1; i < 10; i++) {
			if (i <= 5) {
				for (int j = 0; j < i; j++) {
					System.out.print('*');
				}
				System.out.println();

			} else {
				for (int j = 5; j > i - 5; j--) {
					System.out.print('*');
				}
				System.out.println();
			}
		}

		System.out.println("---------------------");

		System.out.println("5번");

		int startCol=1;
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j < startCol) {
					System.out.print('-');
				} else {
					System.out.print('*');
				}
			}
			System.out.println();
			if (i < 5) {
				startCol++;
			} else {
				startCol--;
			}
		}
			
		
		
		/*
		 * int star = 5;
		 * 
		 * for (int i = 1; i<=9; i++) { for(int j=1; j<=5-star; j++) {
		 * System.out.print("-"); } for (int j=1; j<=star; j++) { System.out.print("*");
		 * } System.out.println();
		 * 
		 * if(i<5) { star--; } else { star++; } }
		 */

		/*
		 * for (int i = 1; i < 10; i++) { if (i <= 5) { for (int a = 0; a < i - 1; a++)
		 * { System.out.print(" "); }
		 * 
		 * for (int j = 5; j >= i; j--) { System.out.print('*'); } System.out.println();
		 * 
		 * } else { for (int b = 5; b > i - 4; b--) { System.out.print(" "); } for (int
		 * j = 5; j <= i; j++) {
		 * 
		 * System.out.print('*'); } System.out.println(); }
		 * 
		 * 
		 * for5+if1 for3+if2 for3+if1 for2+if2
		 * 
		 * 
		 * }
		 */

		System.out.println("---------------------");

		System.out.println("6번");

		for (int i = 9; i > 0; i--) {
			for (int j = 9 - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int k = i * 2 - 1; k > 0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("---------------------");

		System.out.println("7번");

		int n = 1;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 5 - n; j++) {
				System.out.print("-");
			}
			for (int j = 1; j <= 2 * n - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
			if (i < 5) {
				n++;
			} else {
				n--;
			}
		}
		
		
//		for (int i = 0; i < 9; i++) {
//			if (i < 5) {
//
//				for (int j = 1; j < 5 - i; j++) {
//					System.out.print(" ");
//				}
//				for (int k = 0; k < i * 2 + 1; k++) {
//					System.out.print("*");
//				}
//				System.out.println();
//
//			} else {
//
//				for (int j = 4 - i; j < 0; j++) {
//					System.out.print(" ");
//				}
//				for (int k = (9 - i) * 2 - 1; k > 0; k--) {
//					System.out.print("*");
//				}
//				System.out.println();
//
//			}
//		}

	}

}

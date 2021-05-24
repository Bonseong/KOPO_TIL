package kr.ac.kopo.week1.day03;

public class ExamMain02 {

	public static void main(String[] args) {

		System.out.println("---------------------");
		System.out.println("6th");

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
		System.out.println("7th");

		for (int i = 0; i < 9; i++) {
			if (i < 5) {

				for (int j = 1; j < 5 - i; j++) {
					System.out.print(" ");
				}
				for (int k = 0; k < i * 2 + 1; k++) {
					System.out.print("*");
				}
				System.out.println();

			} else {

				for (int j = 4 - i; j < 0; j++) {
					System.out.print(" ");
				}
				for (int k = (9 - i) * 2 - 1; k > 0; k--) {
					System.out.print("*");
				}
				System.out.println();

			}
		}

		System.out.println("---------------------");
		System.out.println("8th");
		
		
		int star = 1;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j <= star || j >= 10 - star) {
					System.out.print("*");
				} else{
					System.out.print("-");
				}
			}
			System.out.println();
			if (i < 5) {
				star++;
			} else {
				star--;
			}
		}

//		int star=1;
//		for(int i=1; i<=9;i++) {
//			for(int j=1; j<=9; j++) {
//				if(j<=star) {
//					System.out.print("*");
//				}else if(j< 10-star) {
//					System.out.print("-");
//				}else {
//					System.out.print("*");
//				}
//				
//			}
//			System.out.println();
//			if(i<5) {
//				star++;
//			}else {
//				star--;
//			}
//		}
		
//		int blank = 9;
//		int dot = 0;
//
//		for (int i = 1; i <= 9; i++) {
//			if (i <= 5) {
//				blank -= 2;
//				dot++;
//			} else {
//				blank += 2;
//				dot--;
//			}
//
//			for (int j = 1; j <= 9; j++) {
//				if (j <= dot)
//					System.out.print("*");
//				else if (j <= dot + blank)
//					System.out.print("-");
//				else
//					System.out.print("*");
//			}
//			System.out.println();
//
//		}

	}
}
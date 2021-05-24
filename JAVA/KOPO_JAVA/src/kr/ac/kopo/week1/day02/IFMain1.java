package kr.ac.kopo.week1.day02;

public class IFMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a= 5, b=5;
		
		//System.out.println(a>b ? a:(a<b? b:0));
		
		
		// 다중 if문
		if (a > b) {
			System.out.println(a);
		} else if (a < b) {
			System.out.println(b);
		} else {
			System.out.println(0);
		}
		
		
		/*
		if (a >= b) {
			if (a == b) {
				System.out.println(0);
			} else {
				System.out.println(a);
			}
		} else {
			System.out.println(b);
		}
		 */
		
		
		// 중첩된 if-else문
		/*
			if (a > b) {
				System.out.println(a);
			} else {
				if (a < b) {
					System.out.println(b);
				} else {
				}
			}
		*/
		
		/*
		 * a가 b보다 크다면 a, 작다면 b, 같다면 0
		 */
		
		
		
		
		/*
		System.out.println("MAX : "+ (a>b?a:b));
		*/
		
		/*
		if (a > b) {
			System.out.println("MAX : " + a);
		} else {
			System.out.println("MAX : " + b);
		}
		*/
		
		//clrl + shift + f : if문을 자동 포맷팅해줌
		 
	}

}

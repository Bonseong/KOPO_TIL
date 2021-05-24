package kr.ac.kopo.week1.day05;

import java.util.Arrays;

public class ArrayMain06 {

	public static void main(String[] args) {
		// deep copy
		
		/*
		int[] a = {10, 20, 30};
		int[] b = {5, 7, 8, 9, 20, 23};
		
		int[] c = new int[a.length+b.length];
		int loc = 0; // 인덱스를 기억해주는 변수
		
		for(int i = 0; i<a.length; i++) {
			c[loc++] = a[i];
		}
		for(int i = 0; i<b.length; i++) {
			c[loc++] = b[i];
		}
		*/
		
		/*
		int [] a = {10, 20, 30};
		int [] b;
		
		b = new int[a.length];
		System.arraycopy(a,0,b,0,a.length); // a배열의 0번지를 b배열의 0번지로, a의 길이만큼 복사
		
		
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		System.out.println("a : " + Arrays.toString(a));
		System.out.println("b : " + Arrays.toString(b));

		++b[0];
		System.out.println("++b[0] 수행후");
		System.out.println("a : " + Arrays.toString(a));
		System.out.println("b : " + Arrays.toString(b));

		 */
		

		int[] a = {10, 20, 30};
		int[] b = {5, 7, 8, 9, 20, 23};
		
		
		int[] c = new int[a.length+b.length];
		System.arraycopy(a,0,c,0,a.length);
		System.arraycopy(b,0,c,a.length,b.length);
		// 이미 c배열은 a.length-1 까지 채워져 있으므로, a.length 부터 채워나가면 됨
		
		System.out.println("a : " + Arrays.toString(a));
		System.out.println("b : " + Arrays.toString(b));
		System.out.println("c : " + Arrays.toString(c));
	}

}

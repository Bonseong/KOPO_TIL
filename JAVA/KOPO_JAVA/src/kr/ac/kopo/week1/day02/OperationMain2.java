package kr.ac.kopo.week1.day02;

public class OperationMain2 {
	public static void main(String[] args) {
		int a=1, b=-1, c=0;
		
		boolean bool = ++a > 0 && ++b > 0 && ++c>0;
		
		System.out.println(bool);
		System.out.println("a : " + a + ", b : " + b + ", c : "  + c );
		// and에서 ++c를 수행하지 않기 때문에 c == 0
		
		
		
		
		
		
	}

}

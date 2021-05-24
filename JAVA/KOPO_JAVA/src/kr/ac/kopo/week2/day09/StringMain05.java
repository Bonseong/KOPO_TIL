package kr.ac.kopo.week2.day09;

public class StringMain05 {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		/*
		int sum = 0;
		for (int i = 0; i < 100000; i++) {
			sum += i;
			//str = str.concat(String.valueOf(i));
		}
		*/
		
		
		String str = "";
		for(int i = 0; i<100000; i++) {
			str+=i;
		}
		
		
	
		long end = System.currentTimeMillis();
		System.out.println("소요시간 : " + (end - start) / 1000.0 + "초");

		
		//------------------------------------------------------
		start = System.currentTimeMillis();
		
		StringBuffer sb = new StringBuffer(); 
		for (int i = 0; i<100000; i++) {
			sb.append(i);
		}

		end = System.currentTimeMillis();
		System.out.println("소요시간 : " + (end - start) / 1000.0 + "초");
		
		// 변화하는 문자열에 대해서는 StringBuffer을 사용하자!
	}

}

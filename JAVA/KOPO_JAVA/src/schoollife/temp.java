package schoollife;

public class temp {

	public static void main(String[] args) {
		int num = 100;
		
		for (int i = 1; i <= num; i++) {
			if (i % 3 == 0) {
				System.out.print("짝");
			}

			if (i % 10 == 0) {
				for(int j=0; j<=(i/num);j++){
					System.out.print("뽀");
				}
				System.out.print("숑");
			}
			

			if (i % 3 != 0 && i % 10 != 0) {
				System.out.print(i);
			}
			System.out.println();
		}
		
	}

}

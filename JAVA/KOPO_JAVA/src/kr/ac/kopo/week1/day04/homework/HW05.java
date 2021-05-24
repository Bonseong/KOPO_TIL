package kr.ac.kopo.week1.day04.homework;

public class HW05 {

	public static void main(String[] args) {
		int printcount = 0;
        for(int i=2; i<=100; i++) {
        	for(int j=2; j<=i; j++) {
        		if (i%j==0 && i!=j) {
        			break;
        		}
        		if (i==j) {
        			System.out.print(i + "\t");
        			printcount++;
        			if(printcount >=5) {
        				System.out.println();
        				printcount=0;
        			}
        			
        		}
        	}
        }

	}

}

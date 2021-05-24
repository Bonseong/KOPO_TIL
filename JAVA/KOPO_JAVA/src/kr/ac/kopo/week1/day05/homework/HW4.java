package kr.ac.kopo.week1.day05.homework;

public class HW4 {

	public static void main(String[] args) {
        int num = 100;
      
   
        int[] arr = new int[num+1];    
        for(int i=2; i<=num; i++) {
            arr[i] = i;
        }
        
        for(int i=2; i*i<=num; i+=1) {
            for(int j=i*i; j<=num; j+=i) {
                arr[j] = 0;        
            }
        }
        System.out.println("소수의 갯수 : ");
        for(int i=0; i<=num; i+=1) {
            if(arr[i] != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
	}
}

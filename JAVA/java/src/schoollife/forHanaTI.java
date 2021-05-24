package schoollife;

import java.util.Scanner;

public class forHanaTI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int days = 1;
		int num = 1;
		while(true) {
			System.out.println(days + "일차 입니다");
			System.out.println("아침이 되었습니다.");
			System.out.println("7:30입니다. 자퇴하시겠습니까?");
			System.out.println("자퇴 0, 등교준비는 1");
			num = sc.nextInt();
			if (num ==0) {
				System.out.println("에잉 쯧쯧");
				break;
			}else if (num == 1) {
				System.out.println("자 씻으러 갑시다.");
			}
			System.out.println("점심이 되었습니다.");
			System.out.println("현타가 옵니다.");
			System.out.println("자퇴 0, 코딩이나 하러가자 1");
			num = sc.nextInt();
			if (num ==0) {
				System.out.println("에잉 쯧쯧");
				break;
			}else if (num == 1) {
				System.out.println("자바... 상속... ㅎ..");
			}
			System.out.println("저녁이 되었습니다.");
			System.out.println("왠지 모르게 화가 납니다.");
			System.out.println("그냥 자퇴는 어떻습니까? 자퇴0, 과제1");
			num = sc.nextInt();
			if (num ==0) {
				System.out.println("에잉 쯧쯧");
				break;
			}else if (num == 1) {
				System.out.println("자바... 과제...");
			}
			System.out.println("오늘도 긴 하루를 보냈습니다.");
			days++;
			
			if (days == 260) {
				System.out.println("드디어 수료했습니다!");
				System.out.println("하지만 70% 미달이라 못들어갔습니다.");
			}
			
		}
		
		
	}

}

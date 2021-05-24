package kr.ac.kopo.week3.day12.homework;

public class ScissorsRockPaper implements Game {
	final static int SCISSOR = 1;
	final static int ROCK = 2;
	final static int PAPER = 3;

	@Override
	public int startGame(int you) {
		int me = (int) (Math.random() * 3) + 1;

		if (me == you) {
			System.out.println("Draw");
			return 2; // 명세는 0이지만, 무승부 출력을 위해
		} else if (me == 1) { // 컴퓨터 : 가위
			if (you == 2) { // 나 : 바위
				System.out.println("You win");
				return 1;
			} else if (you == 3) { // 나 : 보
				System.out.println("You lose");
				return 0;
			}
		} else if (me == 2) { // 컴퓨터 : 바위
			if (you == 1) { // 나 : 가위
				System.out.println("You lose");
				return 0;
			} else if (you == 3) { // 나 : 보
				System.out.println("You win");
				return 1;
			}
		} else { // 컴퓨터 : 보
			if (you == 1) {
				System.out.println("You win");
				return 1;
			} else if (you == 2) {
				System.out.println("You lose");
				return 0;
			}
		}
		return 0;
	}

}

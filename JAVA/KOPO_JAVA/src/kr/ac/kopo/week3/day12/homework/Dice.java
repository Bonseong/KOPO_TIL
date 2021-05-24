package kr.ac.kopo.week3.day12.homework;

public class Dice implements Game {

	@Override
	public int startGame(int you) {
		int me = (int) (Math.random() * 6) + 1;
		if (me == you) {
			System.out.println("You win");
			return 1;
		} else {
			System.out.println("You lose");
		}

		return 0;
	}

}

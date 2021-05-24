package kr.ac.kopo.week3.day12.homework;

import java.util.Scanner;

public class GameMain {
	static int winCount = 0;
	static int loseCount = 0;
	static int drawCount = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String gameSelect;
		char gameType = 'a';
		boolean gameonoff = true;
		int yourInput = 0;
		int gameResult = 0;

		while (gameonoff) {
			System.out.println("게임을 선택하세요");
			System.out.println("A. 가위바위보");
			System.out.println("B. 주사위 값 맞추기");
			System.out.println("C. 종료");

			while (true) { // 게임 선택
				gameSelect = sc.nextLine();
				if (gameSelect.charAt(0) >= 'A' && gameSelect.charAt(0) <= 'C') {
					gameType = gameSelect.charAt(0);
					break;
				} else {
					System.out.println("다시 입력하세요");
				}

			}

			if (gameType == 'A') {
				System.out.println("가위바위보 게임입니다.");
				System.out.println("가위바위보 중 하나를 선택하세요.");
				System.out.println("1 : 가위, 2 : 바위, 3 : 보");

				while (true) {
					yourInput = sc.nextInt();
					sc.nextLine();

					if (yourInput >= 1 && yourInput <= 3) {
						Game srp = new ScissorsRockPaper();
						gameResult = srp.startGame(yourInput);
						if (gameResult == 0) {
							loseCount++;
							break;
						} else if (gameResult == 1) {
							winCount++;
							break;
						} else {
							drawCount++;
							break;
						}

					} else {
						System.out.println("다시 입력하세요.");
					}
				}

			} else if (gameType == 'B') {
				System.out.println("주사위 값 맞추기 게임입니다.");
				System.out.println("주사위를 선택하세요 (1~6값 중 하나)");

				while (true) {
					yourInput = sc.nextInt();
					sc.nextLine();
					if (yourInput >= 1 && yourInput <= 6) {
						Game dice = new Dice();
						gameResult = dice.startGame(yourInput);

						if (gameResult == 0) {
							loseCount++;
							break;
						} else {
							winCount++;
							break;
						}

					}
				}

			} else {
				gameonoff = false;
				System.out.println("게임을 종료합니다.");
				System.out.println("당신의 전적은 " + winCount + "승 " + loseCount + "패 " + drawCount + "무 입니다.");
			}
		}
	}
}

package kr.ac.kopo.service;

public class BoardSequence {
	private static int no = 1;
	public static synchronized int getNo() { // 한 큐에 일을 처리하기 위해
		return BoardSequence.no++;
	}
}

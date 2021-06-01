package kr.ac.kopo.service;

public class TotalAccountSequence {
	private static int userNo = 8;
	public static synchronized int getUserNo() { // 한 큐에 일을 처리하기 위해
		return TotalAccountSequence.userNo++;
	}
}

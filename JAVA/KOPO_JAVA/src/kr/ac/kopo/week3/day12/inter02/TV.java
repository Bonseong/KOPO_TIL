package kr.ac.kopo.week3.day12.inter02;

public interface TV {
	/* public static final */ int MAX_VOLUME_SIZE = 50;
	int MIN_VOLUME_SIZE = 0;

	/* public abstract */ void powerOn();

	void powerOff();

	void channelUp();

	void channelDown();

	void soundUp();

	void soundDown();

	void mute();
	
	/* 인터페이스이기 때문에 일반 메소드를 추가시킬 수 없음.
	void copyright() {
		System.out.println("모든 기술은 TV협회에 귀속됩니다");
	}
	*/ 
	
	default void copyright() { // jdk 1.8에 구현된 기능, default는 접근제어자가 아님
		System.out.println("모든 기술은 TV협회에 귀속됩니다.");
	}
}

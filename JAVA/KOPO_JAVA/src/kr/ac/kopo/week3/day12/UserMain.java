package kr.ac.kopo.week3.day12;

public class UserMain {
	public static void main(String[] args) {
		SamsungTV sam = new SamsungTV();
		sam.powerOn();
		sam.volumeDown();
		sam.volumeUp();
		sam.channelDown();
		sam.channelUp();
		sam.powerOff();
		
		LGTV lg = new LGTV();
		lg.turnOn();
		lg.soundDown();
		lg.soundUp();
		lg.channelDown();
		lg.channelUp();
		lg.turnOff();
		// 서로 호환이 되지 않음 -> 메소드 간 공통의 요소나 통일된 부분이 필요 => 인터페이스로 해결
	}
}

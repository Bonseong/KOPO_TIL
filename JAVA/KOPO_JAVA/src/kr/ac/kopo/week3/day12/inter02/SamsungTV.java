package kr.ac.kopo.week3.day12.inter02;

public class SamsungTV implements TV {
	/* Source -[Override/Implement Methods] */

	private String modelName;
	private boolean power;
	private int volumeSize;
	private int channelNo;
	private int currentVolumeSize;
	private boolean muteToggle = false;

	public SamsungTV() {
		System.out.println("삼성 TV를 구매하였습니다.");
		modelName = "삼성TV";
		power = false;
		volumeSize = 10;
		channelNo = 3;
	}

	@Override
	public void powerOn() {
		power = true;
		System.out.println("전원을 켭니다.");
	}

	@Override
	public void powerOff() {
		power = false;
		System.out.println("전원을 끕니다.");

	}

	@Override
	public void channelUp() {
		System.out.println("채널을 올립니다.");
		channelNo++;
		if (channelNo == 101) {
			channelNo = 1;
		}
		// channelNo = ++channelNo % 100 +1

		info();
	}

	@Override
	public void channelDown() {
		System.out.println("채널을 내립니다.");
		channelNo--;
		if (channelNo == 0) {
			channelNo = 100;
		}
		info();

	}

	@Override
	public void soundUp() {
		System.out.println("볼륨을 올립니다.");
		if (muteToggle) {
			volumeSize = currentVolumeSize;
			muteToggle = false;
		}

		if (volumeSize < TV.MAX_VOLUME_SIZE) // 음소거가 아니라면
			volumeSize++;
		info();

	}

	@Override
	public void soundDown() {
		System.out.println("볼륨을 내립니다.");
		if (muteToggle) {
			volumeSize = currentVolumeSize;
			muteToggle = false;
		}
		if (volumeSize > TV.MIN_VOLUME_SIZE)
			volumeSize--;
		info();

	}

	@Override
	public void mute() {
		if (muteToggle) {
			System.out.println("음소거를 해제합니다.");
			volumeSize = currentVolumeSize;
			muteToggle = false;
			info();

		} else {
			System.out.println("음소거 합니다.");
			currentVolumeSize = volumeSize;
			volumeSize = TV.MIN_VOLUME_SIZE;
			muteToggle = true;
			info();
		}

	} // 구현되지 않은 추상메소드를 구현하던지, 추상클래스로 만들던지

	private void info() {
		// 내부에서만 사용되는 메소드일경우, 굳이 public일 필요가 없음!
		// 이는 삼성만의 메소드이므로 private을 쓰는게 좋음
		System.out.println("채널번호 : " + channelNo + ", 음량크기 : " + volumeSize);
	}
}

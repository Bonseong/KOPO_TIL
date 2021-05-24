package kr.ac.kopo.week1.day01;
import java.util.Random; //패키지 임포트

// 참조클래스 : 혼자 프로그램이 실행되지 않음
public class LottoUtil {
	
	//내용부
	private int lottoNum;
	
	//메소드
	/**
	 * 오늘의 로또 확률을 출력해주는 메소드
	 */
	
	public void todayLotto() {
		Random r = new Random();
		System.out.println("오늘의 로또 확률 : " + r.nextInt(101) + "%입니다");
	}
	
	/**
	 * 1 - 45 사이의 로또 번호를 알려주는 메소드
	 * @return 추출된 로또 번호
	 */
	
	public int genNum() {
		Random r = new Random();
		return r.nextInt(45) + 1; //1~45사이의 로또 번호 추출
	}
	

}



/**
 * 로또와 관련된 기능을 제공하는 기능 클래스
 * 문서화주석
 * @author Bonseong
 */
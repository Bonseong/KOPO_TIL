package kr.ac.kopo.week2.day06;

public class HandphoneMain {
	public static void main(String[] args) {
		// "홍길동", "010-1111-2222", "삼성"을 가지는 Handphone 객체 hp를 생성

		Handphone hp = new Handphone();
		hp.name = "홍길동";
		hp.phone = "010-1111-2222";
		hp.company = "삼성";

		// "윤길동", "000-3333-4444", "애플"을 가지는 Handphone 객체 hp2를 생성

		Handphone hp2 = new Handphone();
		hp2.name = "윤길동";
		hp2.phone = "010-2222-3333";
		hp2.company = "애플";

		// "한길동", "000-5555-6666", "LG"를 가지는 Handphone 객체 hp2를 생성

		Handphone hp3 = new Handphone();
		hp3.name = "한길동";
		hp3.phone = "010-5555-6666";
		hp3.company = "LG";

		System.out.println("소유주명 : " + hp.name + ", 전화번호 : " + hp.phone + ", 제조사 : " + hp.company);
		System.out.println("소유주명 : " + hp2.name + ", 전화번호 : " + hp2.phone + ", 제조사 : " + hp2.company);
		System.out.println("소유주명 : " + hp3.name + ", 전화번호 : " + hp3.phone + ", 제조사 : " + hp3.company);
		// 비효율적, 객체를 통해 해결

		System.out.println("====================================================");

		Handphone[] hpArr = { hp, hp2, hp3 };

		for (int i = 0; i < hpArr.length; i++) {
			System.out
					.println("소유주명 : " + hpArr[i].name + ", 전화번호 : " + hpArr[i].phone + ", 제조사 : " + hpArr[i].company);

		}
		System.out.println("====================================================");
		// 1.5 ver for

		for (Handphone h : hpArr) {
			System.out.println("소유주명 : " + h.name + ", 전화번호 : " + h.phone + ", 제조사 : " + h.company);
		}
	}

}
